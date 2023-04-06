import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String minWindow(String s, String t) {
        String res = "";
        int resLen = Integer.MAX_VALUE;

        if (t.length() > s.length() || t.equals("")){
            return "";
        }

        // initial set up two window maps
        Map<Character, Integer> requiredWindow = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char charAt = t.charAt(i);
            if (requiredWindow.get(charAt) == null) {
                requiredWindow.put(charAt, 1);
            } else {
                requiredWindow.put(charAt, requiredWindow.get(charAt) + 1);
            }
            window.put(charAt, 0);
        }
        //left index of window
        int l = 0;

        int have = 0;
        int need = requiredWindow.size();

        // right index of window
        for (int r = 0; r < s.length(); r++) {
            Character rightChar = s.charAt(r);

            if (window.get(rightChar) != null) {
                // if we care about this character ADD it to window
                window.put(rightChar, window.get(rightChar) + 1);
                // if we have enough count of chars in window, notice it in have variable
                if (requiredWindow.get(rightChar).equals(window.get(rightChar))) {
                    have++;
                }
            }

            // this while loop, cut our window from left to minimize window length while our main equation is true
            while (have == need) {
                // update result
                if (r - l + 1 < resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                char leftChar = s.charAt(l);

                // if necessary update count in window
                if (window.get(leftChar) != null) {
                    window.put(leftChar, window.get(leftChar) - 1);
                    // if we have less count that we should have, decrement our have variable
                    if (window.get(leftChar).intValue() < requiredWindow.get(leftChar).intValue()) {
                        have--;
                    }
                }
                l++;
            }
        }
        return res;
    }
}
