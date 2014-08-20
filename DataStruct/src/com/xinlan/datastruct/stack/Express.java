package com.xinlan.datastruct.stack;

import java.util.Stack;

/**
 * 
 * 利用栈
 * 处理输入表达式类
 * @author panyi
 *
 */
public class Express
{
    private Express instance;
    private Express(){}

    public Express getInstance()
    {
        if(instance==null)
        {
            instance = new Express();
        }
        
        return instance;
    }
    
    public float calExpress(String expressString)
    {
        
        return calExpress(expressString.toCharArray());
    }
    
    /**
     * 读取逆波兰式  计算表达式的值
     * @param expr
     * @return
     */
    public float calExpress(char expr[])
    {
        Stack<Character> stack = new Stack<Character>();
        
        
        
        return 10;
    }
}//end class
