package leetcode;

public class L575DistributeCandies {
    public int distributeCandies(int[] candyType) {
        // HashSet<Integer> set = new HashSet();
        // for(int i:candyType)
        //     set.add(i);
        // return Math.min(set.size(),candyType.length/2);

        boolean[] arr = new boolean[200001];
        int typeCnt = 0;
        int max = candyType.length/2;
        for(int i:candyType){
            if(!arr[i+100000]){
                if(++typeCnt == max) return max;
                arr[i+100000] = true;
            }
        }
        return typeCnt;
    }
}
