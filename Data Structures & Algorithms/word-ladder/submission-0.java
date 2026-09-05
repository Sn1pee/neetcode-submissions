class Pair{
    String first;
    int second;
    public Pair(String str, int l){
        first = str;
        second = l;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++){
            st.add(wordList.get(i));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            Pair it = q.poll();
            String word = it.first;
            int steps = it.second;    

            if(word.equals(endWord)) return steps;
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
