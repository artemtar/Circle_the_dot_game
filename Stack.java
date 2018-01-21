package game;


public interface Stack<E> {

    /**
     * Tests if this Stack is empty.
     */

    public abstract boolean isEmpty();

    /**
     * Returns a reference to the top element; does not change
     * the state of this Stack.
     */

    public abstract E peek() throws EmptyStackException;

    /**
     * Removes and returns the element at the top of this stack.
     */

    public abstract E pop() throws EmptyStackException;

    /**
     * Puts an element onto the top of this stack.
     */

    public abstract void push( E element );

}
