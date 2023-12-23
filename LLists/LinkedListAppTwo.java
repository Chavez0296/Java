class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd)
    {
        iData = id;
        dData = dd;
    }

    public void displayLink()
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
class LinkedList
{
    private Link first;

    public LinkedList()
    {
        first = null;
    }

    public void insertFirst(int id, double dd)
    {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int key)
    {
        Link current = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null;
            else
                current = current.next;            
        }
        return current;
    }

    public Link delete(int key)
    {
        Link current = first;
        Link previous = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null;
            else
            {
                previous = current;
                current = current.next;
            }
        }
        if(current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;

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
class LinkedListAppTwo
{
    public static void main(String[] args)
    {
        LinkedList theList = new LinkedList();

        theList.insertFirst(4, 4.33);
        theList.insertFirst(6, 0.55);
        theList.insertFirst(10, 0);
        theList.insertFirst(67, 19.44);
        theList.insertFirst(100, 6.66);
        theList.insertFirst(3, 5.44);

        theList.displayList();

        Link f = theList.find(100);

        if(f != null)
            System.out.println("Found link with key " + f.iData);

        else
            System.out.println("Can't find link.");

        Link d = theList.delete(67);

        if( d!=null )
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can't delete link");       
        
        theList.displayList();
     
    }
}
