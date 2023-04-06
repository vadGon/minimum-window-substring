import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String minWindow(String s, String t) {
        String res = "";
        int resLen = Integer.MAX_VALUE;

        if (s.length() < t.length()) {
            return res;
        }

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (countT.get(t.charAt(i)) == null) {
                countT.put(t.charAt(i), 1);
            } else {
                countT.put(t.charAt(i), countT.get(t.charAt(i)) + 1);
            }
            window.put(t.charAt(i), 0);
        }

        int l = 0;

        int have = 0;
        int need = countT.size();

        for (int r = 0; r < s.length(); r++) {
            Character rightChar = s.charAt(r);

            if (window.get(rightChar) != null) {
                window.put(rightChar, window.get(rightChar) + 1);
                if (countT.get(rightChar).equals(window.get(rightChar))) {
                    have++;
                }
            }


            while (have == need) {
                if (r - l + 1 < resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                char leftChar = s.charAt(l);
                if (window.get(leftChar) != null) {
                    window.put(leftChar, window.get(leftChar) - 1);

                    if (window.get(leftChar).intValue() < countT.get(leftChar).intValue()) {
                        have--;
                    }
                }

                l++;
            }
        }
        return res;
    }
}
