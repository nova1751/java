package JavaDate;
import java.util.*;
public class DiffDemo {
    public static void main(String[] args) {
        try {
           long start = System.currentTimeMillis( );
           System.out.println(new Date( ) + "\n");
           Thread.sleep(5*60*10);
           System.out.println(new Date( ) + "\n");
           long end = System.currentTimeMillis( );
           long diff = end - start;
           System.out.println("Difference is : " + diff);
           Calendar c1 = Calendar.getInstance();
           System.out.println(c1.get(Calendar.MONTH));
        } catch (Exception e) {
           System.out.println("Got an exception!");
        }
     }
}
