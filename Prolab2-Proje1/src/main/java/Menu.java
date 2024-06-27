
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;



public class Menu extends JPanel{
    
    private JTextField bosluk1;
    private JTextField bosluk2;
     private JTextField kareboyut;
    public static int satirgirdi;
    public static int sutungirdi;
    public static int karegirdi;
    Random random = new Random();
    
    public Menu(){
        
         setLayout(new BorderLayout());
         JPanel girdipanel= new JPanel();
         girdipanel.setLayout(new GridBagLayout());
         JLabel girdisatir = new JLabel("Satir Sayısı:");
         bosluk1 = new JTextField(6);
         JLabel girdisutun = new JLabel("Sutun Sayısı:");
         bosluk2 = new JTextField(6);
         
         JLabel kare_boyutu = new JLabel("Kare Boyutu:");
         kareboyut = new JTextField(6);
         JButton buton1 = new JButton("Oyuna Başla");
         JButton buton2 = new JButton("Harita Oluştur");
         
            buton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Engel.ase=1;
            }
        });
            buton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Engel.ase=0;
                try {
                    int satir = Integer.parseInt(bosluk1.getText());
                    int sutun = Integer.parseInt(bosluk2.getText());
                    int kareboyutt= Integer.parseInt(kareboyut.getText());
                    satirgirdi = satir;
                    sutungirdi = sutun;
                    karegirdi=kareboyutt;
                    OyunAlani oyunFrame = new OyunAlani(satir, sutun);
                    oyunFrame.setVisible(true);
                  
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Menu.this, "Lütfen geçerli bir sayı girin.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
               
            }
        });
         GridBagConstraints eren = new GridBagConstraints();
        eren.gridx = 0;
        eren.gridy = 0;
        girdipanel.add(girdisatir, eren);

        eren.gridx = 1;
        girdipanel.add(bosluk1, eren);

        eren.gridx = 0;
        eren.gridy = 2;
        girdipanel.add(girdisutun, eren);

        eren.gridx = 1;
        girdipanel.add(bosluk2, eren);
        
        eren.gridx = 0;
        eren.gridy = 4;
        girdipanel.add(kare_boyutu, eren);

        eren.gridx = 1;
        girdipanel.add(kareboyut, eren);

        eren.gridx = 0;
        eren.gridy = 6;
        eren.gridwidth = 2; 
        eren.anchor = GridBagConstraints.CENTER; 
        girdipanel.add(buton1, eren);

        eren.gridx = 0;
        eren.gridy = 8;
        eren.gridwidth = 2;
        eren.anchor = GridBagConstraints.CENTER; 
        girdipanel.add(buton2, eren);
        add(girdipanel, BorderLayout.CENTER);



    }
}

class OyunAlani extends JFrame {
    public OyunAlani(int satir, int sutun) {
        setTitle("Kareli Alan Oyunu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(sutun*15+19, satir*15+47);
        setLocationRelativeTo(null);
        setBackground(Color.black);

        Uygulama uygulama = new Uygulama(satir, sutun);
        add(uygulama);
    }
}
