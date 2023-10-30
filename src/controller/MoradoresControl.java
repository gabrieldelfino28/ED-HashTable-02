package controller;

import linkedlist.model.LinkedList;
import model.Morador;

import javax.swing.*;

@SuppressWarnings("All")
public class MoradoresControl {
    private LinkedList<Morador>[] tabelaHash = new LinkedList[10];
    public MoradoresControl() {
        for (int i = 0; i < 10; i++) {
            tabelaHash[i] = new LinkedList<>();
        }
    }

    public void Cadastro(Morador m) throws Exception {

        int pos = hashcode(m.numAP);
        tabelaHash[pos].addLast(m);
    }

    public void Consulta() throws Exception{
        String decision = JOptionPane.showInputDialog("Consultar morador especifico ou listar andar?\n1-Morador\n2-Andar");
        switch (decision) {
            case "1" -> {
                int numAP = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do apartamento do morador"));
                validaNumAP(numAP);
                int pos = hashcode(numAP);
                if(!tabelaHash[pos].isEmpty()) {
                    for(int i = 0; i < tabelaHash[pos].size(); i++) {
                        Morador aux = tabelaHash[pos].get(i);
                        if (aux.numAP == numAP) {
                            System.out.println(tabelaHash[pos].get(i));
                        }
                    }
                }
            }
            case "2" -> {
                int andar = Integer.parseInt(JOptionPane.showInputDialog("Informe o andar"));
                if (andar < 1 || andar > 10) {
                    throw new Exception("Andar inválido ou inexistente");
                }
                tabelaHash[andar-1].printList();
            }
            default -> JOptionPane.showMessageDialog(null,"Opção inválida, retornando ao menu principal.");
        }
    }

    public void Excluir() throws Exception{
        int numAP = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do apartamento do morador"));
        validaNumAP(numAP);

        int pos = hashcode(numAP);
        if(!tabelaHash[pos].isEmpty()) {
            for(int i = 0; i < tabelaHash[pos].size(); i++) {
                Morador aux = tabelaHash[pos].get(i);
                if (aux.numAP == numAP) {
                    tabelaHash[pos].remove(i);
                    System.err.println(aux + " removido!");
                }
            }
        }
    }

    private int hashcode(int ap) {
        return (int) (ap / 100) - 1;
    }

    public void validaNumAP(int numAP) throws Exception{
        if (numAP < 101 || numAP > 1099) {
            throw new Exception("Erro: Número de apartamento inválido");
        }
    }
}
