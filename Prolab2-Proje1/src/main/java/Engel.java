public class Engel extends Lokasyon{

private int satir;
private int sutun;
private int deger;
int kare_boyutu=Menu.karegirdi;
public static int ase =0;

    public Engel( int x, int y, int satir, int sutun, int deger) {
        super(x, y);
        this.satir = satir;
        this.sutun = sutun;
        this.deger = deger;
    }
    public Engel(int x, int y,int satir, int sutun ) {
        super(x, y);
        this.satir = satir;
        this.sutun = sutun;
       
 }

    
    public int getSatir() {
        return satir;
    }

    public void setSatir(int satir) {
        this.satir = satir;
    }

    public int getSutun() {
        return sutun;
    }

    public void setSutun(int sutun) {
        this.sutun = sutun;
    }

    public int getDeger() {
        return deger;
    }

    public void setDeger(int deger) {
        this.deger = deger;
    }
   
    
    
    public void Sag()
    {
    setX(getX()+kare_boyutu);
    }
    public void Sol()
    {
    setX(getX()-kare_boyutu);
    }
    public void Yukari()
    {
    setY(getY()+kare_boyutu);    
    }
    public void Asagi()
    {
    setY(getY()-kare_boyutu);
    }
   
   
  
    
}
