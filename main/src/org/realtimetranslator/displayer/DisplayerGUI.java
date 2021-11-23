package org.realtimetranslator.displayer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class DisplayerGUI {
    JFrame jFrame;
    JLabel jLabel;
    JButton jButton;

    public DisplayerGUI(){
        this.jFrame = new JFrame("translation result");
        this.jFrame.setLayout(new GridLayout(2,1));
        this.jLabel = new JLabel();
        this.jButton = new JButton("종료");
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.jFrame.add(jLabel);
        this.jFrame.add(jButton);
        this.jFrame.setVisible(true);
    }
    public void display(String displayText){
        this.jFrame.setSize(displayText.length()*10, 200);
        this.jLabel.setText(displayText);
    }


}
