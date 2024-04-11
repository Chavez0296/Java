package Stacks;
import java.io.*;

class Stack
{
    private int top;
    private char[] stackArray;
    private int maxSize;
    public Stack(int s)
    {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }
    public void push(char j)
    {
        stackArray[++top] = j;
    }
    public char pop()
    {
        return stackArray[top--];
    }
    public char peek()
    {
        return stackArray[top];
    }
    public boolean isEmpty()
    {
        return (top == -1);
    }
}
class BracketChecker
{
    private String input;
    
    public BracketChecker(String in)
    { 
        input = in;
    }
    public void check()
    {
        int stackSize = input.length();
        Stack theStack = new Stack(stackSize);

        for(int i = 0; i < input.length();i++)
        {
            char ch = input.charAt(i);
            switch(ch)
            {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;

                case '}':
                case ']':
                case ')':
                    if( !theStack.isEmpty() )
                    {
                        char chx = theStack.pop();
                        if( (ch=='}' && chx!='{') || (ch==']' && chx!='[') || (ch==')' && chx!='(') )
                        {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                        
                    }
                    else
                            System.out.println("Error: " + ch + " at " + i);
                        break;
                    default:
                        break;
            }
        }
        if( !theStack.isEmpty() )
            System.out.println("Error: missing right delimiter");
    }

}
class BracketsApp {
    public static void main(String[] args) throws IOException
    {
        String input;
        while(true)
        {
            System.out.print("Enter string containing delimiters: ");
            System.out.flush();
            input = getString();
            if(input == "")
                break;

            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
        }
    }
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
