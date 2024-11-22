/**
 * Class that implements priority queues.
 * @author Maike Anthony dos Santos Silva
 */
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
public class MyPriorityQueue<T> extends AbstractQueue<T> {
    /**The heap representation as an array. */
    private ArrayList<T> heap;
    /**The comparator responsible for checking if the items follow the min heap order property */
    private Comparator<T> comparator;

    /**
     * Constructor of the MyPriorityQueue class.
     * @param comparator responsible for checking if the items follow the min heap order property.
     */
    public MyPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = new ArrayList<>();
        this.heap.add(null);
    }

    /**
     * Getter method for the comparator.
     * @return the comparator instance variable.
     */
    public Comparator<T> getComparator() {
        return comparator;
    }

    /**
     * Method to get the iterator of the heap.
     * @return the iterator of the heap.
     */
    public Iterator<T> iterator() {
        return this.heap.iterator();
    }

    /**
     * Method to get the number of items inside the priority queue.
     * @return the number of items inside the heap instance variable, except for the first one, which is always null.
     */
    public int size() {
        return this.heap.size() - 1;
    }

    /**
     * Method to remove all the items from the priority queue.
     */
    public void clear() {
        this.heap.clear();
        this.heap.add(null);
    }

    /**
     * Helper method to get the index of the parent.
     * @param index index of the current item.
     * @return the index of the parent of the current item.
     */
    private int parent(int index) {
        return index / 2;
    }

    /**
     * Helper method to get the index of the left child.
     * @param index index of the current item.
     * @return the index of the left child of the current item.
     */
    private int leftChild(int index) {
        return index * 2;
    }

    /**
     * Helper method to get the index of the right child.
     * @param index index of the current item.
     * @return the index of the right child of the current item.
     */
    private int rightChild(int index) {
        return index * 2 + 1;
    }

    /**
     * Method to add items to the priority queue.
     * @param item the item to be added.
     * @return true after the item is added.
     */
    public boolean offer(T item) {
        this.heap.add(item);
        this.percolateUp(size());
        return true;
    }

    /**
     * Helper method to percolate items up.
     * @param index the index of the current item.
     */
    private void percolateUp(int index) {
        int parent = parent(index);
        if (parent == 0) {
            return;
        } else  if (this.comparator.compare(this.heap.get(index), this.heap.get(parent)) < 0) {
            T parentItem = this.heap.get(parent);
            T indexItem = this.heap.get(index);
            this.heap.remove(parent);
            this.heap.add(parent, indexItem);
            this.heap.remove(index);
            this.heap.add(index, parentItem);
            percolateUp(parent);
        }
    }

    /**
     * Method to see the item with the highest priority
     * @return the item with the highest priority
     */
    public T peek() {
        return this.heap.get(1);
    }

    /**
     * Method to retrieve the item with the highest priority
     * @return the item with the highest priority
     */
    public T poll() {
        if (this.size() == 0) {
            return null;
        } else if (this.size() == 1) {
            T minItem = this.peek();
            this.heap.remove(1);
            return minItem;
        } else {
            T minItem = this.peek();
            this.swap(1, this.size());
            this.heap.remove(this.size());
            this.percolateDown(1);
            return minItem;
        }
    }

    /**
     * Helper method to percolate items down to obey min-heap order property.
     * @param index the item to be percolated down.
     */
    private void percolateDown(int index) {
        Integer smallestChildIndex = this.findSmallestChildIndex(index);
        if (smallestChildIndex == null) {
            return;
        } else if (this.comparator.compare(this.heap.get(index), this.heap.get(smallestChildIndex)) <= 0) {
            return;
        } else {
            this.swap(index, smallestChildIndex);
            this.percolateDown(smallestChildIndex);
        }
    }

    /**
     * Helper method to find the index of the child with the smallest priority value (highest priority).
     * @param index index of the item to find the child of.
     * @return the index of the child with the highest priority.
     */
    private Integer findSmallestChildIndex(int index) {
        int leftchildindex = this.leftChild(index);
        int rightchildindex = this.rightChild(index);
        if (leftchildindex > this.size()) {
            return null;
        } else if (rightchildindex > this.size()) {
            return leftchildindex;
        } else if (this.comparator.compare(this.heap.get(leftchildindex), this.heap.get(rightchildindex)) <= 0) {
            return leftchildindex;
        } else {
            return rightchildindex;
        }
    }

    /**
     * Helper method to swap two items.
     * @param a index of the first item to be swapped.
     * @param b index of the second item to be swapped.
     */
    private void swap(int a, int b) {
        T itemA = this.heap.get(a);
        this.heap.add(a, this.heap.get(b));
        this.heap.remove(a+1);
        this.heap.add(b, itemA);
        this.heap.remove(b+1);
    }
}
