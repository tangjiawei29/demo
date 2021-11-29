package leetcode;

import java.util.*;

public class L1169InvalidTransactions {
    class Trx {
        public String name;
        public int amt;
        public int time;
        public String city;
        public int idx;
        public boolean isValid = true;

        Trx(String s, int idx) {
            String[] ss = s.split(",");
            name = ss[0];
            time = Integer.valueOf(ss[1]);
            amt = Integer.valueOf(ss[2]);
            city = ss[3];
            this.idx = idx;
        }
    }

    public List<String> invalidTransactions(String[] t) {
        Map<String, List<Trx>> map = new HashMap();
        
        List<String> ans = new ArrayList();
        for (int i = 0; i < t.length; i++) {
            Trx trx = new Trx(t[i], i);
            if (trx.amt >= 1000) {
                trx.isValid = false;
                ans.add(t[i]);
            }
            String name = trx.name;
            if (map.containsKey(name)) {
                List<Trx> trxList = map.get(name);
                for (Trx tt : trxList) {
                    if (Math.abs(tt.time - trx.time) <= 60 && !tt.city.equals(trx.city)) {
                        if (tt.isValid) {
                            tt.isValid = false;
                            ans.add(t[tt.idx]);
                        }
                        if (trx.isValid) {
                            trx.isValid = false;
                            ans.add(t[trx.idx]);
                        }
                    }
                }
                trxList.add(trx);
            } else {
                List<Trx> trxList = new ArrayList();
                trxList.add(trx);
                map.put(name, trxList);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L1169InvalidTransactions l = new L1169InvalidTransactions();
        System.out.println(l.invalidTransactions(new String[] {
                "bob,689,1910,barcelona", "alex,696,122,bangkok", "bob,832,1726,barcelona",
                "bob,820,596,bangkok", "chalicefy,217,669,barcelona", "bob,175,221,amsterdam"}));
    }
}
