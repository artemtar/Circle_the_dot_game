package game;

import java.awt.event.ActionListener;
import java.io.Serializable;

public class LinkedStack<E> implements Stack<E>{

    private static class Elem<T>{
    	
        private T info;
        private Elem<T> next;
        private Elem( T info, Elem<T> next) {
            this.info = info;
            this.next = next;            
            
        }
    }

    private Elem<E> top; // instance variable

    public LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push( E info ) {
    	
    	try{
    		top = new Elem<E>( info, top );
    	}catch(NullPointerException e){
    		
    		System.out.println("Action cannot be perforemed");
    		
    	}
    }
    
	public E peek() throws EmptyStackException {
        
    	if(isEmpty()){
    		
    		throw new EmptyStackException();
    		
    	}else{
		return top.info;
    	}
    }

    public E pop() throws EmptyStackException {
    	
    	if(isEmpty()){
    		
    		throw new EmptyStackException();
    		
    	}else{
    	E savedInfo = top.info;
        GameModel g = (GameModel)top.info;
        Elem<E> oldTop = top;
        Elem<E> newTop = top.next;

        top = newTop;

        oldTop.info = null; // scrubbing the memory
        oldTop.next = null; // scrubbing the memory
        return savedInfo;
    	}
    }
}
