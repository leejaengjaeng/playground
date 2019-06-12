package com.playground.equals_and_hashcode;

import java.util.List;

import com.playground.LauncherBase;

public class Launcher implements LauncherBase {
    @Override
    public void execute() {
        TestModel test1 = new TestModel("test1");
        TestModel sameValueWithTest1 = new TestModel("test1");
        TestModel test2 = new TestModel("test2");

        System.out.println(test1 == sameValueWithTest1);
        System.out.println(test1 == test2);

        List.of(test1, sameValueWithTest1, test2).stream().distinct().forEach(System.out::println);
    }
}
