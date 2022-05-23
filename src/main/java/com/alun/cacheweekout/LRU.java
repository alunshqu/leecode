package com.alun.cacheweekout;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    class DoubleLinkNode {
        int key;
        int value;
        DoubleLinkNode prev;
        DoubleLinkNode next;

        public DoubleLinkNode() {

        }

        public DoubleLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DoubleLinkNode> cache = new HashMap<>();

    private int size;
    private int capacity;
    private DoubleLinkNode head, tail;


    public LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        move2Head(node);
        return node.value;
    }

    private void move2Head(DoubleLinkNode node) {
        removeNode(node);
        add2Head(node);
    }

    private void add2Head(DoubleLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DoubleLinkNode removeTail() {
        DoubleLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }

    public void put(int key, int value) {
        DoubleLinkNode node = cache.get(key);
        if (node == null) {
            node = new DoubleLinkNode(key, value);
            cache.put(key, node);
            add2Head(node);
            if (++size > capacity) {
                DoubleLinkNode tailNode = removeTail();
                cache.remove(tailNode.key);
                --size;
            }
        } else {
            node.value = value;
            move2Head(node);
        }
    }
}
