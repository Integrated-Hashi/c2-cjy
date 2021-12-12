import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("第三题");
        Scanner in = new Scanner(System.in);
        System.out.print("输入形式：1,2,3,4\nnums = ");
        String string = in.next();
        String[] arr = string.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        sets = subsets(nums);
        System.out.println(sets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) tmp.add(nums[j]);
            }
            sets.add(tmp);
        }
        return sets;
    }
}
