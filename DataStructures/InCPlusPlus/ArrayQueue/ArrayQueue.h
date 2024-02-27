#ifndef _ARRAYQUEUE_
#define _ARRAYQUEUE_

#include <cstddef>

template<class T>
class ArrayQueue{

    private:

    T* internalArrayQueue;
    size_t lengthOfQueue;
    size_t numberOfElementsInQueue;
    void clearData();
    void resizeArray();
    void rearrangeArray();
    void zeroAllValues(T* arrayToZeroP, size_t lengthOfArrayP);

    public:

    ArrayQueue();
    ~ArrayQueue();
    bool isEmpty();
    void queue(T dataP);
    T unqueue();
    T peekFront() const;
    T peekBack() const;
    size_t getNumberOfElementsInQueue() const;

};

#include "ArrayQueueDef.cpp"

#endif