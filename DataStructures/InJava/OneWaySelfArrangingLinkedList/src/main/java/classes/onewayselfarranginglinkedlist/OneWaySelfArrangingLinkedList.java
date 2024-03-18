/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.onewayselfarranginglinkedlist;

import com.google.gson.Gson;

/**
 *
 * @author ManuelAlonso
 * @param <T>
 */
public class OneWaySelfArrangingLinkedList<T extends Comparable<T>> implements Iterable<T> {
    
    private Node<T> headOfList;
    private Node<T> endOfList;
    private boolean isDescendingOrder;
    private long numberOfElements;
    
    public OneWaySelfArrangingLinkedList(){
        
        this(false);
        
    } //End of constructor.
    
    public OneWaySelfArrangingLinkedList(boolean isDescendingOrderP){
        
        this.headOfList = null;
        this.endOfList = null;
        this.numberOfElements = 0;
        this.isDescendingOrder = isDescendingOrderP;
        
    } //End of constructor.
    
    public boolean isEmpty(){
        
        return this.headOfList==null && this.endOfList==null; //End of if.
        
    } //End of isEmpty.
    
    public void insert(T valueP){
          
        if(this.isDescendingOrder){
            
            insertDescendingOrder(valueP);
            
        } else{
   
            insertAscendingOrder(valueP);
            
        }
        
        this.numberOfElements++;
        
    } //End of insert.
    
    private void insertAscendingOrder(T valueP){
        
        Node<T> newNode = new Node<>(valueP);
        
        if(isEmpty()){
            
            this.headOfList = this.endOfList = newNode;
            
        } else{
            
            if(valueP.compareTo(this.headOfList.getData())<=0){

                newNode.setNextNode(this.headOfList);
                this.headOfList = newNode;              

            } else if(valueP.compareTo(this.endOfList.getData())>0){

                endOfList.setNextNode(newNode);
                this.endOfList = newNode;

            } else{

                Node<T> tempNode = this.headOfList;

                while(tempNode!=null && tempNode.getNextNode()!=null){

                    if(valueP.compareTo(tempNode.getNextNode().getData())<=0){

                        newNode.setNextNode(tempNode.getNextNode());
                        tempNode.setNextNode(newNode);

                        break;

                    } //End of if.
                    
                    tempNode = tempNode.getNextNode();

                } //End of while. 
                
                tempNode = null;

            } //End of else.
                
        } //End of else.
        
        newNode = null;
        
    } //insertAscendingOrder
    
    private void insertDescendingOrder(T valueP){
        
        Node<T> newNode = new Node<>(valueP);
        
        if(isEmpty()){
            
            this.headOfList = this.endOfList = newNode;
            
        } else{
            
            if(valueP.compareTo(this.headOfList.getData())>=0){

                newNode.setNextNode(this.headOfList);
                this.headOfList = newNode;              

            } else if(valueP.compareTo(this.endOfList.getData())<0){

                endOfList.setNextNode(newNode);
                this.endOfList = newNode;

            } else{

                Node<T> tempNode = this.headOfList;

                while(tempNode!=null && tempNode.getNextNode()!=null){

                    if(valueP.compareTo(tempNode.getNextNode().getData())>=0){

                        newNode.setNextNode(tempNode.getNextNode());
                        tempNode.setNextNode(newNode);

                        break;

                    } //End of if.
                    
                    tempNode = tempNode.getNextNode();

                } //End of while. 
                
                tempNode = null;

            } //End of else.
                
        } //End of else.  
        
        newNode = null;
        
    } //End of insertDescendingOrder.
    
    public T getElementAtIndex(long indexP){
        
        T data = null;
        
        if(indexP >= 0 && indexP < this.numberOfElements ){
            
            Node<T> tempNode = this.headOfList;
            long iterator = 0;
            
            while(iterator < this.numberOfElements){
                
                if(indexP==iterator){
                    
                    data = tempNode.getData();
                    break; 
                    
                }
                
                iterator++;
                tempNode = tempNode.getNextNode();
                
            }
            
        } 
        
        return data;
        
    } //End of getElementAtIndex.
    
    public T getByElement(T dataP){
        
        T data = null;
        
        if(!isEmpty()){
            
            Node<T> tempNode = this.headOfList;
            
            while(tempNode!=null){
                
                if(tempNode.getData().compareTo(dataP)==0){
                    
                    data = tempNode.getData();
                    break;
                    
                }
                
                tempNode = tempNode.getNextNode();
                
            } //End of while.
            
        } //End of if.
        
        return data;
        
    } //End of getByElement.
    
    public boolean contains(T dataP){
        
        boolean isInList = false;  
        
        if(!isEmpty()){
            
            Node<T> tempNode = this.headOfList;
            
            while(tempNode!=null){
                
                if(tempNode.getData().compareTo(dataP)==0){
                    
                    isInList = true;
                    break;
                    
                }
                
                tempNode = tempNode.getNextNode();
                
            } //End of while.
            
        } //End of if.
        
        return isInList;
        
    }
    
    public T deleteByIndex(long indexP){
        
        T data = null;
        
        if(!isEmpty() && indexP>=0 && indexP<this.numberOfElements){
        
            Node<T> nodeToDelete = null;
            
            if(this.headOfList==this.endOfList){
                                
                data = this.headOfList.getData();
                
                this.headOfList.setNextNode(null);
                this.headOfList.setData(null);
                this.endOfList.setNextNode(null);
                this.endOfList.setData(null);
                
                this.headOfList = this.endOfList = null;
                    
            } else if(indexP==0){
                
                data = this.headOfList.getData();
        
                nodeToDelete = this.headOfList;
                
                this.headOfList = this.headOfList.getNextNode();

            } else{
                
                Node<T> tempNode = this.headOfList;
                
                for (int iterator = 1; iterator < this.numberOfElements; iterator++) {
                    
                    if(iterator==indexP){
                    
                        nodeToDelete = tempNode.getNextNode();
                        data = nodeToDelete.getData();
                        break;
                        
                    } //End of if.
                    
                    tempNode = tempNode.getNextNode();
                    
                } //End of for.
                
                if(indexP==(this.numberOfElements-1)){
                    
                    this.endOfList = tempNode;
                    this.endOfList.setNextNode(null);
                    
                } else{
                
                    tempNode.setNextNode(tempNode.getNextNode().getNextNode());
                
                }
                
                tempNode = null;
                                
            }
            
            if(nodeToDelete != null){
                
                nodeToDelete.setNextNode(null);
                nodeToDelete.setData(null);
                nodeToDelete = null;
                
            }
 
            this.numberOfElements--;
            
        }
        
        return data;
        
    } //End of deleteElement.
    
    public T deleteByElement(T dataP){
        
        T data = null;
        
        if(!isEmpty()){
            
            Node<T> nodeToDelete = null;
            
            if(this.headOfList==this.endOfList){

                data = this.headOfList.getData();
                
                this.headOfList.setNextNode(null);
                this.headOfList.setData(null);
                this.endOfList.setNextNode(null);
                this.endOfList.setData(null);
                
                this.headOfList = this.endOfList = null;

            } else if(this.headOfList.getData().compareTo(dataP)==0){
                
                data = dataP;
                       
                nodeToDelete = this.headOfList;

                this.headOfList = this.headOfList.getNextNode();
                    
            } else{
                
                Node<T> tempNode = this.headOfList;
                
                while(tempNode!=this.endOfList){
                    
                    if(tempNode.getNextNode().getData().compareTo(dataP)==0){
                        
                        nodeToDelete = tempNode.getNextNode();
                        data = nodeToDelete.getData();
                        break;
                        
                    }
                    
                    tempNode = tempNode.getNextNode();
                    
                } //End of while.
                
                if(nodeToDelete != null){
                    
                    if(nodeToDelete==this.endOfList){
                        
                        this.endOfList = tempNode;
                        this.endOfList.setNextNode(null);
                        
                    } else{
                        
                        tempNode.setNextNode(tempNode.getNextNode().getNextNode());
                        
                    }
                    
                }
                
                tempNode = null;
                
            } //End of else.
            
            if(nodeToDelete!=null){
                
                nodeToDelete.setNextNode(null);
                nodeToDelete.setData(dataP);
                nodeToDelete = null;
            }
            
            this.numberOfElements--;
            
        } //End of if.
                
        return data;
        
    } //End of deleteByElement.
    
    public T updateElement(T updatedElement){
        
        T data = null;
        
        if(!isEmpty()){
            
            Node<T> tempNode = this.headOfList;
            
            while(tempNode!=null){
                
                if(tempNode.getData().compareTo(updatedElement)==0){
                    
                    tempNode.setData(updatedElement);
                    return tempNode.getData();
                    
                } //End if.
                
                tempNode = tempNode.getNextNode();
                
            } //End of while.
            
        } //End of if.
        
        return data;
        
    } //end of updateElement.

    public void printList(){
        
        if(!isEmpty()){
        
            Gson gson = new Gson();
            Node<T> tempNode = this.headOfList;
            String listString = "[";

            while (tempNode!=null) {            

                T data = tempNode.getData();
                
                if(tempNode.getNextNode()!=null){

                    listString += gson.toJson(data) + ", ";

                } else{

                    listString += gson.toJson(data);

                }

                tempNode = tempNode.getNextNode();

            }

            System.out.println(listString + "]");
        
        } else{
            
            System.out.println("Is empty.");
            
        }
        
    } //End of printList.

    Node<T> getHeadOfList() {
        return headOfList;
    }

    Node<T> getEndOfList() {
        return endOfList;
    }
    
    public long getNumberOfElements() {
        return numberOfElements;
    }
        
    @Override
    public String toString(){
        
        String listString = "";
        
        if(!isEmpty()){
        
            Gson gson = new Gson();
            Node<T> tempNode = this.headOfList;
            listString = "[";

            while (tempNode!=null) {       
                
                T data = tempNode.getData();

                if(tempNode.getNextNode()!=null){

                    listString += gson.toJson(data) + ", ";

                } else{

                    listString += gson.toJson(data);

                }

                tempNode = tempNode.getNextNode();

            }
            
            listString += "]";

        } else{
            
            System.out.println("Is empty.");
            
        } 
        
        return listString;
        
    } //End of toString.
    
    @Override
    public OneWaySelfArrangingLinkedListIterator<T> iterator() {
        
        return new OneWaySelfArrangingLinkedListIterator(this);
        
    }
    
} //End of class. 
