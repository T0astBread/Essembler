/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.output;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author T0astBread
 */
public class StringOutflowPipe extends OutflowPipe<String>
{
    private PrintWriter outStreamWriter;

    public StringOutflowPipe(OutputStream outStream)
    {
        super(outStream);
        this.outStreamWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outStream)));
    }
    
    @Override
    public void write(String value)
    {
        this.outStreamWriter.print(value);
    }

    @Override
    public void flush()
    {
        this.outStreamWriter.flush();
    }

    @Override
    public void close()
    {
        this.outStreamWriter.close();
    }
}
