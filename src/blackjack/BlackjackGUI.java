/*
 * BlackjackGUI.java
 * Author: HeapsOfRam
 */
package blackjack;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlackjackGUI extends JFrame{
    ControlPanel controls;
    ViewPanel view;
    
    public BlackjackGUI(){
        super("Blackjack");
        
        controls = new ControlPanel(view);
        controls.setPreferredSize(new Dimension(300, 100));
        controls.setBorder(BorderFactory.createEtchedBorder());
        
        view = new ViewPanel();
        view.setBorder(BorderFactory.createEtchedBorder());
        
        setLayout(new BorderLayout());       
        add(BorderLayout.SOUTH, controls);
        add(BorderLayout.CENTER, view);
    }
    
}
