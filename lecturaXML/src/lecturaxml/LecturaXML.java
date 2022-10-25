
package lecturaxml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class LecturaXML {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        LecturaXML();
    }
    
    public static void LecturaXML() throws FileNotFoundException, XMLStreamException{
        
        XMLInputFactory factory = XMLInputFactory.newInstance();
        
        XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("/home/oracle/DAM/proba0.xml"));

        
        while (reader.hasNext()){
            int evento = reader.next();
            
            switch(evento){
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println(reader.getLocalName());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println(reader.getLocalName());
                    break;
                case XMLStreamConstants.ATTRIBUTE:
                    System.out.println(reader.getAttributeValue(1));
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.println(reader.getText());
                    break;
            }
           
            
        }
        reader.close();
        
    }
    
}
