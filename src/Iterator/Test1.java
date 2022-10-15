package Iterator;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        Iterator<String> it = sites.iterator();
        System.out.println(it.next());
        while(it.hasNext()){
            System.out.println(it.next());
        }
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        Iterator<Integer> it2 = numbers.iterator();
        while(it2.hasNext()) {
            Integer i = it2.next();
            if(i < 10) {  
                it2.remove();  // 删除小于 10 的元素
            }
        }
        System.out.println(numbers);
    }
}
