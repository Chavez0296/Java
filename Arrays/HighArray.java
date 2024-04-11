package Arrays;
class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max)
    {
        a = new long[max];
        nElems = 0;
    }
    public boolean find(long searchKey)
    {
        int j;
        for(j = 0; j<nElems;j++)
            if(a[j] == searchKey)
                break;
        if(j == nElems) //reached the end?
            return false; //not found
        else
            return true; //found
    }

    public void insert(long value)
    {
        a[nElems] = value; //insert it
        nElems++; //increment size
    }

    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems; j++)
            if( value == a[j])
                break;
        if( j == nElems) // can't find it
            return false;
        else
        {
            for(int k = j; k < nElems; k++)
                a[k] = a[k+1]; // move all elements down
            nElems--; //decrement size
            return true;
        }
    }

    public void display()
    {
        for(int j =0; j<nElems;j++)
            System.out.print(a[j] + " ");
        System.out.println(" ");
    }
}
class HighArrayApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;
        HighArray arr;
        arr = new HighArray(maxSize);

        arr.insert(1);
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(5);
        
        arr.display();

        int searchKey = 5;
        if(arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
        
        arr.delete(3);
        arr.delete(4);

        arr.display();
    }
}
