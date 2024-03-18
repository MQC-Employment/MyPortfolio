/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.linkededstack;
import classes.linkededstack.Node;

/**
 *
 * @author ManuelAlonso
 */
public class LinkedStack<T> {
 
    private Node<T> top;
    private long numberOfElements;

    public LinkedStack() {
        
        this.top = null;
        
    } //End of constructor.
    
    public boolean isEmpty(){
        
        return this.top == null;
        
    } //End of isEmpty.
    
    public void pushIn(T dataP){
        
        Node<T> newNode = new Node<>(dataP);
        
        if(isEmpty()){
            
            this.top = newNode;
            
        } else{
            
            newNode.setPreviousNode(this.top);
            this.top = newNode;
            
        }
        
        newNode = null;
        this.numberOfElements++;
        
    } //End of pushIn.
    
    public T peekTop(){

        if(!isEmpty()){
            
            return this.top.getData();
            
        }
        
        return null;
        
    } //End of peekTop.
    
    public T pop(){
        
        T data = null;
        
        if(!isEmpty()){
            
            Node<T> nodeToDelete = this.top;
            
            data = nodeToDelete.getData();
            
            this.top = this.top.getPreviousNode();
            
            nodeToDelete.setPreviousNode(null);
            nodeToDelete.setData(null);
            nodeToDelete = null;
            
            this.numberOfElements--;
            
            return data;
            
        }
        
        return data;
        
    } //End of pop.

    public long getNumberOfElements() {
        return numberOfElements;
    }
    
    
} //End of LinkedStack class.
