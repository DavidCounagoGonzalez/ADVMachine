
package serializacion2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacion2 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        String[] cod={"p1","p2","p3"};
        String[] desc ={"parafusos","cravos ","tachas"};
        int[] prezo ={3,4,5};
        
        Product prod1= new Product(cod[0],desc[0],prezo[0]);
        Product prod2 = new Product(cod[1],desc[1],prezo[1]);
        Product prod3 = new Product(cod[2],desc[2],prezo[2]);
        
       ObjectOutputStream outp = new ObjectOutputStream (new FileOutputStream("/home/oracle/DAM/serial2.txt"));
       outp.writeObject(prod1);
       outp.writeObject(prod2);
       outp.writeObject(prod3);
       outp.close();
       
       FileInputStream fich = new FileInputStream("/home/oracle/DAM/serial2.txt");
       ObjectInputStream inp = new ObjectInputStream (fich);
       
       Product prodh = null;
       while(fich.available()!=0){
            prodh= (Product) inp.readObject();
            System.out.println(prodh.getCodigo()+ " " + prodh.getDescrición()+ " " + prodh.getPrezo()); 
       }
       
       inp.close();
         
    }
    
}
