class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int count = n;
        for(int[] edge : edges){
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if(x != y){
                count--;
                parent[x] = y;
            }
        }
        return count;
    }
    public int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
       
}
