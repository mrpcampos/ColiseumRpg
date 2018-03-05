/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Erros.LocalJaPossuiEsseItemException;
import Erros.LocalOcupadoException;
import coliseumrpg.Poderes.TiposDeAlvo.Colocavel;
import coliseumrpg.Personagem;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class Lugar {
    
    private Personagem ocupante;
    private ArrayList<Colocavel> objetos;

    public Personagem getPersonagem() {
        return ocupante;
    }

    public void destruir() {
        objetos.clear();
    }
    
    public void passar(Personagem p) throws LocalOcupadoException{
        if(verificaOcupado()){
            throw new LocalOcupadoException();
        }
    }
    
    public void ocupar(Personagem p){
        
    }
    
    public void colocar(Colocavel c) throws LocalJaPossuiEsseItemException{
        if(verificaOcupado() && verificaDisponobilidadeParaColocavel(c)){
            objetos.add(c);
            return;
        }
        throw new LocalJaPossuiEsseItemException();
    }
    
    private boolean verificaOcupado(){
        return ocupante!=null;
    }

    private boolean verificaDisponobilidadeParaColocavel(Colocavel novo) {
        boolean b = true;
        for(Colocavel c: objetos){
            if (c.getClass().equals(novo.getClass())){
                return false;
            }
        }
        return b;
    }
    
}
