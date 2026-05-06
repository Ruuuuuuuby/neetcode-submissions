class Solution {//村子通电
    int[] parent;
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, cost});
            }
        }
        //Arrays.sort只能用于array
        edges.sort(Comparator.comparingInt(a -> a[2]));//work for List
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int res = 0;
        int count = 0;
        for(int[] e : edges){
            int x = find(e[0]);
            int y = find(e[1]);
            if(x != y){
                parent[x] = y;
                res += e[2];
                count++;
            }
            if(count == n - 1){
                break;
            }
        }
        return res;
        
    }
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
