package br.cdg.inatel.Entradas;

import br.cdg.inatel.excessões.EntradaInvalidaException;


import java.util.Objects;
import java.util.Scanner;

public class Entrada {

    private String In;
    private int numero;

    Scanner entrada = new Scanner(System.in);

    public int numJogadore() throws EntradaInvalidaException {

        In = entrada.next();

        if(!Objects.equals(In, "2") && !Objects.equals(In, "3")){

            throw new EntradaInvalidaException("Número de player Inválido, Tente novamente");

        }else{
            numero = Integer.parseInt(In);
            return numero;
        }

    }
    public String nomePlayer(){

        In = entrada.next();
        return In;
    }

    public int posicaoJogada(int numJogadores) throws EntradaInvalidaException{

        In = entrada.next();


        if (numJogadores == 2 ){

            if (!Objects.equals(In, "0") && !Objects.equals(In, "1") && !Objects.equals(In, "2"))    {
                throw new EntradaInvalidaException("Posição inválida, TENTE NOVAMENTE A ÚLTIMA COORDENADA");
            }
        }
        if (numJogadores == 3 ){

            if (!Objects.equals(In, "0") && !Objects.equals(In, "1") && !Objects.equals(In, "2") && !Objects.equals(In, "3"))    {
                throw new EntradaInvalidaException("Posição inválida, TENTE NOVAMENTE A ÚLTIMA COORDENADA");
            }
        }
        numero = Integer.parseInt(In);
        return numero;

    }
    public int jogarNovamente() throws EntradaInvalidaException{

        In = entrada.next();

        if(!Objects.equals(In, "0") && !Objects.equals(In, "1")){

            throw new EntradaInvalidaException("Não entendi o que quis dizer, DIGITE 0 PARA NÃO E 1 PARA SIM");

        }else{
            numero = Integer.parseInt(In);
            return numero;
        }




    }




}
