class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        if(m == 0 || n == 0){
            return "0";
        }
        int[] res = new int[m + n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                res[i + j + 1] += x * y;
            }
        }
        for(int i = m + n - 1; i > 0; i--){
            res[i - 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
        StringBuilder r = new StringBuilder();
        int idx = res[0] == 0 ? 1 : 0;
        for(; idx < m + n; idx++){
            r.append(res[idx]);

        }
        return r.toString();
        
    }
}
