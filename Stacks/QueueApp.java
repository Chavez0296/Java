
class Queue{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public Queue(int n)
    {
        maxSize = n+1;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }
    public void push(long i)
    {
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = i;
    }
    public long remove()
    {
        long temp = queArray[front++];
        if(front == maxSize)
            front = 0;
        return temp;
    }
    public long peek()
    {
        return queArray[front];
    }
    public boolean isEmpty()
    {
        return ( rear+1 == front || (front+maxSize-1 == rear));
    }
    public boolean isFull()
    {
        return ( rear+2==front || (front+maxSize-2==rear) );
    }
    public int size()
    {
        if(rear >= front)
            return rear-front+1;
        else 
            return (maxSize-front) + (rear+1);
    }
}
class QueueApp {
    public static void main(String[] args)
    {
    Queue whatQueue = new Queue(5);
    whatQueue.push(30);
    whatQueue.push(40);
    whatQueue.push(50);
    whatQueue.push(60);
    whatQueue.push(80);

    long values;
    values = whatQueue.peek();
    System.out.println("The front of the Queue is " + values);

    values = whatQueue.size();
    System.out.println("The size of the Queue is " + values);

    System.out.println("isEmpty: " + whatQueue.isEmpty());
    System.out.println("isFull: " + whatQueue.isFull());

    while(!whatQueue.isEmpty())
    {
        values = whatQueue.remove();
        System.out.print(values + " ");

    }

    System.out.println("");
    }


}
