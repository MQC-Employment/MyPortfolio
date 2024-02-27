#ifndef _POINTERQUEUEDEF_
#define _POINTERQUEUEDEF_

#include "PointerQueue.h"

template<class T>
PointerQueue<T>::PointerQueue()
: headOfQueue{nullptr}, endOfQueue{nullptr},numberOfQueuedElements{0}
{}

template<class T>
PointerQueue<T>::~PointerQueue(){

    clearData();

}

template<class T>
bool PointerQueue<T>::isEmpty() const{

    if(this->headOfQueue==nullptr){

        return true;

    } else{

        return false;

    }

}

template<class T>
void PointerQueue<T>::queue(T dataP){

    PointerNode<T>* newElement = new PointerNode<T>(dataP);

    if(isEmpty()){

        this->headOfQueue = newElement;
        this->endOfQueue = newElement;

    } else{

        this->endOfQueue->setPreviousNode(newElement);
        this->endOfQueue = newElement;

    }

    this->numberOfQueuedElements++;

}

template<class T>
T PointerQueue<T>::unqueue(){

    T data = T();

    if(!isEmpty()){

        data = this->headOfQueue->getData();

        PointerNode<T>* temporalTopNode = this->headOfQueue;

        this->headOfQueue = this->headOfQueue->getPreviousNode();
        
        delete temporalTopNode;

        this->numberOfQueuedElements--;

    }

    return data;

}

template<class T>
T PointerQueue<T>::peekFront() const{


    if(!isEmpty()){

        return this->headOfQueue->getData();        

    } else{

        return T();

    }

}

template<class T>
size_t PointerQueue<T>::getNumberOfElementsInQueue() const{

    return this->numberOfQueuedElements;

}

template<class T>
void PointerQueue<T>::clearData(){

    if(!isEmpty()){

        PointerNode<T>* currentNode { this->headOfQueue };
        PointerNode<T>* nextNodeFromCurrentNode { nullptr};

        while(currentNode!=nullptr){

            nextNodeFromCurrentNode = currentNode->getPreviousNode();

            delete currentNode;

            currentNode = nextNodeFromCurrentNode;

        }

    }

}

#endif