// class Solution{
//     public String encode(List<String> strs){
//         StringBuilder sb = new StringBuilder();
//         for(String str : strs){
//             sb.append(str.length()).append('#').append(str);
//         }
//         return sb.toString();
//     }
//     public List<String> decode(String str){
//         List<String> res = new ArrayList<>();
//         int i = 0;
//         while(i != str.length()){
//             int j = i;
//             while(str.charAt(j) != '#'){
//                 j++;
//             }
//             int l = Integer.parseInt(str.substring(i, j));
//             res.add(str.substring(j + 1, j + l + 1));
//             i = j + l + 1;
//         }
//         return res;
//     }
// }

//Map.Entry<Integer, Integer>!!!!! uppercase
//Integer.parseInt()
//str.substring()
//sb.toString()


class Solution{
    public String encode(List<String> strs){
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }
    public List<String> decode(String str){
        List<String> res = new ArrayList<>();
        int i = 0; 
        while(i != str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            String s = str.substring(j + 1, j + len + 1);
            res.add(s);
            i = j + len + 1;
        }
        return res;
    }
}