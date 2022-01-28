import java.util.*;

public class Week8 {
    static Random random=new Random();
    public static void test(){
        System.out.println(task1("abbc","dog cat cat fish"));
        System.out.println(task2(new int[]{1,2,2,3,0}));
        for(int i=0;i<5;i++){
            int target = random.nextInt(15) - 3;
            System.out.println("target:"+target+"\tresult"+task3(new int[]
                    {0,4,5,6,8},target));
        } }

    public static void main(String[] args) {
        test();
    }

    public static boolean task1(String pattern, String str) {
        //第一题代码
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Object, Integer> map = new HashMap<>();

        for (Integer i = 0; i < words.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }

        return true;
    }

    public static int task2(int[] nums) {
        //第二题代码
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)) {
                return num;
            }
        }

        return -1;
    }

    public static int task3(int []nums, int target){
        //第三题代码
        int head = 0, tail = nums.length - 1, mid = 0;
        while (head <= tail) {
            mid = (head + tail) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > target) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        return -mid - 1;
    }
}
