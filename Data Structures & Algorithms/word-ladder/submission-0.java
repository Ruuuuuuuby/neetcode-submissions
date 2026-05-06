class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> word = new HashSet<>(wordList);
        if(!word.contains(endWord)){
            return 0;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int len = 1;
        q.offer(beginWord);
        visited.add(beginWord);//!!!!!!!!
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(cur.equals(endWord)){
                    return len;
                }
                char[] chars = cur.toCharArray();
                for(int j = 0; j < chars.length; j++){
                    char old = chars[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == chars[j]){
                            continue;
                        }
                        chars[j] = c;
                        String next = new String(chars);
                        if(word.contains(next) && !visited.contains(next)){
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                    chars[j] = old;
                }

            }
            len++;
        }
        return 0;

    }
}
