package org.example.statistics;

public class SimpleStatistics {
    private int integerAmount;
    private int floatAmount;
    private int stringAmount;

    public SimpleStatistics(){
        integerAmount = 0;
        floatAmount = 0;
        stringAmount = 0;
    }

    public int getIntegerAmount() {
        return integerAmount;
    }

    public int getFloatAmount() {
        return floatAmount;
    }

    public int getStringAmount() {
        return stringAmount;
    }

    public void incrementIntegerAmount(){
        integerAmount++;
    }

    public void incrementFloatAmount(){
        floatAmount++;
    }

    public void incrementStringAmount(){
        stringAmount++;
    }

    public String getAllStatistics(){
        return "total integer amount: "+integerAmount+
                "\ntotal float amount: "+floatAmount+
                "\ntotal string amount: "+stringAmount+"\n";
    }
}
