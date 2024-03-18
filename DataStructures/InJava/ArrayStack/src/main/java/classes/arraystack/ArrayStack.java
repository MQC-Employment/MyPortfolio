/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.arraystack;

/**
 *
 * @author ManuelAlonso
 */
public class ArrayStack<T> {
    
    private T[] internalArray;
    private int numberOfElements;
    
    public ArrayStack(int sizeP){
        
        this.internalArray = (T[]) new Object[sizeP];
        this.numberOfElements = 0;
        
    }
    
    public ArrayStack(){
        
        this(10);
        
    }
    
    public boolean isEmpty(){
        
        return this.numberOfElements == 0;
        
    }
    
    public void pushIn(T dataP){
        
        if(this.numberOfElements>=this.internalArray.length){
            
            reSizeArray();           
            
        }
        
        this.internalArray[this.numberOfElements] = dataP;
            
        this.numberOfElements++;
        
    } //
    
    public T pop(){
        
        T data = null;
        
        if(!isEmpty()){
            
            data = this.internalArray[this.numberOfElements-1];
            this.internalArray[this.numberOfElements-1] = null;
            this.numberOfElements--;
            
        }
        
        return data;
        
    } //End of pop.
    
    private T peekTop(){
        
        if(!isEmpty()){
            
            return this.internalArray[this.numberOfElements-1];
            
        }
        
        return null;
        
    } //end of peekTop.
    
    private void reSizeArray(){
        
        int newLength = this.internalArray.length + 10;
        
        T[] temporalNewArray = (T[]) new Object[newLength];
        
        for (int iterator = 0; iterator < this.internalArray.length; iterator++) {
            
            temporalNewArray[iterator] = this.internalArray[iterator];
            
        }
        
        for (int iterator = 0; iterator < this.internalArray.length; iterator++) {
            
            this.internalArray[iterator] = null;
            
        }
        
        this.internalArray = null;
        this.internalArray = temporalNewArray;
        temporalNewArray = null;
        
    } //End of reSizeArray.
    
} //end of class. 
