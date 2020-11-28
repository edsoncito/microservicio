package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePrincipal extends JFrame {

    public FramePrincipal(){
        this.setVisible(true);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void setPanel(JPanel panel){
        this.add(panel);
        this.repaint();
        this.revalidate();

    }
    
}
