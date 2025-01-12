/*
 * Cristian
 */
package Modelo;


public class Editorial {
    int id;
     String nomedi;
     String diredi;
     String conedi;
     String teledi;
     String coredi;

    public Editorial() {
    }

    public Editorial(int id, String nomedi, String diredi, String conedi, String teledi, String coredi) {
        this.id = id;
        this.nomedi = nomedi;
        this.diredi = diredi;
        this.conedi = conedi;
        this.teledi = teledi;
        this.coredi = coredi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomedi() {
        return nomedi;
    }

    public void setNomedi(String nomedi) {
        this.nomedi = nomedi;
    }

    public String getDiredi() {
        return diredi;
    }

    public void setDiredi(String diredi) {
        this.diredi = diredi;
    }

    public String getConedi() {
        return conedi;
    }

    public void setConedi(String conedi) {
        this.conedi = conedi;
    }

    public String getTeledi() {
        return teledi;
    }

    public void setTeledi(String teledi) {
        this.teledi = teledi;
    }

    public String getCoredi() {
        return coredi;
    }

    public void setCoredi(String coredi) {
        this.coredi = coredi;
    }
     
     
}
