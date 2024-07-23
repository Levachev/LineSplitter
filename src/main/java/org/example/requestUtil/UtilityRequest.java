package org.example.requestUtil;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UtilityRequest {
    private List<String> fileNames;
    private String path;
    private String prefix;
    private boolean isFullStatistics;
    private boolean isShouldAdd;

    public UtilityRequest(){
        fileNames = new ArrayList<>();
        path = "";
        prefix = "";
        isFullStatistics = false;
        isShouldAdd = false;
    }

    public boolean isShouldAdd() {
        return isShouldAdd;
    }

    public void setShouldAdd(){
        isShouldAdd = true;
    }

    public void addFile(String fileName){
        fileNames.add(fileName);
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isFullStatistics() {
        return isFullStatistics;
    }

    public void setFullStatistics() {
        isFullStatistics = true;
    }
}
