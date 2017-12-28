public class UniqueChar {

    public boolean isUniqueChar2(String string) {
        System.out.println("========= isUniqueChar2 func =========");

        if (string.length() > 128) return false;

        // boolean array initial values are false
        boolean[] char_set = new boolean[256];
        System.out.println("initialized boolean values are: " + char_set[0]);

        for (int i = 0; i < string.length(); i++) {
            int val = string.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    // assume input string is lower letters
    // <<, &, and |: Bitwise and Bit Shift Operators
    // the int type has a limited range, which affects the binary number range and make the result inaccurate. 
    public boolean isUniqueChar(String string) {
        System.out.println("========= isUniqueChar func =========");
        int checker = 0;

        for (int i = 0; i < string.length(); i++) {
            int val = string.charAt(i) - 'a';
            System.out.println("val: " + val);
            if ((checker & (1 << val)) > 0) {
                System.out.println("val after bit shift: " + val);
                System.out.println("val in binary: " + Integer.toBinaryString(val));
                System.out.println("(0 << val): " + Integer.toBinaryString(0 << val));
                System.out.println("val: " + Integer.toBinaryString(val));
                int old = 1000;
                System.out.println("old: " + old);
                System.out.println("old in binary: " + Integer.toBinaryString(old));
                int testVal = 2 << old;
                System.out.println("testVal: " + testVal);
                System.out.println("testVal in binary: " + Integer.toBinaryString(testVal));
                System.out.println("(1 << val): " + Integer.toBinaryString(1 << val));
                System.out.println("(2 << val): " + Integer.toBinaryString(2 << val));

                System.out.println("(checker & (1 << val)): " + (checker & (1 << val)));
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
