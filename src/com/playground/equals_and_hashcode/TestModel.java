package com.playground.equals_and_hashcode;

/**
 * @author Jaeyoung Lee
 */
class TestModel {
    String value;

    TestModel(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object q) {
        System.out.println("Call equals");
        return this.value.equals(((TestModel) q).value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
