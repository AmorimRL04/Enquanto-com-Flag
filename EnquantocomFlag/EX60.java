package Exercicios.EnquantocomFlag;

import javax.swing.*;

public class EX60 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "EX60 - Leia o nome, a idade e o sexo de várias pessoas." +
                "\nO programa vai perguntar se o usuário quer continuar após cada entrada." +
                "\nNo final, mostre:" +
                "\n• O nome da pessoa mais velha" +
                "\n• O nome da mulher mais jovem" +
                "\n• A média de idade do grupo" +
                "\n• Quantos homens têm mais de 30 anos" +
                "\n• Quantas mulheres têm menos de 18 anos.");

        JOptionPane.showMessageDialog(null, "1º Passo - Inicializar as variáveis necessárias.");
        String nomeMaisVelho = "";
        int idadeMaisVelha = 0;
        String nomeMulherMaisJovem = "";
        int idadeMulherMaisJovem = Integer.MAX_VALUE;
        int somaIdades = 0;
        int quantidadePessoas = 0;
        int homensMaisDe30 = 0;
        int mulheresMenosDe18 = 0;
        boolean continuar = true;
        boolean cadastrouMulher = false;

        JOptionPane.showMessageDialog(null, "2º Passo - Criar um laço de repetição para solicitar os dados das pessoas até o usuário optar por não continuar.");
        while (continuar) {
            JOptionPane.showMessageDialog(null, "2º Passo - Solicitar o nome da pessoa.");
            String nome = JOptionPane.showInputDialog("Digite o nome da pessoa:");

            JOptionPane.showMessageDialog(null, "2º Passo - Solicitar e validar a idade da pessoa.");
            int idade;
            while (true) {
                try {
                    String idadeStr = JOptionPane.showInputDialog("Digite a idade de " + nome + ":");
                    idade = Integer.parseInt(idadeStr);
                    if (idade >= 0) {
                        break;
                    }
                    JOptionPane.showMessageDialog(null, "Idade inválida! Digite um número inteiro positivo.");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número inteiro.");
                }
            }

            JOptionPane.showMessageDialog(null, "2º Passo - Solicitar e validar o sexo da pessoa.");
            String sexo;
            while (true) {
                sexo = JOptionPane.showInputDialog("Digite o sexo de " + nome + " (M para Masculino, F para Feminino):").toUpperCase();
                if (sexo.equals("M") || sexo.equals("F")) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Sexo inválido! Por favor, digite 'M' para Masculino ou 'F' para Feminino.");
                }
            }

            JOptionPane.showMessageDialog(null, "3º Passo - Verificar se a idade informada é maior que a maior idade registrada.");
            if (idade > idadeMaisVelha) {
                JOptionPane.showMessageDialog(null, "3º Passo - Atualizar a maior idade e o nome da pessoa mais velha.");
                idadeMaisVelha = idade;
                nomeMaisVelho = nome;
            }

            JOptionPane.showMessageDialog(null, "4º Passo - Verificar se a pessoa cadastrada é do sexo feminino.");
            if (sexo.equals("F")) {
                cadastrouMulher = true;
                JOptionPane.showMessageDialog(null, "4º Passo - Verificar se a idade informada é menor que a idade da mulher mais jovem registrada.");
                if (idade < idadeMulherMaisJovem) {
                    JOptionPane.showMessageDialog(null, "4º Passo - Atualizar a idade e o nome da mulher mais jovem.");
                    idadeMulherMaisJovem = idade;
                    nomeMulherMaisJovem = nome;
                }

                JOptionPane.showMessageDialog(null, "4º Passo - Verificar se a idade informada é menor que 18 anos.");
                if (idade < 18) {
                    JOptionPane.showMessageDialog(null, "4º Passo - Incrementar a quantidade de mulheres com menos de 18 anos.");
                    mulheresMenosDe18++;
                }
            }

            JOptionPane.showMessageDialog(null, "5º Passo - Verificar se a pessoa cadastrada é do sexo masculino e tem mais de 30 anos.");
            if (sexo.equals("M") && idade > 30) {
                JOptionPane.showMessageDialog(null, "5º Passo - Incrementar a quantidade de homens com mais de 30 anos.");
                homensMaisDe30++;
            }

            JOptionPane.showMessageDialog(null, "6º Passo - Acumular a idade total e aumentar o contador de pessoas cadastradas.");
            somaIdades += idade;
            quantidadePessoas++;

            JOptionPane.showMessageDialog(null, "7º Passo - Perguntar ao usuário se deseja continuar cadastrando mais pessoas.");
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra pessoa?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "7º Passo - Usuário optou por não continuar, encerrando o laço de repetição.");
                continuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "8º Passo - Calcular a média de idade do grupo.");
        double mediaIdade = (quantidadePessoas > 0) ? (double) somaIdades / quantidadePessoas : 0;

        JOptionPane.showMessageDialog(null, "9º Passo - Exibir os resultados finais.");
        JOptionPane.showMessageDialog(null, "Nome da pessoa mais velha: " + nomeMaisVelho + " (" + idadeMaisVelha + " anos)" +
                "\nNome da mulher mais jovem: " + (cadastrouMulher ? nomeMulherMaisJovem + " (" + idadeMulherMaisJovem + " anos)" : "Nenhuma mulher cadastrada") +
                "\nMédia de idade do grupo: " + String.format("%.2f", mediaIdade) + " anos" +
                "\nQuantidade de homens com mais de 30 anos: " + homensMaisDe30 +
                "\nQuantidade de mulheres com menos de 18 anos: " + mulheresMenosDe18);
    }
}
