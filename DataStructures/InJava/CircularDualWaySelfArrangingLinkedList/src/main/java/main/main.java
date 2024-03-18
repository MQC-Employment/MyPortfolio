/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import classes.Person;
import classes.onewayselfarranginglinkedlist.CircularDualWaySelfArrangingLinkedList;
import classes.onewayselfarranginglinkedlist.CircularDualWaySelfArrangingLinkedListIterator;
import java.util.Date;

/**
 *
 * @author ManuelAlonso
 */
public class main {

    public static void main(String[] args) {

        CircularDualWaySelfArrangingLinkedList<Integer> myList = new CircularDualWaySelfArrangingLinkedList();
       
        myList.insert(278);
        myList.insert(10);
        myList.insert(2);
        myList.insert(12);

        CircularDualWaySelfArrangingLinkedListIterator iterator = myList.iterator();
        
        while (iterator.hasNext()) {
            
            System.out.println(iterator.next());
            
        }
        
        iterator.moveCircularNext();
        
        System.out.println(iterator.next());

    } //End of main.
    
} //End of class.
