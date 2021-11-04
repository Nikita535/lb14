package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Expression = sc.nextLine();

        Stack<Double> stack = new Stack<Double>();
        String[] str = Expression.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (isNumber(str[i])) {
                stack.push(Double.parseDouble(str[i]));
            } else {
                try {
                    double a = stack.pop();
                    double b = stack.pop();

                    switch (str[i]) {
                        case "+":
                            stack.push(a + b);
                            break;
                        case "-":
                            stack.push(b-a);
                            break;
                        case "*":
                            stack.push(a * b);
                            break;
                        case "/":
                            stack.push(a / b);
                            break;
                    }
                }catch (EmptyStackException e) {
                    System.out.println("Невозможно извлечь элемент из пустого стека");
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }



        private static boolean isNumber(String string){
            try{
                Double.parseDouble(string);
                return true;
            }catch (NumberFormatException e){
                return false;
            }
        }
    }

