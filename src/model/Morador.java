package model;

public class Morador {
    public int numAP;
    public String nome;
    public String modelo;
    public String cor;
    public String placa;

    public Morador() {
        super();
    }

    public Morador(int numAP, String nome, String modelo, String cor, String placa) {
        this.numAP = numAP;
        this.nome = nome;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }

    @Override
    public String toString() {
        return
                "numAP=" + numAP +
                ";nome='" + nome + '\'' +
                ";modelo='" + modelo + '\'' +
                ";cor='" + cor + '\'' +
                ";placa='" + placa + '\'' + "\n";
    }


}
