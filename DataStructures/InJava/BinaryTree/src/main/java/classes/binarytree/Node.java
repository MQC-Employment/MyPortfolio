/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.binarytree;

/**
 *
 * @author ManuelAlonso
 */
class Node<T>{
    
    private Node<T> leftNode;
    private Node<T> rightNode;
    private T data;

    public Node(T data) {
        
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
        
    } //End of constructor. 

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
        
} //end of class.