public class Question3 {

    // following codes are typed from book page 174
    // learn a new method: toCharArray(); static method
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    // method 2 is not as easy as the method 1
    public static boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[256]; // assume the character size is 256

        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            // count the number of each char in s
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            System.out.println("i: " + i);
            System.out.println("t.charAt(i): " + t.charAt(i));
            System.out.println("(int) t.charAt(i): " + (int) t.charAt(i));
            System.out.println("letters[c]: " + letters[c]);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        String s = "dog";
        String t = "god";
        boolean res;

        // 关于静态方法的调用：http://www.cnblogs.com/shenliang123/archive/2011/10/27/2226923.html

        // 静态方法和实例方法的区别主要体现在两个方面：

        // 在外部调用静态方法时，可以使用"类名.方法名"的方式，也可以使用"对象名.方法名"的方式。而实例方法只有后面这种方式。也就是说，调用静态方法可以无需创建对象。

        // 静态方法在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法），而不允许访问实例成员变量和实例方法；实例方法则无此限制。

        res = permutation(s, t);
        System.out.println("String s and t are permutation? " + res);
        res = permutation2(s, t);
        System.out.println("String s and t are permutation? checked by method 2: " + res);
    }
}
