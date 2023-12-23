class Link 
{
    public int iData; //data item(key)
    public double dData; //data item
    public Link next; // next link in list

    public Link(int id, double dd)
    {
        iData = id; //initialize data 
        dData = dd; //('next' is automatically set to null)
    }
    public void displayLink()
    {
        System.out.print("{" + iData + "," + dData + "} ");
    }
}
class LinkedList
{
    private Link first;

    public LinkedList()
    {
        first = null; //list is created empty
    }

    public boolean isEmpty()
    {
        return (first == null);
    }
    public void insertFirst(int id, double dd)
    {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst()
    {
        Link temp = first;
        first = first.next;
        return temp;
    }

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
class LinkedListApp
{
    public static void main(String[] args)
    {
        LinkedList theList = new LinkedList();

        theList.insertFirst(2,4.50);
        theList.insertFirst(6,6.99);
        theList.insertFirst(1,4.44);
        theList.insertFirst(23,9.99);
        theList.insertFirst(9,3.59);
        theList.insertFirst(0,44);
        theList.insertFirst(12,59.59);

        theList.displayList();

        while( !theList.isEmpty() )
        {
            Link aLink = theList.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList();
    }
} 
