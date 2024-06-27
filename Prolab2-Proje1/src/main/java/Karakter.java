

public class Karakter extends Lokasyon {

    private final String ad;
    private final String id;
    int kare_boyutu=Menu.karegirdi;

    public Karakter(String ad, String id, int x, int y) {
        super(x, y);
        this.ad = ad;
        this.id = id;
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
