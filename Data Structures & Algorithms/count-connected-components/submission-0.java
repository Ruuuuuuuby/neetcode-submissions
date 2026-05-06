class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(visited, graph, i);
                count++;
            }
        }
        return count;
    }
        public void dfs(boolean[] visited, List<List<Integer>> graph, int cur){
            visited[cur] = true;
            for(int g : graph.get(cur)){
                if(!visited[g]){
                    dfs(visited, graph, g);
                }
            }
        }
    
}
