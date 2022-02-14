import java.util.*;

public class Week9 {
    static Random random=new Random();
    public static void test(){
        System.out.println(task1(new int[]{5,3,6,1,12}, 3));
        System.out.println(task2(new int[]{0,0,1,0}));
        System.out.println(task3("leetcode", 7, 20, 2, 0));
    }

    public static void main(String[] args) {
        test();
    }

    public static int task1(int[] nums, int original) {
        //第一题代码
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (original == nums[i]) {
                original = nums[i];
                original *= 2;
            }
        }

        return original;
    }

    public static List<Integer> task2(int[] nums) {
        //第二题代码
        int count[] =  new int[nums.length];
        count[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count[i] = count[i-1] + nums[i];
        }
        int max = count[nums.length-1];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, count[count.length-1]-2*count[i]+i+1);
        }
        List<Integer> ans = new ArrayList<>();
        if (max == count[nums.length-1]) {
            ans.add(0);
        }
        for (int i = 0; i < nums.length; i++) {
            if (max == count[nums.length-1]-2*count[i]+i+1) {
                ans.add(i+1);
            }
        }
        return ans;
    }

    public static String task3(String s, int power, int modulo, int k, int hashValue){
        //第三题代码
        long p=1;
        long hash=0;
        int ans=s.length();
        for (int i = 0; i < k; i++) {
            if (i < k-1) {
                p = p*power%modulo;
            }
            hash = (hash*power+s.charAt(s.length()-1-i)-'a'+1)%modulo;
        }
        if (hashValue == hash) {
            ans-=k;
        }
        for ( int i = s.length()-k-1; i >= 0; i--){
            hash = ((hash+(modulo-p)*(s.charAt(i+k)-'a'+1))%modulo*power+s.charAt(i)-'a'+1)%modulo;
            if (hash == hashValue) {
                ans=i;
            }
        }
        return s.substring(ans,ans+k);
    }
}
