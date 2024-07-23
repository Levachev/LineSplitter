package org.example.statistics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class FullStatistics {
    private BigInteger maxInteger;
    private BigInteger minInteger;
    private BigDecimal maxFloat;
    private BigDecimal minFloat;
    private BigInteger sumInteger;
    private BigInteger amountInteger;
    private BigDecimal sumFloat;
    private BigInteger amountFloat;
    private int shortestStringLen;
    private int longestStringLen;

    public FullStatistics(){
        maxInteger = null;
        minInteger = null;
        maxFloat = null;
        minFloat = null;
        sumInteger = BigInteger.valueOf(0);
        amountInteger = BigInteger.valueOf(0);
        sumFloat = BigDecimal.valueOf(0f);
        amountFloat = BigInteger.valueOf(0);
        shortestStringLen = Integer.MAX_VALUE;
        longestStringLen = Integer.MIN_VALUE;
    }

    private BigInteger customBigIntegerMax(BigInteger v1, BigInteger v2){
        if(v1 == null){
            return v2;
        } else{
            if(v2 == null){
                return v1;
            } else{
                return v1.max(v2);
            }
        }
    }

    private BigInteger customBigIntegerMin(BigInteger v1, BigInteger v2){
        if(v1 == null){
            return v2;
        } else{
            if(v2 == null){
                return v1;
            } else{
                return v1.min(v2);
            }
        }
    }

    private BigDecimal customBigDecimalMax(BigDecimal v1, BigDecimal v2){
        if(v1 == null){
            return v2;
        } else{
            if(v2 == null){
                return v1;
            } else{
                return v1.max(v2);
            }
        }
    }

    private BigDecimal customBigDecimalMin(BigDecimal v1, BigDecimal v2){
        if(v1 == null){
            return v2;
        } else{
            if(v2 == null){
                return v1;
            } else{
                return v1.min(v2);
            }
        }
    }

    public void apply(BigInteger value){
        maxInteger = customBigIntegerMax(maxInteger, value);
        minInteger = customBigIntegerMin(minInteger, value);
        sumInteger = sumInteger.add(value);
        amountInteger = amountInteger.add(BigInteger.ONE);
    }

    public void apply(BigDecimal value){
        maxFloat = customBigDecimalMax(maxFloat, value);
        minFloat = customBigDecimalMin(minFloat, value);
        amountFloat = amountFloat.add(BigInteger.ONE);
        sumFloat = sumFloat.add(value);
    }

    public void apply(String value){
        shortestStringLen = Math.min(shortestStringLen, value.length());
        longestStringLen = Math.max(longestStringLen, value.length());
    }


    public String getAllStatistics(){
        return "max integer: "+maxInteger+
                "\nmin integer: "+minInteger+
                "\nsum integer: "+sumInteger+
                "\naverage integer: "+
                new BigDecimal(sumInteger).divide(new BigDecimal(amountInteger), RoundingMode.DOWN)+
                "\n---------------"+
                "\nmax float: "+maxFloat+
                "\nmin float: "+minFloat+
                "\nsum float: "+sumFloat+
                "\naverage float: "+
                sumFloat.divide(new BigDecimal(amountFloat), RoundingMode.DOWN)+
                "\n---------------"+
                "\nshortest string length: "+shortestStringLen+
                "\nlongest string length: "+longestStringLen+"\n";
    }
}
