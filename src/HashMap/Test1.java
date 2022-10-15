package HashMap;
import java.util.HashMap;
public class Test1 {
    public static void main(String[] args) {
        HashMap<Integer,String> sites = new HashMap<Integer,String>();
        // 添加键值对
        sites.put(1, "Google");
        sites.put(2, "Runoob");
        sites.put(3, "Taobao");
        sites.put(4, "Zhihu");
        System.out.println(sites);
        System.out.println(sites.get(3));
        sites.remove(4);
        System.out.println(sites);
        sites.clear();
        // System.out.println(sites);
        System.out.println(sites.size());
    }
}
