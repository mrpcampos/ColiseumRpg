/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Mago;

import Erros.OutOfManaException;
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
    protected Mago caster;
    protected Magia(String nome, String descricao, int custo, int alcance, Mago caster){
        super(nome, descricao);
        this.custo=custo;
        this.alcance=alcance;
        this.caster=caster;
    }

    @Override
    public int getAlcance() {
        return this.alcance;
    }
    
    protected void temManaSuficiente(Mago caster){
        if(caster.getMana()<custo)
            throw new OutOfManaException("Ops, parece que você não tem mais mana para usar essa habilidade.");
    }
}
