package com.playground;

public interface Launcher {
    default void init() {
    }

    void execute();
}
