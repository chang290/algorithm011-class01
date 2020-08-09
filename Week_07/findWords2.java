class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        Set<String> retSet = new HashSet<>();
        if(words == null || board == null || words.length == 0 || 
            board.length == 0 || board[0].length == 0) return new ArrayList<String>(retSet);

        Trie tree = new Trie();
        //将所有的字符串添加到Trie树之中
        for(int i = 0; i < words.length; i++){
            tree.insert(words[i]);
        }
        //深度优先遍历二维数组，不断判断是否在Trie树之中，若存在则添加到返回列表之中
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                Set<Integer> distSet = new HashSet<Integer>();
                bfs(board, tree, retSet, distSet, row, col, "");
            }
        }
        return new ArrayList<String>(retSet);
    }

    private void bfs(char[][] board, Trie tree, Set<String> retSet, Set<Integer> distSet, int row, int col, String str){
        if(row < 0 || row >= board.length || col < 0 || 
            col >= board[0].length || distSet.contains( board[0].length * row + col )) return;

        str += board[row][col];

        Trie curr = tree.search(str);
        if(curr == null) return;
        if(curr.isWord()) retSet.add(str);

        //避免重复遍历
        distSet.add(board[0].length * row + col);

        //前后左右继续遍历下去
        bfs(board, tree, retSet, distSet, row, col - 1, str);
        bfs(board, tree, retSet, distSet, row, col + 1, str);
        bfs(board, tree, retSet, distSet, row - 1, col, str);
        bfs(board, tree, retSet, distSet, row + 1, col, str);

        //此处需要回退
        distSet.remove(board[0].length * row + col);
    }
}

class Trie {

    private Trie[] nextItems = new Trie[26];
    private boolean isWord = false;

    public boolean isWord(){
        return this.isWord;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(curr.nextItems[ c - 'a' ] != null){
                curr = curr.nextItems[ c - 'a' ];
                continue;
            }

            curr.nextItems[ c - 'a' ] = new Trie();   
            curr = curr.nextItems[ c - 'a' ];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public Trie search(String word) {

        Trie curr = this;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(curr.nextItems[ c - 'a' ] == null){
                return null;
            }

            curr = curr.nextItems[ c - 'a' ];
        }

        return curr;
    }
}

