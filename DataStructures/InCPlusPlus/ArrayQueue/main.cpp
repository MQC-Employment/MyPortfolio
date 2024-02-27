#include <iostream>
#include "ArrayQueue.h"

using namespace std;

int main(){

    ArrayQueue<int> myArrayQueue;

    cout << "Number of elements in the stack: " << myArrayQueue.getNumberOfElementsInQueue() << "." << endl;
 
    for (size_t i = 1; i <= 10; i++)
    {

        myArrayQueue.queue(i);

    }

    cout << "Number of elements in the stack: " << myArrayQueue.getNumberOfElementsInQueue() << "." << endl;

    while(!myArrayQueue.isEmpty())
    {

        cout << myArrayQueue.unqueue() << endl;

    }

    return 0;    

}