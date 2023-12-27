//demonstrates simple version of quicksort

class ItemOb
{
    private long[] theArray;
    private int nElems;

    public ItemOb(int max)
    {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value)
    {
        theArray[nElems] = value;
        nElems++;
    }

    public void display()
    {
        System.out.print("A= ");
        for(int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }
    public void quickSort()
    {
        recQuickSort(0, nElems-1);
    }
    public void recQuickSort(int left, int right)
    {
        if(right-left <= 0)
            return;
        else
        {
            long pivot = theArray[right]; // right most item 

            int partition = partitionIt2(left, right, pivot);
            recQuickSort(left, partition-1);  //sort leftside
            recQuickSort(partition+1, right); //sort rightside
        }
    }
    public int partitionIt2(int left, int right, long pivot)
    {
        int leftPtr = left - 1;  //left (after ++)
        int rightPtr = right;    //right-1 (after --)
        while(true)
        {
            while( theArray[++leftPtr] < pivot) // find bigger item
                ;
            while (rightPtr > 0 && theArray[--rightPtr] > pivot ) //find smaller item
                ;
            
            if(leftPtr >= rightPtr) //if pointers cross
                break;              //partition done
            else
                swap(leftPtr, rightPtr); //not crossed, swap elements
        }
        swap(leftPtr, right); //restore pivot
        return leftPtr;         //return pivot location
    }
    public void swap(int dex1, int dex2)
    {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}
class QuickSort1App {
    public static void main(String[] args)
    {
        int maxSize = 16;
        ItemOb arr;
        arr = new ItemOb(maxSize);

        for(int j = 0; j < maxSize; j++)
        {
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }

        arr.display();
        arr.quickSort();
        arr.display();
    }
}
