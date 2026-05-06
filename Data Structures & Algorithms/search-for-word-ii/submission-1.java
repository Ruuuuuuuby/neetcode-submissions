class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];//26!!!!!
        String word = null;//String!!!!
    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s : words){
            TrieNode node = root;
            for(char c : s.toCharArray()){
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = s;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, i, j, res, root);
            }
        }
        return res;  
    }
    public void dfs(char[][] board, int i, int j, List<String> res, TrieNode node){
        char c = board[i][j];
        
        if(c == '#' || node.children[c - 'a'] == null){
            return;
        }
        node = node.children[c - 'a'];
        if(node.word != null){
            res.add(node.word);//node.word
            node.word = null;
        }
        board[i][j] = '#';
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir : dirs){
            int xi = dir[0] + i;
            int yj = dir[1] + j;
            if(xi >= 0 && xi < board.length && yj >= 0 && yj < board[0].length){
                dfs(board, xi, yj, res, node);
            }
        }

        
        
        board[i][j] = c;
    }
}
