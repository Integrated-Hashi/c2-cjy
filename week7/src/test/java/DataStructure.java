import java.util.Arrays;
import java.util.Stack;

public class DataStructure {
    public DataStructure() {
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m];

        for(int i = 0; i < m; ++i) {
            int j;
            for(j = 0; j < n && nums2[j] != nums1[i]; ++j) {
            }

            int k;
            for(k = j + 1; k < n && nums2[k] < nums2[j]; ++k) {
            }

            res[i] = k < n ? nums2[k] : -1;
        }

        return res;
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();
        int j = 0;
        int[] var5 = pushed;
        int var6 = pushed.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            int x = var5[var7];
            stack.push(x);

            while(!stack.isEmpty() && j < N && (Integer)stack.peek() == popped[j]) {
                stack.pop();
                ++j;
            }
        }

        return j == N;
    }

    public static int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        int[] var2 = nums;
        int i = nums.length;

        for(int var4 = 0; var4 < i; ++var4) {
            int x = var2[var4];
            int var10002 = cnt[x]++;
        }

        int sum = 0;

        for(i = 1; i < 101; ++i) {
            if (cnt[i] == 1) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 2};
        int[] b = new int[]{1, 3, 4, 2};
        int[] c = nextGreaterElement(a, b);
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        boolean re = validateStackSequences(pushed, popped);
        int[] nums = new int[]{1, 2, 3, 2};
        int res = sumOfUnique(nums);
        System.out.println(Arrays.toString(c));
        System.out.println(re);
        System.out.println(res);
    }
}