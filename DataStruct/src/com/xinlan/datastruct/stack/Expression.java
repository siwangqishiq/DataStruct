package com.xinlan.datastruct.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * ���ʽ������
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
     * ����
     * 
     * @return
     */
    public String calculate()
    {
        toPostfix();
        return calculateWithPostfix() + "";
    }

    public static String calculate(String expression)
    {
        Expression exp = new Expression(expression);
        return exp.calculate();
    }

    /**
     * ��׺���ʽ��дΪ��׺���ʽ �沨��ʽ
     * 
     * @return
     */
    public String toPostfix()
    {
        storeMidfix = splitExpress();

        // System.out.println("-------���ʽ-----");
        // for (int i = 0; i < storeMidfix.size(); i++)
        // {
        // System.out.print(storeMidfix.get(i).toString() + " ");
        // }// end for i
        // System.out.println();

        postfix = new ArrayList<Object>();
        // postfix.addAll(storeMidfix);
        Stack<Object> workStack = new Stack<Object>();
        for (int i = 0, size = storeMidfix.size(); i < size; i++)
        {
            Object element = storeMidfix.get(i);
            // System.out.println("--->" + element);
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
                        workStack.push(curElement);// ������ ( ��ջ
                        break;
                    case ')':
                        while (!workStack.isEmpty()
                                && (Character) workStack.peek() != '(')
                        {
                            Character addOutput = (Character) workStack.pop();// ��ǰջ��Ԫ�س�ջ
                            if (addOutput != '(')// ����� ���������
                            {
                                postfix.add(addOutput);// ��������б�
                            }
                        }// end while

                        if ((Character) workStack.peek() == '(')
                        {
                            workStack.pop();// �Ƴ�ջ�е�'('�ַ�
                        }
                        break;
                    default:
                        while (!workStack.isEmpty()
                                && priority.get((Character) workStack.peek()) >= priority
                                        .get(curElement))
                        {
                            Character addOutput = (Character) workStack.pop();// ��ǰջ��Ԫ�س�ջ
                            postfix.add(addOutput);// ��������б�
                        }// end while
                        workStack.push(curElement);// ��ǰ������ ��ջ
                }// end switch
            }// end if
        }// end for i

        while (!workStack.isEmpty())
        {
            Character addToOutput = (Character) workStack.pop();// ��ǰջ��Ԫ�س�ջ
            if (addToOutput != '(')// ����¼ �ַ�'('
            {
                postfix.add(addToOutput);// ��������б�
            }
        }// end while

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < postfix.size(); i++)
        {
            // System.out.print(postfix.get(i).toString() + " ");
            sb.append(postfix.get(i).toString() + "  ");
        }// end for i
         // System.out.println("-------��׺���ʽ-----");
        // System.out.println(sb.toString());

        return sb.toString();
    }

    public float calculateWithPostfix()
    {
        if (postfix == null)
        {
            return 0;
        }
        Stack<Object> stack = new Stack<Object>();
        for (int i = 0, size = postfix.size(); i < size; i++)
        {
            Object obj = postfix.get(i);
            // System.out.println(obj);
            if (obj instanceof Character)
            {
                Character oper = (Character) obj;
                String num2 = (String) stack.pop();
                String num1 = (String) stack.pop();

                String result = calculateWithTwo(num1, num2, oper) + "";
                stack.push(result);
            }
            else if (obj instanceof String)
            {
                stack.push(obj);
            }
        }// end for i

        // System.out.println(stack.pop());
        String ret = (String) stack.pop();
        return Float.parseFloat(ret);
    }

    public float calculateWithTwo(String num1, String num2, char oper)
    {
        float op1 = Float.parseFloat(num1);
        float op2 = Float.parseFloat(num2);
        return calculateWithTwo(op1, op2, oper);
    }

    public float calculateWithTwo(float num1, float num2, char oper)
    {
        float result = 0f;
        switch (oper)
        {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }// end switch
        return result;
    }

    private List<Object> splitExpress()
    {
        List<Object> retList = new ArrayList<Object>();
        String filterString = data.replaceAll(" ", "").trim();
        final char[] dataChars = filterString.toCharArray();

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
                    if (!"".equals(temp.trim()))
                    {
                        retList.add(temp);
                    }
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
