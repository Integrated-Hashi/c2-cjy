public class Sort {
    //冒泡排序
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        return nums;
    }

    //插入排序
    public int[] insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            int idx = i-1;
            while(idx>=0 && tmp<nums[idx]) {
                nums[idx+1] = nums[idx];
                idx--;
            }
            nums[idx+1] = tmp;
        }
        return nums;
    }

    //快速排序
    public static int[] quickSort(int[] nums, int low, int high) {
        int i, j;
        if(low> high) {
            return null;
        }
        i = low;
        j = high;
        int tmp = nums[low];
        while(i<j) {
            while(tmp<=nums[j] && i<j) {
                j--;
            }
            while(tmp>=nums[i] && i<j) {
                i++;
            }
            if(i<j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[low] = nums[i];
        nums[i] = tmp;
        quickSort(nums, low, j-1);
        quickSort(nums, j+1, high);
        return nums;
    }

    //合并排序
    public int[] mergeSort(int[] nums, int left, int right, int[] tmp) {
        if(left<right) {
            int mid = (left+right)/2;
            mergeSort(nums, left, mid, tmp);
            mergeSort(nums, mid+1,right, tmp);
            merge(nums, left, right, mid, tmp);
        }
        return nums;
    }

    public static void merge(int[] nums, int left, int right, int mid, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if(nums[i]<=nums[j]) {
                tmp[t] = nums[i];
                t++;
                i++;
            } else {
                tmp[t] = nums[j];
                t++;
                j++;
            }
        }
        while(i<=mid) {
            tmp[t] = nums[i];
            t++;
            i++;
        }
        while(j<=right) {
            tmp[t] = nums[j];
            t++;
            j++;
        }
        t = 0;
        int tmpLeft = left;
        while(tmpLeft<=right) {
            nums[tmpLeft] = tmp[t];
            t++;
            tmpLeft++;
        }
    }

    //堆排序
    public int[] heapSort(int[] nums) {
        int len = nums.length;
        buildHeap(nums, len);
        for (int i = len - 1; i > 0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            len--;
            sink(nums, 0, len);
        }
        return nums;
    }

    public static void buildHeap(int[] nums, int len) {
        for (int i = len/2; i >=0; i--) {
            sink(nums, i, len);
        }
    }

    public static void sink(int[] nums, int idx, int len) {
        int leftChild = 2 * idx + 1;
        int rightChild = 2 * idx +2;
        int pre = idx;
        if (leftChild < len && nums[leftChild] > nums[pre]) {
            pre = leftChild;
        }
        if (rightChild < len && nums[rightChild] > nums[pre]) {
            pre = rightChild;
        }
        if (pre != idx) {
            int tmp = nums[idx];
            nums[idx] = nums[pre];
            nums[pre] = tmp;
            sink(nums, pre, len);
        }
    }
}

