class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int sharpIndex = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, sharpIndex));
            String s = str.substring(sharpIndex + 1, sharpIndex + 1 + length);
            list.add(s);
            i = sharpIndex + 1 + length;
            
        }
        return list;
    }
}
