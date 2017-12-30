public class Question5 {

    // feel like my method is still similar to the given one except the StringBuffer
    // countCompression goes through the string without doing appending just counting.
    // It is useful for method compressAlternate, which can be found in the book page 178
    
    // 学习笔记：
    // StringBuffer is faster than String when appending new char or string to the original string.
    // http://blog.csdn.net/mad1989/article/details/26389541
    // http://blog.csdn.net/xlgen157387/article/details/44302455
    // https://www.zhihu.com/question/31345592
    //    线程安全：
    //    StringBuffer：线程安全
    //    StringBuilder：线程不安全
    //
    //    速度：
    //    一般情况下，速度从快到慢为 StringBuilder > StringBuffer > String，当然这是相对的，不是绝对的。
    //
    //    使用环境：
    //    操作少量的数据使用 String；
    //    单线程操作大量数据使用 StringBuilder；
    //    多线程操作大量数据使用 StringBuffer。

    public static String compressBetter(String str) {
        /* check if compression would create a longer string */
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }

        StringBuffer mystr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                mystr.append(last);
                mystr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        mystr.append(last);
        mystr.append(count);
        return mystr.toString();

    }

    static int countCompression(String str) {
        if (str == null || str.isEmpty()) return 0;
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

    public static String myStringCompression(String string) {
        int counter = 0;
        char head, next;
        String result = "";

        // if the string is null or empty, there is nothing to compress
        if (string == null || string.equals("") || string.isEmpty()) {
            return "";
        }

        char[] str_array = string.toCharArray();
        head = str_array[0];
        result += String.valueOf(head);

        for (int i = 0; i < str_array.length; i++) {
            next = str_array[i];

            if (head == next) {
                counter++;
            }
            else {
                result += String.valueOf(head);
                head = next;
                result += String.valueOf(counter);
                counter = 1;
            }
        }

        result += String.valueOf(head);
        result += String.valueOf(counter);

        if (string.length() <= result.length()) {
            return string;
        }
        return result;
    }

    public static void main(String args[]) {
        String res = myStringCompression("aabcccccaaa");
        String res2 = myStringCompression("aabccdeeaa");
        String res3 = myStringCompression(null);
        System.out.println("res:" + res);
        System.out.println("res2: " + res2);
        System.out.println("res3: " + res3);
    }
}
