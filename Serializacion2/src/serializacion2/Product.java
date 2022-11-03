
package serializacion2;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Products", propOrder = {
    "product"
})
@XmlRootElement(name = "Products")
public class Product implements Serializable{
    
    @XmlElement(name = "product", required = true)
    private String codigo;
    private String descrición;
    private double prezo;

    public Product() {
    }
    public Product(String codigo, String descrición, double prezo) {
        this.codigo = codigo;
        this.descrición = descrición;
        this.prezo = prezo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescrición() {
        return descrición;
    }

    public void setDescrición(String descrición) {
        this.descrición = descrición;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }
    
    
    
}
