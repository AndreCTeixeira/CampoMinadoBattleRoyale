package br.cdg.inatel.player;

import br.cdg.inatel.Entradas.Entrada;
import br.cdg.inatel.excessões.EntradaInvalidaException;

public class Player {
    private final String nome;
    private int vida = 5;
    Entrada entrada = new Entrada();

    public Player(String nome){
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }

    public int jogar(int numeroJogadores) {

        int posicao;
        try {
            posicao = entrada.posicaoJogada(numeroJogadores);

        } catch (EntradaInvalidaException e) {
            System.out.println(e.getMessage());
            posicao = jogar(numeroJogadores);
        }

        return posicao;
    }
    public void perderVida(int dano){

        this.vida -=  dano;
        if(this.vida < 0 ){
            vida = 0;
        }
    }

}
