class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value)
    {
        a[nElems] = value;
        nElems++;
    }

    public void display()
    {
        for(int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println(" ");
    }

    public void bubbleSort()
    {
        int out, in;

        for(out = nElems - 1; out > 1; out--)
            for(in = 0; in < out; in++)
                if(a[in] > a[in+1])
                    swap(in, in+1);
    }

    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
class BubbleSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);

        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(5);
        arr.insert(9);
        arr.insert(8);
        arr.insert(7);
        arr.insert(6);

        arr.display();
        arr.bubbleSort();
        arr.display();
    }
}