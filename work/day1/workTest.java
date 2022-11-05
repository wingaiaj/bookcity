

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName workTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/10 19:14
 * @Version 1.0
 */
public class workTest {
    //1.求出1-100之间偶数和
    @Test
    public void evenNumbersSum() {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    //2.求出1-100之间奇数和
    @Test
    public void oddNumberSum() {
        int sum = 0;
        for (int i = 1; i < 100; i += 2) {
            sum += i;
        }
        System.out.println(sum);
    }

    //3.求出1-100之间既能被3整除又能被5整除的（且要求跳过能够被10整除的数）所有数之和。
//补充说明：比如30，既能3整除又能被5整除，但是能够被10整除，所以30不参与和的计算
    @Test
    public void numberSum() {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i % 10 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    //    // 不死神兔（递归）
//    有一对兔子出生，从第三月起，每个月生一对兔子，出生的兔子也是第三月起每个月生一对兔子，请问n个月后，共有多少对兔子？
//    定义一个方法：参数是 n个月数 ， 返回 n月后的兔子的对数
    //
    public static int ts(int i) {
        if (i == 1 || i == 2) {//出口条件
            return 1;
        } else {
            return ts(i - 1) + ts(i - 2);//规律
        }
    }

    @Test
    public void test() {
        int ts = ts(5);
        System.out.println(ts);
    }

    //冒泡排序
    @Test
    public void sort() {
        int[] arr = new int[]{6, 4, 2, 12, 44, 11, 56, 22, 44, 55, 67};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    @Test
    public void selectSort() {
        int[] arr = new int[]{6, 4, 2, 12, 44, 11, 56, 22, -44, 55, 67};

        for (int i = 0; i < arr.length - 1; i++) {
            //最小数的索引
            int minIndex = i;
            //最小值
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                //比最小数小
                if (min > arr[j]) {
                    //交换位置
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
