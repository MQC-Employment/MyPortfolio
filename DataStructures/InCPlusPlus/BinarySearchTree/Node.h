#ifndef _NODE_
#define _NODE_

template<class T>
class Node{

    private:

    Node<T>* leftChildNode;
    Node<T>* rightChildNode;
    T data;

    public:

    Node(T dataP);
    ~Node();
    void setData(T dataP);
    T getData();
    void setLeftChild(Node<T>* leftChildNodeP);
    Node<T>* getLeftChild();
    void setRightChild(Node<T>* rightChildNodeP);
    Node<T>* getRightChild();
    
};

#include "NodeDef.cpp"

#endif