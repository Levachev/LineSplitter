package org.example.requestUtil;

public class RequestParser {
    public static UtilityRequest parse(String[] args){
        boolean hasStatisticsChoice = false;
        boolean isAddedFile = false;
        UtilityRequest result = new UtilityRequest();

        for(int i = 0; i < args.length; i++){
            String arg = args[i];
            switch(arg){
                case "-a": {
                    if (isAddedFile) {
                        throw new IllegalArgumentException("this key have to be before input files");
                    }
                    result.setShouldAdd();
                    break;
                }
                case "-o": {
                    if (isAddedFile) {
                        throw new IllegalArgumentException("this key have to be before input files");
                    }
                    if (i + 1 >= args.length) {
                        throw new IllegalArgumentException("after -o should be path");
                    }
                    result.setPath(args[++i]);
                    break;
                }
                case "-p": {
                    if (isAddedFile) {
                        throw new IllegalArgumentException("this key have to be before input files");
                    }
                    if (i + 1 >= args.length) {
                        throw new IllegalArgumentException("after -p should be prefix");
                    }
                    result.setPrefix((args[++i]));
                    break;
                }
                case "-s": {
                    if (isAddedFile) {
                        throw new IllegalArgumentException("this key have to be before input files");
                    }
                    hasStatisticsChoice = true;
                    break;
                }
                case "-f": {
                    System.out.println("set full");
                    if (isAddedFile) {
                        throw new IllegalArgumentException("this key have to be before input files");
                    }
                    hasStatisticsChoice = true;
                    result.setFullStatistics();
                    break;
                }
                default: {
                    isAddedFile = true;
                    result.addFile(arg);
                    break;
                }
            }
        }
        if(!hasStatisticsChoice){
            throw new IllegalArgumentException("you have to set one of this keys: -s -f," +
                    " to choose level of statistics");
        } else if(!isAddedFile){
            throw new IllegalArgumentException("not input files");
        }

        return result;
    }
}
