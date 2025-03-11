package Exercicios.EnquantocomFlag;

import javax.swing.*;

public class EX59 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "EX59 - Leia o sexo e a idade de várias pessoas." +
                "\nO programa vai perguntar se o usuário quer continuar ou não após cada entrada." +
                "\nNo final, mostre:" +
                "\n• Qual é a maior idade lida" +
                "\n• Quantos homens foram cadastrados" +
                "\n• Qual é a idade da mulher mais jovem" +
                "\n• Qual é a média de idade entre os homens.");

        JOptionPane.showMessageDialog(null, "1º Passo - Inicializar as variáveis necessárias.");
        int maiorIdade = 0;
        int quantidadeHomens = 0;
        int somaIdadeHomens = 0;
        int quantidadeHomensCadastrados = 0;
        int idadeMulherMaisJovem = Integer.MAX_VALUE;
        boolean continuar = true;

        JOptionPane.showMessageDialog(null, "2º Passo - Criar um laço de repetição para solicitar idade e sexo das pessoas até o usuário optar por não continuar.");
        while (continuar) {
            JOptionPane.showMessageDialog(null, "2º Passo - Solicitar a idade da pessoa.");
            String idadeStr = JOptionPane.showInputDialog("Digite a idade da pessoa:");

            JOptionPane.showMessageDialog(null, "2º Passo - Converter o número digitado para o formato adequado, caso necessário.");
            idadeStr = idadeStr.replace(',', '.');
            int idade = Integer.parseInt(idadeStr);

            JOptionPane.showMessageDialog(null, "2º Passo - Verificar se a idade digitada é maior que a maior idade armazenada.");
            if (idade > maiorIdade) {
                JOptionPane.showMessageDialog(null, "2º Passo - Atualizar a maior idade registrada.");
                maiorIdade = idade;
            }

            JOptionPane.showMessageDialog(null, "2º Passo - Solicitar o sexo da pessoa e validar a entrada.");
            String sexo;
            while (true) {
                sexo = JOptionPane.showInputDialog("Digite o sexo da pessoa (M para Masculino, F para Feminino):").toUpperCase();
                if (sexo.equals("M") || sexo.equals("F")) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Sexo inválido! Por favor, digite 'M' para Masculino ou 'F' para Feminino.");
                }
            }

            JOptionPane.showMessageDialog(null, "3º Passo - Incrementar as variáveis necessárias com base no sexo informado.");

            if (sexo.equals("M")) {
                JOptionPane.showMessageDialog(null, "3º Passo - Contabilizar o número de homens cadastrados e somar suas idades.");
                quantidadeHomens++;
                somaIdadeHomens += idade;
                quantidadeHomensCadastrados++;
            } else if (sexo.equals("F")) {
                JOptionPane.showMessageDialog(null, "3º Passo - Verificar se a idade digitada é menor que a idade da mulher mais jovem registrada.");
                if (idade < idadeMulherMaisJovem) {
                    JOptionPane.showMessageDialog(null, "3º Passo - Atualizar a idade da mulher mais jovem.");
                    idadeMulherMaisJovem = idade;
                }
            }

            JOptionPane.showMessageDialog(null, "3º Passo - Perguntar ao usuário se deseja continuar cadastrando mais pessoas.");
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra pessoa?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "3º Passo - Usuário optou por não continuar, encerrando o laço de repetição.");
                continuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "4º Passo - Calcular a média de idade entre os homens.");
        double mediaIdadeHomens = (quantidadeHomensCadastrados > 0) ? (double) somaIdadeHomens / quantidadeHomensCadastrados : 0;

        JOptionPane.showMessageDialog(null, "5º Passo - Exibir os resultados finais.");
        JOptionPane.showMessageDialog(null, "Maior idade lida: " + maiorIdade + " anos" +
                "\nQuantidade de homens cadastrados: " + quantidadeHomens +
                "\nIdade da mulher mais jovem: " + (idadeMulherMaisJovem == Integer.MAX_VALUE ? "Nenhuma mulher cadastrada" : idadeMulherMaisJovem + " anos") +
                "\nMédia de idade entre os homens: " + String.format("%.2f", mediaIdadeHomens) + " anos");
    }
}
