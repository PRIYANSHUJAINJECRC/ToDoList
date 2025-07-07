import javax.swing.*;

public class   Myapp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoGui().setVisible(true);
            }
        });
    }
}
