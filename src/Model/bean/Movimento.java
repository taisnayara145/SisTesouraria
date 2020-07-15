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
public class Movimento {
    private int codigo;
    private double saldototal;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the saldototal
     */
    public double getSaldototal() {
        return saldototal;
    }

    /**
     * @param saldototal the saldototal to set
     */
    public void setSaldototal(double saldototal) {
        this.saldototal = saldototal;
    }
}
