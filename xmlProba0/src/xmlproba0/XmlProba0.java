
package xmlproba0;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class XmlProba0{

    public static void main(String[] args) throws IOException, XMLStreamException {
       XmlProba0.xmlCreate();
    }
    
    public static void xmlCreate() throws IOException, XMLStreamException{
        XMLOutputFactory factor = XMLOutputFactory.newInstance();

        XMLStreamWriter streamWriter = factor.createXMLStreamWriter(new FileWriter("/home/oracle/DAM/proba0.xml"));
        
        streamWriter.writeStartDocument("1.0");
        streamWriter.writeStartElement("Autores");
            streamWriter.writeStartElement("autor");
            streamWriter.writeAttribute("codigo", "a1");
                streamWriter.writeStartElement("nome");
                streamWriter.writeCharacters("Alexandre Dumas");
                streamWriter.writeEndElement();
                streamWriter.writeStartElement("titulo");
                streamWriter.writeCharacters("El conde de montecristo");
                streamWriter.writeEndElement();
                streamWriter.writeStartElement("titulo");
                streamWriter.writeCharacters("Los Miserables");
                streamWriter.writeEndElement();
            streamWriter.writeEndElement();
            streamWriter.writeStartElement("autor");
            streamWriter.writeAttribute("codigo", "a2");
                streamWriter.writeStartElement("nome");
                streamWriter.writeCharacters("Fiodor Dostoyevski");
                streamWriter.writeEndElement();
                streamWriter.writeStartElement("titulo");
                streamWriter.writeCharacters("El idiota");
                streamWriter.writeEndElement();
                streamWriter.writeStartElement("titulo");
                streamWriter.writeCharacters("Noches Blancas");
                streamWriter.writeEndElement();
            streamWriter.writeEndElement();
        streamWriter.writeEndElement();
        streamWriter.writeEndDocument();
        
        streamWriter.close();
    }
    
}
