package leetcode;

public class L88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        int idx1=m-1;
        int idx2=n-1;
        while(idx1>=0&&idx2>=0){
            if(nums2[idx2]>nums1[idx1]){
                nums1[i]= nums2[idx2];
                idx2--;
            }else{
                nums1[i]= nums1[idx1];
                idx1--;
            }
            i--;

        }
        while(idx2>=0){
            nums1[i]=nums2[idx2];
            idx2--;
            i--;
        }
    }
}
