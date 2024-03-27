#ifndef _BINARYSEARCHTREEDEF_
#define _BINARYSEARCHTREEDEF_

#include "BinarySearchTree.h"

template<class T>
BinarySearchTree<T>::BinarySearchTree()
: root{nullptr}
{

}

template<class T>
BinarySearchTree<T>::~BinarySearchTree(){



}

template<class T>
bool BinarySearchTree<T>::isEmpty(){

    return this->root == nullptr;

}

template<class T>
void BinarySearchTree<T>::insert(T newValueP){

    if(isEmpty()){

        this->root = new Node<T>(newValueP);

    } else{

        recursiveInsert(this->root, newValueP);

    }

}

template<class T>
void BinarySearchTree<T>::recursiveInsert(Node<T>* currentNodeP, T newValueP){

    if(currentNodeP!=nullptr){

        if(newValueP <= currentNodeP->getData()){

            if(currentNodeP->getLeftChild()==nullptr){

                currentNodeP->setLeftChild(new Node<T>(newValueP));

            } else{

                recursiveInsert(currentNodeP->getLeftChild(), newValueP);

            }

        } else{

            if(currentNodeP->getRightChild()==nullptr){

                currentNodeP->setRightChild(new Node<T>(newValueP));

            } else{

                recursiveInsert(currentNodeP->getRightChild(), newValueP);

            }            

        }  

    }

}

template<class T>
T BinarySearchTree<T>::remove(T valueToRemoveP){

    T data = T();

    if(!isEmpty()) {

        if(this->root->getLeftChild()==nullptr && this->root->getRightChild()==nullptr){

            data = this->root->getData();

            delete this->root;            

            this->root = nullptr;

        } else{

            return recursiveRemove(this->root, valueToRemoveP,nullptr);

        }

    }

    return data;

}

template<class T>
T BinarySearchTree<T>::recursiveRemove
(Node<T>* currentNodeP, 
T valueToRemoveP, 
Node<T>* parentNodeOfCurrentNodeP)
{

    if(currentNodeP!=nullptr){

        if(valueToRemoveP<currentNodeP->getData()){

            return recursiveRemove(currentNodeP->getLeftChild(),valueToRemoveP,currentNodeP);

        } else if(valueToRemoveP>currentNodeP->getData()){

            return recursiveRemove(currentNodeP->getRightChild(),valueToRemoveP,currentNodeP);

        } else{

            T data = currentNodeP->getData();

            if(currentNodeP->getLeftChild() == nullptr && currentNodeP->getRightChild() == nullptr){

                if(currentNodeP == parentNodeOfCurrentNodeP->getLeftChild()){

                    parentNodeOfCurrentNodeP->setLeftChild(nullptr);

                } else{

                    parentNodeOfCurrentNodeP->setRightChild(nullptr);

                }

                delete currentNodeP;

            } else if(currentNodeP->getLeftChild() != nullptr && currentNodeP->getRightChild() != nullptr){

                Node<T>* smallestNodeFromCurrentNode = getSmallestNodeFromCurrentNode(currentNodeP->getRightChild());

                currentNodeP->setData(smallestNodeFromCurrentNode->getData());

                recursiveRemove(currentNodeP->getRightChild(),smallestNodeFromCurrentNode->getData(),currentNodeP);

            } else {

                if(currentNodeP->getLeftChild()!=nullptr){

                    currentNodeP->setData(currentNodeP->getLeftChild()->getData());

                    recursiveRemove(currentNodeP->getLeftChild(),currentNodeP->getLeftChild()->getData(),currentNodeP);

                } else{

                    currentNodeP->setData(currentNodeP->getRightChild()->getData());

                    recursiveRemove(currentNodeP->getRightChild(),currentNodeP->getRightChild()->getData(),currentNodeP);

                }

            } 

            return data;

        }

    }

    return T();
    
}

template<class T>
Node<T>* BinarySearchTree<T>::getSmallestNodeFromCurrentNode(Node<T>* currentNodeP){

    if(currentNodeP!=nullptr && currentNodeP->getLeftChild()!=nullptr){

        getSmallestNodeFromCurrentNode(currentNodeP->getLeftChild());

    }

    return currentNodeP;

}

template<class T>
void BinarySearchTree<T>::inOrderPrint(){

    if(!isEmpty()){

        inOrderRecursivePrint(this->root);

        std::cout << std::endl;

    } else{

        std::cout << "Tree is empty" << std::endl;

    }

}

template<class T>
void BinarySearchTree<T>::inOrderRecursivePrint(Node<T>* currenNodeP){

    if(currenNodeP!=nullptr){

        inOrderRecursivePrint(currenNodeP->getLeftChild());
        std::cout << currenNodeP->getData() << " ";
        inOrderRecursivePrint(currenNodeP->getRightChild());

    }

}

#endif