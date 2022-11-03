
package xmlwriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import serializacion2.Product;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
 


public class XMLWriter {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, XMLStreamException {
        
       FileInputStream fich = new FileInputStream("/home/oracle/DAM/serial2.txt");
       ObjectInputStream inp = new ObjectInputStream (fich);
    
       Product prodh = null;
       while(fich.available()!=0){
            prodh= (Product) inp.readObject();
            System.out.println(prodh.getCodigo()+ " " + prodh.getDescrición()+ " " + prodh.getPrezo());
            XMLWriter.jaxbObjectToXML(prodh);
       }
       
       inp.close();
        
    }
    private static void jaxbObjectToXML(Product producto) 
  {
      try{
          JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
           
          Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
          
          File fich = new File("/home/oracle/DAM/products.xml");
 
          jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
          StringWriter sw = new StringWriter();
          
          jaxbMarshaller.marshal(producto, fich);
          jaxbMarshaller.marshal(producto, sw);
           
          String xmlContent = sw.toString();
          System.out.println( xmlContent );
 
      } catch (JAXBException e) {
          System.out.println(e);
      }
  }
    
}


