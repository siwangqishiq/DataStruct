package com.xinlan.datastruct.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 表达式处理类
 * 
 * @author panyi
 * 
 */
public class Expression
{
    private String data;
    private List<Object> storeMidfix;
    private List<Object> postfix;//

    private static Map<Character, Integer> priority = new HashMap<Character, Integer>();
    static
    {
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 3);
        priority.put('/', 3);
        priority.put('(', 0);
        priority.put(')', 0);
    }

    public Expression(String data)
    {
        this.data = data;
    }

    /**
     * 中缀表达式改写为后缀表达式 逆波兰式
     * 
     * @return
     */
    public String toPostfix()
    {
        storeMidfix = splitExpress();

        System.out.println("-------表达式-----");
        for (int i = 0; i < storeMidfix.size(); i++)
        {
            System.out.print(storeMidfix.get(i).toString() + " ");
        }// end for i
        System.out.println();

        postfix = new ArrayList<Object>();
        // postfix.addAll(storeMidfix);
        Stack<Object> workStack = new Stack<Object>();
        for (int i = 0, size = storeMidfix.size(); i < size; i++)
        {
            Object element = storeMidfix.get(i);
            if (element instanceof String)
            {
                postfix.add(element);
            }
            else if (element instanceof Character)
            {
                Character curElement = (Character) element;
                switch (curElement)
                {
                    case '(':
                        workStack.push(curElement);// 操作符 ( 入栈
                        break;
                    case ')':
                        while (!workStack.isEmpty()
                                && (Character) workStack.peek() != '(')
                        {
                            Character addOutput = (Character) workStack.pop();// 当前栈顶元素出栈
                            if (addOutput != '(')// 运算符 加入输出表
                            {
                                postfix.add(addOutput);// 加入输出列表
                            }
                        }// end while
                        
                        if((Character) workStack.peek() == '(')
                        {
                            workStack.pop();//移除栈中的'('字符
                        }
                        break;
                    default:
                        while (!workStack.isEmpty()
                                && priority.get((Character) workStack.peek()) >= priority
                                        .get(curElement))
                        {
                            Character addOutput = (Character) workStack.pop();// 当前栈顶元素出栈
                            postfix.add(addOutput);// 加入输出列表
                        }// end while
                        workStack.push(curElement);// 当前操作符 入栈
                }// end switch
            }// end if
        }// end for i

        while (!workStack.isEmpty())
        {
            Character addToOutput = (Character) workStack.pop();// 当前栈顶元素出栈
            if (addToOutput != '(')// 不记录 字符'('
            {
                postfix.add(addToOutput);// 加入输出列表
            }
        }// end while

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < postfix.size(); i++)
        {
            // System.out.print(postfix.get(i).toString() + " ");
            sb.append(postfix.get(i).toString() + "  ");
        }// end for i
        System.out.println("-------后缀表达式-----");
        System.out.println(sb.toString());

        return sb.toString();
    }
    
    

    private List<Object> splitExpress()
    {
        List<Object> retList = new ArrayList<Object>();
        final char[] dataChars = data.replaceAll(" ", "").trim().toCharArray();

        String temp = "";
        for (int i = 0, length = dataChars.length; i < length; i++)
        {
            char oneChar = dataChars[i];

            switch (oneChar)
            {
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                case ')':
                    retList.add(temp);
                    temp = "";
                    retList.add(oneChar);
                    break;
                default:
                    temp += oneChar;
            }// end switch
        }// end for i
        if (!"".equals(temp))
        {
            retList.add(temp);
        }
        return retList;
    }

}// end class
