import Logica.Estilo;
import Logica.ParteDelCuerpo;
import MODELO.Usuario;
import VISTA.VentanaInicio;

public class App {
  public static void main(String[] args) throws Exception {

    // Poleras
    new Estilo("default", ParteDelCuerpo.TIPO_POLERA, 127, 328, 245, 134, "");
    new Estilo("poleraNegra", ParteDelCuerpo.TIPO_POLERA, 127, 328, 245, 134, "./img/poleranegra.png");
    new Estilo("poleraAgua", ParteDelCuerpo.TIPO_POLERA, 127, 328, 245, 134, "./img/poleraagua.png");
    new Estilo("poleraCafe", ParteDelCuerpo.TIPO_POLERA, 127, 328, 245, 134, "./img/poleracafe.png");
    new Estilo("polerafuxia", ParteDelCuerpo.TIPO_POLERA, 127, 328, 245, 134, "./img/polerafuxia.png");
    new Estilo("poleraroja", ParteDelCuerpo.TIPO_POLERA, 127, 328, 245, 134, "./img/poleraroja.png");
    new Estilo("poleraverde", ParteDelCuerpo.TIPO_POLERA, 127, 328, 245, 134, "./img/poleraverde.png");
    new Estilo("poleralila", ParteDelCuerpo.TIPO_POLERA, 127, 328, 245, 134, "./img/poleralila.png");
    // Poleras
    new Estilo("default", ParteDelCuerpo.TIPO_OJOS, 150, 180, 200, 40, "");
    new Estilo("Ojo1", ParteDelCuerpo.TIPO_OJOS, 150, 180, 200, 40, "./img/avatarojos1.png");
    new Estilo("Ojo2", ParteDelCuerpo.TIPO_OJOS, 150, 180, 200, 41, "./img/avatarojos2.png");
    new Estilo("Ojo3", ParteDelCuerpo.TIPO_OJOS, 150, 156, 200, 65, "./img/avatarojos3.png");
    new Estilo("Ojo4", ParteDelCuerpo.TIPO_OJOS, 150, 156, 200, 66, "./img/avatarojos4.png");
    new Estilo("Ojo4", ParteDelCuerpo.TIPO_OJOS, 150, 156, 200, 66, "./img/avatarojos4.png");
    // Polerass
    new Estilo("default", ParteDelCuerpo.TIPO_CABELLO, 95, 0, 310, 310, "");
    new Estilo("Cabello1", ParteDelCuerpo.TIPO_CABELLO, 95, 0, 310, 310, "./img/cabello1.png");
    new Estilo("Cabello2", ParteDelCuerpo.TIPO_CABELLO, 80, 30, 330, 330, "./img/cabello2.png");
    new Estilo("Cabello3", ParteDelCuerpo.TIPO_CABELLO, 35, -110, 430, 459, "./img/cabello3.png");
    new Estilo("Cabello4", ParteDelCuerpo.TIPO_CABELLO, -155, -119, 820, 820, "./img/cabello4.png");
    new Estilo("Cabello5", ParteDelCuerpo.TIPO_CABELLO, 115, 70, 257, 139, "./img/cabello5.png");
    new Estilo("Cabello6", ParteDelCuerpo.TIPO_CABELLO, 80, 20, 320, 275, "./img/cabello6.png");
    new Estilo("Cabello7", ParteDelCuerpo.TIPO_CABELLO, 107, 41, 285, 179, "./img/cabello7.png");
    new Estilo("Cabello8", ParteDelCuerpo.TIPO_CABELLO, 112, 90, 275, 277, "./img/cabello8.png");
    // bocas
    new Estilo("default", ParteDelCuerpo.TIPO_BOCA, 88, 42, 338, 318, "");
    new Estilo("Boca1", ParteDelCuerpo.TIPO_BOCA, 183, 268, 134, 60, "./img/boca1.png");
    new Estilo("Boca2", ParteDelCuerpo.TIPO_BOCA, 175, 268, 145, 53, "./img/boca2.png");
    new Estilo("Boca3", ParteDelCuerpo.TIPO_BOCA, 175, 276, 150, 44, "./img/boca3.png");

    // Pantalon
    new Estilo("default", ParteDelCuerpo.TIPO_PANTALON, 160, 450, 190, 30, "");
    new Estilo("Pantalon1", ParteDelCuerpo.TIPO_PANTALON, 160, 450, 190, 30, "./img/pantalon1.png");
    new Estilo("Pantalon2", ParteDelCuerpo.TIPO_PANTALON, 157, 444, 192, 39, "./img/pantalon2.png");

    VentanaInicio ventanaInicio = new VentanaInicio();
  }
}
