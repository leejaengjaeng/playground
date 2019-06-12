package com.playground.using_composition_instead_of_extends;

import java.util.HashSet;
import java.util.List;

import com.playground.LauncherBase;

public class Launcher implements LauncherBase {
    @Override
    public void execute() {
        /*
            Effective JAVA 3/E - item 18

            HashSet의 addAll은 기본적으로 add() 함수를 Loop 돌게 구현되어 있음

            1. HashSet을 바로 상속 받아서 UsingExtends 처럼 구현한다면 super.addAll(c)의 호출이 결국
               Override 된 UsingExtends 의 add(e)를 호출하게 됨으로 addAll의 addCount 가 2배씩 올라감

            2. HashSet의 Wrapper 클래스를 사용하여 UsingComposition 처럼 Set 자체를 멤버로 가지고 호출하도록 한다면
               UsingComposition의 add(e) Override가 포함된 Set에게는 영향을 미치지 않아서 의도대로 동작할 수 있음
               추가적으로 Set을 Extends한 SetWrapper를 상속받고 있음으로 UsingComposition 자체도 Set으로 취급될 수 있음
         */
        UsingExtends<Integer> usingExtends = new UsingExtends<>();
        usingExtends.addAll(List.of(1,2,3));
        System.out.println("UsingExtends's add count is " + usingExtends.getAddCount());

        UsingComposition<Integer> usingComposition = new UsingComposition<>(new HashSet());
        usingComposition.addAll(List.of(1,2,3));
        System.out.println("UsingComposition's add count is " + usingComposition.getAddCount());

    }
}
