#ifndef _ARRAYSTACKDEF_
#define _ARRAYSTACKDEF_

#include "ArrayStack.h"

template<class T>
ArrayStack<T>::ArrayStack()
:ArrayStack(10)
{

    /*If no size for the array is specified, then we will manually allocate it a size of 10.
    This constructor uses constructor delegation.*/

}

template<class T>
ArrayStack<T>::ArrayStack(size_t lengthP)
:numberOfElementsInArray{0}, arraySize{lengthP}, internalArrayStack{nullptr}
{

    /*Iniciates the array to the desired length of the user.*/

    internalArrayStack = new T[lengthP];

}

template<class T>
ArrayStack<T>::~ArrayStack(){

    this->arraySize = 0;
    this->numberOfElementsInArray = 0;
    delete[] this->internalArrayStack;
    this->internalArrayStack = nullptr;

}

template<class T>
bool ArrayStack<T>::isEmpty(){

    if(this->numberOfElementsInArray==0){

        return true;

    } else{

        return false;

    }

}

template<class T>
void ArrayStack<T>::push(T dataP){

    if((this->numberOfElementsInArray) < (this->arraySize)){

        this->internalArrayStack[this->numberOfElementsInArray] = dataP;
        this->numberOfElementsInArray++;

    } else{

        std::cout << "Stack overflow!" << std::endl;

    }

}

template<class T>
T ArrayStack<T>::pop(){

    T data = T();

    if(!isEmpty()){

        data = this->internalArrayStack[((this->numberOfElementsInArray)-1)];
        this->numberOfElementsInArray--;

    } 

    return data;

}

template<class T>
T ArrayStack<T>::peekTop(){

    T data = T();

    if(!isEmpty()){

        data = this->internalArrayStack[((this->numberOfElementsInArray)-1)];

    } 

    return data;
    
}

template<class T>
size_t ArrayStack<T>::getNumberOfElementsInStack() const{

    return this->numberOfElementsInArray;

}

#endif