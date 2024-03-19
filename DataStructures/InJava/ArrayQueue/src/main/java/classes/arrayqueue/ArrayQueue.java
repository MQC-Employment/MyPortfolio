/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.arrayqueue;

/**
 *
 * @author ManuelAlonso
 */
public class ArrayQueue<T> {
    
    private T[] internalArray;
    private int numberOfelements;
    
    public ArrayQueue(){
        
        this.internalArray = (T[]) new Object[10];
        this.numberOfelements = 0;
        
    } //end of constructor.
    
    public boolean isEmpty(){
        
        return this.numberOfelements == 0;
        
    } //End of isEmpty.
    
    public void queue(T dataP){
        
        if(this.numberOfelements >= this.internalArray.length){
            
            reSizeArray();
            
        } 
        
        this.internalArray[this.numberOfelements] = dataP;
        this.numberOfelements++;
        
    } //End of queue.
    
    public T unqueue(){
        
        T data =  null;
        
        if(!isEmpty()){
            
            data = this.internalArray[0];
            this.numberOfelements--;
            
            reArrangeArray();
            
        } //End of if.
        
        return data;
        
    } //End of unqueue.
    
    private void reSizeArray(){
        
        int newArraySize = this.internalArray.length + 10;
        
        T[] tempNewArray = (T[]) new Object[newArraySize];
        
        for (int iterator = 0; iterator < this.internalArray.length; iterator++) {
            
            tempNewArray[iterator] = this.internalArray[iterator];
            
        }
        
        this.internalArray = null;
        this.internalArray = tempNewArray;
        
    } //End of reSizeArray.
    
    public void reArrangeArray(){
        
        for (int iterator = 0; iterator < this.numberOfelements; iterator++) {
            
            this.internalArray[iterator] = this.internalArray[iterator+1];
            
        } //End of for loop.
        
    } //End of reArrangeArray.
    
    public T peekFront(){
        
        if(!isEmpty()){
            
            return this.internalArray[0];
            
        } 
        
        return null;
        
    } //End of peekFront.
    
    public T peekBack(){
        
        if(!isEmpty()){
            
            return this.internalArray[this.numberOfelements-1];
            
        } 
        
        return null;
        
    } //end of peekBack.
    
} //End of class.