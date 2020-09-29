package com.leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: dlm
 * @Date: 2020/9/28 09:08
 * @Description:
 */
public class LRUCache_146 {

    /**
     * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
     * <p>
     * Implement the LRUCache class:
     * <p>
     * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
     * <p>
     * int get(int key) Return the value of the key if the key exists, otherwise return -1.
     * <p>
     * void put(int key, int value) Update the value of the key if the key exists. Otherwise,
     * <p>
     * add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
     * <p>
     * evict the least recently used key.
     * <p>
     * Follow up:
     * <p>
     * Could you do get and put in O(1) time complexity?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * Output
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     * <p>
     * Explanation
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // cache is {1=1}
     * lRUCache.put(2, 2); // cache is {1=1, 2=2}
     * lRUCache.get(1);    // return 1
     * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
     * lRUCache.get(2);    // returns -1 (not found)
     * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
     * lRUCache.get(1);    // return -1 (not found)
     * lRUCache.get(3);    // return 3
     * lRUCache.get(4);    // return 4
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= capacity <= 3000
     * 0 <= key <= 3000
     * 0 <= value <= 104
     * At most 3 * 104 calls will be made to get and put.
     */
    public static void main(String[] args) {
        LRUCache2<Integer, Integer> cache = new LRUCache2<>();
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.put(4, 4);
        System.out.println(cache.keySet());
    }

    //1、HashMap + 一个简单的双向链表
    static class LRUCache {
        // 双向链表节点定义
        class Node {
            int key;
            int val;
            Node prev;
            Node next;
        }

        private int capacity;
        //保存链表的头节点和尾节点
        private Node first;
        private Node last;

        private Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        //获取值
        public int get(int key) {
            Node node = map.get(key);
            //为空返回-1
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        //将node移动到表头
        private void moveToHead(Node node) {
            if (node == first) {
                return;
            } else if (node == last) {
                last.prev.next = null;
                last = last.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.prev = first.prev;
            node.next = first;
            first.prev = node;
            first = node;
        }

        //存入值
        public void put(int key, int value) {
            Node node = map.get(key);

            if (node == null) {
                node = new Node();
                node.key = key;
                node.val = value;

                if(map.size() == capacity) {
                    removeLast();
                }

                addToHead(node);
                map.put(key, node);
            } else {
                node.val = value;
                moveToHead(node);
            }
        }

        private void addToHead(Node node) {
            if (map.isEmpty()) {
                first = node;
                last = node;
            } else {
                node.next = first;
                first.prev = node;
                first = node;
            }
        }

        private void removeLast() {
            map.remove(last.key);
            Node prevNode = last.prev;
            if (prevNode != null) {
                prevNode.next = null;
                last = prevNode;
            }
        }

        @Override
        public String toString() {
            return map.keySet().toString();
        }

    }


    // 2、使用LinkedHashMap（基于HashMap和双向链表）实现
    // https://blog.csdn.net/u013568373/article/details/90607083
    public static class LRUCache2<K,V> extends LinkedHashMap<K, V>{

        //首先设定最大缓存空间 MAX_ENTRIES 为 3；
        private static final int MAX_ENTRIES = 3;

        //之后使用LinkedHashMap的构造函数将 accessOrder设置为 true，开启 LRU顺序；
        public LRUCache2() {
            super(MAX_ENTRIES, 0.75f, true);
        }

        //最后覆盖removeEldestEntry(）方法实现，在节点多于 MAX_ENTRIES 就会将最近最少使用的数据移除。
        //因为这个函数默认返回false，不重写的话缓存爆了的时候无法删除最近最久未使用的节点
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            //在容量超过最大允许节点数的时候返回true，使得在afterNodeInsertion函数中能执行removeNode()
            return size() > MAX_ENTRIES;
        }

    }

}
