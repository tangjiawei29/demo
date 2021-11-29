package leetcode;

import java.util.HashSet;
import java.util.Set;

public class L929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();

        for (String e : emails) {
            StringBuffer sb = new StringBuffer();

            char[] c = e.toCharArray();
            boolean ignore = false;
            for (int i = 0; i < c.length; i++) {
                char cc = c[i];
                if (cc == '@') {
                    sb.append(e.substring(i));
                    break;
                } else {
                    if (cc == '.') {
                        continue;
                    } else if (cc == '+') {
                        ignore = true;
                    } else {
                        if (!ignore)
                            sb.append(cc);
                    }
                }
            }

            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        L929UniqueEmailAddresses o = new L929UniqueEmailAddresses();
        System.out.println(o.numUniqueEmails(new String[] {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
