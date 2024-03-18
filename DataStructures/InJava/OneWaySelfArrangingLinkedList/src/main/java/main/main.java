/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import classes.Person;
import classes.onewayselfarranginglinkedlist.OneWaySelfArrangingLinkedList;
import classes.onewayselfarranginglinkedlist.OneWaySelfArrangingLinkedListIterator;

/**
 *
 * @author ManuelAlonso
 */
public class main {

    public static void main(String[] args) {


        OneWaySelfArrangingLinkedList<Double> mySelfArrangingList = new OneWaySelfArrangingLinkedList<>();
        
        mySelfArrangingList.insert(278.25);
        mySelfArrangingList.insert(278.24);
        mySelfArrangingList.insert(20.88);
        mySelfArrangingList.insert(300.00);
        mySelfArrangingList.insert(1.66);
        mySelfArrangingList.insert(6.75);
        mySelfArrangingList.insert(12.88);
        
        mySelfArrangingList.printList();
                  
        System.out.println("\n-------------------------------------------\n");
         
        OneWaySelfArrangingLinkedList<Person> mySelfArrangingLinkedList2 = new OneWaySelfArrangingLinkedList<>(true);
        
        mySelfArrangingLinkedList2.insert(new Person(278,"Juan","Marco",27));
        mySelfArrangingLinkedList2.insert(new Person(10,"Pedro","Matamoros",32));
        mySelfArrangingLinkedList2.insert(new Person(2,"Maria","Angelica",50));
        mySelfArrangingLinkedList2.insert(new Person(12,"Sara","Castillo",21));
        
        for (Person currentPerson : mySelfArrangingLinkedList2) {
            
            System.out.println(currentPerson);
            
        }

        System.out.println(mySelfArrangingLinkedList2.toString());
        
        System.out.println("\n-------------------------------------------\n");
        
        OneWaySelfArrangingLinkedListIterator myIterator = mySelfArrangingLinkedList2.iterator();
        
        System.out.println(myIterator.current());
        myIterator.remove();
        myIterator.moveNext();
        myIterator.moveNext();
        System.out.println(myIterator.current());

    } //End of main.
    
} //End of class.
