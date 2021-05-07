import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JavaSingleLinkedLIstAsQueue {
    @Test
    public void testEnqueueAndRemoveThreeElements() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals(Integer.valueOf(1),queue.remove());
        assertEquals(Integer.valueOf(2),queue.remove());
        assertEquals(Integer.valueOf(3),queue.remove());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyList_throwsException() {
        Queue<Integer> queue = new LinkedList<>();
        queue.remove();
    }

    @Test
    public void testPollFromEmptyList_throwsException() {
        Queue<Integer> queue = new LinkedList<>();
        assertNull(queue.poll());
    }
}
