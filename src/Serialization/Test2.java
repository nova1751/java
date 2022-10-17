package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test2 {
    public static void main(String[] args) {
        Employee e=null;
        try{
            FileInputStream fileIn=new FileInputStream("src/Serialization/tmp/employee.ser");
            ObjectInputStream in=new ObjectInputStream(fileIn);
            e = (Employee)in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i){
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Name:"+e.name);
        System.out.println("Address"+e.address);
        System.out.println("SSN:"+e.SSN);
        System.out.println("Number:"+e.number);

    }
}
