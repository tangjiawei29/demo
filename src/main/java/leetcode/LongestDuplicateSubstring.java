package leetcode;

import java.util.HashSet;

public class LongestDuplicateSubstring {
    final static int prime = 31;
    public String longestDupSubstring(String S) {
        String res = "";

        int arr[] = new int[S.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = S.charAt(i) - 'a' + 1;
        }
        int left = 0, right = S.length();

        while(left <= right) {
            int m = left + (right - left) / 2;
            int ans = findDup(arr, m);
            if (ans == -1) {
                right = m - 1;
            } else {

                res = S.substring(ans, m + ans);
                left = m + 1;
            }
        }
        return res;
    }

    private int findDup(int[] arr, int size) {
        HashSet<Long> set = new HashSet<>();
        long h = hash(arr, 0, size);
        set.add(h);

        long pow = 1;
        for (int i = 1; i < size; i++)
            pow = (pow * 31);

        for (int i = 1; i <= arr.length - size; i++) {
            h = nextHash(arr, i, h, size, pow);
            if (!set.add(h)) {
                return i;
            }
        }
        return -1;
    }

    private long hash(int[] arr, int start, int size) {
        long v = 0;
        long pow = 1;
        for (int i = start + size - 1; i >= start; i--) {
            v += arr[i] * pow;
            pow = pow * prime;
        }

        return v;
    }


    private long nextHash(int[] arr, int start, long lastHash, int size, long pow) {
        return (((lastHash - arr[start - 1] * pow) * prime) + arr[start + size - 1]);

    }


    public static void main(String[] args) {
        LongestDuplicateSubstring o = new LongestDuplicateSubstring();
        System.out.println(o.longestDupSubstring("okmzpmxzwjbfssktjtebhhxfphcxefhonkncnrumgduoaeltjvwqwydpdsrbxsgmcdxrthilniqxkqzuuqzqhlccmqcmccfqddncchadnthtxjruvwsmazlzhijygmtabbzelslebyrfpyyvcwnaiqkkzlyillxmkfggyfwgzhhvyzfvnltjfxskdarvugagmnrzomkhldgqtqnghsddgrjmuhpgkfcjkkkaywkzsikptkrvbnvuyamegwempuwfpaypmuhhpuqrufsgpiojhblbihbrpwxdxzolgqmzoyeblpvvrnbnsdnonhpmbrqissifpdavvscezqzclvukfgmrmbmmwvzfpxcgecyxneipexrzqgfwzdqeeqrugeiupukpveufmnceetilfsqjprcygitjefwgcvqlsxrasvxkifeasofcdvhvrpmxvjevupqtgqfgkqjmhtkyfsjkrdczmnettzdxcqexenpxbsharuapjmdvmfygeytyqfcqigrovhzbxqxidjzxfbrlpjxibtbndgubwgihdzwoywqxegvxvdgaoarlauurxpwmxqjkidwmfuuhcqtljsvruinflvkyiiuwiiveplnxlviszwkjrvyxijqrulchzkerbdyrdhecyhscuojbecgokythwwdulgnfwvdptzdvgamoublzxdxsogqpunbtoixfnkgbdrgknvcydmphuaxqpsofmylyijpzhbqsxryqusjnqfikvoikwthrmdwrwqzrdmlugfglmlngjhpspvnfddqsvrajvielokmzpmxzwjbfssktjtebhhxfphcxefhonkncnrumgduoaeltjvwqwydpdsrbxsgmcdxrthilniqxkqzuuqzqhlccmqcmccfqddncchadnthtxjruvwsmazlzhijygmtabbzelslebyrfpyyvcwnaiqkkzlyillxmkfggyfwgzhhvyzfvnltjfxskdarvugagmnrzomkhldgqtqnghsddgrjmuhpgkfcjkkkaywkzsikptkrvbnvuyamegwempuwfpaypmuhhpuqrufsgpiojhblbihbrpwxdxzolgqmzoyeblpvvrnbnsdnonhpmbrqissifpdavvscezqzclvukfgmrmbmmwvzfpxcgecyxneipexrzqgfwzdqeeqrugeiupukpveufmnceetilfsqjprcygitjefwgcvqlsxrasvxkifeasofcdvhvrpmxvjevupqtgqfgkqjmhtkyfsjkrdczmnettzdxcqexenpxbsharuapjmdvmfygeytyqfcqigrovhzbxqxidjzxfbrlpjxibtbndgubwgihdzwoywqxegvxvdgaoarlauurxpwmxqjkidwmfuuhcqtljsvruinflvkyiiuwiiveplnxlviszwkjrvyxijqrulchzkerbdyrdhecyhscuojbecgokythwwdulgnfwvdptzdvgamoublzxdxsogqpunbtoixfnkgbdrgknvcydmphuaxqpsofmylyijpzhbqsxryqusjnqfikvoikwthrmdwrwqzrdmlugfglmlngjhpspvnfddqsvrajviel"));
        System.out.println(o.longestDupSubstring("aa"));
    }
}
