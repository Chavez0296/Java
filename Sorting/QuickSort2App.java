//demonstrates quick sort with median of three partitioning
package Sorting;
class ItemIns
{
    private long[] theArray; //ref to array theArray
    private int nElems;
    public ItemIns(int max)
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
        int size = right-left+1;
        if(size <= 3)
            manualSort(left,right);  //manual sort if small
        else
        {                                           //quicksort if large
            long median = medianOf3(left, right);           //selects a pivot to be the median on the right 
            int partition = partitionIt(left, right, median);  //returns a partition value after a sort 
            recQuickSort(left, partition-1);                    // starts sorting the left side
            recQuickSort(partition+1, right);                   //starts sorting the right side
        }
    }
    public long medianOf3(int left, int right)
    {
        int center = (left+right)/2;

        if( theArray[left] > theArray[center] ) //Order left & center
            swap(left, center); 
        
        if( theArray[left] > theArray[right] )  //Order left & right
            swap(left, right);

        if( theArray[center] > theArray[right] ) //Order center & right
            swap(center, right);

        swap(center, right-1); //put the pivot on the right
        return theArray[right-1]; // return median value
    }
    public void swap(int dex1, int dex2)
    {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    public int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left; //right of first elem
        int rightPtr = right - 1;  //left of pivot

        while(true)
        {
            while( theArray[++leftPtr] < pivot ) //find bigger 
                ;   //nop
            while( theArray[--rightPtr] > pivot) //find smaller
                ;   //nop
            if(leftPtr >= rightPtr) //pointers cross?
                break;   
            else    
                swap(leftPtr, rightPtr); //not crossed, keep swapping
        }
        swap(leftPtr, right-1); //swap pivot with leftPtr
        return leftPtr; //return pivot location
    }
    public void manualSort(int left, int right)
    {
        int size = right-left+1;
        if(size <= 1)
            return;
        if(size == 2)
        {
            if( theArray[left] > theArray[right] )
                swap(left, right);
            return;
        }
        else
        {
            if( theArray[left] > theArray[right-1])
                swap(left, right-1);
            if( theArray[left] > theArray[right])
                swap(left, right);
            if( theArray[right-1] > theArray[right])
                swap(right-1, right);
        }
    }
}
class QuickSort2App {
    public static void main(String[] args)
    {
        int maxSize = 16;
        ItemIns arr;
        arr = new ItemIns(maxSize);

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
