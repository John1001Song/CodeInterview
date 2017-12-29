public class Question4 {
    // 问题：java中单引号和双引号有什么区别？

    //    单引号引的数据 是char类型的
    //
    //    双引号引的数据 是String类型的
    //    char定义时用单引号，只能有一个字母，数字。char c='c';
    //    而String用双引号，可以是一个，也可能是多个字母，汉字等。就是所谓的字符串。String s="adsaf";
    //    char只是一个基本类型，而String 可以是一个类，可以直接引用。
    //    比如char c='c';不能直接对c调用方法。
    //    String s="abc";  这时可以调用s.charAt(0);等方法,因为String是类，这是就是对象的调用了
    //
    //    转载来自：http://blog.csdn.net/hubianyu/article/details/39700367

    public void replaceSpaces(char[] str, int length) {
        int spaceCount = 0, newLength, i;
        // count how many spaces in the string
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        // make new spaces for "%20", which takes three spaces: '%' + '2' + '0'
        newLength = length + spaceCount * 2;
        // https://stackoverflow.com/questions/26558741/what-does-strnewlength-0-mean/26558831
        // The standard library of the C programming language commonly uses NUL-terminated strings.
        // A NUL-terminated string is stored in an array,
        // and the string itself consists of all the characters in an array prior to the first '\0' character (called a NUL in ASCII).
        str[newLength] = '\0';
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }
            else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
    }

    // as described in the stackoverflow, check the link above
    // the given code uses more C language instead of Java
    // Java provides easier methods to implement and achieve the goal
    public static String myReplaceSpaces(String s, int length) {

        System.out.println("s: " + s);
        System.out.println("length: " + length);

//      String str = s.substring(0, length);
        String str = s.trim();
        System.out.println("str: " + str);
        System.out.println("str.length(): " + str.length());

        String res = str.replaceAll("\\s", "%20");
        System.out.println("res:" + res);

        return res;
    }

    public static void main(String args[]) {
        String output = myReplaceSpaces("Mr John Smith     ", 13);

        System.out.println("output: " + output);
    }
}
