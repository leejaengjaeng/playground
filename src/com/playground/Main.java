package com.playground;

import com.playground.using_composition_instead_of_extends.UsingCompositionInsteadOfExtends;

public class Main {

    public static void main(String[] args) {
        Launcher launcher = new UsingCompositionInsteadOfExtends();

        launcher.init();
        launcher.execute();
    }


}


