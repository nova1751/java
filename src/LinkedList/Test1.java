package LinkedList;

import java.util.LinkedList;

public class Test1 {
    public static void main(String[] args) {
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites);
        sites.addFirst("Wiki");
        System.out.println(sites);
        sites.addLast("Wiki");
        System.out.println(sites);
        sites.removeFirst();
        System.out.println(sites);
        sites.removeLast();
        System.out.println(sites);
        System.out.println(sites.getFirst());
        System.out.println(sites.getLast());
        
    }
}
