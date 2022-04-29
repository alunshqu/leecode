package com.alun;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();

        integers.add(12);
        integers.add(14);
        integers.add(10);
        integers.add(33);
        integers.add(55);
        integers.add(1);
        integers.add(6);
        integers.add(99);
        integers.add(4);

        while (!integers.isEmpty()) {
            System.out.println(integers.poll());
        }

    }
}
