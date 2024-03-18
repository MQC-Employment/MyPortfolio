/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import classes.Person;
import classes.onewayselfarranginglinkedlist.CircularOneWaySelfArrangingLinkedList;
import java.util.Date;

/**
 *
 * @author ManuelAlonso
 */
public class main {

    public static void main(String[] args) {

        CircularOneWaySelfArrangingLinkedList<Person> myList = new CircularOneWaySelfArrangingLinkedList();
       
        
        myList.insert(new Person(278,"Juan","Marco",27));
        myList.insert(new Person(10,"Pedro","Matamoros",32));
        myList.insert(new Person(2,"Maria","Angelica",50));
        myList.insert(new Person(12,"Sara","Castillo",21));
        
        myList.printList();
        
        myList.deleteByIndex(0);
        myList.deleteByIndex(2);
        myList.deleteByIndex(1);
        myList.deleteByIndex(0);
        
        System.out.println(myList.toString());
        

    } //End of main.
    
} //End of class.
