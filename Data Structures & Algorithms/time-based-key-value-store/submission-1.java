class TimeMap {
    // private static class Pair{
    //     int timestamp;
    //     String value;

    //     Pair(String value, int timestamp){
    //         this.value = value;
    //         this.timestamp = timestamp;
    //     }
    // }

    HashMap<String, List<Pair<Integer, String>>> hs;

    public TimeMap() {
        hs = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hs.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {
        if(!hs.containsKey(key)){
            return "";
        }
        int left = 0;
        List<Pair<Integer, String>> list = hs.get(key);
        int right = list.size() - 1;
        String res = "";
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid).getKey() <= timestamp){
                res = list.get(mid).getValue();
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return res;
    }
}
