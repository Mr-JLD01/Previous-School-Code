//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Assignment: Interview Questions
//Submission Time: 5:30 PM

package interviewquestions;

import java.util.*;
/**
 *
 * @author jdenny3
 */
public class InterviewQuestions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("Racecar"));
        System.out.println(isPalindrome("steve"));
        System.out.println(isPalindrome("Taco cat"));
        System.out.println(isBalancedExpression("{}{}({()})") );
        System.out.println(isBalancedExpression("((){}{}") );
        System.out.println(evaluateExpression("42+351-*+"));
        System.out.println(evaluateExpression("545*+5/"));
        System.out.println(evaluateExpression("222^^"));

    }

    public static boolean isPalindrome(String s)
    {
        Stack<Character> palindrome = new Stack<>();
        char[] chars = s.toCharArray();
        
        for(char c : chars)
            palindrome.push(c);
        
        String reverse = "";
        for(int i = 0; i < chars.length; i++)
            reverse += palindrome.pop();
        
        return reverse.replace(" ", "").equalsIgnoreCase(s.replace(" ", ""));
    }
    
    public static boolean isBalancedExpression(String s)
    {
        Stack<Character> exp = new Stack<>();
        char[] chars = s.toCharArray();
        
        for(char c : chars)
        {
            if(c == '(' || c == '{' || c == '[')
                exp.push(c);
            else if((c == ')' && exp.peek() == '(') || (c == '}' && exp.peek() == '{') || (c == ']' && exp.peek() == '['))  
                exp.pop();
        }
        
        return exp.isEmpty();
    }
    
    public static int evaluateExpression(String s)
    {
        Stack<Integer> exp = new Stack<>();
        char[] chars = s.toCharArray();
        
        for(char c : chars)
        {
            if(Character.isDigit(c))
                exp.push(Character.getNumericValue(c));
            else
            {
                switch(c){
                    case '+': exp.push(exp.pop() + exp.pop()); break;
                    case '-': exp.push(-1 * exp.pop() + exp.pop());break;
                    case '*': exp.push(exp.pop() * exp.pop());break;
                    case '/': exp.push( (int)((1 / (double)exp.pop()) * (double)exp.pop()));break;
                    case '^': int power = exp.pop(); exp.push((int)Math.pow(exp.pop(), power));
                }
            }
        }
        if(exp.size() == 1)
            return exp.pop();
        return -1;
    }   
    
}
