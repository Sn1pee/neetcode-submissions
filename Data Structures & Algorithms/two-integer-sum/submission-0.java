class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ans = new HashMap<>();

        for(int i = 0; i < nums.length; i ++){
            int compliment = target - nums[i];
            if(ans.containsKey(compliment)){
                return new int[] {ans.get(compliment), i};
            }
            ans.put(nums[i], i);
        }

        return new int[] {};
    }
}
