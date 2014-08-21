package com.xinlan.datastruct.stack;

import java.util.Stack;

/**
 * 
 * 利用栈 处理输入表达式类
 * 
 * @author panyi
 * 
 */
public class Express
{
    public Express()
    {
    }

    public float calExpress(String expressString) throws Exception
    {

        return calExpress(expressString.toCharArray());
    }

    /**
     * 读取逆波兰式 计算表达式的值
     * 
     * @param expr
     * @return
     */
    public float calExpress(char expr[]) throws Exception
    {
        if (expr == null)
        {
            throw new Exception("表达式为空");
        }

        Stack stack = new Stack();
        String cache = "";
        boolean isNumber = false;
        for (int i = 0, size = expr.length; i < size; i++)
        {
            char readChar = expr[i];
            switch (readChar)
            {
                case '+':
                case '-':
                case '*':
                case '/':
                    stack.push(cache);
                    isNumber = false;
                    cache = "";
                    float num2 = Float.parseFloat((String)stack.pop());
                    float num1 = Float.parseFloat((String)stack.pop());
                    String calResult = calculate(num1,num2,readChar)+"";
                    stack.push(calResult);
                    break;
                default:
                    cache+=readChar;
                    System.out.println(cache);
                    isNumber = true;
                    
            }// end switch
        }// end for i

        return Float.parseFloat((String)stack.pop());
    }
       
    public static float calculate(float x,float y,char oper) throws Exception
    {
        float result = 0f;
        switch (oper)
        {
            case '+':
                result = x+y;
                break;
            case '-':
                result = x-y;
                break;
            case '*':
                result = x*y;
                break;
            case '/':
                result = x/y;
                break;
            default:
                throw new Exception("非法运算符");
        }// end switch
        
        return result;
    }
    
    

    private void readChar(char c)
    {
        
    }

}// end class
