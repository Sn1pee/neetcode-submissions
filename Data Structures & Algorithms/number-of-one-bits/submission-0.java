class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int bitmask = 1;

        while(n != 0){
            int LSB = n & 1;
            if(LSB == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
