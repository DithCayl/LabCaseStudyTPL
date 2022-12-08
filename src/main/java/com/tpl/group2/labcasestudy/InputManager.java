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
    
    String input;
    String dataString;
    List<String> valueList = new ArrayList();
    List<String> arithOpList = new ArrayList();
    List<String> inputSorted = new ArrayList();
    List<String> tokenList = new ArrayList();
    
    boolean isFileOpen = false;
    boolean isSyntaxValid = false;
    
    String inputRegExPattern = "(\".+\\s*.*\")|\\+|\\-|\\*|\\/|%|"
            + ";|=|(\\w+)";
    public InputManager(String input){
        this.input = input;
        Matcher matcher = Pattern.compile(inputRegExPattern).matcher(input);

        while(matcher.find()){
            inputSorted.add(matcher.group());
        }
        isFileOpen = true;
    }
    public void LexicalAnalysis(){
        if(!isFileOpen)return;
        LexicalAnalyzer lexicalAnalyzer =  new LexicalAnalyzer();
        
        tokenList = lexicalAnalyzer.GetTokenList(inputSorted);
        dataString = lexicalAnalyzer.GetDataString();
        valueList = lexicalAnalyzer.GetValueList();
        arithOpList = lexicalAnalyzer.GetArithOpList();
    }
    public boolean SyntaxAnalysis(){
        boolean isSyntaxEqual =  new SyntaxAnalyzer().IsPatternEqual(tokenList);
        isSyntaxValid = isSyntaxEqual;
        return isSyntaxEqual;
    }
    public boolean SemanticAnalysis(){
        boolean isSemanticValid = new SemanticAnalyzer().IsTypeMatched(dataString,valueList);
        return isSemanticValid;
    }
    public List<String> GetTokenList(){
        return tokenList;
    }
    
}
enum DataType{
     StringType,charType,intType,doubleType
}
