public class UnicodeChar {
    
    public static void main(String[] args) {
        char srcMinChar = 33;
        char srcMaxChar = 126;
        for (srcMinChar = srcMinChar;  srcMinChar < srcMaxChar + 1; srcMinChar++) {
            System.out.printf("%3c", srcMinChar);
            if (srcMinChar % 30 == 0) {
                System.out.println();
            }
        }

        srcMinChar = 9398;
        srcMaxChar = 10178;
        System.out.println("\n");
        for (srcMinChar = srcMinChar;  srcMinChar < srcMaxChar + 1; srcMinChar++) {
            System.out.printf("%3c", srcMinChar);
            if (srcMinChar % 30 == 0) {
                System.out.println();
            }
        }
   }    
}