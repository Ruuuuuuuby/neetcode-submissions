class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);//putIfAbsent
            }
        }
        
        int n = words.length;
        for(int i = 0; i < n - 1; i++){//n-1!!!!!!
            String w1 = words[i];
            String w2 = words[i + 1];
            boolean found = false;//注意这句的位置！！！
            int minLen = Math.min(w1.length(), w2.length());
            for(int j = 0; j < minLen; j++){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2){
                    if(!graph.get(c1).contains(c2)){//一定要检验，不然indegree会出错
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    found = true;//只要c1!=c2就可以为true
                    break;
                }
            }
            if(!found && w1.length() > w2.length()){
                return "";
            } 
        }
        Queue<Character> q = new LinkedList<>();
        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0){
                q.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char cur = q.poll();
            sb.append(cur);
            for(char nei : graph.get(cur)){
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0){
                    q.offer(nei);
                }
            }
        }
        return indegree.size() == sb.length() ? sb.toString() : "";//如果有些字母还没排序
    }
}
