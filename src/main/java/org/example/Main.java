package org.example;

import org.example.parseUtil.Worker;
import org.example.requestUtil.RequestParser;
import org.example.requestUtil.UtilityRequest;


public class Main {
    public static void main(String[] args) {
        try {
            UtilityRequest utilityRequest = RequestParser.parse(args);
            Worker worker = new Worker();
            worker.run(utilityRequest);
        } catch (IllegalArgumentException e){
            System.out.println("invalid inputs :\n"+e.getMessage());
        }
    }
}