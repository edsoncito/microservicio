package VISTA;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import javax.swing.JList;
import javax.swing.JPanel;

import MODELO.AvatarLista;

public class PanelAvatarList extends JPanel {

    private PanelAvatarList miInstancia;
    public static PanelAvatarList INSTANCE;

    public static JPanel getInstance(VentanaInicio ventana) {

        if (INSTANCE == null) {
            INSTANCE = new PanelAvatarList();
        }

        INSTANCE.setVentanaInicio(ventana);
        INSTANCE.repaint();
        return INSTANCE;
    }

    private VentanaInicio ventanaInicio;
    private JList lista;

    public PanelAvatarList() {

        this.setBackground(Color.GRAY);
        this.setBounds(0, 0, 850, 600);
        this.setVisible(true);
        this.setLayout(null);
        miInstancia = this;

        lista = new JList();
        lista.setBounds(100, 100, 300, 400);
        lista.setModel(lista());
        this.add(lista);
    }

    private DefaultListModel lista() {
        DefaultListModel model = new DefaultListModel();

        List<String> indexes = new ArrayList<>(AvatarLista.avatares.keySet());
        for (String llave : indexes) {

            model.addElement(AvatarLista.avatares.get(llave));
        }
        return model;
    }

    public void setVentanaInicio(VentanaInicio ventanaInicio) {
        this.ventanaInicio = ventanaInicio;
    }

}
