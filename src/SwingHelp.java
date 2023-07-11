// Chapter 17 Self Test, Q17
// Convert the help system from Try this 4-1 into Swing-based GUI program

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SwingHelp implements ListSelectionListener {

    JList<String> jlst;
    JLabel jlab, jlabEnd, jlabSel;
    JScrollPane jscrlp;

    // Create an array of options.
    String[] menu = {"if", "switch", "for", "while",
                     "do-while", "break","continue"};

    SwingHelp() {
        // Create a new JFrame container.
        JFrame jfrm = new JFrame("Help");

        // Specify flow layout;
        jfrm.setLayout(new BorderLayout());

        // Give frame an intial size.
        jfrm.setSize(250, 220);

        // Terminate program when application is closed.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a list.
        jlst = new JList<>(menu);

        // Set list selection mode to single selection.
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add list to scroll pane.
        jscrlp = new JScrollPane(jlst);

        // Make a label that displays selection.
        jlab = new JLabel("Chose a option: ");
        jlabSel = new JLabel("");
        jlabEnd = new JLabel(" ");

        // Add list selection handler.
        jlst.addListSelectionListener(this);

        // Add list and label to content pane.
        jfrm.add(jlab, BorderLayout.NORTH);
        jfrm.add(jscrlp, BorderLayout.WEST);
        jfrm.add(jlabSel, BorderLayout.CENTER);
        jfrm.add(jlabEnd, BorderLayout.SOUTH);

        // Display frame.
        jfrm.setVisible(true);
    }

    // Handle list selection events.
    public void valueChanged(ListSelectionEvent le) {

        // Get index of changed item.
        int idx = jlst.getSelectedIndex();

        // Display selection when is selected.
        switch(idx) {
            case 0 -> jlabSel.setText("<html>The if: <br> if(condition) statement;<br> else statement;</html>");
            case 1 -> jlabSel.setText("<html>The traditional switch: <br> switch(expression)<br> case constant<br> statement sequence<br> break;<br> //...<br> }</html>");
            case 2 -> jlabSel.setText("<html>The for: <br> for(init; condition; iteration)<br>  statement;</html>");
            case 3 -> jlabSel.setText("<html>The while: <br> while(condition) statement;</html>");
            case 4 -> jlabSel.setText("<html>The do-while: <br> do {<br>  statement;<br> } while(condition);</html>");
            case 5 -> jlabSel.setText("<html>The break: <br> break; or break label;</html>");
            case 6 -> jlabSel.setText("<html>The continue: <br> continue; or continue label;</html>");
        }
        if (idx == -1) {
            jlabSel.setText("");
            jlabEnd.setText(" ");
        }
        else
            jlabEnd.setText("Selected: " + menu[idx]);

    }

    public static void main(String[] args) {
        // Create frame on event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingHelp();
            }
        });
    }
}
