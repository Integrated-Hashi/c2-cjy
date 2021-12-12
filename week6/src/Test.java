import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        StudentMysql mysql = new StudentMysql();
        System.out.println("第一题");
        Student stu1 = new Student("s001", "老大", 20, "计算机学院");
        Student stu2 = new Student("s002", "老二", 19, "计算机学院");
        Student stu3 = new Student("s003", "老三", 18, "计算机学院");
        Student stu4 = new Student("s004", "老四", 17, "计算机学院");
        mysql.insertStudent(stu1);
        mysql.insertStudent(stu2);
        mysql.insertStudent(stu3);
        mysql.insertStudent(stu4);
        mysql.selectAllStudent();

        System.out.println("第二题");
        mysql.selectAllStudent();

        System.out.println("第三题");
        mysql.deleteStuBySno("s004");
        mysql.selectAllStudent();

        System.out.println("第四题");
        Student tmp = mysql.selectStuBySno("s003");
        System.out.println(tmp);
        mysql.selectAllStudent();

        System.out.println("第五题");
        stu1.setCollege("通信学院");
        mysql.updateCollegeByStu(stu1);
        mysql.selectAllStudent();

        Sort sort = new Sort();
        int[] nums = {1,53,23,54,14,54,1,4,76,7,6,32};

//        nums = sort.bubbleSort(nums);

//        nums = sort.insertSort(nums);

//        nums = sort.quickSort(nums,0, nums.length-1);

//        int tmp[] = new int [nums.length];
//        nums = sort.mergeSort(nums, 0, nums.length-1, tmp);

        nums = sort.heapSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}

