package com.yash.shell.commands;

import com.yash.beans.RestOcpClient;
import com.yash.cache.PodCache;
import com.yash.exceptions.OcpException;
import com.yash.ocp.db.service.*;
import com.yash.ocp.utils.OcpUtil;
import com.yash.provider.ocp.json.CMlist.CMSuccessResponse;
import com.yash.provider.ocp.json.dclist.DcSuccessResponse;
import com.yash.provider.ocp.json.podlists.PodListSuccessResponse;
import com.yash.provider.ocp.json.projectlist.ProjectResponseList;
import com.yash.provider.ocp.json.routelist.RouteListSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;

import java.security.NoSuchAlgorithmException;


@ShellComponent
public class MyReportCommands {

    private static final String GROUP = "Reporting Commands";

    @Autowired
    PodCache podCache;

    @Autowired
    ReportGenerationService reportService;

    @ShellMethod(value = "Generate Report", group = GROUP, prefix = "-")
    public String generateReport(String release) throws NoSuchAlgorithmException, OcpException {

        reportService.generateReport(release);
        return "";
    }



}