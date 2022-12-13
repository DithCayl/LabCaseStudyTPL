/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpl.group2.labcasestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author USER
 */
public class InputManager {
    
    String dataString;
    List<String> inputList = new ArrayList();
    List<InputObject> inputObjectList = new ArrayList();
    boolean isFileOpen = false;
    
    String inputRegExPattern = "[\\\"\\'](?:\\\\.|[^\\\\])*?[\\\"\\']|(?<!\\d)[\\+\\-]?\\.*\\w+\\.*\\w*|[\\+\\-\\*\\/\\;\\=]";

    public InputManager(List<String> inputList){
        this.inputList = inputList;
        int i = 0;
        for(String input: inputList){
            i++;
            List<String> inputSorted = new ArrayList();
            Matcher matcher = Pattern.compile(inputRegExPattern).matcher(input);
            while(matcher.find()){
                inputSorted.add(matcher.group());
            }
            inputObjectList.add(new InputObject(input,inputSorted,i));
        }
        
        isFileOpen = true;
    }
    public void LexicalAnalysis(){
        for(InputObject input: inputObjectList){
            LexicalAnalyzer lexicalAnalyzer =  new LexicalAnalyzer();
            input.setTokenList(lexicalAnalyzer.GetTokenList(input.getSortedInput()));
            input.setDataString(lexicalAnalyzer.GetDataString());
            input.setValueList(lexicalAnalyzer.GetValueList());
            System.out.println(input.getInput());
        }
    }
    /*public boolean SyntaxAnalysis(){
        boolean isSyntaxEqual =  new SyntaxAnalyzer().IsPatternEqual(tokenList);
        return isSyntaxEqual;
    }*/
    public List<Boolean> SyntaxAnalysis(){
        List<Boolean> syntaxList = new ArrayList<Boolean>();
        for(InputObject input: inputObjectList){
            boolean isSyntaxEqual =  new SyntaxAnalyzer().IsPatternEqual(input.getTokenList());
            syntaxList.add(isSyntaxEqual);
        }
        return syntaxList;
    }
    /*public boolean SemanticAnalysis(){
        boolean isSemanticValid = new SemanticAnalyzer().IsTypeMatched(dataString,valueList);
        return isSemanticValid;
    }*/
    public List<Boolean> SemanticAnalysis(){
        List<Boolean> semanticList = new ArrayList();
        for(InputObject input: inputObjectList){
            boolean isSemanticValid = new SemanticAnalyzer().IsTypeMatched(input);
            semanticList.add(isSemanticValid);
        }
        return semanticList;
    }
    public List<InputObject> getInputObjectList() {
        return inputObjectList;
    }

    
}
enum DataType{
     StringType,charType,intType,doubleType
}
