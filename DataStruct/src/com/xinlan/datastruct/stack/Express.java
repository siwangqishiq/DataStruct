package com.xinlan.datastruct.stack;

import java.util.Stack;

/**
 * 
 * ����ջ
 * ����������ʽ��
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
     * ��ȡ�沨��ʽ  ������ʽ��ֵ
     * @param expr
     * @return
     */
    public float calExpress(char expr[])
    {
        Stack<Character> stack = new Stack<Character>();
        
        
        
        return 10;
    }
}//end class
