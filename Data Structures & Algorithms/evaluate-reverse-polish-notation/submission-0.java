class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> s = new ArrayDeque<>();
        String ops = "+-*/";
        int res = 0;
        for(int i = 0; i < tokens.length; i++){
            String ch = tokens[i];
            if(ops.contains(ch)){
                int a = Integer.parseInt(s.pop());
                int b = Integer.parseInt(s.pop());
                if(ch.equals("+")){
                    res = a + b;
                    s.push(String.valueOf(res));
                }
                else if(ch.equals("-")){
                    res = b - a;
                    s.push(String.valueOf(res));
                }
                else if(ch.equals("*")){
                    res = a * b;
                    s.push(String.valueOf(res));
                }
                else if(ch.equals("/")){
                    if(a == 0){
                        res = 0;
                    }
                    else{
                        res = b / a;
                    }
                    s.push(String.valueOf(res));
                }
            }
            else{
                s.push(ch);
            }
        }
        res = Integer.parseInt(s.pop());
        return res;
    }
}
