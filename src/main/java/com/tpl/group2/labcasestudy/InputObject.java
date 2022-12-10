/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpl.group2.labcasestudy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class InputObject {
    
    String input;
    List<String> sortedInput = new ArrayList();
    List<String> tokenList = new ArrayList();
    
    String dataString;
    List<String> valueList = new ArrayList();

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueString) {
        this.valueList = valueString;
    }
    

    public List<String> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<String> tokenList) {
        this.tokenList = tokenList;
    }
    
    public InputObject(String input, List<String> sortedInput) {
        this.input = input;
        this.sortedInput = sortedInput;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<String> getSortedInput() {
        return sortedInput;
    }

    public void setSortedInput(List<String> sortedInput) {
        this.sortedInput = sortedInput;
    }
    
}
