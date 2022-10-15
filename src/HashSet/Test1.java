package HashSet;
import java.util.HashSet;
public class Test1 {
    public static void main(String[] args) {
        HashSet<String> sites = new HashSet<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");
        System.out.println(sites);
        System.out.println(sites.contains("Taobao"));
        sites.remove("Taobao");
        System.out.println(sites);
        // sites.clear();
        // System.out.println(sites);
        System.out.println(sites.size());
    }
}
