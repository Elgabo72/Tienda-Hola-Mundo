
package Modelo;


public class Categoria {
    int id;
     String nomcat;
     String descat;

    public Categoria() {
    }

    public Categoria(int id, String nomcat, String descat) {
        this.id = id;
        this.nomcat = nomcat;
        this.descat = descat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }

    public String getDescat() {
        return descat;
    }

    public void setDescat(String descat) {
        this.descat = descat;
    }
 
}
