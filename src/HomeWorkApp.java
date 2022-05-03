public class HomeWorkApp {
    public static void main(String[] args) {
        invertArray();
        System.out.println();
        fillArray();
        System.out.println();
        changeArray();
        System.out.println();
        fillDiagonal();
        System.out.println();
        initArray(9, 15);
        System.out.println();
        searchMinMaxInArray();
        System.out.println();
        int[] array = {2, 2, 2, 1, 4, 10, 1};
        System.out.println(checkBalance(array));
        System.out.println();
        shiftArray(array, -2);
    }
    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
            }

        }
        for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + " ");
       }
    }
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + " ");
       }
    }
    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void fillDiagonal() {
        int[][] arr = new int [5][5];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++ ) {
                 System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] initArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        return arr;
    }
    public static void searchMinMaxInArray() {
        int[] arr = {4, 2, 6, 9, 12, 5, 3};
        int min = arr[0];
        int max = arr[0];
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        System.out.println("Минимальное значение = " + min);
        System.out.println("Максимальное значение = " + max);
    }
    public static boolean checkBalance(int[] arr) {
        int pointerLeft = 0;
        int pointerRight = arr.length-1;
        int sumLeft = arr[pointerLeft];
        int sumRight = arr[pointerRight];
        while (pointerRight - pointerLeft >= 2) {
            if (sumLeft < sumRight) {
                pointerLeft++;
                sumLeft += arr[pointerLeft];
            } else {
                pointerRight--;
                sumRight += arr[pointerRight];
            }
        }

              if (sumLeft == sumRight) {
            return true;
        } else {
            return false;
        }
    }
    public static void shiftArray(int[] arr, int n) {
        int tmp;
        if (n > 0) {
            for (int j = 0; j < n; j++) {
                tmp = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = tmp;
            }

        }
        if (n < 0) {
            for (int j = 0; j > n; j--) {
                tmp = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = tmp;
            }

        }

        for (int y = 0; y < arr.length; y++) {
            System.out.print(arr[y] + " ");
        }
        System.out.println();
    }
}
