#include <iostream>
#include "BinarySearchTree.h"

using namespace std;

int main(){

    BinarySearchTree<int> myTree;

    myTree.insert(27);
    myTree.insert(100);
    myTree.insert(88);
    myTree.insert(1);
    myTree.insert(4);
    myTree.insert(37);

    myTree.inOrderPrint();

    myTree.remove(100);

    myTree.inOrderPrint();

    myTree.remove(4);

    myTree.inOrderPrint();

    return 0;

} //End of main.