/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.asm;

/**
 *
 * @author T0astBread
 */
public class FunctionCall
{
    private String functionName;
    private int quantitiy;
    
    public FunctionCall(String functionName)
    {
        this(functionName, 1);
    }

    public FunctionCall(String functionName, int quantity)
    {
        this.functionName = functionName;
        this.quantitiy = quantity;
    }

    public String getFunctionName()
    {
        return functionName;
    }

    public int getQuantitiy()
    {
        return quantitiy;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof FunctionCall)) return false;
        FunctionCall fcObj = (FunctionCall) obj;
        return this.functionName.equals(fcObj.functionName) && this.quantitiy == fcObj.quantitiy;
    }
}
