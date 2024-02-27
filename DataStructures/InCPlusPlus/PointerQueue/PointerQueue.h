#ifndef _POINTERQUEUE_
#define _POINTERQUEUE_

#include "PointerNode.h"
#include <cstddef>

template<class T>
class PointerQueue{

    private:

    PointerNode<T>* headOfQueue;
    PointerNode<T>* endOfQueue;
    size_t numberOfQueuedElements;
    void clearData();

    public:

    PointerQueue();
    ~PointerQueue();
    bool isEmpty() const;
    void queue(T dataP);
    T unqueue();
    T peekFront() const;
    size_t getNumberOfElementsInQueue() const;

};

#include "PointerQueueDef.cpp"

#endif