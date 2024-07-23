package org.example.parseUtil;

import org.example.exception.ParseFileException;
import org.example.statistics.SimpleStatistics;
import org.example.requestUtil.UtilityRequest;
import org.example.statistics.FullStatistics;

import java.io.IOException;

public class Worker {
    private FileParser fileParser;
    private static final String integerOutputFileName = "integers.txt";
    private static final String floatOutputFileName = "floats.txt";
    private static final String stringOutputFileName = "strings.txt";

    public Worker(){
    }

    public void run(UtilityRequest request){
        fileParser = new FileParser(integerOutputFileName, floatOutputFileName,
                stringOutputFileName, new TypeDefinerJavaParser(), request.isShouldAdd());

        FullStatistics fullStatistics = request.isFullStatistics() ? new FullStatistics() : null;
        SimpleStatistics simpleStatistics = new SimpleStatistics();

        for(String fileName : request.getFileNames()){
            try {
                fileParser.parseFile(fileName, request.getPath(), request.getPrefix(),
                        simpleStatistics, fullStatistics);
            } catch (ParseFileException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        try {
            fileParser.closeAllWriters();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(simpleStatistics.getAllStatistics());
        if(request.isFullStatistics()){
            System.out.println(fullStatistics.getAllStatistics());
        }
    }
}
