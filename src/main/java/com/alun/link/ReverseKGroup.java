package com.alun.link;

public class ReverseKGroup {

    class LinkNode {
        int value;
        LinkNode next;

        public LinkNode() {
        }

        public LinkNode(int value, LinkNode next) {
            this.value = value;
            this.next = next;
        }

        public LinkNode(int value) {
            this.value = value;
        }
    }

    public LinkNode reverseKGroup(LinkNode head, int k) {
        LinkNode dummy = new LinkNode(0), prev = dummy, current = head, next;
        dummy.next = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        head = dummy.next;
        for (int i = 0; i < length % k; i++) {
            for (int j = 0; j < k - 1; j++) {
                next = current.next;
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = current;
            current = prev.next;
        }
        return dummy.next;
    }
}
