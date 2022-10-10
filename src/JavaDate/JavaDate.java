package JavaDate;
import java.util.Date;
public class JavaDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.printf("全部日期和时间信息：%tc%n", date);
    }
}
