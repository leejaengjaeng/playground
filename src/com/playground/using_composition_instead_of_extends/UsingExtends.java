package com.playground.using_composition_instead_of_extends;

import java.util.Collection;
import java.util.HashSet;

class UsingExtends<E> extends HashSet<E> {
    private int addCount = 0;

    public int getAddCount() {
        return addCount;
    }

    @Override
    public boolean add(E e) {
        this.addCount++;
        System.out.println("Call UsingExtends's add");
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        this.addCount += c.size();
        return super.addAll(c);
    }
}