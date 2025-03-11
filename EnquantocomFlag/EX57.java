package Exercicios.EnquantocomFlag;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Locale;

public class EX57 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "EX57 - Leia o salário e o sexo de vários funcionários." +
                "\nNo final, mostre o total de salários pagos aos homens e o total pago às mulheres." +
                "\nO programa vai perguntar ao usuário se ele quer continuar ou não sempre que ler os dados de um funcionário.");

        JOptionPane.showMessageDialog(null, "1º Passo - Inicializar as variáveis necessárias.");
        double totalSalariosHomens = 0;
        double totalSalariosMulheres = 0;
        boolean continuar = true;

        JOptionPane.showMessageDialog(null, "2º Passo - Criar um laço de repetição para solicitar o salário e o sexo dos funcionários até o usuário decidir parar.");
        while (continuar) {
            JOptionPane.showMessageDialog(null, "2º Passo - Solicitar o salário do funcionário.");
            String salarioStr = JOptionPane.showInputDialog("Digite o salário do funcionário:");

            JOptionPane.showMessageDialog(null, "2º Passo - Converter o número digitado para o formato americano, caso necessário.");
            salarioStr = salarioStr.replace(',', '.');
            double salario = Double.parseDouble(salarioStr);

            JOptionPane.showMessageDialog(null, "2º Passo - Solicitar e validar o sexo do funcionário.");
            String sexo;
            while (true) {
                sexo = JOptionPane.showInputDialog("Digite o sexo do funcionário (M para Masculino, F para Feminino):").toUpperCase();
                if (sexo.equals("M") || sexo.equals("F")) {
                    JOptionPane.showMessageDialog(null, "2º Passo - Sexo validado com sucesso.");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Sexo inválido! Por favor, digite 'M' para Masculino ou 'F' para Feminino.");
                }
            }

            JOptionPane.showMessageDialog(null, "2º Passo - Verificar o sexo do funcionário e acumular o salário no total correspondente.");
            if (sexo.equals("M")) {
                JOptionPane.showMessageDialog(null, "2º Passo - Funcionário do sexo masculino, adicionar salário ao total de homens.");
                totalSalariosHomens += salario;
            } else if (sexo.equals("F")) {
                JOptionPane.showMessageDialog(null, "2º Passo - Funcionário do sexo feminino, adicionar salário ao total de mulheres.");
                totalSalariosMulheres += salario;
            }

            JOptionPane.showMessageDialog(null, "2º Passo - Perguntar ao usuário se deseja cadastrar outro funcionário.");
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro funcionário?", "Continuar", JOptionPane.YES_NO_OPTION);

            JOptionPane.showMessageDialog(null, "2º Passo - Verificar a resposta do usuário.");
            if (resposta == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "2º Passo - Usuário optou por não continuar, encerrando o loop.");
                continuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "3º Passo - Definir o formato da moeda para exibição.");
        Locale Brasil = new Locale("pt", "BR");

        JOptionPane.showMessageDialog(null, "4º Passo - Exibir os resultados finais.");
        JOptionPane.showMessageDialog(null, "Total de salários pagos aos homens: " + NumberFormat.getCurrencyInstance(Brasil).format(totalSalariosHomens) +
                "\nTotal de salários pagos às mulheres: " + NumberFormat.getCurrencyInstance(Brasil).format(totalSalariosMulheres));
    }
}
