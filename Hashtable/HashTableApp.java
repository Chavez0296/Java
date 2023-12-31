package Hashtable;
//demonstrates hash table with linear probing
import java.io.*;

class DataItem
{
    private int iData;

    public DataItem(int ii)
    {
        iData = ii;
    }
    public int getKey()
    {
        return iData;
    }
}
class Hashtable
{
    private DataItem[] hashArray; //array that holds hashtable
    private int arraySize;
    private DataItem nonItem; //for deleted items
//---------------------------------------------------------------------//
    public Hashtable(int size)
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }
//---------------------------------------------------------------------//
    public void displayTable()
    {
        System.out.print("Hashtable: ");
        for(int j = 0; j < arraySize;j++)
        {
            if(hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else 
                System.out.print(" ** ");     
        }
        System.out.println();
    }
//---------------------------------------------------------------------//
    public int hashFunc(int key)
    {
        return key % arraySize; //hash function
    }
//---------------------------------------------------------------------//
    public void insert(DataItem item) //insert data item (assumes table is not full)
    {
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1)
        {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }
//---------------------------------------------------------------------//
    public DataItem delete(int key)
    {
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey() == key)
            {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
//---------------------------------------------------------------------//
    public DataItem find(int key)
    {
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null)
        {
            if(hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
//---------------------------------------------------------------------//
}
class HashTableApp 
{
    public static void main(String[] args) throws IOException
    {
        DataItem aDataItem;
        int aKey, size, n ,keysPerCell;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;

        Hashtable theHashtable = new Hashtable(size);

        for(int j = 0; j < n ; j ++)
        {
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);
            aDataItem = new DataItem(aKey);
            theHashtable.insert(aDataItem);
        }

        while(true)
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashtable.displayTable();    
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashtable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashtable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashtable.find(aKey);
                    if(aDataItem != null)
                    {
                        System.out.print("Found " + aKey);
                    }
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.println("Invalid entry\n");
            }
        }
    }
//---------------------------------------------------------------------//
    public static String getString()throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//---------------------------------------------------------------------//
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
//---------------------------------------------------------------------//
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}
