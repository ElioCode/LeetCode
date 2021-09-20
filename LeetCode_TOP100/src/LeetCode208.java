import java.util.HashMap;

public class LeetCode208 {
    class Trie {

        TrieNode head = null;

        class TrieNode {

            boolean end = false;
            HashMap<Character, TrieNode> desNode = new HashMap<>();

        }


        /**
         * Initialize your data structure here.
         */
        public Trie() {
            head = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode tempNode = head;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                TrieNode node = tempNode.desNode.get(charArray[i]);
                if (node == null) {
                    node = new TrieNode();
                    tempNode.desNode.put(charArray[i], node);
                }
                if (i == charArray.length - 1) {
                    node.end = true;
                }
                tempNode = node;

            }

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode tempNode = head;
            int position = 0; // 当前比较的位置
            while (position < word.length()) {
                char c = word.charAt(position);
                tempNode = tempNode.desNode.get(c);
                if (tempNode == null) {
                    return false;
                }else if (tempNode.end == true && position == word.length() - 1){
                    return true;
                }else{
                    position++;
                }
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode tempNode = head;
            int position = 0; // 当前比较的位置
            while (position < prefix.length()) {
                char c = prefix.charAt(position);
                tempNode = tempNode.desNode.get(c);
                if (tempNode == null) {
                    return false;
                }else{
                    position++;
                }
            }
            return true;
        }
    }
}
