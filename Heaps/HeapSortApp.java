package Heaps;
//demonstrates heap sort
import java.io.*;
//--------------------------------------------------------------------------//
class Node
{
  private int iData;
  public Node(int key)
  {
    iData = key;
  }
//--------------------------------------------------------------------------//
  public int getKey()
  {
    return iData;
  }
}
class HeapTwo
{
  private Node[] heapArray;
  private int maxSize;
  private int currentSize;
//--------------------------------------------------------------------------//
  public HeapTwo(int max)
  {
    maxSize = max;
    currentSize = 0;
    heapArray = new Node[maxSize];
  }
//--------------------------------------------------------------------------//
  public Node remove() //delete item with max key (assumes non-empty list)
  {
    Node root = heapArray[0];
    heapArray[0] = heapArray[--currentSize];
    trickleDown(0);
    return root;
  }
//--------------------------------------------------------------------------//
  public void trickleDown(int index)
  {
    int largerChild;
    Node top = heapArray[index]; //save root
    while(index < currentSize/2) //not on bottom row
    {
      int leftChild = 2 * index+1;
      int rightChild = leftChild+1;

      if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) //find larger child
        largerChild = rightChild;                                                                   //right child exists?
      else 
        largerChild = leftChild;
      
      if(top.getKey() >= heapArray[largerChild].getKey()) //top >= largerChild?
        break;
      
        heapArray[index] = heapArray[largerChild]; //shift child up
        index = largerChild;                        //go down
    }
    heapArray[index] = top;               //root to index
  }
//--------------------------------------------------------------------------//
  public void displayHeap()
  {
    int nBlanks = 32;
    int itemsPerRow = 1;
    int col = 0;
    int j = 0; //current size
    String dots = ".............................................................";
    System.out.println(dots+dots);

    while(currentSize > 0)
    {
      if(col == 0)
        for(int i = 0; i < nBlanks; i++)
          System.out.print(" ");
      
      System.out.print(heapArray[j].getKey());

      if(++j == currentSize)
        break;
      
      if(++col == itemsPerRow)
      {
        nBlanks /= 2;
        itemsPerRow *= 2;
        col = 0;
        System.out.println();
      }
      else
        for(int k = 0; k < nBlanks*2-2; k++)
          System.out.print(" ");
    }
    System.out.println("\n"+dots+dots);
  }
//--------------------------------------------------------------------------//
  public void displayArray()
  {
    for(int i = 0; i < maxSize; i++)
      System.out.print(heapArray[i].getKey() + " ");
    System.out.println("");
  }
//--------------------------------------------------------------------------//
  public void insertAt(int index, Node newNode)
  {
    heapArray[index] = newNode;
  }
//--------------------------------------------------------------------------//
  public void incrementSize()
  {
    currentSize++;  
  }
//--------------------------------------------------------------------------//
}
class HeapSortApp {
  public static void main(String[] args) throws IOException
  {
    int size, j;
    System.out.print("Enter number of items: ");
    size = getInt();
    HeapTwo theHeap = new HeapTwo(size);

    for(j = 0; j < size; j++)
    {
      int random = (int)(java.lang.Math.random()*100);
      Node newNode = new Node(random);
      theHeap.insertAt(j, newNode);
      theHeap.incrementSize();
    }

    System.out.print("Random: ");
    theHeap.displayArray();

    for(j = size/2-1; j>= 0;j--)
      theHeap.trickleDown(j);
    
    System.out.print("Heap: ");
    theHeap.displayArray();
    theHeap.displayHeap();

    for(j = size -1; j >= 0; j--)
    {
      Node biggestNode = theHeap.remove();
      theHeap.insertAt(j, biggestNode);
    }
    System.out.print("Sorted: ");
    theHeap.displayArray();
  }
//--------------------------------------------------------------------------//
  public static String getString() throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s = br.readLine();
    return s;
  }
//--------------------------------------------------------------------------//
  public static char getChar() throws IOException
  {
    String s = getString();
    return s.charAt(0);
  }
//--------------------------------------------------------------------------//
  public static int getInt() throws IOException
  {
    String s = getString();
    return Integer.parseInt(s);
  }
}
