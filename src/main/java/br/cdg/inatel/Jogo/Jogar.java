package br.cdg.inatel.Jogo;

import br.cdg.inatel.Entradas.Entrada;
import br.cdg.inatel.campo.Campo;
import br.cdg.inatel.excessões.BombaException;
import br.cdg.inatel.excessões.EntradaInvalidaException;
import br.cdg.inatel.player.Player;

import java.util.Random;

public class Jogar {
    Entrada entrada =  new Entrada();
    Campo[][] campo = new Campo[0][0];
    Player[] player = new Player[0];
    Random rand = new Random();
    int jogadoresEliminados = 0;
    int numerDeJogadores = 0 ;
    int numeroRodadas = 0;
    
    public int selecionarQuantidadePlayer(){

        do {
            try {
                numerDeJogadores = entrada.numJogadore();
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());

            }

        }while (numerDeJogadores != 2 && numerDeJogadores !=3);
        
        return numerDeJogadores;
    }


    public void criarPlayer(){
        player = new Player[numerDeJogadores];
        if (numerDeJogadores == 2) {
            System.out.println(" ");
            System.out.println("Player 1 entre com seu nome");
            player[0] = new Player(entrada.nomePlayer());
            System.out.println(" ");
            System.out.println("Player 2 entre com seu nome");
            player[1] = new Player(entrada.nomePlayer());
        }
        else if (numerDeJogadores == 3) {
            System.out.println(" ");
            System.out.println("Player 1 entre com seu nome");
            player[0] = new Player(entrada.nomePlayer());
            System.out.println(" ");
            System.out.println("Player 2 entre com seu nome");
            player[1] = new Player(entrada.nomePlayer());
            System.out.println(" ");
            System.out.println("Player 3 entre com seu nome");
            player[2] = new Player(entrada.nomePlayer());
        }       
        
    }
    public void criarCampo(){
        if (numerDeJogadores == 2) {
            campo = new Campo[3][3];
            
            for (int  i= 0;  i < 3  ; i ++) {
                for (int j = 0; j < 3; j++) {
                    campo[i][j] = new Campo(false);
                }
            }
            for (int i = 0; i < 5; i++) {
                int ii = rand.nextInt(3);
                int jj = rand.nextInt(3);
                
                try {
                    campo[ii][jj].adicionarBomba();

                } catch (BombaException e) {
                    i = i - 1;
                }

            }
            /*
            for (int  i= 0;  i < 3  ; i ++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println("Bomba Tem? posiçao"+i+j+"  " +campo[i][j].temBomba);;
                }
            }*/
        }
        else if (numerDeJogadores == 3) {
            campo = new Campo[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    campo[i][j] = new Campo(false);
                }
            }
            for (int i = 0; i < 8; i++) {
                int ii = rand.nextInt(4);
                int jj = rand.nextInt(4);

                try {
                    campo[ii][jj].adicionarBomba();

                } catch (BombaException e) {
                    i = i - 1;
                }

            }
            /*
            for (int  i= 0;  i < 4  ; i ++) {
                for (int j = 0; j < 4; j++) {
                    System.out.println("Bomba Tem? posiçao"+i+j+"  " +campo[i][j].temBomba);;
                }
            }*/
        }
    }
    public void jogando(){
        do {
            numeroRodadas += 1;
            System.out.println("Rodada " + (numeroRodadas));
            System.out.println(" ");
            System.out.println("Posições livres para jogar:");
            if (numerDeJogadores == 2){
                System.out.println("      y    ");
                for (int x = 0 ; x < 3 ; x ++){
                    if (x != 1){
                        System.out.println("  "+campo[x][0].posicaoJaJogada(x, 0)
                                +"  "+campo[x][1].posicaoJaJogada(x, 1)+"  "+campo[x][2].posicaoJaJogada(x, 2));
                    }else{
                        System.out.println("x "+campo[x][0].posicaoJaJogada(x, 0)
                                +"  "+campo[x][1].posicaoJaJogada(x, 1)+"  "+campo[x][2].posicaoJaJogada(x, 2));
                    }
                }
            }
            if (numerDeJogadores == 3){
                System.out.println("      y       ");
                for (int x = 0 ; x < 4 ; x ++){
                    if (x != 2){
                        System.out.println("  "+campo[x][0].posicaoJaJogada(x, 0)
                                +"  "+campo[x][1].posicaoJaJogada(x, 1)+"  "+campo[x][2].posicaoJaJogada(x, 2)+"  "+campo[x][3].posicaoJaJogada(x, 3));
                    }else{
                        System.out.println("x "+campo[x][0].posicaoJaJogada(x, 0)
                                +"  "+campo[x][1].posicaoJaJogada(x, 1)+"  "+campo[x][2].posicaoJaJogada(x, 2)+"  "+campo[x][3].posicaoJaJogada(x, 3));
                    }
                }

            }
            System.out.println(" ");
            for (int j = 0; j < numerDeJogadores; j++){
                System.out.println(player[j].getNome() + " sua vida é de "+player[j].getVida());
            }
            System.out.println(" ");
            for (int i= 0; i < numerDeJogadores; i++){

                if(player[i].getVida() > 0 ){
                    if (jogadoresEliminados != (numerDeJogadores -  1)){
                        for(int p = 0; p < 1; p++){
                            System.out.println(player[i].getNome() + " Escolha a posição x para jogar ");
                            int x = player[i].jogar(numerDeJogadores);
                            System.out.println(player[i].getNome() + " Escolha a posição y para jogar ");
                            int y = player[i].jogar(numerDeJogadores);
                            System.out.println(" ");
                            int dano = campo[x][y].verificaBomba(player[i].getNome());
                            if(dano == -1){
                                p = p - 1;
                            }else{
                                player[i].perderVida(dano);
                                if(player[i].getVida() == 0){
                                    jogadoresEliminados += 1;
                                    System.out.println(player[i].getNome() + " FOI ELIMIDADO :( ");
                                }
                            }

                        }

                    }
                }else
                    System.out.println(player[i].getNome() + " está eliminado e não joga");

            }



        }while(jogadoresEliminados != (numerDeJogadores - 1));
        
    }
    public String quemGanhou(){
        String nome = null;
        for(int i = 0; i< numerDeJogadores; i++){
            if(player[i].getVida() > 0){
               nome = player[i].getNome();
            }
        }
        return nome;
    }

    public boolean jogarNovammente(){
        int numero = 0;
        for (int i = 0; i < 1; i++){
            try {
                numero = entrada.jogarNovamente();

            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());
                i -= 1;
            }

        }
        if (numero == 0){
            return false;
        }else{
            return  true;
        }

    }
    
}
