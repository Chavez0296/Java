package Sorting;
class SelectSort {
    private long[] a;
    private int nElems;

    public SelectSort(int max)
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
    public void selectionSort()
    {
        int out, in, min;

        for(out = 0; out < nElems; out++)
        {
            min = out;
            for(in = out+1; in < nElems; in++)
                if(a[in] < a[min])
                    min = in;
                    swap(out, min);
        }
    }

    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
class SelectSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;
        SelectSort arr;
        arr = new SelectSort(maxSize);

        arr.insert(9);
        arr.insert(4);
        arr.insert(2);
        arr.insert(7);
        arr.insert(8);
        arr.insert(1);
        arr.insert(6);
        arr.insert(5);
        arr.insert(3);
        arr.insert(15);
        arr.insert(18);
        arr.insert(11);
        arr.insert(14);

        arr.display();

        arr.selectionSort();

        arr.display();
    }
}