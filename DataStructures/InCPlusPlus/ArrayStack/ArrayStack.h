#ifndef _ARRAYSTACK_
#define _ARRAYSTACK_

#include <iostream>

template <class T>
class ArrayStack{

    private:

    T* internalArrayStack;
    size_t arraySize;
    size_t numberOfElementsInArray;

    public:

    ArrayStack();
    ArrayStack(size_t lengthP);
    ~ArrayStack();
    bool isEmpty();
    void push(T dataP);
    T pop();
    T peekTop();
    size_t getNumberOfElementsInStack() const;

};

#include "ArrayStackDef.cpp"

#endif