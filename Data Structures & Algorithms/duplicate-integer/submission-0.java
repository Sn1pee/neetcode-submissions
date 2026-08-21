class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> ans = new HashSet<>();

        for(int num: nums){
            if(!ans.add(num)) return true;
        }

        return false;
    }
}