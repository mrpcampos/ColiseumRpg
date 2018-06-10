/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mago;

import Mapa.Lugar;
import Poderes.TiposDeAlvo.LocalAlvo;
import Poderes.TiposDeAlvo.Poder;

/**
 *
 * @author Matheus
 */
public abstract class Magia extends Poder implements LocalAlvo{
    protected int custo;
    protected int alcance;
    protected Magia(String nome, String descricao, int custo, int alcance){
        super(nome, descricao);
        this.custo=custo;
        this.alcance=alcance;
    }

    @Override
    public int getAlcance() {
        return this.alcance;
    }
    
}
