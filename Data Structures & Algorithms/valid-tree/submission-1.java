class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n - 1 != edges.length){
            return false;
        }
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int[] e : edges){
            int x = find(e[0], parent);
            int y = find(e[1], parent);
            if(x == y){
                return false;
            }
            parent[x] = y;
        }
        return true;
        


    }

    public int find(int x, int[] parent){
        if(parent[x] != x){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}
