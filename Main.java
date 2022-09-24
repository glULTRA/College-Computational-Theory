import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        // Create a frame.
        JFrame window = new JFrame("Window");
        // Frame properties.
        window.setLayout(null);
        window.setBounds(1920/3, 1080/5, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Let's make two list that we can intercet them.
        // First set.
        JTextField set1 = new JTextField("a,b,c");
        set1.setBounds(50, 50, 200, 30);
        window.add(set1);
        // Second set.
        JTextField set2 = new JTextField("b,c");
        set2.setBounds(50, 100, 200, 30);
        window.add(set2);

        // Result label.
        JLabel result = new JLabel("");
        result.setBounds(50, 150, 500, 30);
        window.add(result);

        // Button of Interception.
        JButton interception = new JButton("Interception");
        interception.setBounds(300, 70, 130, 30);
        interception.setBackground(Color.white);
        window.add(interception);

        // Action Listener of interception button.
        interception.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String _set1 = set1.getText();
                String _set2 = set2.getText();
                result.setText(Sets.readableFormat(_set1) + " ∩ " + Sets.readableFormat(_set2) + " = " + Sets.interception(_set1, _set2));
            }
        });
        
        JButton union = new JButton("Union");
        union.setBounds(300, 120, 130, 30);
        union.setBackground(Color.white);
        window.add(union);

        union.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String _set1 = set1.getText();
                String _set2 = set2.getText();
                result.setText(Sets.readableFormat(_set1) + " U " + Sets.readableFormat(_set2) + " = " + Sets.union(_set1, _set2));
            }
        });

        // Render the window.
        window.setVisible(true);
    }
}