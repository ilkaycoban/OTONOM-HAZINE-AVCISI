
import java.util.ArrayList;
import java.util.Random;
public class RastgeleYaz {

    Random random = new Random();
    
    ArrayList<Integer> yazx =new ArrayList<>();
    ArrayList<Integer> yazy =new ArrayList<>();
     ArrayList<Integer> kisx =new ArrayList<>();
    ArrayList<Integer> kisy =new ArrayList<>();
   
    public RastgeleYaz() {
        
      while(kisx.size()<30)
      {
          
            int x=random.nextInt( (Menu.sutungirdi / 2)-7);
            int y=random.nextInt(Menu.satirgirdi-7)+1;
             int kontrol=0;
            
     
                  for (int i = 0; i < kisx.size(); i++) 
                  {
                        int x2 = kisx.get(i);
                        int y2 = kisy.get(i);

                      if (Math.abs(x - x2) <= 7 && Math.abs(y- y2) <= 7) {
                         kontrol=1;
                      }
                  }
                  if(kontrol==0)
                  {
                      kisx.add(x);
                      kisy.add(y);
                  }
      }
      
       while(yazx.size()<30)
      {
            int a=( Menu.sutungirdi / 2);
            int x=random.nextInt(a-7) +a;
            int y=random.nextInt(Menu.satirgirdi-7)+1;
            int kontrol=0;
            
     
                  for (int i = 0; i < yazx.size(); i++) 
                  {
                        int x2 = yazx.get(i);
                        int y2 = yazy.get(i);

                      if (Math.abs(x - x2) <= 7 && Math.abs(y- y2) <= 7) {
                         kontrol=1;
                      }
                  }
                  if(kontrol==0)
                  {
                      yazx.add(x);
                      yazy.add(y);
                  }
      }

        

    }

    
    
}
