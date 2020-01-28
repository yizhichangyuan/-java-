import src.Stack;
import java.util.Scanner;

public class Evalute {
    public static Double calcutor(String str) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/')
                stack.push(Character.toString(c));
            else if (c == ')') {
                double c1 = Double.parseDouble(stack.pop());
                String c2 = stack.pop();
                double c3 = Double.parseDouble(stack.pop());
                if (c2.equals("+"))
                {
                    stack.push(Double.toString(c1 + c3));
                }
                else if (c2.equals("-"))
                    stack.push(Double.toString(c1 - c3));
                else if (c2.equals("*"))
                    stack.push(Double.toString(c1 * c3));
                else if (c2.equals("/"))
                    stack.push(Double.toString(c1 / c3));
            }
            else if(c == ' ' || c == '(')
                ;
            else
                stack.push(Character.toString(c));
        }
//        System.out.println(stack.peek());
        return Double.parseDouble(stack.peek());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("input a string to calculate");
        String str = scan.nextLine();
        System.out.println("calculate result: " + calcutor(str));
    }
    }

