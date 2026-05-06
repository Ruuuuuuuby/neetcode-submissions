class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n - 1 != edges.length){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        if(hasCycle(0, -1, visited, graph)){
            return false;
        }
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;

    }

    public boolean hasCycle(int cur, int parent, boolean[] visited, List<List<Integer>> graph){
        visited[cur] = true;
        for(int nei : graph.get(cur)){
            if(nei == parent){
                continue;//////是continue，忽略掉父节点即可
            }
            if(visited[nei] || hasCycle(nei, cur, visited, graph)){
                return true;
            }
        }
        return false;
    }
}
