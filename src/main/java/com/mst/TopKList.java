package com.mst;

import java.util.*;

public class TopKList <E extends Comparable>{
    private PriorityQueue<E> queue;
    //堆的最大容量
    private int maxSize;

    public TopKList(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalStateException();
        }
        this.maxSize = maxSize;
//        this.queue = new PriorityQueue<>(maxSize, new Comparator<E>() {
//            @Override
//            public int compare(E o1, E o2) {
//                // 最大堆用o2 - o1，最小堆用o1 - o2
//                return (o1.compareTo(o2));
//            }
//        });
        
        
        this.queue = new PriorityQueue<>(maxSize, (o1,o2) -> o1.compareTo(o2));
    }

    public void add(E e) {
        if (queue.size() < maxSize) {
            queue.add(e);
        } else {
            E peek = queue.peek();
            if (e.compareTo(peek) > 0) {
                queue.poll();
                queue.add(e);
            }
        }
    }
    

//    public List<E> sortedList() {
//        List<E> list = new ArrayList<>(queue);
//        Collections.sort(list);
//        return list;
//    }

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        TopKList pq = new TopKList(4);
        for (int n : array) {
            pq.add(n);
        }
//        System.out.println(pq.sortedList());
        
        int size = 4;
        while(size > 0) {
        	System.out.println(pq.queue.poll());
        	size--;
        }
    }
}
