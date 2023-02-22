// Java program to demonstrate TreeSet
import java.util.*;

class TreeSetExample {

    public static void main(String[] args)
    {
        
        // Creating an empty TreeSet
        TreeSet<String> s = new TreeSet<String>();

        // Elements are added using add() method
        s.add("gfg");
        s.add("courses");
        s.add("ide");
        
        // Displaying the TreeSet
        // in sorted order
        System.out.println(s);
        
        // Checking whether "ide" is present 
        // or not
        System.out.println(s.contains("ide"));
        
        // Iterator to traverse the TreeSet
        Iterator<String> i = s.iterator();
        while(i.hasNext())
            System.out.println(i.next());
    }
}
