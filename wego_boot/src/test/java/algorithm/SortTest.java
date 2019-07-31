package algorithm;

public class SortTest {
    public static void main(String[] args) {
        int[] a = {8, 2, 6, 12, 1, 9, 5, 5, 10};
//        QuickSort.quickSort(a, 0, 8);/*排好序的结果*/
//        print("排序结束后", a);

        BubbleSort.bubbleSortBig(a);
        print("排序结束后", a);
    }

    public static void print(String message, int[] arry) {
        System.out.println(message + "开始");
        for (int data : arry) {
            System.out.print(data + ",");
        }
        System.out.println();
    }
}
