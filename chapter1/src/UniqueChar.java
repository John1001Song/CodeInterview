public class UniqueChar {
    public boolean isUniqueChar2(String string) {
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
}
