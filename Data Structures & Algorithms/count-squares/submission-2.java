class CountSquares {
    int[][] count = new int[1001][1001];
    List<int[]> points = new ArrayList<>();

    public CountSquares() {
        
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        count[x][y]++;
        points.add(point);
        
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int res = 0;
        for(int[] p : points){
            int xi = p[0];
            int yi = p[1];
            if(x != xi && y == yi){
                int d = xi - x;
                if(y + d >= 0 && y + d <= 1000){
                    res += count[x][y + d] * count[xi][y + d];
                    
                }
                
                if(y - d >= 0 && y - d <= 1000){
                    res += count[x][y - d] * count[xi][y - d];
                    
                }
                


            }
            
        }
        return res;
        
    }
}
