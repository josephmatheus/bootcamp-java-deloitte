package com.joseph.bootcampDeloitte;

import java.util.Scanner;

public class desafio01_trocar_valores {
    public static void main(String[] args) {
        // Receber primeiro valor do usuário
        Scanner primeiroValor = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int a = primeiroValor.nextInt();

        // Receber segundo valor do usuário
        Scanner segundoValor = new Scanner(System.in);
        System.out.print("Digite outro número: ");
        int b = segundoValor.nextInt();

        // Perguntar se o usuário quer que os valores sejam invertidos
        Scanner inputEscolha = new Scanner(System.in);
        System.out.print("Você quer trocar os valores? ");
        String opcaoEscolha = inputEscolha.nextLine();
        if (opcaoEscolha.equals("s") || opcaoEscolha.equals("S") || opcaoEscolha.equals("sim") || opcaoEscolha.equals("Sim")) {
            // Fazer a troca dos valores
            System.out.println("Trocando os valores...");
            int temp = a;
            a = b;
            b = temp;

            // Imprimir valores trocados
            System.out.println("a = " + a); // 10
            System.out.println("b = " + b); // 5
            System.out.println("Valores trocados com sucesso!");
        } else {
            // NÃO Fazer a troca dos valores
            System.out.println("Os valores digitados foram:");
            System.out.println("a = " + a); // 5
            System.out.println("b = " + b); // 10
        }
    }
}