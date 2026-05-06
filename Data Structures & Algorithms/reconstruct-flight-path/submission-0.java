class Solution {//pq写法
    HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> t : tickets){
            String from = t.get(0);
            String to = t.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK");
        return res; 
    }
    
    public void dfs(String from){
        while(graph.containsKey(from) && !graph.get(from).isEmpty()){
            String to = graph.get(from).poll();
            dfs(to);
        }
        res.add(0, from);//不是to！！
    }
}
