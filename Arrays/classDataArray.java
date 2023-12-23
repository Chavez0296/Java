//class data array
//data items as class objects

class Person
{
    private String lastName;
    private String firstName;
    private int age;
    public Person(String last, String first, int a)
    {
        lastName = last;
        firstName = first;
        age = a;
    }

    public void displayPerson()
    {
        System.out.print("      Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }

    public String getLast()
    {
        return lastName;
    }
    
}
class ClassDataArray {
    private Person[] a;
    private int nElems;

    public ClassDataArray(int max) //constructor
    {
        a = new Person[max]; // create the array
        nElems = 0; //no items yet
    }

    public Person find(String searchName)
    {
        int j;
        for(j = 0; j <nElems; j++)
            if(a[j].getLast().equals(searchName))// for each element (last name) found? 
                break; // break loop
        if(j == nElems) // searched till the end and not found?
            return null;  // null

        else
            return a[j]; // no , found it
    }

    public void insert(String last, String first, int age)
    {
        a[nElems] = new Person(last, first, age); //person gets constructed and placed in an array 
        nElems++; //increment size
    }

    public boolean delete(String searchName)
    {
        int j;
        for(j = 0; j <  nElems;j++)
            if(a[j].getLast().equals(searchName))
                break;
        if(j==nElems)
            return false;
        else
        {
            for(int k =j; k <nElems; k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }

    public void displayA()
    {
        for(int j = 0; j < nElems; j++)
            a[j].displayPerson();
    }
}

class ClassDataApp
{
    public static void main(String args[])
    {
        int maxSize = 100; //array size
        ClassDataArray arr; //reference to array
        arr = new ClassDataArray(maxSize); //create the array

        arr.insert("Evans", "Patty", 24);
        arr.displayA();

        Person found = arr.find("Evans");
        if(found != null)
        {
            System.out.print("Found ");
            found.displayPerson();
        }
        else 
            System.out.println("Can't find " + "Evans");

        System.out.println("Deleting Evans");
        arr.delete("Evans");
    }
    
}
