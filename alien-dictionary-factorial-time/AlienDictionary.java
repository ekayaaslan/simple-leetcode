// https://leetcode.com/problems/alien-dictionary
// LC269. Alien Dictionary
// Factorial time, linear extra-space.
class AlienDictionary {
    List<Character> findLetters(String[] words) {
        List<Character> letters = new ArrayList();
        boolean[] seen = new boolean[26];
        for (String word : words) {
            for (int i=0; i<word.length(); i++) {
                char letter = word.charAt(i);
                int ch = letter-'a';
                if (!seen[ch]) {
                    seen[ch] = true;
                    letters.add(letter);
                }
            }
        }
        return letters;
    }
    boolean isGreater(String lhs, String rhs, String alphabet) {
        int size = Math.min(lhs.length(), rhs.length());
        int[] perm = new int[26];
        for (int i=0; i<alphabet.length(); i++) {
            int ch = alphabet.charAt(i)-'a';
            perm[ch] = i;
        }
        for (int i=0; i<size; i++) {
            int lhsChar = lhs.charAt(i)-'a';
            int rhsChar = rhs.charAt(i)-'a';
            if (lhsChar != rhsChar) {
                return perm[lhsChar] > perm[rhsChar];
            }
        }
        return lhs.length() > rhs.length();
    }
    boolean isLexicographical(String[] words, String alphabetString) {
        int n = words.length;
        for (int i=0; i<n-1; i++) {
            if (isGreater(words[i], words[i+1], alphabetString)) {
                return false;
            }
        }
        return true;
    }
    String search(List<Character> letters, 
            StringBuilder alphabet, String[] words, boolean[] seen) {
        if (letters.size() == alphabet.length()) {
            String alphabetString = alphabet.toString();
            if(isLexicographical(words, alphabetString)) {
                return alphabetString;
            }
        }
        for (char letter : letters) {
            int ch = letter-'a';
            if (seen[ch]) { continue; }
            seen[ch] = true;
            alphabet.append(letter);
            String result = search(letters, alphabet, words, seen);
            if (!result.isEmpty()) { 
                return result;
            }
            alphabet.deleteCharAt(alphabet.length()-1);
            seen[ch] = false;
        }
        return "";
    }
    public String alienOrder(String[] words) {
        List<Character> letters = findLetters(words);
        StringBuilder alphabet = new StringBuilder();
        boolean[] seen = new boolean[26];
        return search(letters, alphabet, words, seen);
    }
}