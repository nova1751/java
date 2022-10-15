package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(25);
        myNumbers.add(10);
        myNumbers.add(15);
        myNumbers.add(20);

        for (int i : myNumbers) {
            System.out.println(i);
        }
        Collections.sort(myNumbers);
        System.out.println(myNumbers);
    }
}
