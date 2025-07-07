import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoGui extends JFrame implements ActionListener {
    //taskPanel will carry the actions of the task component
    //taskcomponentPanel will store the all of is taskcomponent
    private JPanel taskpanel;
    private JPanel taskcomponentpanel;
    public ToDoGui(){
        super("TODO List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstant.dim_size);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        addGui();
    }
    private void addGui(){
        JLabel bannerlabel=new JLabel("to do List");
        bannerlabel.setBounds(0,0,CommonConstant.dim_size.width,50);
        bannerlabel.setFont(new Font("Dialog",Font.BOLD,40));
        bannerlabel.setHorizontalAlignment(SwingConstants.CENTER);
        taskpanel=new JPanel();
        taskcomponentpanel=new JPanel();
        taskcomponentpanel.setLayout(new BoxLayout(taskcomponentpanel,BoxLayout.Y_AXIS));
        taskpanel.add(taskcomponentpanel);
         JScrollPane scrollPane=new JScrollPane(taskpanel);
         scrollPane.setBounds(8,70,CommonConstant.taskpanel.width,CommonConstant.taskpanel.height);
         scrollPane.setMaximumSize(CommonConstant.taskpanel);
         scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
         scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
         scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         JScrollBar verticalscrollbar=scrollPane.getVerticalScrollBar();
         verticalscrollbar.setUnitIncrement(20);
        JButton addButton=new JButton("add Task");
        addButton.setBounds(-5,CommonConstant.dim_size.height-88,CommonConstant.button.width,CommonConstant.button.height);
        addButton.setFont(new Font("Dialog",Font.PLAIN,32));
        addButton.addActionListener(this);
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



         this.getContentPane().add(bannerlabel);
         this.getContentPane().add(scrollPane);
         this.getContentPane().add(addButton);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String cammand=e.getActionCommand();
        if(cammand.equalsIgnoreCase("add Task")){
        taskComponent TaskComponent=new taskComponent(taskcomponentpanel);
        taskcomponentpanel.add(TaskComponent);

        if(taskcomponentpanel.getComponentCount()>1){
            taskComponent previous=(taskComponent) taskcomponentpanel.getComponent(taskcomponentpanel.getComponentCount()-2);
            previous.getTextPane().setBackground(null);

        }


        TaskComponent.getTextPane().requestFocus();
        repaint();
        revalidate();
    }}
}
