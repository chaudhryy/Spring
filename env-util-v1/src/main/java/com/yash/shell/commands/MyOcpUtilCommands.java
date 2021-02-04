package com.yash.shell.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MyOcpUtilCommands {
    private static final String GROUP = "Ocp Utility Commands";

    @ShellMethod(value = "Get OCP POD Dump", group = GROUP, prefix = "-")
    public void getPodDump(String userName, String password){

    }
}
