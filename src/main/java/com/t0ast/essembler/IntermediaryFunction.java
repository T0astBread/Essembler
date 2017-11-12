/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T0astBread
 */
public class IntermediaryFunction
{
    private String name;
    private List<String> bodyTokens;

    public IntermediaryFunction(String name)
    {
        this(name, 16);
    }
    
    public IntermediaryFunction(String name, int bodyLength)
    {
        this.name = name;
        this.bodyTokens = new ArrayList<>(bodyLength);
    }

    public String getName()
    {
        return name;
    }

    public List<String> getBodyTokens()
    {
        return bodyTokens;
    }
    
    public void appendBodyToken(String token)
    {
        this.bodyTokens.add(token);
    }
}
