import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Uygulama extends JPanel {
    int hiz=40;

    private final int satir;
    private final int sutun;
    private final int kare_boyutu = Menu.karegirdi;
    int kontrol = 0;
    ArrayList<Engel> engeller = new ArrayList<>();
    ArrayList<Integer> kirmizi = new ArrayList<>();

    private Image arkaPlanResmi1; // İlk arka plan resmi
    private Image arkaPlanResmi2; // İkinci arka plan resmi
    private boolean oyunBittiMi = false; // Oyunun bitip bitmediğini belirten bayrak
    int sayac = 0;
    ArrayList<Engel> engel = new ArrayList<>();
    Random random = new Random();
    Karakter karakter = new Karakter("AnkaraMessi", "19", 0, 0);
    Resim resim = new Resim();

    public Uygulama(int satir, int sutun) {
        this.satir = satir;
        this.sutun = sutun;
     
        engel.add(altin);
        engel.add(altin);
        engel.add(altin2);
        engel.add(altin3);
        engel.add(altin_karli);
        engel.add(altin_karli2);
        engel.add(bakir);
        engel.add(bakir2);
        engel.add(bakir3);
        engel.add(bakir_kis);
        engel.add(bakir_kis2);
        engel.add(gumus);
        engel.add(gumus2);
        engel.add(gumus_karli);
        engel.add(gumus_karli2);
        engel.add(gumus_karli3);
        engel.add(zumrut);
        engel.add(zumrut2);
        engel.add(zumrut_karli);
        engel.add(zumrut_karli2);
        engel.add(zumrut_karli3);

        engel1 = kisayol(engel, baslangic(karakter));
        int a = random.nextInt(1);
        if (a == 1) {
            karakter.setX(rast.yazx.get(24) * kare_boyutu);
            karakter.setY(rast.yazy.get(24) * kare_boyutu);
        } else {
            karakter.setX(rast.kisx.get(24) * kare_boyutu);
            karakter.setY(rast.kisy.get(24) * kare_boyutu);
        }
        engeller.add(ari);
        engeller.add(agac);
        engeller.add(dag);
        engeller.add(duvar);
        engeller.add(kus);
        engeller.add(tas);
        engeller.add(agac1);
        engeller.add(dag2);
        engeller.add(dag3);
        engeller.add(duvar1);
        engeller.add(tas2);
        engeller.add(tas3);
        engeller.add(agac_karli);
        engeller.add(ari_kis);
        engeller.add(dag_karli);
        engeller.add(duvar_karli);
        engeller.add(kus_karli);
        engeller.add(tas_karli);
        engeller.add(ari_kis2);
        engeller.add(agac_karli2);
        engeller.add(agac_karli3);
        engeller.add(dag_karli1);
        engeller.add(duvar_karli2);
        engeller.add(duvar_karli3);
        engeller.add(tas_karli1);

        Timer timer = new Timer(hiz, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!oyunBittiMi) {
                    
                    if(Engel.ase==0)
                    {
                    repaint();
                    } else {     
                    hareketEttir();
                    kontrolEt();
                    repaint();  
                    }
                }
            }
        });
        timer.start();

    }
    ArrayList<Engel> engel1 = new ArrayList<>();
    ArrayList<Integer> yesil = new ArrayList<>();

    public Engel baslangic(Karakter karakter) {
        int enkucuk = Integer.MAX_VALUE;
        Engel yakin = engel.get(0);

        for (int i = 0; i < engel.size(); i++) {
            int a = Math.abs(karakter.getX() - engel.get(i).getX()) + Math.abs(karakter.getY() - engel.get(i).getY());
            if (enkucuk > a) {
                enkucuk = a;
                yakin = engel.get(i);
            }

        }
        return yakin;
    }

    public ArrayList<Engel> kisayol(ArrayList<Engel> engel, Engel baslangic) {
        int boyut = engel.size();
        boolean[] toplandi = new boolean[boyut];
        ArrayList<Engel> yol = new ArrayList<>();
        yol.add(baslangic);
        toplandi[0] = true;

        while (yol.size() < boyut) {

            int son_deger = yol.size() - 1;
            int kisa_mesafe = 999999;
            int enkcukdeger = -1;

            for (int i = 0; i < boyut; i++) {
                if (!toplandi[i]) {
                    int ilker;
                    ilker = mesafe(yol.get(son_deger), engel.get(i));
                    if (ilker < kisa_mesafe) {
                        kisa_mesafe = ilker;
                        enkcukdeger = i;
                    }
                }
            }

            yol.add(engel.get(enkcukdeger));
            toplandi[enkcukdeger] = true;
        }

        return yol;
    }

    public int mesafe(Engel engel1, Engel engel2) {
        int x = Math.abs(engel1.getX() - engel2.getX());
        int y = Math.abs(engel1.getY() - engel2.getY());
        int toplam = x + y;
        return toplam;
    }

    RastgeleYaz rast = new RastgeleYaz();

    int a = 2;
    int b = 2;

    Engel agac = new Engel(rast.yazx.get(0) * kare_boyutu, rast.yazy.get(0) * kare_boyutu, 4, 4);
    Engel altin = new Engel(rast.yazx.get(1) * kare_boyutu, rast.yazy.get(1) * kare_boyutu, a, b, 0);
    Engel ari = new Engel(rast.yazx.get(2) * kare_boyutu, rast.yazy.get(2) * kare_boyutu, a, 2);
    Engel bakir = new Engel(rast.yazx.get(3) * kare_boyutu, rast.yazy.get(3) * kare_boyutu, a, b, 3);
    Engel dag = new Engel(rast.yazx.get(4) * kare_boyutu, rast.yazy.get(4) * kare_boyutu, 7, 7);
    Engel duvar = new Engel(rast.yazx.get(5) * kare_boyutu, rast.yazy.get(5) * kare_boyutu, 1, 6);
    Engel gumus = new Engel(rast.yazx.get(6) * kare_boyutu, rast.yazy.get(6) * kare_boyutu, a, b, 1);
    Engel kus = new Engel(rast.yazx.get(7) * kare_boyutu, rast.yazy.get(7) * kare_boyutu, 2, b);
    Engel tas = new Engel(rast.yazx.get(8) * kare_boyutu, rast.yazy.get(8) * kare_boyutu, 3, 3);
    Engel zumrut = new Engel(rast.yazx.get(9) * kare_boyutu, rast.yazy.get(9) * kare_boyutu, a, b, 2);
    Engel altin2 = new Engel(rast.yazx.get(10) * kare_boyutu, rast.yazy.get(10) * kare_boyutu, a, b, 0);
    Engel altin3 = new Engel(rast.yazx.get(11) * kare_boyutu, rast.yazy.get(11) * kare_boyutu, a, b, 0);
    Engel bakir2 = new Engel(rast.yazx.get(12) * kare_boyutu, rast.yazy.get(12) * kare_boyutu, a, b, 3);
    Engel bakir3 = new Engel(rast.yazx.get(13) * kare_boyutu, rast.yazy.get(13) * kare_boyutu, a, b, 3);
    Engel gumus2 = new Engel(rast.yazx.get(14) * kare_boyutu, rast.yazy.get(14) * kare_boyutu, a, b, 1);
    Engel zumrut2 = new Engel(rast.yazx.get(15) * kare_boyutu, rast.yazy.get(15) * kare_boyutu, a, b, 2);
    Engel agac1 = new Engel(rast.yazx.get(16) * kare_boyutu, rast.yazy.get(16) * kare_boyutu, 3, 3);
    Engel dag2 = new Engel(rast.yazx.get(17) * kare_boyutu, rast.yazy.get(17) * kare_boyutu, 6, 6);
    Engel dag3 = new Engel(rast.yazx.get(18) * kare_boyutu, rast.yazy.get(18) * kare_boyutu, 6, 6);
    Engel duvar1 = new Engel(rast.yazx.get(19) * kare_boyutu, rast.yazy.get(19) * kare_boyutu, 1, 6);
    Engel tas2 = new Engel(rast.yazx.get(20) * kare_boyutu, rast.yazy.get(20) * kare_boyutu, 3, 3);
    Engel tas3 = new Engel(rast.yazx.get(21) * kare_boyutu, rast.yazy.get(21) * kare_boyutu, 3, 3);


    Engel altin_karli2 = new Engel(rast.kisx.get(0) * kare_boyutu, rast.kisy.get(0) * kare_boyutu, a, b, 0);
    Engel gumus_karli2 = new Engel(rast.kisx.get(1) * kare_boyutu, rast.kisy.get(1) * kare_boyutu, a, b, 1);
    Engel gumus_karli3 = new Engel(rast.kisx.get(2) * kare_boyutu, rast.kisy.get(2) * kare_boyutu, a, b, 1);
    Engel bakir_kis2 = new Engel(rast.kisx.get(3) * kare_boyutu, rast.kisy.get(3) * kare_boyutu, a, b, 3);
    Engel zumrut_karli2 = new Engel(rast.kisx.get(4) * kare_boyutu, rast.kisy.get(4) * kare_boyutu, a, b, 2);
    Engel zumrut_karli3 = new Engel(rast.kisx.get(5) * kare_boyutu, rast.kisy.get(5) * kare_boyutu, a, b, 2);
    Engel agac_karli = new Engel(rast.kisx.get(6) * kare_boyutu, rast.kisy.get(6) * kare_boyutu, 4, 4);
    Engel altin_karli = new Engel(rast.kisx.get(7) * kare_boyutu, rast.kisy.get(7) * kare_boyutu, a, b, 0);
    Engel ari_kis = new Engel(rast.kisx.get(8) * kare_boyutu, rast.kisy.get(8) * kare_boyutu, a, 2);
    Engel bakir_kis = new Engel(rast.kisx.get(9) * kare_boyutu, rast.kisy.get(9) * kare_boyutu, a, b, 3);
    Engel dag_karli = new Engel(rast.kisx.get(10) * kare_boyutu, rast.kisy.get(10) * kare_boyutu, 7, 7);
    Engel duvar_karli = new Engel(rast.kisx.get(11) * kare_boyutu, rast.kisy.get(11) * kare_boyutu, 1, 6);
    Engel gumus_karli = new Engel(rast.kisx.get(12) * kare_boyutu, rast.kisy.get(12) * kare_boyutu, a, b, 1);
    Engel kus_karli = new Engel(rast.kisx.get(13) * kare_boyutu, rast.kisy.get(13) * kare_boyutu, 2, b);
    Engel tas_karli = new Engel(rast.kisx.get(14) * kare_boyutu, rast.kisy.get(14) * kare_boyutu, 3, 3);
    Engel zumrut_karli = new Engel(rast.kisx.get(15) * kare_boyutu, rast.kisy.get(15) * kare_boyutu, a, b, 2);
    Engel ari_kis2 = new Engel(rast.kisx.get(16) * kare_boyutu, rast.kisy.get(16) * kare_boyutu, a, 2);
    Engel agac_karli2 = new Engel(rast.kisx.get(17) * kare_boyutu, rast.kisy.get(17) * kare_boyutu, 3, 3);
    Engel agac_karli3 = new Engel(rast.kisx.get(18) * kare_boyutu, rast.kisy.get(18) * kare_boyutu, 3, 3);
    Engel dag_karli1 = new Engel(rast.kisx.get(19) * kare_boyutu, rast.kisy.get(19) * kare_boyutu, 7, 7);
    Engel duvar_karli2 = new Engel(rast.kisx.get(20) * kare_boyutu, rast.kisy.get(20) * kare_boyutu, 1, 6);
    Engel duvar_karli3 = new Engel(rast.kisx.get(21) * kare_boyutu, rast.kisy.get(21) * kare_boyutu, 1, 6);
    Engel tas_karli1 = new Engel(rast.kisx.get(22) * kare_boyutu, rast.kisy.get(22) * kare_boyutu, 3, 3);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(resim.yaz_resmi.get(10), (sutun / 2) * kare_boyutu, 0, (sutun / 2) * kare_boyutu, satir * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(11), 0, 0, (sutun / 2) * kare_boyutu, satir * kare_boyutu, this);

        

        g.drawImage(resim.yaz_resmi.get(1), altin2.getX(), altin2.getY(), altin2.getSatir() * kare_boyutu, altin2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(1), altin3.getX(), altin3.getY(), altin3.getSatir() * kare_boyutu, altin3.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(3), bakir2.getX(), bakir2.getY(), bakir2.getSatir() * kare_boyutu, bakir2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(3), bakir3.getX(), bakir3.getY(), bakir3.getSatir() * kare_boyutu, bakir3.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(6), gumus2.getX(), gumus2.getY(), gumus2.getSatir() * kare_boyutu, gumus2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(9), zumrut2.getX(), zumrut2.getY(), zumrut2.getSatir() * kare_boyutu, zumrut2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(1), altin_karli2.getX(), altin_karli2.getY(), altin_karli2.getSatir() * kare_boyutu, altin_karli2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(6), gumus_karli2.getX(), gumus_karli2.getY(), gumus_karli2.getSatir() * kare_boyutu, gumus_karli2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(6), gumus_karli3.getX(), gumus_karli3.getY(), gumus_karli3.getSatir() * kare_boyutu, gumus_karli3.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(3), bakir_kis2.getX(), bakir_kis2.getY(), bakir_kis2.getSatir() * kare_boyutu, bakir_kis2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(9), zumrut_karli2.getX(), zumrut_karli2.getY(), zumrut_karli2.getSatir() * kare_boyutu, zumrut_karli2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(9), zumrut_karli3.getX(), zumrut_karli3.getY(), zumrut_karli3.getSatir() * kare_boyutu, zumrut_karli3.getSutun() * kare_boyutu, this);

        g.drawImage(resim.yaz_resmi.get(0), agac.getX(), agac.getY(), agac.getSatir() * kare_boyutu, agac.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(0), agac1.getX(), agac1.getY(), agac1.getSatir() * kare_boyutu, agac1.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(1), altin.getX(), altin.getY(), altin.getSatir() * kare_boyutu, altin.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(2), ari.getX(), ari.getY(), ari.getSatir() * kare_boyutu, ari.getSatir() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(3), bakir.getX(), bakir.getY(), bakir.getSatir() * kare_boyutu, bakir.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(4), dag.getX(), dag.getY(), dag.getSatir() * kare_boyutu, dag.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(4), dag2.getX(), dag2.getY(), dag2.getSatir() * kare_boyutu, dag2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(4), dag3.getX(), dag3.getY(), dag3.getSatir() * kare_boyutu, dag3.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(5), duvar.getX(), duvar.getY(), duvar.getSutun() * kare_boyutu, duvar.getSatir() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(5), duvar1.getX(), duvar1.getY(), duvar1.getSutun() * kare_boyutu, duvar1.getSatir() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(6), gumus.getX(), gumus.getY(), gumus.getSatir() * kare_boyutu, gumus.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(7), kus.getX(), kus.getY(), kus.getSutun() * kare_boyutu, kus.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(8), tas.getX(), tas.getY(), tas.getSatir() * kare_boyutu, tas.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(8), tas2.getX(), tas2.getY(), tas2.getSatir() * kare_boyutu, tas2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(8), tas3.getX(), tas3.getY(), tas3.getSatir() * kare_boyutu, tas3.getSutun() * kare_boyutu, this);
        g.drawImage(resim.yaz_resmi.get(9), zumrut.getX(), zumrut.getY(), zumrut.getSatir() * kare_boyutu, zumrut.getSutun() * kare_boyutu, this);

        g.drawImage(resim.kis_resmi.get(0), agac_karli.getX(), agac_karli.getY(), agac_karli.getSatir() * kare_boyutu, agac_karli.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(0), agac_karli2.getX(), agac_karli2.getY(), agac_karli2.getSatir() * kare_boyutu, agac_karli2.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(0), agac_karli3.getX(), agac_karli3.getY(), agac_karli3.getSatir() * kare_boyutu, agac_karli3.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(1), altin_karli.getX(), altin_karli.getY(), altin_karli.getSatir() * kare_boyutu, altin_karli.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(2), ari_kis.getX(), ari_kis.getY(), ari_kis.getSatir() * kare_boyutu, ari_kis.getSatir() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(2), ari_kis2.getX(), ari_kis2.getY(), ari_kis2.getSatir() * kare_boyutu, ari_kis2.getSatir() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(3), bakir_kis.getX(), bakir_kis.getY(), bakir_kis.getSatir() * kare_boyutu, bakir_kis.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(4), dag_karli.getX(), dag_karli.getY(), dag_karli.getSatir() * kare_boyutu, dag_karli.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(4), dag_karli1.getX(), dag_karli1.getY(), dag_karli1.getSatir() * kare_boyutu, dag_karli1.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(5), duvar_karli.getX(), duvar_karli.getY(), duvar_karli.getSutun() * kare_boyutu, duvar_karli.getSatir() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(5), duvar_karli2.getX(), duvar_karli2.getY(), duvar_karli2.getSutun() * kare_boyutu, duvar_karli2.getSatir() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(5), duvar_karli3.getX(), duvar_karli3.getY(), duvar_karli3.getSutun() * kare_boyutu, duvar_karli3.getSatir() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(6), gumus_karli.getX(), gumus_karli.getY(), gumus_karli.getSatir() * kare_boyutu, gumus_karli.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(7), kus_karli.getX(), kus_karli.getY(), kus_karli.getSutun() * kare_boyutu, kus_karli.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(8), tas_karli.getX(), tas_karli.getY(), tas_karli.getSatir() * kare_boyutu, tas_karli.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(8), tas_karli1.getX(), tas_karli1.getY(), tas_karli1.getSatir() * kare_boyutu, tas_karli1.getSutun() * kare_boyutu, this);
        g.drawImage(resim.kis_resmi.get(9), zumrut_karli.getX(), zumrut_karli.getY(), zumrut_karli.getSatir() * kare_boyutu, zumrut_karli.getSutun() * kare_boyutu, this);

       

        
        
        for (int i = 0; i < kontrol; i++) {
            if (engel1.get(i).getX() < (sutun / 2) * kare_boyutu) {
                g.drawImage(resim.kis_resmi.get(11), engel1.get(i).getX(), engel1.get(i).getY(), engel1.get(i).getSatir() * kare_boyutu, engel1.get(i).getSutun() * kare_boyutu, this);

            } else if (engel1.get(i).getX() >= (sutun / 2) * kare_boyutu) {
                g.drawImage(resim.yaz_resmi.get(10), engel1.get(i).getX(), engel1.get(i).getY(), engel1.get(i).getSatir() * kare_boyutu, engel1.get(i).getSutun() * kare_boyutu, this);
            }
        }
        for (int i = 0; i < yesil.size() - 1; i += 2) {
            g.drawImage(resim.kis_resmi.get(12), yesil.get(i), yesil.get(i + 1), kare_boyutu, kare_boyutu, this);
        }

        g.drawImage(resim.kis_resmi.get(13), karakter.getX(), karakter.getY(), kare_boyutu, kare_boyutu, this);//karakter fotografi

        g.setColor(Color.BLACK);
        for (int y = 0; y <= satir; y++) {
            g.drawLine(0, y * kare_boyutu, sutun * kare_boyutu, y * kare_boyutu);
        }
        for (int x = 0; x <= sutun; x++) {
            g.drawLine(x * kare_boyutu, 0, x * kare_boyutu, satir * kare_boyutu);
        }

       
                g.setColor(Color.BLUE);
                Font originalFont = g.getFont();
                Font boldFont = originalFont.deriveFont(originalFont.getSize() * 1.5f).deriveFont(Font.BOLD);
                g.setFont(boldFont);
                 String text ;
           
                FontMetrics ilker = g.getFontMetrics();
                int textWidth = 390;
                int textHeight = ilker.getHeight()-10;
                int x = getWidth() - textWidth;
                int y = textHeight;
                for(int i=0;i<engel1.size();i++)
                {
                    
                    if(kontrol==i+1)
                    {
                        if(engel1.get(i).getDeger()==0)
                        {
                            text= "Altin sandik "+"("+engel1.get(i).getX()/kare_boyutu+","+engel1.get(i).getY()/kare_boyutu+") konumunda bulundu!";
                            g.drawString(text, x, y);
                        }
                         if(engel1.get(i).getDeger()==1)
                        {
                            text= "Gumus sandik "+"("+engel1.get(i).getX()/kare_boyutu+","+engel1.get(i).getY()/kare_boyutu+") konumunda bulundu!";
                            g.drawString(text, x, y);
                        }
                         if(engel1.get(i).getDeger()==2)
                        {
                            text= "Zumrut sandik "+"("+engel1.get(i).getX()/kare_boyutu+","+engel1.get(i).getY()/kare_boyutu+") konumunda bulundu!";
                            g.drawString(text, x, y);
                        }
                         if(engel1.get(i).getDeger()==3)
                        {
                            text= "Bakir sandik "+"("+engel1.get(i).getX()/kare_boyutu+","+engel1.get(i).getY()/kare_boyutu+") konumunda bulundu!";
                            g.drawString(text, x, y);
                        }  
                    }
                    else
                    {
                         text= "";
                            g.drawString(text, x, y);
                    }
                    
                }
     
    }
    int sayac1 = 0;
    int sayac2 = 0;
    int sayac3 = 0;
    int sayac4 = 0;
    int sayac5=0;
    private void hareketEttir() {
        sayac5++;
        if (sayac < 6) {
            ari.Sag();
            sayac++;
        } else if (6 <= sayac && sayac < 12) {
            ari.Sol();
            sayac++;
            if (sayac == 12) {
                sayac = 0;
            }
        }
        if (sayac1 < 6) {
            ari_kis.Sag();
            sayac1++;

        } else if (6 <= sayac1 && sayac1 < 12) {
            ari_kis.Sol();
            sayac1++;
            if (sayac1 == 12) {
                sayac1 = 0;
            }
        }
        if (sayac2 < 6) {
            ari_kis2.Sag();
            sayac2++;

        } else if (6 <= sayac2 && sayac2 < 12) {
            ari_kis2.Sol();
            sayac2++;
            if (sayac2 == 12) {
                sayac2 = 0;
            }
        }

        if (sayac3 < 6) {
            kus.Yukari();
            sayac3++;
        } else if (6 <= sayac3 && sayac3 < 12) {
            kus.Asagi();
            sayac3++;
            if (sayac3 == 12) {
                sayac3 = 0;
            }
        }
        if (sayac4 < 6) {
            kus_karli.Yukari();
            sayac4++;
        } else if (6 <= sayac4 && sayac4 < 12) {
            kus_karli.Asagi();
            sayac4++;
            if (sayac4 == 12) {
                sayac4 = 0;
            }
        }

        int hedefx = engel1.get(kontrol).getX();
        int hedefy = engel1.get(kontrol).getY();
        for (int i = 0; i < engeller.size(); i++) {
            int engelx = engeller.get(i).getX();
            int engely = engeller.get(i).getY();
            int engele = engeller.get(i).getSutun() * kare_boyutu;
            int engelb = engeller.get(i).getSatir() * kare_boyutu;
            int x = karakter.getX();
            int y = karakter.getY();
            int b = kare_boyutu;

            if ((hedefx > engelx && engelx > x) || (hedefx < engelx && engelx < x))//dağ x ekseninde sandıkla karakter arasındaysa
            {
                if (y >= engely) {
                    if (y - engely < engelb)//karakter dağın alt tarafında ve yakınında mı
                    {
                        if ((engelx - x == b) || (x - engelx == engele))//karakter dağa yapştı mı
                        {
                            if (engely == 0) {
                                karakter.Yukari();
                                return;
                            } else {
                                if (engely > hedefy) {
                                    karakter.Asagi();
                                    return;
                                } else {
                                    karakter.Yukari();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < engeller.size(); i++) {
            int engelx = engeller.get(i).getX();
            int engely = engeller.get(i).getY();
            int engele = engeller.get(i).getSutun() * kare_boyutu;
            int engelb = engeller.get(i).getSatir() * kare_boyutu;
            int x = karakter.getX();
            int y = karakter.getY();
            int b = kare_boyutu;

            if ((hedefy > engely && engely > y) || (hedefy < engely && engely < y))//dağ x ekseninde sandıkla karakter arasındaysa
            {
                if (x >= engelx) {
                    if ((x - engelx) <= engele)//karakter dağın alt tarafında ve yakınında mı
                    {
                        if (engely - y == b || y - engely == engelb)//karakter dağa yapştı mı
                        {
                            if (engelx == 0) {
                                karakter.Sag();
                                return;
                            } else {
                                if (engelx > hedefx) {
                                    karakter.Sol();
                                    return;
                                } else {
                                    karakter.Sag();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (Math.abs(karakter.getX() - hedefx) > Math.abs(karakter.getY() - hedefy)) {
            if (karakter.getX() != hedefx) {
                if (karakter.getX() < hedefx) {
                    karakter.Sag();
                } else {
                    karakter.Sol();
                }
            } else if (karakter.getY() != hedefy) {
                if (karakter.getY() < hedefy) {
                    karakter.Yukari();
                } else {
                    karakter.Asagi();
                }
            }
        } else {
            if (karakter.getY() != hedefy) {
                if (karakter.getY() < hedefy) {
                    karakter.Yukari();
                } else {
                    karakter.Asagi();
                }
            } else if (karakter.getX() != hedefx) {
                if (karakter.getX() < hedefx) {
                    karakter.Sag();
                } else {
                    karakter.Sol();
                }
            }
        }

        yesil.add(karakter.getX());
        yesil.add(karakter.getY());
        
    }

    private void kontrolEt() {
        if (karakter.getX() == engel1.get(kontrol).getX() && karakter.getY() == engel1.get(kontrol).getY()) {
            kontrol++;
        }
        int a = random.nextInt(5);
        String text ="Toplam Alınan Yol: "+sayac5+" birim."+"\n\nOgrenilen Nesneler :\n\nBakir Sandik Kesfedildi! \n Kus Öğrenildi! \n Altin Sandik Kesfedildi!\n Duvar Öğrenildi!"
                + "Agac Öğrenildi! \n Dag Öğrenildi! \n Gumus sandik Kesfedildi! "
                + "\n Tas Öğrenildi!\n  Zumrut Sandik Kesfedildi!"
                + " \n Ari Öğrenildi";
        String text1 ="Toplam Alınan Yol: "+sayac5+" birim."+"\n\nOgrenilen Nesneler :\n\nAgac Öğrenildi! \n Dag Öğrenildi! \n Gumus sandik Kesfedildi! "
                + "\n Tas Öğrenildi!\n  Zumrut Sandik Kesfedildi!"
                + " \n Ari Öğrenildi\n Bakir Sandik Kesfedildi! \n Kus Öğrenildi! \n Altin Sandik Kesfedildi!\n Duvar Öğrenildi!";
        String text2 ="Toplam Alınan Yol: "+sayac5+" birim."+"\n\nOgrenilen Nesneler :\n\n Ari Öğrenildi \n Dag Öğrenildi! \n Agac Öğrenildi!"
                + " \n Bakir Sandik Kesfedildi!\n Tas Öğrenildi!\n Kus Öğrenildi! \n  Zumrut Sandik Kesfedildi!" 
                + "\n Gumus sandik Kesfedildi!\n Altin Sandik Kesfedildi!\n Duvar Öğrenildi!";
          String text3 ="Toplam Alınan Yol: "+sayac5+" birim."+"\n\nOgrenilen Nesneler :\n\n Gumus sandik Kesfedildi! \nBakir Sandik Kesfedildi!  \n Altin Sandik Kesfedildi!\n Duvar Öğrenildi!"
                + "Agac Öğrenildi! \n Dag Öğrenildi!  "
                + "\n Tas Öğrenildi!\n  Zumrut Sandik Kesfedildi!\n Kus Öğrenildi!"
                + " \n Ari Öğrenildi";
        String text4 ="Toplam Alınan Yol: "+sayac5+" birim."+"\n\nOgrenilen Nesneler :\n\n Altin Sandik Kesfedildi!\nAgac Öğrenildi!\n Bakir Sandik Kesfedildi!   "
                + "\n Gumus sandik Kesfedildi!\n Tas Öğrenildi!\n  Zumrut Sandik Kesfedildi!"
                + " \n Ari Öğrenildi\n Dag Öğrenildi! \n Kus Öğrenildi! \n Duvar Öğrenildi!";
       
        if (kontrol == 21) {
            oyunBittiMi = true;
            switch (a) {
                case 0:
                    JOptionPane.showMessageDialog(this, text, "Oyun Bitti!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(this, text1, "Oyun Bitti!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(this, text2, "Oyun Bitti!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                     case 3:
                    JOptionPane.showMessageDialog(this, text3, "Oyun Bitti!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(this, text4, "Oyun Bitti!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    break;
            }
            String msg="";
            
            for(int i=0;i<engel1.size();i++)
            {
                if(engel1.get(i).getDeger()==0)
                {
                    msg=msg+"\n Altın sandik toplandi!" +" ("+engel1.get(i).getX()/kare_boyutu+","+engel1.get(i).getY()/kare_boyutu+") "+ "konumunda bulundu\n";
                }
            }
            for(int i=0;i<engel1.size();i++)
            {
                if(engel1.get(i).getDeger()==1)
                {
                    msg=msg+"\n Gumus sandik toplandi!" +" ("+engel1.get(i).getX()/kare_boyutu+","+engel1.get(i).getY()/kare_boyutu+") "+ "konumunda bulundu\n";
                }
            }
            for(int i=0;i<engel1.size();i++)
            {
                if(engel1.get(i).getDeger()==2)
                {
                    msg=msg+"\n Zumrut sandik toplandi!" +" ("+engel1.get(i).getX()/kare_boyutu+","+engel1.get(i).getY()/kare_boyutu+") "+ "konumunda bulundu\n";
                }
            }
            for(int i=0;i<engel1.size();i++)
            {
                if(engel1.get(i).getDeger()==3)
                {
                    msg=msg+"\n Bakir sandik toplandi!" +" ("+engel1.get(i).getX()/kare_boyutu+","+engel1.get(i).getY()/kare_boyutu+") "+ "konumunda bulundu\n";
                }
            }
             JOptionPane.showMessageDialog(this, msg, "Sandik Konumlari", JOptionPane.INFORMATION_MESSAGE);
            
            
        }
    }

}
