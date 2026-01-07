// https://leetcode.com/problems/implement-trie-prefix-tree
// LC208. Implement Trie Prefix Tree
// Linear time, linear extra-space.
class ImplementTriePrefixTree {

    List<String> words;
    public Trie() {
        words = new ArrayList();
    }
    
    public void insert(String word) {
        words.add(word);
    }
    
    public boolean search(String word) {
        for (String w : words) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        for (String word : words) {
            if (word.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
