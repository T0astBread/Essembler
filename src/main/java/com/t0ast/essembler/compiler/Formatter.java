/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.compiler;

import static com.t0ast.essembler.compiler.Tokenizer.REGEX_LINE_BREAK;

/**
 *
 * @author T0astBread
 */
public class Formatter
{
    public String format(String source)
    {
        return source.replaceAll(REGEX_LINE_BREAK + "|\\s", "");
    }
}
