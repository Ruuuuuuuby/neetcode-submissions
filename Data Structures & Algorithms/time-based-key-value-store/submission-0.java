class TimeMap {
    private static class Pair{
        String value;
        int timestamp;
        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, List<Pair>> hs;

    public TimeMap() {
        hs = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hs.putIfAbsent(key, new ArrayList<>());
        hs.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!hs.containsKey(key)){
            return "";
        }
        List<Pair> list = hs.get(key);
        int left = 0;
        int right = list.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid).timestamp > timestamp){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right >= 0 ? list.get(right).value : "";
    }
    
}
