#ifndef _POINTERNODEDEF_
#define _POINTERNODEDEF_

#include "PointerNode.h"

template<typename T>
PointerNode<T>::PointerNode(T dataP)
:previousNode{nullptr}, data{nullptr}
{

    this->data = new T;
    *(this->data) = dataP;

}

template<typename T>
PointerNode<T>::~PointerNode(){

    delete this->data;
    
    this->data =nullptr;
    this->previousNode = nullptr;    

}

template<typename T>
PointerNode<T>* PointerNode<T>::getPreviousNode() const{

    return this->previousNode;

}

template<typename T>
void PointerNode<T>::setPreviousNode(PointerNode<T>* previousNodeP){

    this->previousNode = previousNodeP;

}

template<typename T>
T PointerNode<T>::getData() const{

    return *(this->data);

}

template<typename T>
void PointerNode<T>::setData(T dataP){

    *(this->data) = dataP;

}

#endif