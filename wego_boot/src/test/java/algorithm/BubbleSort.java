package algorithm;

/**
 * 冒泡排序
 * <p>
 * 相邻两个比较排序，大的移位，小的降阶。
 */
public class BubbleSort {
    /**
     * 优先固定小位，大位上浮
     *
     * @param arr
     */
    public static void bubbleSortSmall(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 优先固定大位，小位下浮
     *
     * @param arr
     */
    public static void bubbleSortBig(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
