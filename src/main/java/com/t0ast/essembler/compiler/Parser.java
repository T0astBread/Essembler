/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.essembler.compiler;

import com.t0ast.essembler.IntermediaryFunction;
import java.util.HashMap;

/**
 *
 * @author T0astBread
 */
public class Parser
{
    public static final String FUNCTION_NAME_REGEX = "^(\\w|_)+$";
    
    public HashMap<String, IntermediaryFunction> functions;

    public Parser()
    {
        this.functions = new HashMap<>();
    }
    
    public HashMap<String, IntermediaryFunction> parse(String[] tokens) throws ParsingException
    {
        this.functions.clear();
        for(int i = 0; i < tokens.length;)
        {
            String token = tokens[i++];
            if(!token.matches(FUNCTION_NAME_REGEX)) throw new ParsingException(i, token, "Function name malformed: " + token);
            IntermediaryFunction newFunction = new IntermediaryFunction(token);
            
            token = tokens[i++];
            if(!token.equals("{")) throw new ParsingException(i, token, "'{' expected after function header");
            
            while(true)
            {
                token = tokens[i++];
                if(token.equals("}")) break;
                if(token.equals(";")) continue;
                if(!token.matches(FUNCTION_NAME_REGEX)) throw new ParsingException(i, token, "Malformed function call in function " + newFunction.getName() + ": " + token);
                token = tokens[i++];
                // Next: quantifiers
                // LAST EDITED - 8.11.
            }
        }
    }
    
    public static class ParsingException extends CompilationException
    {
        private int tokenIndex;
        private String token;

        public ParsingException(int tokenIndex, String token)
        {
            this.tokenIndex = tokenIndex;
            this.token = token;
        }

        public ParsingException(int tokenIndex, String token, String message)
        {
            super(message);
            this.tokenIndex = tokenIndex;
            this.token = token;
        }

        public ParsingException(int tokenIndex, String token, Throwable cause)
        {
            super(cause);
            this.tokenIndex = tokenIndex;
            this.token = token;
        }
    }
}
