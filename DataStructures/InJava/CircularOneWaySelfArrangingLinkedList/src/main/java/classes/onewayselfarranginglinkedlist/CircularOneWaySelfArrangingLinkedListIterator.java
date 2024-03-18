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
public class CircularOneWaySelfArrangingLinkedListIterator<T> implements Iterator<T>{

    private CircularOneWaySelfArrangingLinkedList currentList;
    private Node<T> beginNode;
    private Node<T> endNode;
    private Node<T> currentNode;
    
    CircularOneWaySelfArrangingLinkedListIterator(CircularOneWaySelfArrangingLinkedList currentListP){
        
        this.currentList = currentListP;
        this.beginNode = currentListP.getHeadOfList();
        this.endNode = currentListP.getEndOfList();
        this.currentNode = beginNode;
        
    }

    @Override
    public boolean hasNext() {
                
        return this.currentNode != null;

    }

    @Override
    public T next() {
        
        T data = null;
        
        if(hasNext()){
        
            data = this.currentNode.getData();
            this.currentNode = this.currentNode.getNextNode();
            
            if(this.currentNode==this.beginNode){
                
                this.currentNode = null;
                
            }
        
        }
        
        return data;
        
    }
    
    @Override
    public void remove(){
        
        if(!this.currentList.isEmpty()){
        
            currentList.deleteByElement((Comparable) this.currentNode.getData());

            this.currentNode = currentList.getHeadOfList();      
        
        }
        
    }
        
    public T current(){
        
        T data = null;
        
        if(hasNext()){
            
            data = this.currentNode.getData();            
            
        }
        
        return data;
        
    }
    
     public void moveCircularNext(){
        
        if(!this.currentList.isEmpty()){
            
            if(this.currentNode!=null){
            
                this.currentNode = this.currentNode.getNextNode();
            
            } else{
                
                this.currentNode = this.currentList.getHeadOfList();
                
            }
            
        }
        
    }
    
} //End of SelfArrangingLinkedListIterator.
