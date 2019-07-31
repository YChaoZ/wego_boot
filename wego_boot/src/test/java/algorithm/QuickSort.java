package algorithm;

/**
 * 快速排序算法
 * <p>
 * 排序中获取到小值,对比初始值：8|开始
 * 5,2,6,12,1,9,5,5,10,
 * 排序中获取到大值,对比初始值：8|开始
 * 5,2,6,12,1,9,5,12,10,
 * 排序中获取到小值,对比初始值：8|开始
 * 5,2,6,5,1,9,5,12,10,
 * 排序中获取到大值,对比初始值：8|开始
 * 5,2,6,5,1,9,9,12,10,
 * 排序中获取排序结束,对比初始值：8|开始
 * 5,2,6,5,1,8,9,12,10,
 * <p>
 * 排序中获取到小值,对比初始值：5|开始
 * 1,2,6,5,1,8,9,12,10,
 * 排序中获取到大值,对比初始值：5|开始
 * 1,2,6,5,6,8,9,12,10,
 * 排序中获取排序结束,对比初始值：5|开始
 * 1,2,5,5,6,8,9,12,10,
 * <p>
 * 排序中获取排序结束,对比初始值：1|开始
 * 1,2,5,5,6,8,9,12,10,
 * <p>
 * 排序中获取排序结束,对比初始值：5|开始
 * 1,2,5,5,6,8,9,12,10,
 * <p>
 * 排序中获取排序结束,对比初始值：9|开始
 * 1,2,5,5,6,8,9,12,10,
 * <p>
 * 排序中获取到小值,对比初始值：12|开始
 * 1,2,5,5,6,8,9,10,10,
 * 排序中获取排序结束,对比初始值：12|开始
 * 1,2,5,5,6,8,9,10,12,
 * <p>
 * 排序结束后开始
 * 1,2,5,5,6,8,9,10,12,
 */
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        // 快速排序，每次重置比较位置和比较值
        int i = left;
        int j = right;

        // 相等时，停止排序
        if (left >= right) {
            return;
        }

        int temp = arr[i];

        while (i < j) {
            while (i < j && arr[j] >= temp)
                j--;
            if (i < j) {
                arr[i] = arr[j];
                i++;
                print("排序中获取到小值,对比初始值：" + temp + "|", arr);
            }

            while (i < j && arr[i] <= temp)
                i++;

            if (i < j) {
                arr[j] = arr[i];
                j--;
                print("排序中获取到大值,对比初始值：" + temp + "|", arr);
            }
        }

        // 获取到第一个起始位置大于对比位，获取到第一个最终位置小于对比位，数据对换
        arr[i] = temp;
        print("排序中获取排序结束,对比初始值：" + temp + "|", arr);
        System.out.println();
        if (i - 1 > left) quickSort(arr, left, i - 1);
        if (j + 1 < right) quickSort(arr, j + 1, right);
    }

    public static void print(String message, int[] arry) {
        System.out.println(message + "开始");
        for (int data : arry) {
            System.out.print(data + ",");
        }
        System.out.println();
    }
}
