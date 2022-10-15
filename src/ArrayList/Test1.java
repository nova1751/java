package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Weibo");
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        System.out.println(sites.get(1));
        sites.set(2, "Wiki");
        System.out.println(sites);
        sites.remove(3);
        System.out.println(sites);
        System.out.println(sites.size());
        Collections.sort(sites);
        System.out.println(sites);
    }
}
