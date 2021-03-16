package VISTA;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.showMessageDialog;
import MODELO.Usuario;

public class PanelRegistroUsuario extends JPanel {

    public static PanelRegistroUsuario INSTANCE;

    public static JPanel getInstance(VentanaInicio ventana) {
        INSTANCE = new PanelRegistroUsuario(ventana);
        return INSTANCE;
    }

    private VentanaInicio ventanaInicio;

    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JLabel lblUsuario;
    private JLabel lblPass;

    private JTextField txtNombre;
    private JTextField txtUsuario;
    private JTextField txtPassword;

    private JButton btnRegistrar;

    public PanelRegistroUsuario(VentanaInicio ventanaInicio) {
        this.ventanaInicio = ventanaInicio;
        this.setBackground(Color.GRAY);
        this.setBounds(0, 0, 850, 580);       
        this.setVisible(true);
        this.setLayout(null);

        //
        lblTitulo = new JLabel();
        lblTitulo.setText("Registro de Usuario");
        lblTitulo.setSize(20, 20);
        lblTitulo.setBounds(380, 0, 300, 100);
        this.add(lblTitulo);
        // label nombre
        lblNombre = new JLabel();
        lblNombre.setText("Nombre");
        lblNombre.setBounds(300, 30, 100, 100);
        this.add(lblNombre);
        // label usuario
        lblUsuario = new JLabel();
        lblUsuario.setText("Usuario");
        lblUsuario.setBounds(300, 100, 100, 100);
        this.add(lblUsuario);
        // label pass
        lblPass = new JLabel();
        lblPass.setText("Contraseña");
        lblPass.setBounds(300, 170, 100, 100);
        this.add(lblPass);

        // text nombre
        txtNombre = new JTextField();
        txtNombre.setBounds(300, 90, 300, 50);
        this.add(txtNombre);
        // text usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(300, 160, 300, 50);
        this.add(txtUsuario);
        // text pass
        txtPassword = new JTextField();
        txtPassword.setBounds(300, 230, 300, 50);
        this.add(txtPassword);

        // button iniciar
        btnRegistrar = new JButton("INICIAR");
        btnRegistrar.setBounds(400, 300, 100, 50);
        btnRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String usr = txtUsuario.getText();
                String pass = txtPassword.getText();

                boolean entro = validarCampos(nombre, usr, pass);
                if (entro) {
                    ventanaInicio.mostrarPanel(PanelLogin.getInstance(ventanaInicio));
                } else {
                    showMessageDialog(null, "Falta datos por rellenar");
                }
            }
        });
        this.add(btnRegistrar);

        this.repaint();
    }

    /// me creo un metodo para validar todos los campos de registro
    public boolean validarCampos(String nombre, String usr, String pass) {
        boolean exito = true;

        if (nombre.length() <= 0) {
            exito = false;
            return false;
        }
        if (usr.length() <= 0) {
            exito = false;
            return false;
        }
        if (pass.length() <= 0) {
            exito = false;
            return false;
        }

        if (exito == true) {
            new Usuario(nombre, usr, pass);
            /// ventanaInicio.mostrarPanel(PanelLogin.getInstance(ventanaInicio));
            return true;
        }
        return false;

    }

}
