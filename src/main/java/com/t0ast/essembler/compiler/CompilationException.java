/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.compiler;

/**
 *
 * @author T0astBread
 */
public class CompilationException extends Exception
{

    public CompilationException()
    {
    }
    
    public CompilationException(String message)
    {
        super(message);
    }
    
    public CompilationException(Throwable cause)
    {
        super(cause);
    }
}
