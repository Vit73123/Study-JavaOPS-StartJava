public class GuessNumber {

    public static void main(String[] args) {
        final int MIN = 0 + 1;
        final int MAX = 100;
        int num = 100;
        int testNum = 1;
        int testBuffer = testNum;
        int testRange = (MAX - MIN) / 2;
        int i = 0;

        do {
            if (testNum > num) {
                System.out.println("Число " + testNum +
                        " больше того, что загадал компьютер");
                if (testNum > testBuffer) {
                    testRange /= 2;
                }
                testBuffer = testNum;
                if ((testNum -= testRange) < MIN) {
                    testNum = MIN;
                }
            } else if (testNum < num) {
                System.out.println("Число " + testNum +
                        " меньше того, что загадал компьютер");
                if (testNum < testBuffer) {
                    testRange /= 2;
                }
                testBuffer = testNum;
                if ((testNum += testRange) > MAX) {
                    testNum = MAX;
                }
            }
            i++;
        } while (testNum != num);
        System.out.println("\nЧисло, которое загадал компьютер: " + testNum);
        System.out.println("Попыток: " + i);
    }
}