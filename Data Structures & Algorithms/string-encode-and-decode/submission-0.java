class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for(String s : strs){
            encode.append(s.length());
            encode.append('#');
            encode.append(s);
        }
        return encode.toString();

    }

    public List<String> decode(String str) {
        List<String> decode = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int sharpIndex = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, sharpIndex));
            String s = str.substring(sharpIndex + 1, sharpIndex + length + 1);
            decode.add(s);
            i = sharpIndex + 1 + length;
        }
        return decode;
    }
}
