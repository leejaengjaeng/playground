package com.playground;

import com.playground.using_composition_instead_of_extends.Launcher;

public class Main {

    public static void main(String[] args) {
        LauncherBase launcher = new Launcher();

        launcher.init();
        launcher.execute();
    }


}


