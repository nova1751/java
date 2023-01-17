class FreshJuice {
    enum FreshJuiceSize {
        SMALL, MEDIUM, LARGE
    }

    FreshJuiceSize size;
}

public class App {
    public static void main(String[] args) {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
        System.out.println(juice);
        System.out.println(juice.size);
    }
}