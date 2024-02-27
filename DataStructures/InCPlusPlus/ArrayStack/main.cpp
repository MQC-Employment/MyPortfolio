#include <iostream>
#include "ArrayStack.h"

using namespace std;

int main(){

    ArrayStack<int> myArrayStack(3);

    cout << "Number of elements in the stack: " << myArrayStack.getNumberOfElementsInStack() << "." << endl;
 
    myArrayStack.push(10);
    myArrayStack.push(20);
    myArrayStack.push(30);
    myArrayStack.push(40);

    cout << "Number of elements in the stack: " << myArrayStack.getNumberOfElementsInStack() << "." << endl;
    cout << "The top element of the stack is: " << myArrayStack.peekTop() << "." << endl;

    myArrayStack.pop();
    myArrayStack.pop();

    cout << "Number of elements in the stack: " << myArrayStack.getNumberOfElementsInStack() << "." << endl;
    cout << "The top element of the stack is: " << myArrayStack.peekTop() << "." << endl;

    myArrayStack.pop();

    cout << "Number of elements in the stack: " << myArrayStack.getNumberOfElementsInStack() << "." << endl;
    cout << "The top element of the stack is: " << myArrayStack.peekTop() << "." << endl;

    return 0;    

}