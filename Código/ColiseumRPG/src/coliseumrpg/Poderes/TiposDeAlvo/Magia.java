/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg.Poderes.TiposDeAlvo;

/**
 *
 * @author Matheus
 */
public abstract class Magia extends Poder implements LocalAlvo{
    protected int custo;
    protected Magia(int custo){
        this.custo=custo;
    }
}
