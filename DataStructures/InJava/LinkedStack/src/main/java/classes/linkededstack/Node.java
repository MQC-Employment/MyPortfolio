/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.linkededstack;

/**
 *
 * @author ManuelAlonso
 */
class Node<T> {
    
    private Node<T> previousNode;
    private T data;

    public Node(T data) {
        
        this.previousNode = null;
        this.data = data;
        
    }

    public Node<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
} //End of Node class.
