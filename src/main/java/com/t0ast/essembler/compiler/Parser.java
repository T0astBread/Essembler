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

/**
 *
 * @author T0astBread
 */
public class Parser
{
    public static final String FUNCTION_NAME_REGEX = "^(\\w|_)+$";
    
    public HashMap<String, Function> functions;

    public Parser()
    {
        this.functions = new HashMap<>();
    }
    
    public Map<String, Function> parse(String[] tokens) throws ParsingException
    {
        Map<String, Function> functions = new HashMap<>();
        for(int i = 0; i < tokens.length;)
        {
            String token = tokens[i++];
            if(!token.matches(FUNCTION_NAME_REGEX)) throw new ParsingException(i, token, "Function name malformed: " + token);
            Function newFunction = new Function(token);
            
            token = tokens[i++];
            if(!token.equals("{")) throw new ParsingException(i, token, "'{' expected after function header");
            
            while(true)
            {
                token = tokens[i++];
                if(token.equals("}")) break;
                if(token.equals(";")) continue;
                if(!token.matches(FUNCTION_NAME_REGEX)) throw new ParsingException(i, token, "Malformed function call in function " + newFunction.getName() + ": " + token);
                String calledFuncName = token;
                token = tokens[i++];
                int quantity = 1;
                if(token.equals("["))
                {
                    String malformedQuant = "Malformed quantifier in function " + newFunction.getName() + ": ";
                    token = tokens[i++];
                    if(!token.matches("\\d")) throw new ParsingException(i, token, malformedQuant + token);
                    int tempQuantitiy = Integer.parseInt(token);
                    token = tokens[i++];
                    if(!token.equals("]")) throw new ParsingException(i, token, malformedQuant + token);
                }
                if(!token.equals(";")) throw new ParsingException(i, token, "Syntax error in function " + newFunction.getName() + ": ; expected after call to " + calledFuncName + " instead of " + token);
                newFunction.appendFunctionCall(new FunctionCall(calledFuncName, quantity));
            }
            functions.put(newFunction.getName(), newFunction);
        }
        return functions;
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
