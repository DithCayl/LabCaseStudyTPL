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
    List<String> inputSorted = new ArrayList<String>();
    List<String> tokenList = new ArrayList<String>();
    
    boolean isFileOpen = false;
    
    
    String inputRegExPattern = "(\".+\\s*.*\")|;|=|(\\w+)";
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
        tokenList = new LexicalAnalyzer().GetTokenList(inputSorted);
    }
    
    public List<String> GetTokenList(){
        return tokenList;
    }
}
