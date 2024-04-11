package Sorting;
class OrderedArray {
    private long[] a;
    private int nElems;

    public OrderedArray(int max)
    {
        a = new long[max];
        nElems = 0;
    }
    public int size()
    {
        return nElems;
    }
    public int find(long searchKey)
    {
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while(true)
        {
            curIn = (lowerBound + upperBound) / 2;

            if(a[curIn]==searchKey)
                return curIn;
            else if(lowerBound > upperBound)
                return nElems;
            else
            {
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }
    public void insert(long value)
    {
        int j;
        for(j = 0; j < nElems;j++)
            if(a[j] > value) //linear search
                break;
        for(int k = nElems; k > j; k--)
            a[k] = a[k-1]; //moves bigger ones up
        a[j] = value; // insert it
        nElems++; //increment size
    }
    public boolean delete(long value)
    {
        int j = find(value);
        if(j == nElems)
            return false;
        else 
        {
            for(int k = j; k < nElems; k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }

    public void display()
    {
        for(int j=0; j<nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println(" ");
    }
}

class OrderedArrayApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;
        OrderedArray arr; //reference to the array
        arr = new OrderedArray(maxSize);
        
        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(5);
        arr.insert(5);
        arr.insert(6);
        arr.insert(7);
        arr.insert(8);

        int searchKey = 6;

        if( arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
        
        arr.display();

        arr.delete(5);
        arr.delete(8);
        arr.delete(1);

        arr.display();
    }
}
