class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] list = new ArrayList[nums.length + 1];
        for(int n : hm.keySet()){
            int f = hm.get(n);
            if(list[f] == null){
                list[f] = new ArrayList<>();
            }
            list[f].add(n);
        }

        int i = 0;
        int[] res = new int[k];
        for(int t = nums.length; t > 0; t--){
            if(list[t] != null){
                for(int j = 0; j < list[t].size() && i < k; j++){
                    res[i] = list[t].get(j);
                    i++;
                }
            }  
        }
        return res;
        
    }
}
