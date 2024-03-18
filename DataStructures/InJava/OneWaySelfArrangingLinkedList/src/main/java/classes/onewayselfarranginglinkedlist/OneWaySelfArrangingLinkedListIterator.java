/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.onewayselfarranginglinkedlist;

import java.util.Iterator;

/**
 *
 * @author ManuelAlonso
 * @param <T>
 */
public class OneWaySelfArrangingLinkedListIterator<T> implements Iterator<T>{

    private OneWaySelfArrangingLinkedList currentList;
    private final Node<T> beginNode;
    private final  Node<T> lastNode; 
    private Node<T> currentNode;
    
    OneWaySelfArrangingLinkedListIterator(OneWaySelfArrangingLinkedList currentListP){
        
        this.currentList = currentListP;
        this.beginNode = currentListP.getHeadOfList();
        this.lastNode = currentListP.getEndOfList();
        this.currentNode = beginNode;
        
    }
    
    @Override
    public boolean hasNext() {

        return currentNode!=null;
        
    }

    @Override
    public T next() {
        
        T data = null;
        
        if(hasNext()){
        
            data = currentNode.getData();
            currentNode = currentNode.getNextNode();
        
        }
        
        return data;
        
    }
    
    public T current(){
        
        T data = null;
        
        if(hasNext()){
            
            data = currentNode.getData();
            
        } 
        
        return data;
        
    }
    
    @Override
    public void remove(){
        
        if(hasNext()){
        
            this.currentList.deleteByElement((Comparable) this.currentNode.getData());

            this.currentNode = this.currentNode.getNextNode();
        
        }
        
    }
        
    public void moveNext(){
        
        if(hasNext()){
            
            this.currentNode = this.currentNode.getNextNode();
            
        }
        
    } 
    
} //End of SelfArrangingLinkedListIterator.
