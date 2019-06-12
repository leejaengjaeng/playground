package com.playground.using_composition_instead_of_extends;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UsingComposition<E> extends SetWrapper<E> {
    private int addCount = 0;

    UsingComposition(Set set) {
        super(set);
    }

    public int getAddCount() {
        return addCount;
    }

    @Override
    public boolean add(E e) {
        this.addCount++;
        System.out.println("Call UsingComposition's add");
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        this.addCount += c.size();
        return super.addAll(c);
    }
}

class SetWrapper<E> extends HashSet<E> {
    private final Set set;

    SetWrapper(Set set) {
        this.set = set;
    }

    @Override
    public boolean add(E e) {
        return set.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }
}