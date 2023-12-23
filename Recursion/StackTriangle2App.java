package Recursion;


import java.io.*;

class StackV
{
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackV(int s)
    {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int p)
    {
        stackArray[++top] = p;
    }

    public int pop()
    {
        return stackArray[top--];
    }

    public int peek()
    {
        return stackArray[top];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }
}
class StackTriangle2App {
    static int theNumber;
    static int theAnswer;
    static StackV theStack;
    public static void main(String[] args) throws IOException
    {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        stackTriangle();
        System.out.println("Triangle="+theAnswer);
    }

    public static void stackTriangle()
    {
        theStack = new StackV(10000);

        theAnswer = 0;

        while( theNumber > 0 )
        {
            theStack.push(theNumber);
            --theNumber;
        }
        while( !theStack.isEmpty() )
        {
            int newN = theStack.pop();
            theAnswer += newN;
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }


}
