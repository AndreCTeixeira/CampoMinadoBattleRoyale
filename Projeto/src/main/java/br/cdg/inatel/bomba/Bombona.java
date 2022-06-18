package br.cdg.inatel.bomba;

public class Bombona extends Bomba {

    public Bombona(String nome, int dano){

        super(nome,dano);
    }

    @Override
    public int tirarVida() {
        return 4;
    }
}
