public class Question5 {

    public static String myStringCompression(String string) {
        int counter = 0;
        char head, next;
        String result = "";

        // if the string is null or empty, there is nothing to compress
        if (string.equals("")) {
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
        
        return result;
    }

    public static void main(String args[]) {
        String res = myStringCompression("aabcccccaaa");
        System.out.println("res:" + res);
    }
}
