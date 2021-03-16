package VISTA;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MODELO.Usuario;

import static javax.swing.JOptionPane.showMessageDialog;

public class PanelLogin extends JPanel {

    public static PanelLogin INSTANCE;
    Usuario Dato;

    public static JPanel getInstance(VentanaInicio ventana) {
        INSTANCE = new PanelLogin();
        INSTANCE.setVentanaInicio(ventana);
        return INSTANCE;
    }

    private VentanaInicio ventanaInicio;
    private JLabel lbusuario;
    private JLabel lbcontra;
    private JTextField usuario;
    private JTextField password;
    private JButton btnIniciar;
    private JButton btnRegistro;

    public PanelLogin() {

        this.setBackground(Color.GRAY);
        this.setBounds(0, 0, 850, 580);
        this.setVisible(true);
        this.setLayout(null);

        lbusuario = new JLabel("Usuario");
        lbusuario.setBounds(300, 70, 300, 50);
        this.add(lbusuario);

        usuario = new JTextField();
        usuario.setBounds(300, 100, 300, 50);
        this.add(usuario);

        lbcontra = new JLabel("Contraseña");
        lbcontra.setBounds(300, 140, 300, 50);
        this.add(lbcontra);

        password = new JTextField();
        password.setBounds(300, 170, 300, 50);
        this.add(password);

        btnIniciar = new JButton("INICIAR");
        btnIniciar.setBounds(400, 240, 100, 50);

        btnRegistro = new JButton("REGISTRARSE");
        btnRegistro.setBounds(400, 300, 100, 50);

        this.add(btnIniciar);
        this.add(btnRegistro);

        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String usr = usuario.getText();
                String pass = password.getText();
                // setDato(usr);
                setDato(usr);
                boolean next = login(pass);
                if (next) {
                    // showMessageDialog(null, "entroooooo");
                    // agrego mi usuario logueado
                    Usuario usrd = getDato();
                    Usuario.Usuariolog = usrd;
                    ventanaInicio.mostrarPanel(PanelAvatar.getInstance(ventanaInicio));
                } else {
                    showMessageDialog(null, "Datos incorrectos");
                }
            }
        });

        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ventanaInicio.mostrarPanel(PanelRegistroUsuario.getInstance(ventanaInicio));
            }
        });
        this.repaint();
    }

    public void setDato(String dato) {
        Usuario usr = Usuario.DATA.get(dato);
        Dato = usr;
    }

    public Usuario getDato() {
        return Dato;
    }

    public void setVentanaInicio(VentanaInicio ventanaInicio) {
        this.ventanaInicio = ventanaInicio;
    }

    private boolean login(String pass) {

        // Usuario usuario = Usuario.DATA.get(usr);
        // showMessageDialog(null, usuario);
        Usuario usuario = getDato();
        if (usuario == null) {
            return false;
        }
        if (!usuario.getPass().equals(pass)) {
            return false;
        }
        return true;
    }

}
