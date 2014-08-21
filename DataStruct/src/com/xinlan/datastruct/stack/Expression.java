package com.xinlan.datastruct.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式处理类
 * 
 * @author panyi
 * 
 */
public class Expression
{
    private String data;
    private List<Object> store;

    public Expression(String data)
    {
        this.data = data;
    }

    public String toPostfix()
    {
        store = splitExpress();

        for (int i = 0; i < store.size(); i++)
        {
            System.out.print(store.get(i).toString() + " ");
        }
        
        

        return "";
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
