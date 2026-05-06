class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] ok = new boolean[3];
        for(int[] triplet : triplets){
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]){
                continue;
            }
            if(triplet[0] == target[0]){
                ok[0] = true;
            }
            if(triplet[1] == target[1]){
                ok[1] = true;
            }
            if(triplet[2] == target[2]){
                ok[2] = true;
            }
        }
        return ok[0] && ok[1] && ok[2];
    }
}
