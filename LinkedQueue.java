package game;

public class LinkedQueue<E> implements Queue<E> {

    private static class Elem<T> {

        private T value;
        private Elem<T> next;

        private Elem( T value, Elem<T> next ) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> front;
    private Elem<E> rear;

    public E peek() throws LinkedQueueException {
    	
    
    if(isEmpty()){
    		
    		throw new LinkedQueueException();
    		
    	}else{
        return front.value;}
    }

    public void enqueue( E o ) {
    	
    	try{
        Elem<E> newElem = null;        
        newElem = new Elem<E>( o, null );
        if ( rear == null ) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
        }catch(NullPointerException e1){
        	System.out.println("Action cannot be perforemed");
        }

    }

    public E dequeue() throws LinkedQueueException {
    	
if(isEmpty()){
    		
    		throw new LinkedQueueException();
    		
    	}else{
        E result = front.value;
        if ( front != null & front.next == null ) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return result;
    	}
    }

    public boolean isEmpty() {
        return front == null;
    }

}
