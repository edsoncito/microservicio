package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelLogin extends JPanel{
    
    private JButton btnIr;
    public PanelLogin(){
        this.setSize(400,400);
        this.setVisible(true);
        this.setBackground(Color.ORANGE);
        createBtnIr();
        this.repaint();
    }

    public void createBtnIr(){
        this.btnIr = new JButton();
        btnIr.setText("IR A LA PAGINA");
        btnIr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                                    
            }
        });
        this.add(btnIr);

    }
}
