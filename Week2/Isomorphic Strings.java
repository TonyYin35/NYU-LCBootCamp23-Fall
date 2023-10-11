class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashS = new int [128];
        int[] hashT = new int [128];

        for (int i = 0; i < 128; i++) {
            hashS[i] = -1;
            hashT[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (hashS[sChar] == -1 && hashT[tChar] == -1) {
                hashS[sChar] = tChar;
                hashT[tChar] = sChar;
            }
            else if (hashS[sChar] != tChar || hashT[tChar] != sChar) {
                return false;
            }
        }
        return true;
    }
}