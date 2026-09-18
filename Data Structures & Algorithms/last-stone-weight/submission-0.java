public class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if(n == 1) return stones[0];
        if(n == 2){
            return Math.abs(stones[0] - stones[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            pq.offer(stone);
        }

        while(pq.size() >= 2){
            int first = pq.poll();
            int second = pq.poll();
            int diff = Math.abs(first - second);
            pq.offer(diff);
        }

        return pq.poll();
    }
}