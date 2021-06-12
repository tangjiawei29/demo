package leetcode;

public class L6ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuffer[] arr = new StringBuffer[numRows];
        char[] cArr = s.toCharArray();
        int bufferIdx = 0;
        boolean down = true;
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuffer();
        }
        for (int i = 0; i < cArr.length; i++) {
//            System.out.println(bufferIdx + ""+down);
            arr[bufferIdx].append(cArr[i]);
            if (down)
                bufferIdx++;
            else
                bufferIdx--;
            if (bufferIdx == numRows && down) {
                down = false;
                bufferIdx = numRows - 2;
            } else if (bufferIdx == -1 && !down) {
                down = true;
                bufferIdx = 1;
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = 1; i < numRows; i++) {
            arr[0].append(arr[i]);
        }

        return arr[0].toString();
    }

    public String convert2(String s, int numRows) {
        StringBuffer[] arr = new StringBuffer[numRows];
        char[] cArr = s.toCharArray();
        int bufferIdx = 0;
        boolean down = true;
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuffer();
        }
        int idx = 0;
        while(idx < s.length()) {
            for (int i = 0; i < numRows && idx < s.length(); i++) {
                arr[i].append(cArr[idx++]);
            }
            for (int i = numRows - 2; i > 0 && idx < s.length(); i--) {
                arr[i].append(cArr[idx++]);
            }
        }

        for (int i = 1; i < numRows; i++) {
            arr[0].append(arr[i]);
        }

        return arr[0].toString();
    }

    public static void main(String[] args) {
        L6ZigZagConversion o = new L6ZigZagConversion();
        System.out.println(o.convert2("aaaaaaaaa", 1));
        System.out.println(o.convert2("paypalishiring", 3));//"PAHNAPLSIIGYIR"
        System.out.println(o.convert2("paypalishiring", 4));//"PINALSIGYAHRPI"
    }
}
