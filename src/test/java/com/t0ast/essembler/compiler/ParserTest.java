/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.compiler;

import com.t0ast.essembler.asm.Function;
import com.t0ast.essembler.asm.FunctionCall;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author T0astBread
 */
public class ParserTest
{
    
    public ParserTest()
    {
    }

    /**
     * Test of parse method, of class Parser.
     * @throws java.lang.Exception when something goes wrong
     */
    @Test
    public void testParse() throws Exception
    {
        System.out.println("parse");
        String[] tokens = {"my_func", "{", "my_other_func", ";", "my_third_func", ";", "}"};
        Parser instance = new Parser();
        Map<String, Function> expResult = new HashMap<>();
        expResult.put("my_func", new Function("my_func", new FunctionCall[]{new FunctionCall("my_other_func", 1), new FunctionCall("my_third_func", 1)}));
        Map<String, Function> result = instance.parse(tokens);
        assertEquals(expResult, result);
    }
    
}
