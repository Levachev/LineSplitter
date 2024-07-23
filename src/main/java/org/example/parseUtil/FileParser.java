package org.example.parseUtil;

import org.example.exception.ParseFileException;
import org.example.statistics.FullStatistics;
import org.example.statistics.SimpleStatistics;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FileParser {
    private final String integerOutputFileName;
    private final String floatOutputFileName;
    private final String stringOutputFileName;
    private final TypeDefiner typeDefiner;
    private BufferedWriter integerWriter = null;
    private BufferedWriter floatWriter = null;
    private BufferedWriter stringWriter = null;
    private final boolean isShouldAdd;

    public FileParser(String integerOutputFileName, String floatOutputFileName,
                          String stringOutputFileName, TypeDefiner typeDefiner, boolean isShouldAdd){
        this.integerOutputFileName = integerOutputFileName;
        this.floatOutputFileName = floatOutputFileName;
        this.stringOutputFileName = stringOutputFileName;
        this.typeDefiner = typeDefiner;
        this.isShouldAdd = isShouldAdd;
    }

    public void parseFile(String fileName, String path, String prefix,
                          SimpleStatistics simpleStatistics, FullStatistics fullStatistics) throws ParseFileException {

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for(String line; (line = br.readLine()) != null; ) {
                DefinedTypes type = typeDefiner.define(line);

                if(fullStatistics != null){
                    applyFullStatistics(fullStatistics, line, type);
                }

                BufferedWriter outputWriter = getWriter(type, simpleStatistics, path, prefix);
                writeToOutputFile(outputWriter, line);
            }
        } catch (FileNotFoundException e) {
            throw new ParseFileException("file: "+fileName+" not found\n"+e.getMessage());
        } catch (IOException e) {
            throw new ParseFileException("cannot read from file: "+fileName+"\n"+e.getMessage());
        } catch (IllegalArgumentException e){
            throw new ParseFileException(e.getMessage());
        }

    }

    void closeAllWriters() throws IOException {
        integerWriter.close();
        floatWriter.close();
        stringWriter.close();
    }

    private BufferedWriter getWriter(DefinedTypes type,
                                                SimpleStatistics simpleStatistics,
                                                String path, String prefix) throws IOException {
        switch (type){
            case STRING -> {
                return handleStringType(simpleStatistics, path, prefix);
            }
            case INTEGER -> {
                return handleIntegerType(simpleStatistics, path, prefix);
            }
            case FLOAT -> {
                return handleFloatType(simpleStatistics, path, prefix);
            }
            default -> throw new IllegalArgumentException("unknown type");
        }
    }

    private BufferedWriter handleStringType(SimpleStatistics simpleStatistics,
                                        String path, String prefix) throws IOException {
        simpleStatistics.incrementStringAmount();
        if(simpleStatistics.getStringAmount() == 1){
            stringWriter = new BufferedWriter(new FileWriter(
                    path+prefix+stringOutputFileName, isShouldAdd));
        }

        return stringWriter;
    }

    private BufferedWriter handleIntegerType(SimpleStatistics simpleStatistics,
                                         String path, String prefix) throws IOException {
        simpleStatistics.incrementIntegerAmount();
        if(simpleStatistics.getIntegerAmount() == 1){
            integerWriter = new BufferedWriter(new FileWriter(
                    path+prefix+integerOutputFileName, isShouldAdd));
        }

        return integerWriter;
    }

    private BufferedWriter handleFloatType(SimpleStatistics simpleStatistics,
                                         String path, String prefix) throws IOException {
        simpleStatistics.incrementFloatAmount();
        if(simpleStatistics.getFloatAmount() == 1){
            floatWriter = new BufferedWriter(new FileWriter(
                    path+prefix+floatOutputFileName, isShouldAdd));
        }

        return floatWriter;
    }

    private void writeToOutputFile(BufferedWriter writer, String line) throws ParseFileException {

        try {
            writer.write(line);
            writer.newLine();
        }
        catch(IOException ex){
            throw new ParseFileException("cannot write to file :\n"+ex.getMessage());
        }
    }

    private void applyFullStatistics(FullStatistics fullStatistics, String value, DefinedTypes type){
        switch (type){
            case STRING -> {
                fullStatistics.apply(value);
            }
            case INTEGER -> {
                fullStatistics.apply(new BigInteger(value));
            }
            case FLOAT -> {
                fullStatistics.apply(new BigDecimal(value));
            }
            default -> throw new IllegalArgumentException("unknown type");
        }
    }
}
