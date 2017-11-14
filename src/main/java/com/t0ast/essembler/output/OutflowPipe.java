/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.output;

import java.io.OutputStream;

/**
 *
 * @author T0astBread
 */
public abstract class OutflowPipe<T>
{
    private OutputStream outStream;

    public OutflowPipe(OutputStream outStream)
    {
        this.outStream = outStream;
    }

    protected OutputStream getOutStream()
    {
        return outStream;
    }
    
    public abstract void write(T value);
    public abstract void flush();
    public abstract void close();
}
