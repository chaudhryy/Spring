package com.yash.shell.commands;

import com.yash.cache.LocalCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.StringUtils;


@ShellComponent
public class MyOcpAdminCommands {

    private static final String GROUP= "Ocp Admin Commands";

    @Autowired
    LocalCache cache;

    @ShellMethod(value = "set auth", group = GROUP)
    public void setAuth(String auth) {

        cache.setAuthorization(auth);
    }


    @ShellMethod(key="set-project",value = "set project", group = GROUP)
    public void setdefaultProject(String project) {

        cache.setNamespace(project);
    }


    @ShellMethod(value = "get auth", group = GROUP)
    public String getAuth() {
        if(StringUtils.isEmpty(cache.getAuthorization())){
            return "Authorization Token is not set yet";
        }
        return "Authorization Token : "+cache.getAuthorization();
    }


    @ShellMethod(key="get-project",value = "get project", group = GROUP)
    public String getDefaultProject() {
        if(StringUtils.isEmpty(cache.getNamespace())){
            return "Namespace is not set yet";
        }
        return cache.getNamespace();
    }
}