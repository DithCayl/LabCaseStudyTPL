/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpl.group2.labcasestudy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class SyntaxAnalyzer {
    
    List<String> patternList = new ArrayList<String>();
    String pattern1 ="<data_type><identifier><assignment_operator><value><delimiter>";
    String pattern2 ="<data_type><identifier><delimiter>";
    String pattern3 ="<identifier><assignment_operator><value><delimiter>";
    
    public SyntaxAnalyzer(){
        patternList.add(pattern1);
        patternList.add(pattern2);
        patternList.add(pattern3);
    }
    
    public boolean IsPatternEqual(List<String> tokenList){
        String tokenString ="";
        for(String token: tokenList){
            tokenString+=token;
        }
        for(String pattern: patternList){
            if(tokenString.equals(pattern))return true;
        }
        return false;
    }
}
