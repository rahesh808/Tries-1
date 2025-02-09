class Solution2 {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }
        for (String word : dictionary) {
            insert(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                result.append(" ");
            }
            String word = words[i];
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (curr.children[ch - 'a'] == null || curr.isEnd == true) {
                    break;
                }
                sb.append(ch);
                curr = curr.children[ch - 'a'];
            }
            if (curr.isEnd) {
                result.append(sb);
            } else {
                result.append(word);
            }
        }

        return result.toString();
    }

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
}