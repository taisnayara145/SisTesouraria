
package Model.bean;


public class Prestador {
   
    private String nome;
    private int id;

    

   
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
   
@Override
    public String toString(){
        
        return nome;
    }
    
    
    
}
