package com.playground;

public interface LauncherBase {
    default void init() {
    }

    void execute();
}
