package graph;

/**
 * <p>
 *  前缀树
 * @author zhl
 * @since 2024-07-23 23:12
 */
@SuppressWarnings("all")
public class _04_Trie {

}

@SuppressWarnings("all")
class Trie {
    private Trie[] children;
    // 在节点的末尾，设置存在完整的单词
    private boolean isEnd;

    public Trie() {
        children=new Trie[26];
        isEnd=false;
    }

    public void insert(String word) {
        Trie node  = this;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index]==null) {
                node.children[index] = new Trie();
            }
            node=node.children[index];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node!=null && node.isEnd;
    }

    public boolean startWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for(int i=0;i<prefix.length();i++) {
            char ch = prefix.charAt(i);
            int index = ch-'a';
            if(node.children[index]==null){
                return null;
            }
            node=node.children[index];
        }
        return node;
    }
}