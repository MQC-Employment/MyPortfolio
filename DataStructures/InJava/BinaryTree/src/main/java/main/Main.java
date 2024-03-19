/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import classes.binarytree.BinaryTree;

/**
 *
 * @author ManuelAlonso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        
        BinaryTree<Integer> myBinaryTee = new BinaryTree();
        
        myBinaryTee.insert(27);
        myBinaryTee.insert(100);
        myBinaryTee.insert(88);
        myBinaryTee.insert(1);
        myBinaryTee.insert(4);
        myBinaryTee.insert(37);

        System.out.println("InOrder print: " + myBinaryTee.inOrderString());
        System.out.println("Smallest value of the tree: " + myBinaryTee.smallestValue());
        
        System.out.println("Is 37 present? " + myBinaryTee.search(37));
        System.out.println("Is 278 present? " + myBinaryTee.search(278));
        
        System.out.println("Removing 100...");
        myBinaryTee.remove(100);
        
        System.out.println("Removing 4...");
        myBinaryTee.remove(4);
        
        System.out.println("InOrder print: " + myBinaryTee.inOrderString());

    } //end of main class.
    
} //end of class.
