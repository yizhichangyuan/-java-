import src.Stack;
import java.util.Scanner;
public class ex1309 {
    public static String addBracket(String str){
        Stack<String> stackVal = new Stack<String>();
        Stack<String> stackOpt = new Stack<String>();
        int size = str.length();
        for(int i = 0; i < size; i++){
            char c = str.charAt(i);
            if(c == '+'|| c == '-' || c == '*' || c == '/')
                stackOpt.push(Character.toString(c));
            else if(c == ')') {
                String opt = stackOpt.pop();
                String val1 = stackVal.pop();
                String val2 = stackVal.pop();
                String v = "(" + val2 + opt + val1 + ")";
                stackVal.push(v);
            }
            else if(c == ' ')
                ;
            else
                stackVal.push(Character.toString(c));
            }
        String s1 = "";
        while(!stackVal.isEmpty())
            s1 += stackVal.pop();
        return s1;
        }

    public static void main(String[] args) {
        System.out.println("please input a string");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println("after add bracket: " + addBracket(str));
    }
    }

