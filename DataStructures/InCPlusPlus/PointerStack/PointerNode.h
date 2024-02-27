#ifndef _POINTERNODE_
#define _POINTERNODE_

template <typename T>
class PointerNode{

    private:

    PointerNode<T>* previousNode;
    T* data;

    public:

    PointerNode(T dataP);
    ~PointerNode();
    PointerNode<T>* getPreviousNode() const;
    void setPreviousNode(PointerNode<T>* previousNodeP);
    T getData() const;
    void setData(T dataP);
    
};

#include "PointerNodeDef.cpp"

#endif