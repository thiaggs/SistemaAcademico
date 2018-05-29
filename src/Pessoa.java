import java.util.*;

abstract class  Pessoa {

    protected String nome;
    // Data de nascimento
    protected int dia;
    protected int mes;
    protected int ano;

    Pessoa(){ //Construtor base da superclasse
        nome = "Não informado";
        dia = 0;
        mes = 0;
        ano = 0;
    }

    Pessoa(String nome, int dia, int mes, int ano){ //Construtor da superclasse
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public abstract void podeSerMonitor();
}