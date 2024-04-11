package LLists;
class Link
{
    public long dData;
    public Link next;

    public Link(long dd)
    {
        dData = dd;
    }
    public void displayLink()
    {
        System.out.print(dData + " ");
    }
}
class SortedList
{
    private Link first;

    public SortedList()
    {
        first = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void insert(long key)
    {
        Link newLink = new Link(key); //make new link
        Link previous = null;          // start at first
        Link current = first;
        
        while( current != null && key>current.dData)
        {                               //until the end of the list 
            previous = current;          //or key > current
            current = current.next;        //go to the next item
        }
        if(previous == null)   //at the beginning of the list
            first = newLink;   //first --> newLink
        else                        //not at the begining
            previous.next = newLink;    //old prev --> newLink
        newLink.next = current;         //newLink --> old current
    }

    public Link remove()
    {                       //assumes non-empty list
        Link temp = first; //save first
        first = first.next; //delete first
        return temp;       //return value
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first; //start at the beginning of the list
        while(current != null) //until end of list,
        {
            current.displayLink(); //print data
            current = current.next; //move to next link
        }
        System.out.println("");
    }
}
class SortedListApp {
    public static void main(String[] args)
    {
    SortedList theSortedList = new SortedList();
    theSortedList.insert(2);
    theSortedList.insert(4);

    theSortedList.displayList();

    theSortedList.insert(1);
    theSortedList.insert(3);
    theSortedList.insert(5);

    theSortedList.displayList();


    theSortedList.remove();

    theSortedList.displayList();

    }
}
