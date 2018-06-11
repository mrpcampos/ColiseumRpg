/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Classes.Cacador.Armadilha;
import Erros.LocalJaPossuiEsseItemException;
import Erros.LocalOcupadoException;
import Poderes.TipoDePoderes.Colocavel;
import coliseumrpg.Personagem;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class Lugar {

    private Personagem ocupante;
    private ArrayList<Colocavel> colocaveis;

    public Personagem getPersonagem() {
        return ocupante;
    }

    public void destruir() {
        colocaveis.forEach(c -> c.destruir());
    }

    public void ocupar(Personagem p) {
        if (estaOcupado()) {
            throw new LocalOcupadoException("Dois personagens nãp podem ocupar o mesmo quadrante no espaço ao mesmo tempo!");
        }
        for(Colocavel c: colocaveis){
            c.pisar(p);
        }
        this.ocupante=p;
    }
    
    public void desocupar(){
        this.ocupante=null;
    }

    public void colocar(Colocavel c) throws LocalJaPossuiEsseItemException {
        if (!estaOcupado() && !disponivelParaColocavel(c)) {
            colocaveis.add(c);
            return;
        }
        throw new LocalJaPossuiEsseItemException("Você ja colocou uma armadilha nesse quadrante.");
    }

    public boolean estaOcupado() {
        return ocupante != null;
    }

    private boolean disponivelParaColocavel(Colocavel novo) {
        boolean b = true;
        for (Colocavel c : colocaveis) {
            if (c.getClass().equals(novo.getClass()) && c.getTime() == novo.getTime()) {
                if (((Armadilha) c).estaFuncional()) {
                    return false;
                }
            }
        }
        return b;
    }

}
