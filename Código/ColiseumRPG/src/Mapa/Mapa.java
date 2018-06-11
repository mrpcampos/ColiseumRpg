/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Erros.ErroTolo;
import Erros.ForaDoAlcanceException;
import Erros.UmPassoDeCadaVezException;
import NetGames.Time;
import Poderes.TiposDeAlvo.LocalAlvo;
import coliseumrpg.Personagem;
import java.util.HashMap;
import javafx.geometry.Dimension2D;

/**
 *
 * @author Matheus
 */
public class Mapa {

    private HashMap<Dimension2D, Lugar> alteracoes;
    private HashMap<Personagem, Dimension2D> posicoesPersonagens;
    protected Lugar mapa[][];

    public Mapa(Personagem pers1Jog1, Personagem pers2Jog1) {
        this.posicoesPersonagens = new HashMap<>();
        this.alteracoes = new HashMap<>();

        this.mapa = new Lugar[20][12];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = new Lugar();
            }
        }

        posicionarPersonagem(pers1Jog1, new Dimension2D(1, 4));
        posicionarPersonagem(pers2Jog1, new Dimension2D(1, 8));
    }

    /**
     * @param p personagem que esta tentando se mover
     * @param destino local para onde o personagem deve se mover
     * @return numero de quadrantes que essa movimentação gastou
     */
    public int andar(Personagem p, Dimension2D destino) {
        int distancia = calculaDistancia(getPosicaoPersonagem(p), destino);
        if (p.getVelocidade() <= distancia) {
            switch (distancia) {
                case 1:
                    posicionarPersonagem(p, destino);
                    break;
                case 0:
                    throw new ErroTolo("Você acabou de tentar andar para o lugar onde ja estava...\nPor que??");
                default:
                    throw new UmPassoDeCadaVezException("Voce deve andar um quadrante por vez, para poder escolher seu caminho.");
            }
        }
        throw new ForaDoAlcanceException("O personagem não tem movimetação sobrando para andar tão longe.");
    }

    private void posicionarPersonagem(Personagem personagem, Dimension2D destino) {
        Lugar alvo = getTarget(destino);
        Dimension2D origem = posicoesPersonagens.get(personagem);
        Lugar lugarOrigem = getTarget(origem);
        if (lugarOrigem != null) {
            lugarOrigem.desocupar();
            alteracoes.put(origem, lugarOrigem);
        }
        alvo.ocupar(personagem);
        alteracoes.put(destino, alvo);
        posicoesPersonagens.put(personagem, destino);
    }

    public void poderLocalAlvo(Dimension2D origem, LocalAlvo poder, Dimension2D destino) {
        int distancia = calculaDistancia(origem, destino);
        if (distancia <= poder.getAlcance()) {
            Lugar alvo = getTarget(destino);
            poder.usar(alvo);
            alteracoes.put(destino, alvo);
        } else {
            throw new ForaDoAlcanceException("Essa habilidade alcança apenas " + poder.getAlcance() + " quadrantes.\n O quadrante que você escolheu esta a " + distancia + " de você.");
        }
    }

    public Dimension2D getPosicaoPersonagem(Personagem p) {
        return posicoesPersonagens.get(p);
    }

    private int calculaDistancia(Dimension2D origem, Dimension2D destino) {
        int distanciaVertical = Math.abs((int) origem.getHeight() - (int) destino.getHeight());
        int distanciaHorizontal = Math.abs((int) origem.getWidth() - (int) destino.getWidth());
        return distanciaHorizontal + distanciaVertical;
    }

    public Lugar getTarget(Dimension2D d) {
        return mapa[(int) d.getWidth()][(int) d.getHeight()];
    }

    public void atualizar(HashMap<Dimension2D, Lugar> alteracoesMapa, HashMap<Personagem, Dimension2D> novaPosicaoPersonagens) {
        this.posicoesPersonagens = novaPosicaoPersonagens;
        alteracoesMapa.forEach((dimension, lugar) -> {
            mapa[(int) dimension.getWidth()][(int) dimension.getHeight()] = lugar;
        });
    }

    public HashMap<Dimension2D, Lugar> getAlteracoesAndReset() {
        HashMap paraEnviar = alteracoes;
        alteracoes = new HashMap();
        return paraEnviar;
    }

    public HashMap<Personagem, Dimension2D> getPosicoesPersonagens() {
        return posicoesPersonagens;
    }

}
