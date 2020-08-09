import java.util.LinkedList;

class Trie {

    private Trie[] nextItems = new Trie[26];
    private boolean isWord = false;

    /** Initialize your data structure here. */
    public Trie() {

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
    public boolean search(String word) {

        Trie curr = this;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(curr.nextItems[ c - 'a' ] == null){
                return false;
            }

            curr = curr.nextItems[ c - 'a' ];
        }

        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        Trie curr = this;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);

            if(curr.nextItems[ c - 'a' ] == null){
                return false;
            }

            curr = curr.nextItems[ c - 'a' ];
        }

        return true;
    }

    private void bfsPrint(){
        //按照广度优先方式遍历这棵树，并打印出来

        LinkedList<Trie> list = new LinkedList<Trie>();
        list.addLast(this);
        int level = 1;
        while(list.size() > 0){
            int count = list.size();
            for(int i = 0 ; i < count; i++){    //出列count个节点，并打印，同时把这些节点的子节点加入到列表之中
                Trie tree = list.removeFirst();
                tree.printTree(level);

                ///把该节点的所有子节点加入到列表之中
                for(int j = 0; j < tree.nextItems.length; j++){
                    if(tree.nextItems[j] != null){
                        list.addLast(tree.nextItems[j]);
                    }
                }
            }
            level++;
        }

    }

    private void printTree(int depth){
        String str = "";
        for(int i = 0 ; i < nextItems.length; i++){
            if(nextItems[i] != null){
                str += (char)('a' + i);
            }
        }
        System.out.printf("(%d) %s\n", depth, str);
    }

    public static void main(String[] args) {
        Trie tree = new Trie();
        tree.insert("zhong");
        tree.insert("zhonz");
        tree.insert("chang");
        System.out.println(tree.startsWith("a"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

