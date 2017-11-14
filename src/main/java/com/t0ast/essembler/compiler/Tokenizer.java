/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.compiler;

import java.util.Arrays;

/**
 *
 * @author T0astBread
 */
public class Tokenizer
{
    private static final String[] TOKEN_DELIMITERS = {"{", ";", "}"};
    
    private Formatter formatter;

    public Tokenizer()
    {
        this.formatter = new Formatter();
    }
    
    public String[] tokenize(String source)
    {
        return cleanTokens(split(this.formatter.format(source)));
    }
    
    private String[] split(String formattedSource)
    {
        String splittable = formattedSource;
        for(String delimeter : TOKEN_DELIMITERS)
        {
            splittable = splittable.replace(delimeter, " " + delimeter + " ");
        }
//        System.out.println(splittable);
        return splittable.split(" ");
    }
    
    private String[] cleanTokens(String[] tokens)
    {
        return Arrays.stream(tokens).filter(t -> !t.replace("\\s", "").isEmpty()).toArray(String[]::new);
    }
}
