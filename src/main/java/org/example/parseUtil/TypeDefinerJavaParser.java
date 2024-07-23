package org.example.parseUtil;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TypeDefinerJavaParser implements TypeDefiner{

    @Override
    public DefinedTypes define(String input) {
        try {
            new BigInteger(input);
            return DefinedTypes.INTEGER;
        } catch (NumberFormatException ignored){
        }
        try{
            new BigDecimal(input);
            return DefinedTypes.FLOAT;
        } catch (NumberFormatException ignored){
        }
        return DefinedTypes.STRING;
    }
}
