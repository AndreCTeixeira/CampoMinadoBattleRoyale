package br.cdg.inatel.bomba;

public abstract class Bomba {
    
    protected String nome;
    protected int dano;

    public Bomba(String nome, int dano) {
         this.nome = nome;
         this.dano = dano;

    }


    public int tirarVida(){
        
        return dano;
    }

    public String getNome() {
        return nome;
    }
}
