/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.binarytree;

/**
 *
 * The BinaryTree class. It requires an oject that implements the "Comparable" interface.
 * All java types support this interface. If a custom class is desired, such custom class must implement the "Comparable" interface.
 * 
 * @author ManuelAlonso
 * @param <T> The comparable data to insert. 
 */
public class BinaryTree<T extends Comparable<T>> {
    
    private Node<T> root;
    
    public BinaryTree(){
        
        this.root = null;
        
    } //end of constructor.
    
    /**
     *  Verifies whether the tree is empty.
     * 
     * @return 
     * "True" if the tree is empty, else "false". 
     */
    public boolean isEmpty(){
        
        return this.root == null;
        
    } //End of isEmpty.
    
    /**
     * 
     * Inserts new data to the tree. Data must implement "CompareTo<T>" interface. 
     * Note: Java data types support this by default. Custom class must implement such interface.
     * 
     * @param dataP The new data to inasert.
     */
    public void insert(T dataP){
        
        if(isEmpty()){
            
            this.root = new Node<>(dataP);
            
        } else{
            
            recursiveInsert(this.root, dataP);
            
        } //End of else.
        
    } //End of insert.
    
    /**
     * 
     * Recuursive method for the insertion of data to the tree.
     * 
     * @param currentNodeP The starting node where the tree will start the valuation of the new data. By default, it should be the root of the tree.
     * @param newValueP The new data to insert. Must extend from "CompareTo<T>" interface.
     */
    private void recursiveInsert(Node<T> currentNodeP, T newValueP){
        
        if(newValueP.compareTo(currentNodeP.getData()) <= 0){
            
            if(currentNodeP.getLeftNode() == null){
                
                Node<T> newNode = new Node<>(newValueP);
                
                currentNodeP.setLeftNode(newNode);
                
            } else{
                
                recursiveInsert(currentNodeP.getLeftNode(), newValueP);
                
            }
            
        } else{
            
            if(currentNodeP.getRightNode()== null){
                
                Node<T> newNode = new Node<>(newValueP);
                
                currentNodeP.setRightNode(newNode);
                
            } else{
                
                recursiveInsert(currentNodeP.getRightNode(), newValueP);
                
            }            
            
        } //End of else. 
        
    } //End of recursiveInsert.
    
    /**
     * 
     * Performs a binary search for the desired element. If the element is found, it's returned; else, it will return null.
     * 
     * @param dataP The data to search in the tree.
     * @return The desired element if it is present in the tree; else, it will return null.
     */
    public T search(T dataP){

        return recursiveSearch(this.root, dataP);
        
    } //End of search.
    
    
    /**
     * 
     * The recursive method for the binary search. 
     * 
     * @param currentNodeP The starting point node for the search. Usually, it's the root of the tree. 
     * @param elementToSearch The element to be searched on the tree.
     * @return The desired element if it is present in the tree; else, it will return null. 
     */
    private T recursiveSearch(Node<T> currentNodeP ,T elementToSearch){
        
        if(currentNodeP!=null){
            
            if(elementToSearch.compareTo(currentNodeP.getData())==0){
            
                return currentNodeP.getData();
            
            } else if(elementToSearch.compareTo(currentNodeP.getData()) < 0){
                
                return recursiveSearch(currentNodeP.getLeftNode(), elementToSearch);
                
            } else{
                
                return recursiveSearch(currentNodeP.getRightNode(), elementToSearch);
                
            }
                        
        } //End of if.   
        
        return null;

    } //End of recursiveSearch.
    
    /**
     * 
     * Removes the desired element from the tree.
     * 
     * @param elementToRemoveP The element to be removed from the tree.
     * @return The removed element if found; else, it will retur null.
     */
    public T remove(T elementToRemoveP){
        
        T data = null;
        
        if(!isEmpty()){
            
            if(this.root.getData().compareTo(elementToRemoveP)== 0 &&
                    this.root.getLeftNode()==null && this.root.getRightNode()==null){
                
                data = this.root.getData();
                
                this.root.setRightNode(null);
                this.root.setLeftNode(null);
                this.root.setData(null);
                this.root = null;
                
                return data;
                
            } 
                
            return removeRecursively(this.root, elementToRemoveP);
                
        } else{
            
            return null;
            
        }
        
    } //End of remove.
    
    
    /**
     * 
     * The recursive method for removal of nodes. 
     * 
     * @param currentNodeP The node where the removal method should start at. 
     * @param valueToDeleteP The value to be removed. 
     * @return The re moved valued if found; else, null.
     */    
    private T removeRecursively(Node<T> currentNodeP, T valueToDeleteP){
        
        if(currentNodeP!=null){
            
            if(valueToDeleteP.compareTo(currentNodeP.getData())<0){
                
                return removeRecursively(currentNodeP.getLeftNode(), valueToDeleteP);
                
            } else if(valueToDeleteP.compareTo(currentNodeP.getData())>0){
                
                return removeRecursively(currentNodeP.getRightNode(), valueToDeleteP);
                
            } else{
                
                T data = currentNodeP.getData();
                
                if(currentNodeP.getLeftNode()!=null && currentNodeP.getRightNode()!=null){
                                     
                    Node<T> smallestNodeOnTheRight = findSmallestNode(currentNodeP.getRightNode());
                    
                    currentNodeP.setData(smallestNodeOnTheRight.getData());
                    
                    removeRecursively(currentNodeP.getRightNode(), smallestNodeOnTheRight.getData());
                    
                    smallestNodeOnTheRight = null;
                    
                } else if(currentNodeP.getLeftNode()!=null || currentNodeP.getRightNode()!=null){
                    
                    if(currentNodeP.getLeftNode()!=null){
                        
                        currentNodeP.setData(currentNodeP.getLeftNode().getData());
                        
                        removeRecursively(currentNodeP.getLeftNode(), currentNodeP.getLeftNode().getData());
                        
                    } else{
                        
                        currentNodeP.setData(currentNodeP.getRightNode().getData());
                        
                        removeRecursively(currentNodeP.getRightNode(), currentNodeP.getRightNode().getData());                        
                        
                    }
                                        
                } else {
                    
                    Node<T> parentNode = findParentNode(currentNodeP);
                    
                    if(currentNodeP==parentNode.getLeftNode()){
                        
                        parentNode.setLeftNode(null);
                        
                    } else{
                        
                        parentNode.setRightNode(null);
                        
                    }
                    
                    currentNodeP.setLeftNode(null);
                    currentNodeP.setRightNode(null);
                    currentNodeP.setData(null);
                    
                    parentNode = null;
      
                } //End of else.
                               
                return data;
                               
            } //End of else.
            
        } //End of if.
        
        return null;
        
    } //End of removeRecursively.
    
    /**
     * 
     * Return the smallest value in the tree.
     * 
     * @return The smallest value in the tree; null if the tree is empty. 
     */
    public T smallestValue(){
        
         if(!isEmpty()){
             
             return findSmallestNode(this.root).getData();
             
         }
         
         return null;
        
    }
    
    /**
     * 
     * Obtains the node which contains the smallest value from a starting point. 
     * 
     * @param startingNodeToSearch The node where the search should start looking for the smallest value. 
     * @return The node that contains the smallest value from a specific starting point; itself if no smaller value was found from such specific starting point.
     */
    private Node<T> findSmallestNode(Node<T> startingNodeToSearch){
        
        if(startingNodeToSearch!=null && startingNodeToSearch.getLeftNode()!=null){
            
            return findSmallestNode(startingNodeToSearch.getLeftNode());
            
        }
        
        return startingNodeToSearch;
        
    } //End of findSmallestNode.
    
    /**
     * 
     * Finds the parent node of the current child node given. For instance: 
     * if the node with the value 20 is the parent node for node that contains 14, then it returns such parent node that contains such 20 value.
     * 
     * @param currentChildNodeP The child node to find its parent.
     * @return The parent node of the given child node. If no parent node was found, it returns null.
     */
    private Node<T> findParentNode(Node<T> currentChildNodeP){
        
        return findParentNodeRecursive(this.root, currentChildNodeP);
        
    }
    
    /**
     * 
     * The recursive method to find the parent node of a certain given child node.
     * 
     * @param currentNodeP The root node to start the search.
     * @param currentChildNodeP The child node to find its parent.
     * @return The parent node of the given child node; null if such child node got no parent. In example, the root of the tree.
     */
    private Node<T> findParentNodeRecursive(Node<T> currentNodeP, Node<T> currentChildNodeP){
        
        if(currentNodeP!=null){
            
            if((currentNodeP.getLeftNode()!=null && currentNodeP.getLeftNode()==currentChildNodeP) ||
                    (currentNodeP.getRightNode()!=null && currentNodeP.getRightNode()==currentChildNodeP)){
    
                return currentNodeP;
                
            } else if(currentNodeP.getLeftNode()!=null && currentChildNodeP.getData().compareTo(currentNodeP.getData())<0){
                
                return findParentNodeRecursive(currentNodeP.getLeftNode(), currentChildNodeP);
                
            } else {
                
                return findParentNodeRecursive(currentNodeP.getRightNode(), currentChildNodeP);
                
            } 
      
        } //End of if.
        
        return null;
        
    } //End of findParentNode.
    
    /**
     * 
     * Returns a string of the tree in inorder.
     * 
     * @return The tring in its inorder form.
     */
    public String inOrderString(){
        
        StringBuilder treeString = new StringBuilder("");
        
        if(!isEmpty()){
            
            inOrderRecursion(this.root, treeString);
            
            return treeString.toString().trim();
            
        } else{
            
            return "Tree is empty.";
            
        }
        
    } //End of inOrderString.
    
    /**
     * 
     * Covers the entire tree in an inorder path. 
     * 
     * @param currentNodeP The node to start the inorder path.
     * @param currentTreeStringP  The string the represents the tree itself.
     */
    private void inOrderRecursion(Node<T> currentNodeP, StringBuilder currentTreeStringP){
        
        if(currentNodeP != null){
            
            inOrderRecursion(currentNodeP.getLeftNode(), currentTreeStringP);
            currentTreeStringP.append(" ").append(currentNodeP.getData());
            inOrderRecursion(currentNodeP.getRightNode(), currentTreeStringP);
            
        }
        
    } //End of inOrderrecursion.
     
    /**
     * 
     * Returns a string of the tree in preorder.
     * 
     * @return The tring in its preorder form.
     */
    public String preOrderString(){
        
        StringBuilder treeString = new StringBuilder("");
        
        if(!isEmpty()){
            
            preOrderRecursion(this.root, treeString);
            
            return treeString.toString().trim();
            
        } else{
            
            return "Tree is empty.";
            
        }
        
    } //End of inOrderString.
    
    
    /**
     * 
     * Covers the entire tree in an preorder path. 
     * 
     * @param currentNodeP The node to start the preorder path.
     * @param currentTreeStringP  The string the represents the tree itself.
     */
    private void preOrderRecursion(Node<T> currentNodeP, StringBuilder currentTreeStringP){
        
        if(currentNodeP != null){
            
            currentTreeStringP.append(" ").append(currentNodeP.getData());
            preOrderRecursion(currentNodeP.getLeftNode(), currentTreeStringP);            
            preOrderRecursion(currentNodeP.getRightNode(), currentTreeStringP);
            
        }
        
    } //End of inOrderrecursion.
    
    
    /**
     * 
     * Returns a string of the tree in postorder.
     * 
     * @return The tring in its postorder form.
     */
    public String postOrderString(){
        
        StringBuilder treeString = new StringBuilder("");
        
        if(!isEmpty()){
            
            postOrderRecursion(this.root, treeString);
            
            return treeString.toString().trim();
            
        } else{
            
            return "Tree is empty.";
            
        }
        
    } //End of inOrderString.
    
    
    /**
     * 
     * Covers the entire tree in an postorder path. 
     * 
     * @param currentNodeP The node to start the postorder path.
     * @param currentTreeStringP  The string the represents the tree itself.
     */
    private void postOrderRecursion(Node<T> currentNodeP, StringBuilder currentTreeStringP){
        
        if(currentNodeP != null){
            
            postOrderRecursion(currentNodeP.getLeftNode(), currentTreeStringP);
            postOrderRecursion(currentNodeP.getRightNode(), currentTreeStringP);
            currentTreeStringP.append(" ").append(currentNodeP.getData());
            
        }
        
    } //End of inOrderrecursion.
    
} //end of class. 