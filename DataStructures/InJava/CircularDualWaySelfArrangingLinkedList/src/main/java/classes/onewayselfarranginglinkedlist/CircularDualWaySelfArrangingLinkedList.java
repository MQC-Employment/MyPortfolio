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
public class CircularDualWaySelfArrangingLinkedList<T extends Comparable<T>> implements Iterable<T> {
    
    private Node<T> headOfList;
    private Node<T> endOfList;
    private boolean isDescendingOrder;
    private long numberOfElements;   
    
    public CircularDualWaySelfArrangingLinkedList(){
        
        this(false);
        
    } //End of constructor.
    
    public CircularDualWaySelfArrangingLinkedList(boolean isDescendingOrderP){
        
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
            this.headOfList.setNextNode(this.endOfList);
            this.headOfList.setPreviousNode(this.endOfList);            
            this.endOfList.setNextNode(this.headOfList);
            this.endOfList.setPreviousNode(this.headOfList);
            
        } else{
            
            if(valueP.compareTo(this.headOfList.getData())<=0){

                newNode.setNextNode(this.headOfList);
                this.headOfList.setPreviousNode(newNode);                
                this.headOfList = newNode;
                this.headOfList.setPreviousNode(this.endOfList);        
                this.endOfList.setNextNode(this.headOfList);

            } else if(valueP.compareTo(this.endOfList.getData())>0){
                
                this.endOfList.setNextNode(newNode);
                newNode.setPreviousNode(this.endOfList);
                this.endOfList = newNode;
                this.endOfList.setNextNode(this.headOfList);
                this.headOfList.setPreviousNode(this.endOfList);
                
            } else{

                Node<T> tempNode = this.headOfList;

                while(tempNode!=null && tempNode.getNextNode()!=null){

                    if(valueP.compareTo(tempNode.getNextNode().getData())<=0){

                        newNode.setNextNode(tempNode.getNextNode());
                        newNode.setPreviousNode(tempNode);
                        tempNode.getNextNode().setPreviousNode(newNode);
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
            this.headOfList.setNextNode(this.endOfList);
            this.headOfList.setPreviousNode(this.endOfList);            
            this.endOfList.setNextNode(this.headOfList);
            this.endOfList.setPreviousNode(this.headOfList);
            
        } else{
            
            if(valueP.compareTo(this.headOfList.getData())>=0){

                newNode.setNextNode(this.headOfList);
                this.headOfList.setPreviousNode(newNode);                
                this.headOfList = newNode;
                this.headOfList.setPreviousNode(this.endOfList);        
                this.endOfList.setNextNode(this.headOfList);

            } else if(valueP.compareTo(this.endOfList.getData())<0){

                newNode.setPreviousNode(this.endOfList);
                this.endOfList.setNextNode(newNode);
                this.endOfList = newNode;
                this.endOfList.setNextNode(this.headOfList);
                this.headOfList.setPreviousNode(this.endOfList);

            } else{

                Node<T> tempNode = this.headOfList;

                while(tempNode!=null && tempNode.getNextNode()!=null){

                    if(valueP.compareTo(tempNode.getNextNode().getData())>=0){

                        newNode.setNextNode(tempNode.getNextNode());
                        newNode.setPreviousNode(tempNode);
                        tempNode.getNextNode().setPreviousNode(newNode);
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
            
            while(true){
                
                if(tempNode.getData().compareTo(dataP)==0){
                    
                    data = tempNode.getData();
                    break;
                    
                }
                
                tempNode = tempNode.getNextNode();
                
                if(tempNode==this.headOfList){
                    
                    break;
                    
                }
                
            } //End of while.
            
        } //End of if.
        
        return data;
        
    } //End of getByElement.
    
    public boolean contains(T dataP){
        
        boolean isInList = false;  
        
        if(!isEmpty()){
            
            Node<T> tempNode = this.headOfList;
            
            while(true){
                
                if(tempNode.getData().compareTo(dataP)==0){
                    
                    isInList = true;
                    break;
                    
                }
                
                tempNode = tempNode.getNextNode();
                
                if(tempNode==this.headOfList){
                    
                    break;
                    
                }
                
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
                this.headOfList.setPreviousNode(null);
                this.headOfList.setData(null);
                
                this.endOfList.setNextNode(null);
                this.endOfList.setPreviousNode(null);
                this.endOfList.setData(null);
                
                this.headOfList = this.endOfList = null;
                    
            } else if (indexP==0){
                
                data = this.headOfList.getData();
                    
                nodeToDelete = this.headOfList;

                this.headOfList = this.headOfList.getNextNode();
                this.headOfList.setPreviousNode(this.endOfList);                    
                this.endOfList.setNextNode(this.headOfList);

            } else if(indexP==(this.numberOfElements-1)){
                
                data = this.endOfList.getData();
                
                nodeToDelete = this.endOfList;
                
                this.endOfList = this.endOfList.getPreviousNode();
                this.endOfList.setNextNode(this.headOfList);
                this.headOfList.setPreviousNode(this.endOfList);
                
            } else {
                
                Node<T> tempNode = this.headOfList;
                
                for (int iterator = 1; iterator < this.numberOfElements; iterator++) {
                    
                    if(iterator==indexP){
                    
                        nodeToDelete = tempNode.getNextNode();
                        data = nodeToDelete.getData();
                        break;
                        
                    } //End of if.
                    
                    tempNode = tempNode.getNextNode();
                    
                } //End of for.
                
                tempNode.setNextNode(tempNode.getNextNode().getNextNode());
                tempNode.getNextNode().getNextNode().setPreviousNode(tempNode);
                
                tempNode = null;
                                
            }
            
            if(nodeToDelete!=null){
            
                nodeToDelete.setNextNode(null);   
                nodeToDelete.setPreviousNode(null);
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

                data = headOfList.getData();
                
                this.headOfList.setNextNode(null);
                this.headOfList.setPreviousNode(null);
                this.headOfList.setData(null);
                
                this.endOfList.setNextNode(null);
                this.endOfList.setPreviousNode(null);
                this.endOfList.setData(null);
                
                this.headOfList = this.endOfList = null;

            } else if (this.headOfList.getData().compareTo(dataP)==0){
                
                data = this.headOfList.getData();
               
                nodeToDelete = this.headOfList;

                this.headOfList = this.headOfList.getNextNode();
                this.headOfList.setPreviousNode(this.endOfList);               
                this.endOfList.setNextNode(this.headOfList);                
                
            } else if(this.endOfList.getData().compareTo(dataP)==0){
                
                data = this.endOfList.getData();
                
                nodeToDelete = this.endOfList;
                
                this.endOfList = this.endOfList.getPreviousNode();
                this.endOfList.setNextNode(this.headOfList);
                this.headOfList.setPreviousNode(this.endOfList);                
                
            } else {
                
                Node<T> tempNode = this.headOfList;
                
                while(true){
                    
                    if(tempNode.getNextNode().getData().compareTo(dataP)==0){
                        
                        nodeToDelete = tempNode.getNextNode();
                        data = nodeToDelete.getData();
                        break;
                        
                    }
                    
                    tempNode = tempNode.getNextNode();
                    
                    if(tempNode==this.headOfList){
                        
                        break;
                        
                    }
                    
                } //End of while.
                
                if(nodeToDelete != null){
                    
                    tempNode.setNextNode(tempNode.getNextNode().getNextNode());
                    tempNode.getNextNode().getNextNode().setPreviousNode(tempNode);
                                        
                }
                
                tempNode = null;
                
            } //End of else.
            
            if(nodeToDelete!=null){
            
                nodeToDelete.setNextNode(null);
                nodeToDelete.setPreviousNode(null);
                nodeToDelete.setData(null);
            
            }
            
            this.numberOfElements--;

        } //End of if.

        return data;
        
    } //End of deleteByElement.
    
    public T updateElement(T updatedElement){
        
        T data = null;
        
        if(!isEmpty()){
            
            Node<T> tempNode = this.headOfList;
            
            while(true){
                
                if(tempNode.getData().compareTo(updatedElement)==0){
                    
                    tempNode.setData(updatedElement);
                    return tempNode.getData();
                    
                } //End if.
                
                tempNode = tempNode.getNextNode();
                
                if(tempNode==this.headOfList){
                    
                    break;
                    
                }
                
            } //End of while.
            
        } //End of if.
        
        return data;
        
    } //end of updateElement.
    
    public void printList(){
        
        String listString = "";
        
        if(!isEmpty()){
        
            Gson gson = new Gson();
            Node<T> tempNode = this.headOfList;
            listString = "[";

            while (true) {            

                T data = tempNode.getData();
                
                if(tempNode.getNextNode()!=this.headOfList){

                    listString += gson.toJson(data) + ", ";

                } else{

                    listString += gson.toJson(data);
                    break;

                }

                tempNode = tempNode.getNextNode();

            }
            
            listString += "]";
            
            System.out.println(listString);

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

            while (true) {            

                T data = tempNode.getData();
                
                if(tempNode.getNextNode()!=this.headOfList){

                    listString += gson.toJson(data) + ", ";

                } else{

                    listString += gson.toJson(data);
                    break;

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
    public CircularDualWaySelfArrangingLinkedListIterator<T> iterator() {
            
        CircularDualWaySelfArrangingLinkedListIterator listIterator = new CircularDualWaySelfArrangingLinkedListIterator(this);
        
        return listIterator;
        
    }    
    
} //End of class. 