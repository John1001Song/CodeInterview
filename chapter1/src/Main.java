public class Main {
    public static void main(String[] args) {
        String input = "ABCA";
        UniqueChar uniqueChar = new UniqueChar();
        boolean res = uniqueChar.isUniqueChar2(input);

        boolean res1 = uniqueChar.isUniqueChar(input);

        System.out.println("Input string in uniqueChar2: " + input + ", is unique? " + res);
        System.out.println("Input string in uniqueChar: " + input + ", is unique? " + res1);
    }
}
