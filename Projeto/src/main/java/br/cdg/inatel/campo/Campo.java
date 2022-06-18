package br.cdg.inatel.campo;

import br.cdg.inatel.bomba.Bomba;
import br.cdg.inatel.bomba.Bombinha;
import br.cdg.inatel.bomba.Bombona;
import br.cdg.inatel.excessões.BombaException;

import java.util.Random;

public class Campo {

    private Bomba bomba;
    public boolean temBomba;
    Random rand = new Random();
    private boolean posicaoJogada = false;

    public Campo(boolean temBomba){
        this.temBomba = temBomba;
    }

    public void adicionarBomba() throws BombaException {

        if (temBomba){
            throw new BombaException("Impossivel adicionar bomba");
        }else{
            int sorteio = rand.nextInt(2);
            if (sorteio == 0){
                bomba = new Bombinha("Bombinha", 2);
            }else {
                bomba = new Bombona("Bombona", 4);
            }
            temBomba = true;

        }
    }
    public int verificaBomba(String nome) {
        int dano;
        if (posicaoJogada){
            System.out.println("Posição já jogada, tente novamente em outra posição");
            System.out.println(" ");
            dano = -1;
        }else{
            if (temBomba ){
                posicaoJogada = true;
                dano =  bomba.tirarVida();
                System.out.println(nome + " você acertou uma "+ bomba.getNome() + ", seu dano foi de "+dano);
                System.out.println(" ");
            }else{
                posicaoJogada = true;
                dano  = 0;
                System.out.println("Você escolheu uma posição onde não sofreu danos :) ");
                System.out.println(" ");
            }

        }

        return dano;
    }
    public String posicaoJaJogada(int x, int y){
        String retorno ="--";
        if (!posicaoJogada) retorno = Integer.toString(x) + Integer.toString(y);

        return retorno;

    }






}
