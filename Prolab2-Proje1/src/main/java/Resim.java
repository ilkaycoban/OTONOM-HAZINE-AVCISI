
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Resim {  
   
    ArrayList<Image> yaz_resmi= new ArrayList<>();
    ArrayList<Image> kis_resmi= new ArrayList<>();

    public Resim() {
        
        yaz_resmi.add(new ImageIcon("agac.png").getImage());    //0 
        yaz_resmi.add(new ImageIcon("altin.png").getImage());   //1
        yaz_resmi.add(new ImageIcon("ari.png").getImage());     //2
        yaz_resmi.add(new ImageIcon("bakir.png").getImage());   //3 
        yaz_resmi.add(new ImageIcon("dag.png").getImage());     //4
        yaz_resmi.add(new ImageIcon("duvar.png").getImage());   //5
        yaz_resmi.add(new ImageIcon("gumus.png").getImage());   //6
        yaz_resmi.add(new ImageIcon("kus.png").getImage());     //7 
        yaz_resmi.add(new ImageIcon("tas.png").getImage());     //8
        yaz_resmi.add(new ImageIcon("zumrut.png").getImage());  //9
        yaz_resmi.add(new ImageIcon("sari.png").getImage());    //10
        yaz_resmi.add(new ImageIcon("mavi.png").getImage());    //11
      
        
        
        kis_resmi.add(new ImageIcon("agac_karli.png").getImage());  //0
        kis_resmi.add(new ImageIcon("altin_karli.png").getImage()); //1
        kis_resmi.add(new ImageIcon("ari_kis.png").getImage());     //2 
        kis_resmi.add(new ImageIcon("bakir_kis.png").getImage());   //3 
        kis_resmi.add(new ImageIcon("dag_karli.png").getImage());   //4
        kis_resmi.add(new ImageIcon("duvar_karli.png").getImage()); //5
        kis_resmi.add(new ImageIcon("gumus_karli.png").getImage()); //6
        kis_resmi.add(new ImageIcon("kus_karli.png").getImage());   //7
        kis_resmi.add(new ImageIcon("tas_karli.png").getImage());   //8
        kis_resmi.add(new ImageIcon("zumrut_karli.png").getImage());//9
        kis_resmi.add(new ImageIcon("karli_arkaplan.png").getImage());//10
        kis_resmi.add(new ImageIcon("mavi.png").getImage());        //11
        kis_resmi.add(new ImageIcon("yesil.png").getImage());       //12
        kis_resmi.add(new ImageIcon("jett2.png").getImage());       //13
       

        
    }
    
    
    
}
