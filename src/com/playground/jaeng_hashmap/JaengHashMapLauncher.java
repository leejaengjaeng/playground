package com.playground.jaeng_hashmap;

import com.playground.Launcher;

public class JaengHashMapLauncher implements Launcher {
    @Override
    public void execute() {
        JaengHashMap<String, Integer> hashMap = new JaengHashMap<>();
        hashMap.put("일",1);
        hashMap.put("이",2);
        hashMap.put("삼",3);

        System.out.println("Before update [일]");
        for(JaengHashMap.Node node : hashMap.getNodes()) {
            System.out.println(node.key + " " + node.value);
        }

        hashMap.put("일",1111);

        System.out.println("After update [일]");
        for(JaengHashMap.Node node : hashMap.getNodes()) {
            System.out.println(node.key + " " + node.value);
        }
    }
}
