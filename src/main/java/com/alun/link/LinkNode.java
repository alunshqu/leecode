package com.alun.link;

import java.util.Optional;

public class LinkNode {

    int value;
    LinkNode next;
    public LinkNode() {

    }
    public LinkNode(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        LinkNode linkNode = null;
        Optional<LinkNode> linkNode1 = Optional.ofNullable(linkNode).map(node -> node.next).map(node -> node.next);
        System.out.println(linkNode1.orElse(new LinkNode()).value);
    }

}
