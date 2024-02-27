#include <iostream>
#include "PointerQueue.h"

using namespace std;

int main(){

    PointerQueue<int> myPointerQueque;

    cout << "Number of elements in queue: " << myPointerQueque.getNumberOfElementsInQueue() << "." << endl;

    myPointerQueque.queue(10);
    myPointerQueque.queue(20);
    myPointerQueque.queue(30);
    myPointerQueque.queue(40);
    myPointerQueque.queue(50);

    cout << "Number of elements in queue: " << myPointerQueque.getNumberOfElementsInQueue() << "." << endl;

    cout << "Now serving: " << myPointerQueque.unqueue() << "." << endl;
    cout << "Now serving: " << myPointerQueque.unqueue() << "." << endl;

    cout << "The current element in front of the queue is: " << myPointerQueque.peekFront() << "." << endl;

    return 0;

} //End of main.