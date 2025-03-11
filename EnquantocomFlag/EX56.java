package Exercicios.EnquantocomFlag;

import javax.swing.*;

public class EX56 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "EX56 - Leia vários números pelo teclado e mostre no final o somatório entre eles." +
                "\nO programa será interrompido quando o número 1111 for digitado.");

        JOptionPane.showMessageDialog(null, "1º Passo - Inicializar as variáveis necessárias.");
        int soma = 0;
        int numero;
        String numerosDigitados = "";

        JOptionPane.showMessageDialog(null, "2º Passo - Criar um laço de repetição para ler os números até o usuário digitar 1111.");
        while (true) {
            JOptionPane.showMessageDialog(null, "2º Passo - Solicitar um número ao usuário.");
            String numeroStr = JOptionPane.showInputDialog("Digite um número (digite 1111 para sair):");

            JOptionPane.showMessageDialog(null, "2º Passo - Converter o número digitado para o formato correto.");
            numeroStr = numeroStr.replace(',', '.');
            numero = Integer.parseInt(numeroStr);

            JOptionPane.showMessageDialog(null, "2º Passo - Verificar se o número digitado é 1111 para interromper o loop.");
            if (numero == 1111) {
                JOptionPane.showMessageDialog(null, "2º Passo - Número 1111 foi digitado. Sair do laço de repetição.");
                break;
            }

            JOptionPane.showMessageDialog(null, "2º Passo - Somar o número digitado à variável soma.");
            soma += numero;

            JOptionPane.showMessageDialog(null, "2º Passo - Concatenar o número digitado na string de números.");
            numerosDigitados += numero + " ";
        }

        JOptionPane.showMessageDialog(null, "3º Passo - Exibir o resultado final.");
        JOptionPane.showMessageDialog(null, "Os números digitados foram: " + numerosDigitados +
                "\nO somatório dos números digitados é: " + soma);
    }
}
