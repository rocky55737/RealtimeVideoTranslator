package org.realtimetranslator.displayer;
import javax.swing.*;

public class DisplayerGUI {
    JFrame jFrame;
    JLabel jLabel;

    public DisplayerGUI(){
        this.jFrame = new JFrame("translation result");
        this.jLabel = new JLabel();
        this.jFrame.add(jLabel);
        this.jFrame.setVisible(true);
    }
    public void display(String displayText){
        this.jFrame.setSize(displayText.length()*10, 100);
        this.jLabel.setText(displayText);
    }
}
