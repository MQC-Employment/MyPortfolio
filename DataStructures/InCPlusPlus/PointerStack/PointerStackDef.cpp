#ifndef _POINTERSTACKDEF_
#define _POINTERSTACKDEF_

#include "PointerStack.h"

template<typename T>
PointerStack<T>::PointerStack()
:numberOfElementsInStack{0}, topNode{nullptr}{



}

template<typename T>
PointerStack<T>::~PointerStack(){

    deleteData();

}

template<typename T>
bool PointerStack<T>::isEmpty(){

    if(this->topNode==nullptr){

        return true;

    } else{

        return false;

    }

}

template<typename T>
T PointerStack<T>::peekTop(){

    T data = T();

    if(!isEmpty()){

        data = this->topNode->getData();

    } 

    return T();

}

template<typename T>
void PointerStack<T>::pushIn(T dataP){

    PointerNode<T>* newNode = new PointerNode<T>(dataP);

    if(isEmpty()){

        this->topNode = newNode;

    } else{
        
        newNode->setPreviousNode(this->topNode);
        this->topNode = newNode;

    }

    this->numberOfElementsInStack++;

}

template<typename T>
T PointerStack<T>::pop(){

    T tempData = T();

    if (!isEmpty())
    {
        
        tempData = this->topNode->getData();

        PointerNode<T>* tempTopNodeReference = this->topNode;

        this->topNode = this->topNode->getPreviousNode();
        delete tempTopNodeReference;
        tempTopNodeReference = nullptr;

        this->numberOfElementsInStack--;
        
    }

    return tempData;
  
}

template<typename T>
size_t PointerStack<T>::getNumberOfElementsInStack() const{

    return this->numberOfElementsInStack;

}

template<class T>
void PointerStack<T>::deleteData(){

    if (!isEmpty()) {

        PointerNode<T>* currentNode{ this->topNode };
        PointerNode<T>* nextNodeFromCurrentOne{ nullptr };

        while (currentNode!=nullptr)
        {

            nextNodeFromCurrentOne = currentNode->getPreviousNode();

            delete currentNode;

            currentNode = nextNodeFromCurrentOne;

        }

    }

}

#endif