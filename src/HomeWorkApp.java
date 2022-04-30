public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(checkSum(5, 19));
        printPositiveOrNegative(-1);
        System.out.println(checkSign(-5));
        printTextNTimes("Текст для вывода на консоль", 5);
        System.out.println(checkYear(2100));
    }
    public static boolean checkSum(int a, int b) {
        return ((a + b) > 10) && ((a + b) < 20);
    }
    public static void printPositiveOrNegative(int c) {
        if (c >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }
    public static boolean checkSign(int d) {
        return (d >= 0);
    }
    public static void printTextNTimes(String text, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(text);
        }
    }
    public static boolean checkYear(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && !(year % 100 == 0))) {
            return true;
        } else
        return false;
    }
}
