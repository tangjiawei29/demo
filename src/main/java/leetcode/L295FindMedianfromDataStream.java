package leetcode;

import java.util.ArrayList;

public class L295FindMedianfromDataStream {
    /** initialize your data structure here. */

    ArrayList<Integer> lst = null;

    /** initialize your data structure here. */
    public L295FindMedianfromDataStream() {
        lst = new ArrayList<>();
    }

    public void addNum(int num) {
        if(lst.size()==0){
            lst.add(num);
        }else{
            int idx= 0;
            for(int i=0;i<lst.size();i++){
               if(num<=lst.get(i))break;
               else idx++;
            }
            lst.add(idx,num);
        }
    }

    public double findMedian() {
        int n = lst.size();
        if(n%2==0){

            return (lst.get((n-1)/2)+lst.get((n-1)/2+1))/2.0f;
        }else{
            return (float)lst.get(n/2);
        }
    }
    public static void main(String[] args) {
        L295FindMedianfromDataStream medianFinder = new L295FindMedianfromDataStream();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]

        System.out.println(medianFinder.findMedian());
    }
}
