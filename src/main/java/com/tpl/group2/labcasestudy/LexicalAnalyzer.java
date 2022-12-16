/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tpl.group2.labcasestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class LexicalAnalyzer {
    
     List<String> tokenList = new ArrayList();
     
     String dataString;
     List<String> valueList = new ArrayList();
     List<String> arithOpList = new ArrayList();
    
     public List<String> GetTokenList(List<String> input){
         
       for(String lexeme: input){
            if(IsDataType(lexeme)){
                tokenList.add("<data_type>");
                dataString = lexeme;
                continue;
            }
            if(IsIdentifier(lexeme)){
                tokenList.add("<identifier>");
                continue;
            }
            if(lexeme.equals("=")){
                tokenList.add("<assignment_operator>");
                continue;
            }
            if(IsArithmeticOp(lexeme)){
                tokenList.add("<arithmetic_operator>");
                arithOpList.add(lexeme);
                continue;
            }
            if(IsValueType(lexeme)){
                tokenList.add("<value>");
                valueList.add(lexeme);
                continue;
            }
            if(lexeme.equals(";")){
                tokenList.add("<delimiter>");
            }
        }
        return tokenList;
     }
     public boolean IsDataType(String input){
          boolean bool = input.equals("int")||input.equals("double")||
                  input.equals("String")||input.equals("char");
          return bool;
      }
      public boolean IsIdentifier(String input){
          String regExPattern = "[a-zA-Z_]\\w*";
          boolean bool = Pattern.matches(regExPattern,input);
          return bool;
      }
      public boolean IsValueType(String input){
          String regExPattern = "(-*\\d+)|" +   //int
                  "(-*\\d*\\.*\\d*)|" +         //double
                  "([\\\"\\'].+[\\\"\\'])";     //char
          boolean bool = Pattern.matches(regExPattern,input);
          return bool;
      }
      public boolean IsArithmeticOp(String input){
          String regExPattern ="\\+|\\-|\\*|\\/|%";                  //char
          boolean bool = Pattern.matches(regExPattern,input);
          return bool;
      }
      public String GetDataString(){
          return dataString;
      }
      public List<String> GetValueList(){
          return valueList;
      }
      public List<String> GetArithOpList(){
          return arithOpList;
      }
}
