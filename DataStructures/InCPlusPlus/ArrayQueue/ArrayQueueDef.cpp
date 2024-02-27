#ifndef _ARRAYQUEUEDEF_
#define _ARRAYQUEUEDEF_

#include "ArrayQueue.h"

template<class T>
ArrayQueue<T>::ArrayQueue()
:internalArrayQueue{nullptr},lengthOfQueue{10},numberOfElementsInQueue{0}
{

    this->internalArrayQueue = new T[lengthOfQueue];
    zeroAllValues(this->internalArrayQueue,lengthOfQueue);

}

template<class T>
ArrayQueue<T>::~ArrayQueue(){

    delete this->internalArrayQueue;
    this->numberOfElementsInQueue = 0;
    this->lengthOfQueue = 0;

}

template<class T>
bool ArrayQueue<T>::isEmpty(){

    if(this->numberOfElementsInQueue==0){

        return true;

    } else {

        return false;

    }

}

template<class T>
void ArrayQueue<T>::queue(T dataP){

    if((this->numberOfElementsInQueue) >= (this->lengthOfQueue)){

        resizeArray();
    
    } 

    this->internalArrayQueue[numberOfElementsInQueue] = dataP;
    this->numberOfElementsInQueue++;

}

template<class T>
T ArrayQueue<T>::unqueue(){

    T data = T();

    if(!isEmpty()){

        data = this->internalArrayQueue[0];

        this->numberOfElementsInQueue--;
        
        rearrangeArray();

    }

    return data;

}

template<class T>
T ArrayQueue<T>::peekFront() const{

    if(!isEmpty()){

        return this->internalArrayQueue[0];

    } else{

        return T();

    }

}

template<class T>
T ArrayQueue<T>::peekBack() const{

    if(!isEmpty()){

        return this->internalArrayQueue[numberOfElementsInQueue-1];

    } else{

        return T();

    } 

}

template<class T>
size_t ArrayQueue<T>::getNumberOfElementsInQueue() const{

    return this->numberOfElementsInQueue;

}

template<class T>
void ArrayQueue<T>::resizeArray(){

    this->lengthOfQueue += 10;

    T* temporalNewArray = new T[lengthOfQueue];

    zeroAllValues(temporalNewArray,lengthOfQueue);

    for (size_t iterador = 0; iterador < numberOfElementsInQueue; iterador++)
    {
        
        temporalNewArray[iterador] = this->internalArrayQueue[iterador];

    }
    
    delete this->internalArrayQueue;
    this->internalArrayQueue = temporalNewArray;

}

template<class T>
void ArrayQueue<T>::rearrangeArray(){

    for (size_t iterador = 0; iterador < numberOfElementsInQueue; iterador++)
    {
        
        this->internalArrayQueue[iterador] = this->internalArrayQueue[iterador+1];

    }

}

template<class T>
void ArrayQueue<T>::clearData(){

    delete this->internalArrayQueue;
    this->lengthOfQueue = 0;
    this->numberOfElementsInQueue = 0;

}

template<class T>
void ArrayQueue<T>::zeroAllValues(T* arrayToZeroP, size_t lengthOfArrayP){

    for (size_t iterator = 0; iterator < lengthOfArrayP; iterator++)
    {
        
        arrayToZeroP[iterator] = 0;

    }
    
}

#endif