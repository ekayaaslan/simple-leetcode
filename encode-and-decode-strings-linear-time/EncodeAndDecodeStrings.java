// https://leetcode.com/problems/encode-and-decode-strings
// LC271. Encode And Decode Strings
// Time/space: Linear time.
// Solution kind: Good.
public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.isEmpty()) { return ""; }
        String encoded = new String();
        encoded = strs.size() + ":";
        for (String str : strs) {
            encoded += str.length()+":";
        }
        for (String str : strs) {
            encoded += str;
        }
        return encoded;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList();
        if (s.isEmpty()) { return List.of(); }
        int end = s.indexOf(":");
        int size = Integer.parseInt(s.substring(0,end));
        int[] lengths = new int[size];
        int start = end+1;        
        for (int i=0; i<size; i++) {
            end = start+s.substring(start).indexOf(":");
            lengths[i] = Integer.parseInt(s.substring(start, end));
            start = end+1;
        }
        for (int i=0; i<size; i++) {
            end = start+lengths[i];
            decoded.add(s.substring(start, end));
            start = end;
        }
        return decoded;
    }
}
