package sortLesson;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * trie字典树
 */
public class TrieTree {

    public static void main(String[] args) {
        long pre1 = System.currentTimeMillis();
        insert("insert".toCharArray());
        long last1 = System.currentTimeMillis();
        System.out.println(last1 - pre1);
        long pre2 = System.currentTimeMillis();
        System.out.println(find("ins".toCharArray()));
        long last2 = System.currentTimeMillis();
        System.out.println(last2 - pre2);
    }

    // 存储无意义字符
    private final static TrieNode root = new TrieNode('/');

    // 往Trie树中插入一个字符串
    public static void insert(char[] text) {
        TrieNode p = root;
        for (char c : text) {
            if (!p.children.containsKey(c)) {
                p.children.put(c, new TrieNode(c));
            }
            //下一个字符
            p = p.children.get(c);
            p.isEndingChar = true;
        }
    }

    // 在Trie树中查找一个字符串
    public static boolean find(char[] pattern) {
        TrieNode p = root;
        for (char c : pattern) {
            // 不存在pattern
            if (!p.children.containsKey(c)) {
                return false;
            }
            p = p.children.get(c);
        }
        // 不能完全匹配，只是前缀
        // 找到pattern
        return p.isEndingChar;
    }

    public static class TrieNode {
        public char data;
        public Map<Character, TrieNode> children = Maps.newHashMap();
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
