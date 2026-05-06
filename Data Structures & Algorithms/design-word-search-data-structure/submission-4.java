class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;

    }

    public boolean search(String word) {
        char[] wordList = word.toCharArray();
        return dfs(word.toCharArray(), 0, root);

    }

    public boolean dfs(char[] wordList, int i, TrieNode node){
        if (i == wordList.length){
            return node.isEnd;
        }
        char c = wordList[i];
        if(c != '.'){
            int idx = c - 'a';
            return (node.children[idx] != null) && (dfs(wordList, i + 1, node.children[idx]));

        }else{
            for(int j = 0; j < 26; j++){
                if ((node.children[j] != null) && dfs(wordList, i + 1, node.children[j])){
                    return true;
                }

            }
        }
        return false;
        
    }
}
