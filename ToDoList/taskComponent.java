import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class taskComponent extends JPanel implements ActionListener {
private  JCheckBox checkBox;
private JTextPane textPane;

private JButton deletebutton;
private JPanel parentPanel;
    public JTextPane getTextPane(){
        return textPane;
    }

public taskComponent(JPanel parentpanel){
    this.parentPanel=parentpanel;
    textPane=new JTextPane();
    textPane.setBorder(BorderFactory.createLineBorder(Color.red.darker()));
    textPane.setPreferredSize(CommonConstant.taskField);
    textPane.setContentType("text/html");
    textPane.setFont(new Font("serif",Font.PLAIN,26));
    textPane.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            textPane.setBackground(Color.GRAY);
        }

        @Override
        public void focusLost(FocusEvent e) {
            textPane.setBackground(Color.white);
        }
    });

    checkBox=new JCheckBox();
    checkBox.setPreferredSize(CommonConstant.checkBox);
    checkBox.addActionListener(this);
    checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


    deletebutton=new JButton("X");
    deletebutton.setPreferredSize(CommonConstant.Delete);
    deletebutton.addActionListener(this);
    deletebutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    deletebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    add(checkBox);
    add(textPane);
     add(deletebutton);

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            String tasktext=textPane.getText().replaceAll("<[^>]*>","");
            textPane.setText("<html><s>"+tasktext+"</s></html>");
        } else if (!checkBox.isSelected()) {
            String tasktext=textPane.getText().replaceAll("<[^>]*>","");
            textPane.setText(tasktext);
        }
        if(e.getActionCommand().equalsIgnoreCase("X")){
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();

        }
    }
}
