class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int left = 0, right = 0;
        String result = s + " ";

        int[] hashmap = new int[128];
        for (int i = 0; i < t.length(); i++) {
            hashmap[t.charAt(i)]++;
        }

        int required = t.length();
        int formed = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (hashmap[c] > 0) {
                formed++;
            }
            hashmap[c]--;
            right++;

            while (formed == required) {
                if (right - left < result.length()) {
                    result = s.substring(left, right);
                }

                c = s.charAt(left);
                hashmap[c]++;
                if (hashmap[c] > 0) {
                    formed--;
                }
                left++;
            }
        }
        return result.length() <= s.length() ? result : "";
    }
}