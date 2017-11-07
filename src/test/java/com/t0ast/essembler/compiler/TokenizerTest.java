/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.compiler;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author T0astBread
 */
public class TokenizerTest
{
    
    public TokenizerTest()
    {
    }

    /**
     * Test of tokenize method, of class Tokenizer.
     */
    @Test
    public void testTokenize()
    {
        System.out.println("tokenize");
        String source = "my_function_one\n{\nmy_function_two;\n}\n";
        Tokenizer tokenizer = new Tokenizer();
        String[] expResult = {"my_function_one", "{", "my_function_two", ";", "}"};
        String[] result = tokenizer.tokenize(source);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expResult, result);
        System.out.println("Passed\n");
    }
    
}
