class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nsr[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && heights[i] <= heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = n;
            }
            else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        int nsl[] = new int[n];
        s = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && heights[i] <= heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        int maxarea = 0;
        for(int i = 0; i < n; i++){
            int h = heights[i];
            int w = nsr[i] - nsl[i] - 1;
            
            int curr = h * w;
            maxarea = Math.max(maxarea, curr);
        }
        return maxarea;
    }
}
