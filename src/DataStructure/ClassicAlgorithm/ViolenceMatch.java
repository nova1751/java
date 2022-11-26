package DataStructure.ClassicAlgorithm;

public class ViolenceMatch {
    /*
     * 暴力匹配
     */
    public int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2len = s2.length;

        int i = 0; // 指向s1中正在匹配的位置
        int j = 0; // 指向s2中正在匹配的位置
        while (i < s1Len && j < s2len) {
            // 如果相等，则让两个指针都往前移动
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        // 如果找到，则返回当前的索引
        // 因为在匹配过程中，没有匹配上j就被重置为零
        if (j == s2len) {
            return i - j;
        }
        return -1;
    }

    public void fun1() {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        System.out.println(violenceMatch(str1, str2));
    }

    public void fun2() {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你x";
        System.out.println(violenceMatch(str1, str2));
    }

    public static void main(String[] args) {
        ViolenceMatch violenceMatch = new ViolenceMatch();
        violenceMatch.fun1();
        violenceMatch.fun2();
    }
}
