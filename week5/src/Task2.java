import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("第二题");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        System.out.println(fibonacci(i));
    }

    public static int fibonacci(int n) {
        if (n == 1) return 1;
        int a = 1, b = 2, c;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
