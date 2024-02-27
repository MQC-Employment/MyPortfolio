#ifndef _POINTERSTACK_
#define _POINTERSTACK_

#include <cstddef>
#include "PointerNode.h"

template<typename T>
class PointerStack{

    private:

    size_t numberOfElementsInStack;
    PointerNode<T>* topNode;
    void deleteData();

    public:

    PointerStack();
    ~PointerStack();
    bool isEmpty();
    T peekTop();
    void pushIn(T dataP);
    T pop();
    size_t getNumberOfElementsInStack() const;

};

#include "PointerStackDef.cpp"

#endif