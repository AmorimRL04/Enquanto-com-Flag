package Exercicios.EnquantocomFlag;

import javax.swing.*;

public class EX58 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "EX58 - Leia a idade de vários alunos de uma turma." +
                "\nO programa vai parar quando for digitada a idade 999." +
                "\nNo final, mostre quantos alunos existem na turma e qual é a média de idade do grupo.");

        JOptionPane.showMessageDialog(null, "1º Passo - Inicializar as variáveis necessárias.");
        int totalIdade = 0;
        int contadorAlunos = 0;
        boolean continuar = true;

        JOptionPane.showMessageDialog(null, "2º Passo - Criar um laço de repetição para solicitar a idade dos alunos até que seja digitado 999.");
        while (continuar) {
            JOptionPane.showMessageDialog(null, "2º Passo - Solicitar a idade do aluno.");
            String idadeStr = JOptionPane.showInputDialog("Digite a idade do aluno (digite 999 para sair):");

            JOptionPane.showMessageDialog(null, "2º Passo - Converter o número digitado para o formato adequado, caso necessário.");
            idadeStr = idadeStr.replace(',', '.');
            int idade = Integer.parseInt(idadeStr);

            JOptionPane.showMessageDialog(null, "2º Passo - Verificar se a idade digitada é 999 para interromper o programa.");
            if (idade == 999) {
                JOptionPane.showMessageDialog(null, "2º Passo - Idade 999 detectada, encerrando o laço de repetição.");
                break;
            }

            JOptionPane.showMessageDialog(null, "2º Passo - Adicionar a idade digitada ao total de idades.");
            totalIdade += idade;

            JOptionPane.showMessageDialog(null, "2º Passo - Incrementar o contador de alunos.");
            contadorAlunos++;
        }

        JOptionPane.showMessageDialog(null, "3º Passo - Calcular a média de idade do grupo.");
        double mediaIdade = (contadorAlunos > 0) ? (double) totalIdade / contadorAlunos : 0;

        JOptionPane.showMessageDialog(null, "4º Passo - Exibir os resultados finais.");
        JOptionPane.showMessageDialog(null, "Número de alunos na turma: " + contadorAlunos +
                "\nMédia de idade do grupo: " + String.format("%.2f", mediaIdade) + " anos");
    }
}
