/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstproject;

/**
 *
 * @author ARJIT MITTAL
 */
import javax.swing.*;

public class TestBinaryTree {
    public static void main(String[] args){      
        JFrame f = new JFrame("Binary Search Tree"); // creating a new frame
        TreeControl tc = new TreeControl(new BinaryTree<Integer>()); // creating object of class: TreeControl and giving the reference to variable tc
        f.add(tc); // adding tc to the frame
        f.setVisible(true); // making the frame visible to the user
        f.setBounds(200,10,1500, 1020); // coordinates of the frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the frame, if user selects the close window 
    }
}
