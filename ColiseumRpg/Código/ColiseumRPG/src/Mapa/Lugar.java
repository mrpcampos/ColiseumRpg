/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Poderes.Armadilha;
import Erros.LocalJaPossuiEsseItemException;
import Erros.LocalOcupadoException;
import NetGames.Time;
import Poderes.TipoDePoderes.Colocavel;
import coliseumrpg.Personagem;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class Lugar {

    private Personagem ocupante;
    protected String caminhoIcone;

    private ArrayList<Colocavel> colocaveis;

    public Lugar() {
        this.caminhoIcone = "../resources/CampoVerde.png";
        colocaveis = new ArrayList();
    }

    public Personagem getPersonagem() {
        return ocupante;
    }

    public void destruir() {
        colocaveis.forEach(c -> c.destruir());
    }

    public void ocupar(Personagem p) {
        if (estaOcupado()) {
            throw new LocalOcupadoException("Dois personagens não podem ocupar o mesmo quadrante no espaço ao mesmo tempo!");
        }
        colocaveis.forEach((c) -> {
            c.pisar(p);
        });
        this.ocupante = p;
    }

    public void desocupar() {
        this.ocupante = null;
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
        return colocaveis.stream().filter((c) -> (c.getClass().equals(novo.getClass()) && c.getTime() == novo.getTime())).noneMatch((c) -> (((Armadilha) c).estaFuncional()));
    }

    /**
     * Devolve o icone do lugar para colocar no mapa. O icone de uma lugar vai
     * ser definido primeiro pelo ocupante, depois pelos colocaveis que estão
     * ativos, depois pelos colocaveis destruidos e por fim o campo verde
     * default.
     *
     * @param time Time de quem quer ver o mapa, algumas coisas só são visíveis
     * pelo próprio time.
     * @return O caminho para o icone que deve ser mostrado na tela.
     */
    public String getIcone(Time time) {
        if (estaOcupado()) {
            return getPersonagem().getIcone();
        }
        if (!colocaveis.isEmpty()) {
            Colocavel temp = null;
            for (Colocavel c : colocaveis) {
                if (c.visivelPeloInimigo() != null) {
                    if (temp == null || (c.estaFuncional() && !temp.estaFuncional())) {
                        if (c.visivelPeloInimigo() || c.getTime().equals(time)) {
                            temp = c;
                        }
                    }
                }
            }
            if (temp != null) {
                return temp.getIcon();
            }
        }
        return this.caminhoIcone;
    }

}
