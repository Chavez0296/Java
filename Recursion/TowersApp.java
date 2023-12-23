package Recursion;
//solves the towers of hanoi puzzle
class TowersApp {
    static int nDisks = 3;
    public static void main(String[] args)
    {
        doTowers(nDisks, 'A', 'B', 'C');
    }
    public static void doTowers(int topN, char first, char mid, char last)
    {
        if(topN == 1)
            System.out.println("Disk 1 from " + first + " to " + last);
        else
        {
            System.out.println("post:"+(topN-1));
            doTowers(topN-1, first, last, mid);
            System.out.println("curr:"+topN);
            
            System.out.println("Disk " + topN + "from " + first + " to " + last);

            doTowers(topN-1, mid, first, last);
            System.out.println(topN-1);
        }
    }
}
