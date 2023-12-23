
class Stack
{
    private int maxSize;
    private long[] stackArray;
    private int top;
    
    public Stack(int s) //constructor
    {
        maxSize = s; //assign s to maxSize
        stackArray = new long[maxSize]; //create array with maxSize
        top = -1; //set to negative one because there are no items yet.
    }

    public void push(long j)
    {
        stackArray[++top] = j; // assign value to top preincremented so that it is properly assigned to the right value since top = -1 =>
                            // => ++-1 = j also means stackArray[0] = j;
    }

    public long pop()
    {
        return stackArray[top--]; //accessing the top most item and then decrement the top
    }
    
    public long peek()
    {
        return stackArray[top];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public boolean isFull()
    {
        return (top == maxSize-1);
    }
}
class StackApp{
    public static void main(String[] args)
    {
        Stack theStack = new Stack(10);
        long values;
        theStack.push(2);
        theStack.push(10);
        theStack.push(20);

        values = theStack.peek();
        System.out.println(values);

        theStack.push(40);
        theStack.push(100);
        
        values = theStack.peek();
        System.out.println(values);

        while(!theStack.isEmpty())
        {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}