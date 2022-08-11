package leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
//        new Solution().longestCommonPrefixTrie(new String[]{"flower", "flow", "flight"});
        new Solution().longestCommonPrefixTrie(new String[]{"", "b"});
//        new Solution().longestCommonPrefixTrie(new String[]{"", ""});
//        new Solution().longestCommonPrefixTrie(new String[]{"ab", "a"});
    }

    public String longestCommonPrefixNaive(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int min = Integer.MAX_VALUE;

        int max = strs[0].length();
        for (int i = 1; i < strs.length; ++i) {
            if (strs[i].length() < max) {
                max = strs[i].length();
            }
        }

        for (int i = 1; i < strs.length; ++i) {
            String first = strs[i - 1];
            String second = strs[i];
            int l = 0;
            while (l < max && first.charAt(l) == second.charAt(l)) {
                ++l;
            }
            if (l < min) {
                min = l;
            }
        }

        StringBuilder result = new StringBuilder(min);
        for (int i = 0; i < min; ++i) {
            result.append(strs[0].charAt(i));
        }
        return result.toString();

    }

    public String longestCommonPrefixTrie(String[] strs) {
        TrieArray t = new TrieArray();

        for (String str : strs) {
            if (str.isBlank()) {
                return "";
            }
            t.add(str);
        }


        String s = t.longestCommon();
        return s.trim();
    }


    private class TrieArray {

        TrieArrayNode root = new TrieArrayNode();

        private void add(String word) {

            char[] letters = word.toCharArray();
            TrieArrayNode it = root;

            for (int i = 0; i < letters.length; i++) {
                char letter = letters[i];
                int idx = letter - 'a';
                if (it.chs[idx] == null) {
                    TrieArrayNode newNode = new TrieArrayNode();
                    newNode.ch = letter;
                    it.chs[idx] = newNode;
                    it = newNode;
                } else {
                    it = it.chs[idx];
                }
                if (i == letters.length - 1) {
                    it.end = true;
                }
            }
        }

        public String longestCommon() {
            int cnt = 0;
            TrieArrayNode it = root;
            StringBuilder result = new StringBuilder();

            if (getChildrenCount(it) > 1) {
                return result.toString();
            }

            while (getChildrenCount(it) == 1) {
                result.append(it.ch);
                if (it.end) {
                    break;
                }
                it = firstChild(it);

                if (getChildrenCount(it) != 1) {
                    result.append(it.ch);
                    break;
                }

            }


            return result.toString().trim();
        }

        private TrieArrayNode firstChild(TrieArrayNode n) {
            for (TrieArrayNode i : n.chs) {
                if (i != null) {
                    return i;
                }
            }
            return null;
        }

        private int getChildrenCount(TrieArrayNode it) {
            int childrenCount = 0;
            for (TrieArrayNode i : it.chs) {
                if (i != null) {
                    ++childrenCount;
                }
            }
            return childrenCount;
        }
    }

    static class TrieArrayNode {
        char ch;
        TrieArrayNode[] chs = new TrieArrayNode[26];
        boolean end;
    }

    private static class TrieWithMap {
        Map<Character, TrieWithMap> root = new HashMap<>();
        boolean wordEnd = false;

        private void add(String word) {
            char[] chars = word.toCharArray();
            TrieWithMap it = this;
            if (word.isEmpty()) {
                root.put(' ', new TrieWithMap());
            }
            for (int i = 0; i < chars.length; ++i) {
                if (it.root.containsKey(chars[i])) {
                    it = it.root.get(chars[i]);
                } else {
                    TrieWithMap t2 = new TrieWithMap();
                    it.root.put(chars[i], t2);
                    it = t2;
                }
                if (i == chars.length - 1) {
                    it.wordEnd = true;
                }
            }

        }

        private String longestCommon() {
            TrieWithMap it = this;
            StringBuilder result = new StringBuilder();

            while (it.root.keySet().size() == 1) {
                Character next = it.root.keySet().iterator().next();
                result.append(next);
                it = it.root.get(next);
                if (it.wordEnd) {
                    break;
                }
            }

            return result.toString();
        }

    }
}