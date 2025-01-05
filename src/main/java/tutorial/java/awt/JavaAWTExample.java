package tutorial.java.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Refer: https://www.geeksforgeeks.org/java-awt-tutorial/
 *
 * Java AWT or Abstract Window Toolkit is an API used for developing GUI(Graphic User Interfaces) or Window-Based Applications in
 * Java. Java AWT is part of the Java Foundation Classes (JFC) that provides a way to build platform-independent graphical applications.
 * In this AWT tutorial, you will learn the basics of the AWT, including how to create windows, buttons, labels, and text fields.
 * We will also learn how to add event listeners to components so that they can respond to user input.
 * By the end of this tutorial, you will have a good understanding of the AWT and be able to create simple GUIs in Java.
 *
 * AWT stands for Abstract Window Toolkit, which is an API for creating graphical user interface (GUI) or windows-based applications
 * in Java. AWT provides various components like buttons, labels, text fields, etc. that can be used as objects in a Java program
 *
 * Points about Java AWT components:
 * i. Components of AWT are heavy and platform dependent
 * ii. AWT has less control as the result can differ because of components are platform dependent.
 * */
public class JavaAWTExample {

    public static void main(String[] args)
    {
        // Creating instance of frame with the label
        Frame frame = new Frame("Example 2");

        // Creating instance of button with label
        Button button = new Button("Click Here");

        // Setting the position for the button in frame
        button.setBounds(80, 100, 64, 30);

        // Adding button to the frame
        frame.add(button);

        // setting size, layout and visibility of frame
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        // Using WindowListener for closing the window
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

}
