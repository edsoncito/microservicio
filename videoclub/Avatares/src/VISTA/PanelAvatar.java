package VISTA;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Logica.Estilo;
import Logica.ParteDelCuerpo;
import Logica.ParteDelCuerpo;
import MODELO.Avatar;
import MODELO.AvatarLista;
import MODELO.Usuario;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static javax.swing.JOptionPane.showMessageDialog;

public class PanelAvatar extends JPanel {

    private PanelAvatar miInstancia;
    public static PanelAvatar INSTANCE;

    public static JPanel getInstance(VentanaInicio ventana) {

        INSTANCE = new PanelAvatar(ventana);
        return INSTANCE;
    }

    private VentanaInicio ventanaInicio;

    private JLabel lblCategoria;
    private JLabel lblEstilo;

    private JLabel lblNombreUsuario;

    private JButton btnAtrasArriba;
    private JButton btnAdelanteArriba;

    private JButton btnAtrasAbajo;
    private JButton btnAdelanteAbajo;

    private JTextField nombreAvatar;
    private JButton btnGuardarAvatar;

    private BufferedImage image;

    private ParteDelCuerpo parteDelCuerpo;

    private String CategoriaSelect;
    private int indexCategoriaSelect = -1;
    private HashMap<String, Estilo> EstilosDeCategoria;
    private Estilo EstiloSelect;
    private int indexEstiloSelect = -1;

    private Avatar AVATAR;

    public PanelAvatar(VentanaInicio ventanaInicio) {
        this.ventanaInicio = ventanaInicio;
        this.setBackground(Color.GRAY);
        this.setBounds(0, 0, 850, 600);
        this.setVisible(true);
        this.setLayout(null);
        miInstancia = this;
        try {
            image = ImageIO.read(new File("./img/personasinRopa.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // boton atras abajo

        Usuario usuario = Usuario.Usuariolog;
        AVATAR = new Avatar(usuario, "defaul");

        lblNombreUsuario = new JLabel();
        lblNombreUsuario.setText(usuario.getNombre());
        lblNombreUsuario.setBounds(220, 500, 120, 60);
        lblNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(lblNombreUsuario);

        setMenuCategoria();
        setMenuEstilos();
        AvanzarCategoria();
        GuardarAvatar();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 100, 85, 300, 411, null);
        AVATAR.paint(g);

    }

    public void AvanzarCategoria() {
        indexCategoriaSelect++;
        if (indexCategoriaSelect == ParteDelCuerpo.TIPOS.length) {
            indexCategoriaSelect = 0;
        }
        CategoriaSelect = ParteDelCuerpo.TIPOS[indexCategoriaSelect];
        EstilosDeCategoria = ParteDelCuerpo.getEstilos(CategoriaSelect);
        lblCategoria.setText(CategoriaSelect);
        List<String> indexes = new ArrayList<>(EstilosDeCategoria.keySet());
        indexEstiloSelect = indexes.indexOf(AVATAR.getParte(CategoriaSelect)) - 1;
        AvanzarEstilo();

    }

    public void RetrocederCategoria() {
        indexCategoriaSelect--;
        if (indexCategoriaSelect < 0) {
            indexCategoriaSelect = ParteDelCuerpo.TIPOS.length - 1;
        }
        CategoriaSelect = ParteDelCuerpo.TIPOS[indexCategoriaSelect];
        EstilosDeCategoria = ParteDelCuerpo.getEstilos(CategoriaSelect);
        lblCategoria.setText(CategoriaSelect);
        List<String> indexes = new ArrayList<>(EstilosDeCategoria.keySet());
        indexEstiloSelect = indexes.indexOf(AVATAR.getParte(CategoriaSelect)) - 1;
        AvanzarEstilo();

    }

    public void AvanzarEstilo() {
        indexEstiloSelect++;
        if (EstilosDeCategoria.size() <= 0) {
            lblEstilo.setText("NO CUENTA CON ESTILOS");
            return;
        }
        if (indexEstiloSelect == EstilosDeCategoria.size()) {
            indexEstiloSelect = 0;
        }
        List<String> indexes = new ArrayList<>(EstilosDeCategoria.keySet());
        EstiloSelect = EstilosDeCategoria.get(indexes.get(indexEstiloSelect));
        AVATAR.setParte(EstiloSelect.getCategoria(), EstiloSelect.getNombre());
        lblEstilo.setText(EstiloSelect.getNombre());

    }

    public void RetrocederEstilo() {
        indexEstiloSelect--;
        if (EstilosDeCategoria.size() <= 0) {
            lblEstilo.setText("NO CUENTA CON ESTILOS");
            return;
        }
        if (indexEstiloSelect < 0) {
            indexEstiloSelect = EstilosDeCategoria.size() - 1;
        }
        List<String> indexes = new ArrayList<>(EstilosDeCategoria.keySet());
        EstiloSelect = EstilosDeCategoria.get(indexes.get(indexEstiloSelect));
        AVATAR.setParte(EstiloSelect.getCategoria(), EstiloSelect.getNombre());
        lblEstilo.setText(EstiloSelect.getNombre());
    }

    public void setVentanaInicio(VentanaInicio ventanaInicio) {
        this.ventanaInicio = ventanaInicio;
    }

    public void setMenuCategoria() {
        // boton atras arriba
        btnAtrasArriba = new JButton();
        btnAtrasArriba.setText("<");
        btnAtrasArriba.setBounds(450, 0, 120, 60);
        btnAtrasArriba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                RetrocederCategoria();
                miInstancia.repaint();
            }
        });
        this.add(btnAtrasArriba);
        // boton adelante arriba
        btnAdelanteArriba = new JButton();
        btnAdelanteArriba.setText(">");
        btnAdelanteArriba.setBounds(730, 0, 120, 60);
        btnAdelanteArriba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AvanzarCategoria();
                miInstancia.repaint();
            }
        });
        this.add(btnAdelanteArriba);
        this.CategoriaSelect = ParteDelCuerpo.TIPO_POLERA;

        // etiqueta Categoria
        lblCategoria = new JLabel();
        lblCategoria.setText(CategoriaSelect);
        lblCategoria.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
        lblCategoria.setVerticalAlignment(SwingConstants.CENTER);
        lblCategoria.setBounds(520, 0, 260, 60);
        this.add(lblCategoria);
    }

    public void setMenuEstilos() {

        btnAtrasAbajo = new JButton();
        btnAtrasAbajo.setText("<");
        btnAtrasAbajo.setBounds(450, 100, 120, 60);
        btnAtrasAbajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                RetrocederEstilo();
                miInstancia.repaint();
            }
        });
        this.add(btnAtrasAbajo);
        // boton adelante abajo
        btnAdelanteAbajo = new JButton();
        btnAdelanteAbajo.setText(">");
        btnAdelanteAbajo.setBounds(730, 100, 120, 60);
        btnAdelanteAbajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AvanzarEstilo();
                miInstancia.repaint();
            }
        });
        this.add(btnAdelanteAbajo);

        // etiqueta Estilo

        lblEstilo = new JLabel();
        lblEstilo.setText("as");
        lblEstilo.setFont(new Font("calibri", Font.PLAIN, 20));
        lblEstilo.setHorizontalAlignment(SwingConstants.CENTER);
        lblEstilo.setVerticalAlignment(SwingConstants.CENTER);
        lblEstilo.setBounds(520, 100, 260, 60);
        this.add(lblEstilo);
    }

    public void GuardarAvatar() {

        nombreAvatar = new JTextField();
        nombreAvatar.setText("");
        nombreAvatar.setBounds(590, 250, 120, 50);
        btnGuardarAvatar = new JButton();
        btnGuardarAvatar.setText("Guardar");
        btnGuardarAvatar.setBounds(590, 320, 120, 50);
        btnGuardarAvatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // RetrocederCategoria();
                boolean next = validarNombreAvatar(nombreAvatar.getText());
                if (next) {
                    AvatarLista.setAvatar(AVATAR);
                    ventanaInicio.mostrarPanel(PanelAvatarList.getInstance(ventanaInicio));
                    miInstancia.repaint();
                } else {
                    showMessageDialog(null, "ingrese el nombre de su avatar!!!");
                }
            }
        });
        this.add(nombreAvatar);
        this.add(btnGuardarAvatar);
    }

    private boolean validarNombreAvatar(String nombreAvatar) {
        boolean exito = true;
        if (nombreAvatar.length() <= 0) {
            exito = false;
        }
        if (exito) {
            AVATAR.setNombre(nombreAvatar);
            return true;
        }
        return false;
    }
    // public Object clone() {
    // PanelAvatar result = null;
    // try {
    // result.AVATAR = (Avatar) super.clone();
    // ventanaInicio.mostrarPanel(PanelAvatarList.getInstance(ventanaInicio));
    // // result.AVATAR = (Avatar) result.AVATAR.clone();
    // // return result.AVATAR;
    // } catch (CloneNotSupportedException e) {
    // throw new AssertionError(e);
    // }
    // return result.AVATAR;
    // }
}
