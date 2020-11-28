import Vista.FramePrincipal;
import Vista.PanelLogin;

public class App {
    public static void main(String[] args) throws Exception {
        
        FramePrincipal framePrincipal = new FramePrincipal();
        framePrincipal.setPanel(new PanelLogin());
    }
}
