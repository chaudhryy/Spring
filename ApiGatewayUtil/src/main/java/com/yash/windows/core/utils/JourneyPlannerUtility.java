package com.yash.windows.core.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.reflect.FieldUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class JourneyPlannerUtility extends Component {

    private JPanel panel1;
    protected JTextField initiativeName;
    private JButton createStructureButton;

        
    String[] arrayTribe = {"Home and Business Connectivity",//
            "Future of Connectivity",//
            "Managed Service",//
            "Data and Automation",//
            "Billing and Digital Self Services",//
            "Technology Change",//
            "IT Application-Sustain",//
            "Path to Production",//
            "IT Application-Opex",//
            "CICD", //
            "Not Categorized"};
    private JList listOfTribes ;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(args);
            }
        });
    }

    private static void createAndShowGUI(String[] args) {


        JFrame frame = new JFrame("Api Gateway Utility");
        frame.setContentPane(new JourneyPlannerUtility(args).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public JourneyPlannerUtility(String[] args) {
        listOfTribes.setListData(arrayTribe);
        createStructureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    processRequest(args);
                } catch (Exception ex) {
                    showErrorPane(ex.getMessage(), ExceptionUtils.getFullStackTrace(ex));
                }
            }
        });
    }

    void processRequest(String[] args) {
        if (validateInputFields()) {
            createDirectoryStructure(args);
        }
    }


    boolean validateInputFields() {
        boolean isValid = true;
        if (!initiativeName.getText().matches("^[a-zA-Z0-9_]*$")) {
            isValid = false;
            showErrorPane("input validation error", "Initiative name should be only alphanumeric including underscore ");
        }

        Object tribe = listOfTribes.getSelectedValue();
        if(tribe == null){
            isValid = false;
            showErrorPane("input validation error","Please select a tribe");

        }
        return isValid;
    }


    void createDirectoryStructure(String[] args) {
        Date date = new Date();
        String basePath= null;
        if (args == null || args.length <1) {
            basePath = "C:\\Users\\t827090\\OneDrive - Spark New Zealand\\Spark\\Journeys\\";
        }else{
            basePath = args[0];
        }
        String rootFolderName = initiativeName.getText()+"_"+((String)listOfTribes.getSelectedValue()).replace(" ","-")+"_"+date.getDate()+"_"+date.getMonth()+"_"+(date.getYear() + 1900);
        File file = new File(basePath+rootFolderName);
        File fileCode = new File(basePath+rootFolderName+"/Code");
        File fileDoc = new File(basePath+rootFolderName+"/Documents");
        File fileSamples = new File(basePath+rootFolderName+"/Samples");
        try {
            if(!file.exists()) {
                FileUtils.forceMkdir(file);
                FileUtils.forceMkdir(fileCode);
                FileUtils.forceMkdir(fileDoc);
                FileUtils.forceMkdir(fileSamples);
                System.exit(1);
            }else{
                showErrorPane("Create Directory error","Folder with  Name " + rootFolderName + " already Exists");

            }

        } catch (IOException e) {
            showErrorPane("Create Directory error","Folder Name " + rootFolderName + " "+e.getMessage() );
        }

    }

    void showErrorPane(String title, String msg) {
        JOptionPane pane = new JOptionPane(msg, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = pane.createDialog("Application says: " + title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}
