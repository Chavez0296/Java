package Hashtable;
import java.io.*;

class Link
{
    private int iData;// data item
    public Link next; // next link in list
//----------------------------------------------------------------------------------//
    public Link(int ii)
    {
        iData = ii;
    }
//----------------------------------------------------------------------------------//
    public int getKey()
    {
        return iData;
    }
//----------------------------------------------------------------------------------//
    public void displayLink()
    {
        System.out.print(iData + " ");
    }
}
class SortedList
{
    private Link first;
//----------------------------------------------------------------------------------//
    public SortedList()
    {
        first = null;
    }
//----------------------------------------------------------------------------------//
    public void insert(Link theLink)
    {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;                               //start at first

        while( current != null && key > current.getKey() )  // until the end of the list or current > key
        {
            previous = current;                             
            current = current.next;                         // go to next item
        }
        if(previous == null )                               //if beginning of list, first --> newLink
            first = theLink;
        else                                                // not at beginning, 
            previous.next = theLink;                        // prev --> newLink
        theLink.next = current;                             // newLink --> current
    }
//----------------------------------------------------------------------------------//
    public void delete(int key)
    {
        Link previous = null;
        Link current = first;

        while( current != null && key != current.getKey() )
        {
            previous = current;
            current = current.next;
        }

        if(previous == null)
            first = first.next;
        else    
            previous.next = current.next;
    }
//----------------------------------------------------------------------------------//
    public Link find(int key)
    {
        Link current = first;

        while (current != null && current.getKey() <= key) {
            if(current.getKey() == key)
                return current;
            current = current.next;
        }
        return null;
    }
//----------------------------------------------------------------------------------//
    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
class HashTable
{
    private SortedList[] hashArray;
    private int arraySize;
//----------------------------------------------------------------------------------//
    public HashTable(int size)
    {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for(int i = 0; i < arraySize; i++)
            hashArray[i] = new SortedList();
    }
//----------------------------------------------------------------------------------//
    public void displayTable()
    {
        for(int i = 0; i < arraySize; i++)
        {
            System.out.print(i + ", ");
            hashArray[i].displayList();
        }
    }
//----------------------------------------------------------------------------------// 
    public int hashFunc(int key)
    {
        return key % arraySize;
    }
//----------------------------------------------------------------------------------// 
    public void insert(Link theLink)
    {
        int key = theLink.getKey();
        int hashVal = hashFunc(key); //hash the key
        hashArray[hashVal].insert(theLink); //insert at hashVal
    }
//----------------------------------------------------------------------------------// 
    public void delete(int key)
    {
        int hashVal = hashFunc(key); //hash the key
        hashArray[hashVal].delete(key); // delete link
    }
//----------------------------------------------------------------------------------// 
    public Link find(int key)
    {
        int hashVal = hashFunc(key);                //hash the key
        Link theLink = hashArray[hashVal].find(key); //get link
        return theLink;
    }
//----------------------------------------------------------------------------------// 
}
class HashChainApp {
    public static void main(String[] args) throws IOException
    {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;

        System.out.print("Enter size of the hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();

        HashTable theHashTable = new HashTable(size);

        for(int i = 0; i < n; i++)
        {
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);
            aDataItem = new Link(aKey);
            theHashTable.insert(aDataItem);
        }

        while(true)
        {
            System.out.print("Enter first leter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch(choice)
            {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null)
                        System.out.print("Found " + aKey + "\n");
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid Entry\n");
            }
        }
    }
//----------------------------------------------------------------------------------//
    public static String getString() throws IOException 
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//----------------------------------------------------------------------------------//   
    public static char getChar()throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
//----------------------------------------------------------------------------------//
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}
