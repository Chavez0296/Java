package Recursion;

class DArray
{
    private long[] theArray; // ref to array theArray
    private int nElems;      // number of data items

    public DArray(int max)          //constructor
    {
        theArray = new long[max];    //create array with size max
        nElems = 0;                  //no items upon creation
    }
    public void insert(long value)
    {
        theArray[nElems] = value;    //insert it
        nElems++;                    //increment count up
    }
    public void display()
    {
        for(int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " "); //linear print of items in array.
        System.out.println("");
    }
    public void mergeSort()
    {
        long[] workSpace = new long[nElems];             //called by main()
        recMergSort(workSpace, 0, nElems-1);   // provides workspace
    }
    private void recMergSort(long[] workSpace, int lowerBound, int upperBound)
    {
        if(lowerBound == upperBound)        //if range is 1, no reason to sort
            return;
        else
        {
            int mid = (lowerBound + upperBound) / 2;      //find midpoint
            
            recMergSort(workSpace, lowerBound, mid);      //sort lower half
            
            recMergSort(workSpace, mid+1, upperBound);    //sort upper half
            
            merge(workSpace, lowerBound, mid+1, upperBound);  //merge them
        }
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound)
    {
        int j = 0;                     //workspace index
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1; //# of items
        System.out.println("LowerBound: " + lowerBound);
        System.out.println("Mid: " + mid);
        System.out.println(("n: " + n));
        System.out.println("upperBound: " + upperBound);
        while(lowPtr <= mid && highPtr <= upperBound)
            if( theArray[lowPtr] < theArray[highPtr] )
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        
        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];

        
        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];

        for(j = 0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];
        
        

        
    }
}
class MergeSortApp {
    public static void main(String[] args)
    { 
        int maxSize = 100;

        DArray arr;
        arr = new DArray(maxSize);

        arr.insert(91);
        arr.insert(15);
        arr.insert(93);
        arr.insert(256);
        arr.insert(44);
        arr.insert(76);
        arr.insert(34);
        arr.insert(98);
        arr.insert(13);
        arr.insert(76);

        arr.display();

        arr.mergeSort();

        arr.display();
    }
}
