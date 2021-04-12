package VISTA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VentanaInicio extends JFrame {

    private JMenu menu;
    private JMenuItem usuarios, listas, avatares;
    VentanaInicio ventana;

    public VentanaInicio() {
        this.ventana = this;
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Opciones");
        usuarios = new JMenuItem("Usuarios");
        listas = new JMenuItem("listas");
        avatares = new JMenuItem("Avatares");
        menu.add(usuarios);
        menu.add(listas);
        menu.add(avatares);
        mb.add(menu);
        setJMenuBar(mb);

        usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            
                mostrarPanel(new PanelRegistroUsuario(ventana));
                // mostrarPanel(PanelRegistroUsuario.getInstance(ventana));
            }
        });
        avatares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // mostrarPanel(new PanelAvatar());
                mostrarPanel(new PanelAvatar(ventana));
            }
        });

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(850, 635);
        this.setLayout(null);

        mostrarPanel(PanelLogin.getInstance(this));
    }

    private JPanel selected;

    public void mostrarPanel(JPanel panel) {
        if (selected != null) {
            this.remove(selected);
        }
        selected = panel;
        this.add(panel);
        this.repaint();

    }

}
