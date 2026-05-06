class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hs = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : count){
                sb.append('#');
                sb.append(i);
            }
            String key = sb.toString();
            if(!hs.containsKey(key)){
                hs.put(key, new ArrayList<>());
            }
            hs.get(key).add(str);
        }
        return new ArrayList<>(hs.values());
        
    }
}
