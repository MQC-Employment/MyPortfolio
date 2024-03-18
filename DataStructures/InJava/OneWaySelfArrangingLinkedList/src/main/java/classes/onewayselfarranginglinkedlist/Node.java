/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.onewayselfarranginglinkedlist;


/**
 *
 * @author ManuelAlonso
 */
class Node<T> {
    
    private Node<T> nextNode;
    private T data;

    public Node(T dataP) {
        
        this.nextNode = null;
        this.data = dataP;
        
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNodeP) {
        this.nextNode = nextNodeP;
    }

    public T getData() {
        return data;
    }

    public void setData(T dataP) {
        this.data = dataP;
    }
    
}
