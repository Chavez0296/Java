package LLists;
class Link
{
    public long dData;
    public Link next;
    
    public Link(long d)
    {
        dData = d;
    }
    public void displayLink()
    {
        System.out.print(dData + " ");
    }
}
class FirstLastList
{
    private Link first; //ref to first link
    private Link last; //ref to last link

    public FirstLastList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return first==null;
    }

    public void insertFirst(long dd)
    {
        Link newLink = new Link(dd);

        if( isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;

    }

    public void insertLast(long dd)
    {
        Link newLink = new Link(dd);
        if( isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink; 
    }

    public long deleteFirst()
    {
        long temp = first.dData;
        if(first.next == null)
            last = null;
        first = first.next;
        return temp;
    }

    public void displayList()
    {
        System.out.print("List {first-->last}: " );
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
class FirstLastApp
{
    public static void main(String[] args)
    {
        FirstLastList theList = new FirstLastList();

        theList.insertFirst(3);
        theList.insertFirst(4);
        theList.insertFirst(5);

        theList.insertLast(9);
        theList.insertFirst(8);
        theList.insertFirst(7);

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();

    }
}