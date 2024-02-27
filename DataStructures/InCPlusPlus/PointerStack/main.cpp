#include <iostream>
#include <string>
#include "PointerStack.h"

using namespace std;

int main(){

    PointerStack<int> myPointerStack;

    cout << "Number of elements in the stack: " << myPointerStack.getNumberOfElementsInStack() << "." << endl;
 
    myPointerStack.pushIn(10);
    myPointerStack.pushIn(20);
    myPointerStack.pushIn(30);
    myPointerStack.pushIn(40);

    cout << "Number of elements in the stack: " << myPointerStack.getNumberOfElementsInStack() << "." << endl;
    cout << "The top element of the stack is: " << myPointerStack.peekTop() << "." << endl;

    myPointerStack.pop();
    myPointerStack.pop();

    cout << "Number of elements in the stack: " << myPointerStack.getNumberOfElementsInStack() << "." << endl;
    cout << "The top element of the stack is: " << myPointerStack.peekTop() << "." << endl;

    myPointerStack.pop();
    myPointerStack.pop();

    cout << "Number of elements in the stack: " << myPointerStack.getNumberOfElementsInStack() << "." << endl;
    cout << "The top element of the stack is: " << myPointerStack.peekTop() << "." << endl;

    myPointerStack.pop();
    
    return 0;

} //End of main.