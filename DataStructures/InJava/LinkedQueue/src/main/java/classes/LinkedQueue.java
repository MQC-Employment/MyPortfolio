/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author ManuelAlonso
 */
public class LinkedQueue<T> {
    
    private Node<T> headOfQueue;
    private Node<T> backOfQueue;

    public LinkedQueue() {
        
        this.headOfQueue = null;
        this.backOfQueue = null;
        
    } //End of constructor. 
    
    public boolean isEmpty(){
        
        return this.headOfQueue == null;

    } //End.
    
    public void queue(T dataP){
        
        Node<T> newNode = new Node(dataP);
        
        if(isEmpty()){
            
            this.headOfQueue = this.backOfQueue = newNode;
            
        } else{
            
            this.backOfQueue.setPreviousNode(newNode);
            this.backOfQueue = newNode;
            
        }
        
        newNode = null;
        
    }
    
    public T unqueue(){
        
        T data = null;
        
        if(!isEmpty()){
            
            Node<T> nodeToDelete = this.headOfQueue;
            
            data = nodeToDelete.getData();
            
            this.headOfQueue = this.headOfQueue.getPreviousNode();
            
            nodeToDelete.setPreviousNode(null);
            nodeToDelete.setData(null);
            nodeToDelete = null;
            
        }
        
        return data;
        
    } //End of unqueue.
    
} //End of LinkedQueue. 