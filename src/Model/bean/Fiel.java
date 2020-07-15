/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

/**
 *
 * @author 4001109296
 */
public class Fiel {
  
    private String nome;
    private int cpf;
    private Celula celula;



    /**
     * @return the nome
     */
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
     * @return the celula
     */
    public Celula getCelula() {
        return celula;
    }

    /**
     * @param celula the celula to set
     */
    public void setCelula(Celula celula) {
        this.celula = celula;
    }

    /**
     * @return the cpf
     */
   
   @Override
    public String toString(){
        
        return nome;
    }

    /**
     * @return the cpf
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}