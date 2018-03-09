/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliseumrpg;

import coliseumrpg.Poderes.TiposDeAlvo.Poder;

/**
 *
 * @author Matheus
 */
public abstract class Especialidade {
    protected String nome;
    protected String descricao;
    protected Poder[] poderes;
    
    public Poder[] getPoderes(){
        return this.poderes;
    }
}
