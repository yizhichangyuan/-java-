import src.Stack;
import java.util.Scanner;

public class ex1304 {
    public static boolean Parentheses(String a) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if(c == '{' || c == '[' || c == '(')
                stack.push(c);
            else if(c == '}' && (stack.isEmpty() || stack.pop() != '{')
                    || c == ']' && (stack.isEmpty() || stack.pop() != '[')
                    || c == ')' && (stack.isEmpty() || stack.pop() != '('))
                return false;
    }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        System.out.println(Parentheses(a));
    }
}
