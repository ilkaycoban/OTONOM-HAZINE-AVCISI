
import javax.swing.JFrame;


public class ProlabOyun {

    
    public static void main(String[] args) {
     
       new AnaPanelFrame();

    }

    static class AnaPanelFrame extends JFrame {
        public AnaPanelFrame() {
            setTitle("Ana Panel");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 200);
            setLocationRelativeTo(null);

         Menu menu = new Menu();
            add(menu);

            setVisible(true);
        }
    }
    
}