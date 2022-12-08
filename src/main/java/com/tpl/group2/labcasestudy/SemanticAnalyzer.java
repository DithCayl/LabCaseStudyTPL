/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpl.group2.labcasestudy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class SemanticAnalyzer {
    
    
    public DataType GetDataType(String input){
        switch(input){
            case"String":
                return DataType.StringType;
            case"char":
                return DataType.charType;
            case"int":
                return DataType.intType;
            case"double":
                return DataType.doubleType;
            default:
                return null;
        }
    }
    public boolean IsTypeMatched(String dataString, List<String> valueList){
        String charPatternValue ="((\'.{1}\'))";
        String stringPatternValue ="(\".*\")";
        String intPatternValue ="(-|\\+)?\\d+";
        String doublePatternValue ="((-|\\+)?((\\d+)|(\\d+\\.*\\d*)|(\\d*\\.*\\d+)))";
        String regExValue;

        switch(GetDataType(dataString)){
            case StringType:
                regExValue = stringPatternValue;
                break;
            case charType:
                regExValue = charPatternValue;
                break;
            case intType:
                regExValue = intPatternValue;
                break;
            case doubleType:
                regExValue = doublePatternValue;
                break;
            default:
                regExValue = null;
        }
        if(regExValue==null)return false;
        for(String value: valueList){
            Matcher matcher = Pattern.compile(regExValue).matcher(value);
            if(!matcher.matches())return false;
        }
        return true;
    }
}
