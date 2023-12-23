package Recursion;

class OrdArray
{
    private long[] a;
    private int nElems;

    public OrdArray(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public int size()
    {return nElems;}

    public int find(long searchKey)
    {
        return recFind(searchKey, 0, nElems-1);
    }
    private int recFind(long searchKey, int lowerBound, int upperBound)
    {
        int curIn;

        curIn = (lowerBound + upperBound) / 2;

        if(a[curIn]==searchKey)
            return curIn;
        else if(lowerBound > upperBound)
            return nElems;
        else
        {
            if(a[curIn] < searchKey)
                return  recFind(searchKey, curIn+1, upperBound); //it's in the upper half
            else
                return recFind(searchKey, lowerBound, curIn-1); //it's in the lower half
        }
    }
    public void insert(long value)
    {
        int j;
        for(j = 0; j < nElems; j++) //linear search
            if(a[j] > value)        //find where it goes if it's smaller than the first value or a value, break the loop and it will hold 
                break;              // the value a[j] that it breaks with.
        for(int k = nElems; k>j; k--) //move bigger ones up the array
            a[k] = a[k-1];
        a[j] = value; //insert it 
        nElems++;     //increment size
    }

    public void display()
    {
        for(int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
}
class BinarySearchApp {
    public static void main(String[] args)
    {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);

        arr.insert(2);
        arr.insert(4);
        arr.insert(6);
        arr.insert(8);
        arr.insert(9);
        arr.insert(7);
        arr.insert(5);
        arr.insert(3);
        arr.insert(1);
        arr.insert(11);
        arr.insert(12);
        arr.insert(13);
        arr.insert(14);
        arr.insert(15);
        arr.insert(16);
        arr.insert(17);

        arr.display();

        int searchKey = 15;
        if( arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
    }
}
