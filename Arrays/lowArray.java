class LowArray {
 private long[] a;
 
 public LowArray(int size)
 {
    a = new long[size];
 }

 public void setElem(int index, long value)
 {
    a[index] = value;
 }

 public long getElem(int index)
 {
    return a[index];
 }
}
class LowArrayApp
{
    public static void main(String[] args)
    {
        LowArray arr;
        arr = new LowArray(100);
        int nElems = 0;
        int j;

        arr.setElem(0, 77);
        arr.setElem(1, 99);
        nElems = 2;

        for(j = 0; j < nElems; j++)
            System.out.print(arr.getElem(j) + " ");
        System.out.println("");

        int searchKey = 77;

        for(j = 0; j<nElems;j++)
            if(arr.getElem(j) == searchKey)
                break;
        if(j == nElems)
            System.out.println("Can't find " + searchKey);
        else
            System.out.println("Found " + searchKey);

        for(j=0; j <nElems; j++)
            if(arr.getElem(j) == 99)
                break;
        for(int k = j; k < nElems; k++)
            arr.setElem(k, arr.getElem(k+1));
        nElems--;

        for(j= 0; j < nElems; j++)
            System.out.print(arr.getElem(j) + " ");
        System.out.println(" ");
        
    }
}