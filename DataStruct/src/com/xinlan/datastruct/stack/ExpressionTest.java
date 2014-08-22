package com.xinlan.datastruct.stack;

import java.util.Scanner;

public class ExpressionTest
{

    public static void main(String[] args)
    {
        // Expression s = new Expression(" 23 + 57*(3 +100)+200 ");
        // Expression s = new Expression(" 23 + 57*(3 +100)+200 ");
        // Expression s = new Expression(" a*(b+c)+d");
        // s.toPostfix();
        // s.calculateWithPostfix();
        // System.out.println(Expression.calculate(" 23 + 57*(3 +100)+200 "));
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true)
        {
            System.out.print(" ‰»Îº∆À„ Ω:");
            input = scanner.nextLine();
            System.out.println(Expression.calculate(input));
        }// end while
    }

}// end class
