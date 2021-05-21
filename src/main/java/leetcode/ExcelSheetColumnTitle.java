package leetcode;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            int curr = n%26;
            n /= 26;
            sb.append((char)(curr+'A'));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle a = new ExcelSheetColumnTitle();
        System.out.println(a.convertToTitle(52)+"\n====\n");
        System.out.println(a.convertToTitle(701)+"\n====\n");
        //System.out.println(a.convertToTitle(28));
    }
}
