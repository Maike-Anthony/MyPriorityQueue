import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import java.util.Iterator;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.Test;

public class MyPriorityQueueTest {
    @Test
    void testClear() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(comparator);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.clear();
        int size = queue.size();
        assertEquals(0, size);
    }

    @Test
    void testOffer() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(comparator);
        queue.offer(2);
        queue.offer(8);
        queue.offer(13);
        queue.offer(34);
        queue.offer(21);
        queue.offer(5);
        queue.offer(55);
        queue.offer(1);
        queue.offer(89);
        queue.offer(144);
        queue.offer(3);
        Iterator<Integer> iter = queue.iterator();
        iter.next();
        int nxt = iter.next();
        assertEquals(1, nxt);
        nxt = iter.next();
        assertEquals(2, nxt);
        nxt = iter.next();
        assertEquals(5, nxt);
        nxt = iter.next();
        assertEquals(8, nxt);
        nxt = iter.next();
        assertEquals(3, nxt);
        nxt = iter.next();
        assertEquals(13, nxt);
        nxt = iter.next();
        assertEquals(55, nxt);
        nxt = iter.next();
        assertEquals(34, nxt);
        nxt = iter.next();
        assertEquals(89, nxt);
        nxt = iter.next();
        assertEquals(144, nxt);
        nxt = iter.next();
        assertEquals(21, nxt);
    }

    @Test
    void testSize() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(comparator);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        int size = queue.size();
        assertEquals(3, size);
    }

    @Test
    void testPeek() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(comparator);
        queue.offer(2);
        queue.offer(8);
        queue.offer(13);
        queue.offer(34);
        queue.offer(21);
        queue.offer(5);
        queue.offer(55);
        queue.offer(1);
        queue.offer(89);
        queue.offer(144);
        queue.offer(3);
        int higher = queue.peek();
        assertEquals(1, higher);
    }

    @Test
    void testPoll() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(comparator);
        queue.offer(2);
        queue.offer(8);
        queue.offer(13);
        queue.offer(34);
        queue.offer(21);
        queue.offer(5);
        queue.offer(55);
        queue.offer(1);
        queue.offer(89);
        queue.offer(144);
        queue.offer(3);
        int first = queue.poll();
        Iterator<Integer> iter = queue.iterator();
        iter.next();
        int iterFirst = iter.next();
        int iterSecond = iter.next();
        int iterThird = iter.next();
        assertEquals(1, first);
        assertEquals(2, iterFirst);
        assertEquals(3, iterSecond);
        assertEquals(5, iterThird);
    }
}
