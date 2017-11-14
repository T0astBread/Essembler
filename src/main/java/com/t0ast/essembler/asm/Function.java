/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.asm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author T0astBread
 */
public class Function
{
    private String name;
    private List<FunctionCall> body;

    public Function(String name)
    {
        this(name, 16);
    }
    
    public Function(String name, int bodyLength)
    {
        this.name = name;
        this.body = new ArrayList<>(bodyLength);
    }
    
    public Function(String name, FunctionCall[] body)
    {
        this(name, body.length);
        Stream.of(body).forEach(this.body::add);
    }

    public String getName()
    {
        return name;
    }
    
    public void appendFunctionCall(FunctionCall call)
    {
        this.body.add(call);
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Function && this.body.stream().allMatch(c -> ((Function) obj).body.contains(c));
    }
}
