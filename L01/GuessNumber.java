public class GuessNumber {

    public static void main(String[] args) {
        final int min = 1;
        final int max = 100;
        int num = 100;
        int testNum;
        int left = min;
        int right = max;
        int i = 0;

        do {
            testNum = (left + right) / 2;
            if (testNum > num) {
                System.out.println("Число " + testNum +
                        " больше того, что загадал компьютер " + 
                        " left = " + left + " right = " + right);
                right = testNum - 1;
            } else if (testNum < num) {
                System.out.println("Число " + testNum +
                        " меньше того, что загадал компьютер" +
                        " left = " + left + " right = " + right);
                left = testNum + 1;
            }
            i++;
        } while ((testNum != num) && (i < 10));
        System.out.println("\nЧисло, которое загадал компьютер: " + testNum);
        System.out.println("Попыток: " + i);
    }
}