// https://leetcode.com/problems/design-add-and-search-words-data-structure
// LC211. Design Add and Search Words Data Structure
// Linear time, linear extra-space.
class DesignAddAndSearchWordsDataStructure {

    List<String> words;

    public WordDictionary() {
        words = new ArrayList();
    }
    
    public void addWord(String word) {
        words.add(word);
    }

    boolean match(String word, String pattern) {
        int n = word.length();
        if (pattern.length() != n) {
            return false;
        }
        for (int i=0; i<n; i++) {
            if (pattern.charAt(i) == '.') {
                continue;
            }
            char ch = word.charAt(i);
            if (ch != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean search(String word) {
        for (String w : words) {
            if (match(w, word)) {
                return true;
            }
        }
        return false;
    }
}