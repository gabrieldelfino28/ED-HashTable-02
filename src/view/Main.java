package view;

import controller.MoradoresControl;
import model.Morador;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MoradoresControl mc = new MoradoresControl();
        String menu = "";
        do {
            menu = JOptionPane.showInputDialog("Menu - Apartamentos\n1- Cadastro\n2- Consulta\n3- Excluir\n9- FIM");
            Morador morador = new Morador();
            try {
                switch (menu) {
                    case "1" -> {
                        morador.numAP = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do Apertamento"));
                        mc.validaNumAP(morador.numAP);
                        morador.nome = JOptionPane.showInputDialog("Informe o nome do morador");
                        morador.modelo = JOptionPane.showInputDialog("Informe o modelo do carro do morador");
                        morador.cor = JOptionPane.showInputDialog("Informe a cor do carro do morador");
                        morador.placa = JOptionPane.showInputDialog("Informe a placa do carro do morador");
                        mc.Cadastro(morador);
                    }
                    case "2" -> {
                        mc.Consulta();
                    }
                    case "3" -> {
                        mc.Excluir();
                    }
                    case "9" -> {
                        System.err.println("Exiting...");
                        System.exit(1);
                    }
                    default -> System.err.println("Opção inválida");
                }
            } catch (Exception err) {

                if (err.getMessage().contains("For input string")) {
                    System.err.println("Erro: Tentativa inválida de inserção de dados,\nTente novamente.");
                } else if (err.getMessage().contains("is null")) {
                    System.err.println("Exiting...");
                    System.exit(1);
                } else {
                    System.err.println(err.getMessage() + "... tente novamente!");
                }
            }
        } while (true);
    }
}
