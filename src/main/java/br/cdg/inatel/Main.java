package br.cdg.inatel;

import br.cdg.inatel.Jogo.Jogar;


public class Main {

    public static void main(String[] args) {


        boolean jogarNovamente = true;

        do {
            Jogar jogar = new Jogar();

            int numerDeJogadores;
            System.out.println("##############################################################################");
            System.out.println(" ");
            System.out.println("Bem Vindo ao Campo Minado, seu objetivo é não morrer e ser o último vivo.");
            System.out.println(" ");
            System.out.println("##############################################################################");
            System.out.println(" ");
            System.out.println("Primeiro escolha o número de jogadores (2 OU 3):" );


            //Selecionando os player
            numerDeJogadores = jogar.selecionarQuantidadePlayer();
            System.out.println("Número de jogadores escolhidos: "+numerDeJogadores);
            //criando os player
            jogar.criarPlayer();
            //criando campo
            jogar.criarCampo();
            //iniciando jogo
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("------------------------------------------------------------------------------- ");
            System.out.println(" ");
            System.out.println("Começando o jogo!!");
            System.out.println("Vida incial de cada player = 5");
            System.out.println("Ao zerar a vida está eliminado");
            System.out.println("O ÚLTMIMO A RESTAR VENCE");
            System.out.println("Bomobonas tiram 4 de vida e bombinhas 2 de vida");
            System.out.println(" ");


            if (numerDeJogadores == 2){
                System.out.println("O campo possui dimensoões 3x3 onde x corresponde a linha e y a coluna.");
                System.out.println(" ");
                System.out.println("------------------------------------------------------------------------------- ");
            }else {
                System.out.println("O campo possui dimensoões 4x4 onde x corresponde a linha e y a coluna.");
                System.out.println(" ");
                System.out.println("------------------------------------------------------------------------------- ");
            }
            jogar.jogando();
            //mostrar o vencedor
            System.out.println(" ");
            System.out.println("PARABÉNS "+ jogar.quemGanhou() + " VOCÊ GANHOUU");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Quer Jogar Novamente?");
            System.out.println("Digite 0 para não e 1 para sim");
            jogarNovamente = jogar.jogarNovammente();


        }while(jogarNovamente);
        System.out.println("OBRIGADO por jogar, espero que tenha gostado e até breve");


    }




}
