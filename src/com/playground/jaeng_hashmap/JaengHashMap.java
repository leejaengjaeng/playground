package com.playground.jaeng_hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JaengHashMap<String, V> {

    private static final int BUCKET_SIZE = 20;
    private Node<V>[] bucket;

    JaengHashMap() {
        this.bucket = new Node[BUCKET_SIZE];    // Generic array 생성불가
    }

    public void put(String key, V value) {
        int bucketIndex = getBucketIndex(key);
        addToBucket(bucketIndex, key, value);

    }

    private int getBucketIndex(String key) {
        return key.hashCode() % BUCKET_SIZE;
    }

    private void addToBucket(int bucketIndex, String key, V value) {
        Node<V> newNode = new Node<>(key, value);

        if (bucket[bucketIndex] == null) {
            bucket[bucketIndex] = newNode;
            return;
        }

        bucket[bucketIndex].linkToNext(newNode);
    }

    public V get(String key) {
        int bucketIndex = getBucketIndex(key);
        Node<V> targetBucket = bucket[bucketIndex];
        if (targetBucket == null) {
            return null;
        }

        Node<V> targetNode = targetBucket;
        while (targetNode != null) {
            if (targetNode.key.equals(key)) {
                return targetNode.value;
            }
            targetNode = targetNode.next;
        }
        return null;
    }

    public List<Node> getNodes() {
        return Arrays.stream(bucket)
                .flatMap(currentBucket -> {
                    List<Node> nodes = new ArrayList<>();

                    Node<V> currentNode = currentBucket;
                    while (currentNode != null) {
                        nodes.add(currentNode);
                        currentNode = currentNode.next;
                    }

                    return nodes.stream();
                })
                .collect(Collectors.toList());
    }

    public class Node<VA> {
        String key;
        VA value;
        Node<VA> next;

        Node(String key, VA value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        void linkToNext(Node<VA> newNext) {
            if (this.key.equals(newNext.key)) {
                this.value = newNext.value;
                return;
            }

            if (this.next == null) {
                this.next = newNext;
                return;
            }

            this.next.linkToNext(newNext);
        }
    }

}
