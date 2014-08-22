package com.xinlan.datastruct.stack;

public class ExpressionTest
{

    public static void main(String[] args)
    {
        Expression s = new Expression(" 23 + 57*(3 +100)+200 ");
        //Expression s = new Expression(" a*(b+c)+d");
        s.toPostfix();
    }

}//end class
