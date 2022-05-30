package com.alun.link;

public class LinkCycle {

    public LinkNode getNodeInLoop(LinkNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        LinkNode slow = head.next;
        LinkNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    public LinkNode detectCycle(LinkNode head) {
        LinkNode node = getNodeInLoop(head);
        if (node == null) {
            return null;
        }
        int count = 1;
        for (LinkNode n = node; n.next != node; n = n.next) {
            count++;
        }
        LinkNode fast = head;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }
        LinkNode slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public LinkNode detectCycleV2(LinkNode head) {
        LinkNode node = getNodeInLoop(head);
        if(node == null) {
            return null;
        }
        LinkNode n = head;
        while (n != node) {
            n = n.next;
            node = node.next;
        }
        return n;
    }
}
