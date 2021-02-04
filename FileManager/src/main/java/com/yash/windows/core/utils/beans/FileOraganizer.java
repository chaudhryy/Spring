package com.yash.windows.core.utils.beans;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileOraganizer {


    private final String fromPath;
    private final String toPath;
    private final String toCodePath;
    private   Integer version = new Integer(1);


    public FileOraganizer(String fromPath, String toPath, String toCodePath) {
        this.fromPath = fromPath;
        this.toPath = toPath;
        this.toCodePath = toCodePath;
    }

    public void process(){

        // archive old folders
        // anything old and has nothing processed for more than configured time


        // Sort file by Types
        // Create links , If already exists create new version 
        
            processDirectory("Documents");
        // archive files older than configured time 
        
        // Close Running Intelija Process and move the code to one common directory
        
    }

    private void processDirectory(String targetDir) {
        File fromPathDir = new File(this.fromPath);
        File[] fileList = fromPathDir.listFiles();
        if(fileList != null && fileList.length >0){
            for(File file : fileList){
                if(file != null && file.isDirectory() && !file.getName().equalsIgnoreCase("archive")){
                    Map<String,File> extMap = new HashMap<>();
                    getFileByExtension(file.getName(),file,extMap);
                }
            }
        }


    }

    private boolean  getFileByExtension(String name, File rootDir, Map<String, File> extMap) {
        boolean isFileChanged = false;
        File[] fileList = rootDir.listFiles();
        for(File file : fileList){
            try {
                if(file != null && file.isFile() && !FileUtils.isSymlink(file)){
                    isFileChanged = orgainizeFile(name,rootDir,file);
                }else if(file != null && file.isDirectory() && file.getName().equalsIgnoreCase("Documents")){
                    getFileByExtension(name,file,extMap);
                }else if (file != null && file.isDirectory() && file.getParentFile().getName().equalsIgnoreCase("Documents")){
                    getFileByExtension(name,file,extMap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  isFileChanged;
    }

    private boolean orgainizeFile(String name, File rootDir, File file) {
        String newPathName = this.toPath+"/"+getExtension(file.getName());
        File toPath = new File(newPathName);
        if(!(toPath.exists() && toPath.isDirectory())){
            toPath.mkdir();
        }

        String rootDirName = name;
        String originalName = file.getName();
        String finalName;
        if (rootDirName.indexOf("-")>0) {
//             finalName = .replaceAll(" ","-");
            finalName=  FilenameUtils.normalize(FilenameUtils.removeExtension(originalName)+"_"+rootDirName.substring(0,rootDirName.indexOf("-"))+"."+FilenameUtils.getExtension(originalName));
        }else{
            finalName =FilenameUtils.normalize(FilenameUtils.removeExtension(originalName)+"_"+rootDirName+"."+FilenameUtils.getExtension(originalName)); ;//rootDirName+"_"+originalName;
        }

        try {
            FileUtils.copyToDirectory(file,toPath);
            String newFilePathWithName = newPathName+"/"+finalName;
            String oldFilePathName = newPathName+"/"+originalName;
            version = new Integer(1);
            File newFile =  getNewFilePathName(newFilePathWithName);
            File oldFile = new File(oldFilePathName);
            oldFile.renameTo(newFile);
            Path path = file.toPath();
            File documentLink = null;
//            System.out.println("RootDirName " + rootDirName + " ,Version " +version);
            if(rootDirName.equalsIgnoreCase(file.getParentFile().getName())){
//                System.out.println("Parent File Name  " + file.getParentFile().getName());

                File documentsFolder = new File(file.getParentFile().getAbsolutePath().toString()+"/Documents/");
                      if(!(documentsFolder.exists() && documentsFolder.isDirectory())){
                          documentsFolder.mkdir();
//                          System.out.println("Document Folder Created" + documentsFolder.getAbsolutePath());

                      }

                documentLink = new File(documentsFolder.getAbsolutePath().toString()+"/"+FilenameUtils.removeExtension(file.getName().toString())+"_V"+version.intValue()+"."+FilenameUtils.getExtension(file.getName().toString()));

            }else{
                documentLink = new File(file.getAbsolutePath().toString());
            }
            file.delete();
            Files.createSymbolicLink(documentLink.toPath(),newFile.toPath());
//            Files.createLink(documentLink.toPath(),newFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }


        return true;
    }

    private File getNewFilePathName(String newFilePathWithName) {

//        FilenameUtils.removeExtension(newFilePathWithName)+"_V"+version.intValue()+"."+FilenameUtils.getExtension(newFilePathWithName);
        File newFile = new File(FilenameUtils.removeExtension(newFilePathWithName)+"_V"+version.intValue()+"."+FilenameUtils.getExtension(newFilePathWithName));
        if(newFile.exists()){
            System.out.println("File Already Exists get another one " + newFile.getName());
            version++;
            return getNewFilePathName(newFilePathWithName);
        }
        return  newFile;
    }

    private String getExtension(String name) {
        String ext = null;
        if(name != null && !name.isEmpty()){
           ext= FilenameUtils.getExtension(name);//  name.substring(name.lastIndexOf(".")+1);
        }
        return getDirectoryForExtension(ext);
        
    }

    private String getDirectoryForExtension(String ext) {
      if(ext == null){
          return "Untracked";
      }else{
          return ext;
      }
    }
}
