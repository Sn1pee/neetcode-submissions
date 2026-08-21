class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int l = 0;
        int longest = 0;
        for(int r = 0; r < s.length(); r++){
            char curr = s.charAt(r);
            while(st.contains(curr)){
                st.remove(s.charAt(l));
                l++;
            }
            st.add(curr);
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
