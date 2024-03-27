#ifndef _BINARYSEARCHTREE_
#define _BINARYSEARCHTREE_

#include <iostream>
#include "Node.h"
#include <string>

template<class T>
class BinarySearchTree{

    private:

    Node<T>* root;
    void recursiveInsert(Node<T>* currentNodeP, T newValueP);
    T recursiveRemove(Node<T>* currentNodeP, T valueToRemoveP, Node<T>* parentNodeOfCurrentNodeP);
    void inOrderRecursivePrint(Node<T>* currenNodeP);
    Node<T>* getSmallestNodeFromCurrentNode(Node<T>* currentNodeP);
    void recursiveCleartree(Node<T>* currentNodeP);

    public:

    BinarySearchTree();
    ~BinarySearchTree();
    bool isEmpty();
    void insert(T newValueP);
    T remove(T valueToRemoveP);
    void inOrderPrint();

};

#include "BinarySearchTreeDef.cpp"

#endif