/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Erros.ErroTolo;
import Erros.ForaDoAlcanceException;
import Erros.UmPassoDeCadaVezException;
import Poderes.TipoDePoderes.PoderLocalAlvo;
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

        posicionarPersonagem(pers1Jog1, new Dimension2D(3, 3));
        posicionarPersonagem(pers2Jog1, new Dimension2D(3, 7));
    }
    
    public void adicionaPersonagensSegundoAJogar(Personagem pers1Jog2, Personagem pers2Jog2){
        posicionarPersonagem(pers1Jog2, new Dimension2D(15, 3));
        posicionarPersonagem(pers2Jog2, new Dimension2D(15, 7));
    }

    /**
     * @param p personagem que esta tentando se mover
     * @param destino local para onde o personagem deve se mover
     */
    public void andar(Personagem p, Dimension2D destino) {
        int distancia = calculaDistancia(getPosicaoPersonagem(p), destino);
        if (distancia == 1) {
            posicionarPersonagem(p, destino);
        } else if (distancia == 0) {
            throw new ErroTolo("Você acabou de tentar andar para o lugar onde ja estava?\n...\nPor que??");
        } else {
            throw new UmPassoDeCadaVezException("Voce deve andar um quadrante por vez, para poder escolher seu caminho.");
        }

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

    public void poderLocalAlvo(Dimension2D coordenadaOrigem, PoderLocalAlvo poder, Dimension2D coordenadaDestino) {
        int distancia = calculaDistancia(coordenadaOrigem, coordenadaDestino);
        if (distancia <= poder.getAlcance()) {
            Lugar alvo = getTarget(coordenadaDestino);
            poder.usar(alvo);
            alteracoes.put(coordenadaDestino, alvo);
        } else {
            throw new ForaDoAlcanceException("Essa habilidade alcança apenas " + poder.getAlcance() + " quadrantes."
                    + "\n O quadrante que você escolheu esta a " + distancia + " de você.");
        }
    }

    public void atacar(Personagem personagem, Dimension2D destino) {
        Dimension2D origem = posicoesPersonagens.get(personagem);
        if (personagem.getAlcance() >= calculaDistancia(origem, destino)) {
            getTarget(destino).getPersonagem();
        } else {
            throw new ForaDoAlcanceException("O alcance do ataque de seu personagem é " + personagem.getAlcance() + " quadrantes."
                    + "\n Escolha um alvo mais próximo.");
        }
    }

    public Dimension2D getPosicaoPersonagem(Personagem p) {
        return posicoesPersonagens.get(p);
    }

    private int calculaDistancia(Dimension2D coordenadaOrigem, Dimension2D coordenadaDestino) {
        int distanciaVertical = Math.abs((int) coordenadaOrigem.getHeight() - (int) coordenadaDestino.getHeight());
        int distanciaHorizontal = Math.abs((int) coordenadaOrigem.getWidth() - (int) coordenadaDestino.getWidth());
        return distanciaHorizontal + distanciaVertical;
    }

    public Lugar getTarget(Dimension2D d) {
        return d==null?null:mapa[(int) d.getWidth()][(int) d.getHeight()];
    }

    public void atualizar(HashMap<Dimension2D, Lugar> alteracoesMapa, HashMap<Personagem, Dimension2D> novaPosicaoPersonagens) {
        this.posicoesPersonagens = novaPosicaoPersonagens;
        alteracoesMapa.forEach((coordenada, lugar) -> {
            mapa[(int) coordenada.getWidth()][(int) coordenada.getHeight()] = lugar;
        });
    }

    public HashMap<Dimension2D, Lugar> getAlteracoes() {
        return this.alteracoes;
    }

    /**
     * Pega as ultimas alterações feitas no mapa, como itens adicionados
     * ou personagens que se moveram. Exemplo, se um personagem
     * se moveu um quadrante teremos guardados o quadrante de onde ele saiu
     * e o para onde ele foi.
     * 
     * Depois de enviar esse histórico é apagado.
     * 
     * @return hashmap com dimensions referenciando os lugares alterados.
     */
    public HashMap<Dimension2D, Lugar> getAlteracoesAndReset() {
        HashMap paraEnviar = alteracoes;
        alteracoes = new HashMap();
        return paraEnviar;
    }

    public HashMap<Personagem, Dimension2D> getPosicoesPersonagens() {
        return posicoesPersonagens;
    }

}
