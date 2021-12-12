import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("第一题");
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        int i = in.nextInt();
        System.out.println(selfReverse(i));
    }

    public static int selfReverse(int n) {
        String aString = String.valueOf(n);
        String bString = aString;
        int flag = 1;
        if (n < 0) {
            flag = -1;
            bString = aString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(bString)).reverse().toString()) * flag;
        } catch (Exception e) {
            return 0;
        }
    }
}


