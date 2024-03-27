#ifndef _NodeDef_
#define _NodeDef_

#include "Node.h"

template<class T>
Node<T>::Node(T dataP){

    this->data = dataP;
    this->leftChildNode = nullptr;
    this->rightChildNode = nullptr;

}

template<class T>
Node<T>::~Node(){

    this->data = T();
    this->leftChildNode = nullptr;
    this->rightChildNode = nullptr;

}

template<class T>
void Node<T>::setData(T dataP){

    this->data = dataP;

}

template<class T>
T Node<T>::getData(){

    return this->data;

}

template<class T>
void Node<T>::setLeftChild(Node<T>* leftChildNodeP){

    this->leftChildNode = leftChildNodeP;

}

template<class T>
Node<T>* Node<T>::getLeftChild(){

    return this->leftChildNode;

}

template<class T>
void Node<T>::setRightChild(Node<T>* rightChildNodeP){

    this->rightChildNode = rightChildNodeP;

}

template<class T>
Node<T>* Node<T>::getRightChild(){

    return this->rightChildNode;

}

#endif