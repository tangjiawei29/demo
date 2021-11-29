package util;
public class SortUtil {
    public static void swapArrayElement(int[] arr, int idx1, int idx2 ){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int a:arr ) {
            System.out.print(String.format("%d ",a));
        }
//        System.out.println("\n--------------");
    }
}
