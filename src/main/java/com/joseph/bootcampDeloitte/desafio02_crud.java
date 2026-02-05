package com.joseph.bootcampDeloitte;

import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    String nome;
    String cpf;
    boolean planoAtivo;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setPlanoAtivo(boolean planoAtivo) {
        this.planoAtivo = planoAtivo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", CPF: " + cpf +
                ", Plano ativo: " + (planoAtivo ? "Sim" : "Não");
    }
}

public class desafio02_crud {

    public static void main(String[] args) {
        // Cria array de clientes
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n========== MENU ==========\n" +
                    "1 - Cadastrar novo cliente\n" +
                    "2 - Ver clientes cadastrados\n" +
                    "3 - Atualizar dados de um cliente\n" +
                    "4 - Excluir cadastro de cliente\n" +
                    "0 - Sair\n" +
                    "==========================\n");

            System.out.print("Digite a opção desejada: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1: // Cadastrar Cliente
                    Cliente novoCliente = new Cliente();

                    System.out.print("Digite o nome do cliente: ");
                    novoCliente.setNome(scanner.nextLine());

                    System.out.print("Digite o CPF do novo cliente: ");
                    novoCliente.setCpf(scanner.nextLine());

                    System.out.print("Cliente em dia? (true/false): ");
                    novoCliente.setPlanoAtivo(scanner.nextBoolean());

                    clientes.add(novoCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2: // Listar clientes
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("Clientes cadastrados: ");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println(i + 1 + " - " + clientes.get(i));
                        }
                    }
                    break;
                case 3: // Atualizar cliente
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("Selecione o cliente para atualizar:");

                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println((i + 1) + " - " + clientes.get(i));
                        }

                        System.out.print("Digite o número do cliente: ");
                        int indice = scanner.nextInt();
                        scanner.nextLine();

                        if (indice < 1 || indice > clientes.size()) {
                            System.out.println("❌ Cliente inválido.");
                        } else {
                            Cliente cliente = clientes.get(indice - 1);

                            System.out.print("Novo nome: ");
                            cliente.setNome(scanner.nextLine());

                            System.out.print("Novo CPF: ");
                            cliente.setCpf(scanner.nextLine());

                            System.out.print("Plano ativo? (true/false): ");
                            cliente.setPlanoAtivo(scanner.nextBoolean());

                            System.out.println("✅ Cliente atualizado com sucesso!");
                        }
                    }
                    break;
                case 4: // Excluir cliente
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("Selecione o cliente para excluir:");

                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println((i + 1) + " - " + clientes.get(i));
                        }

                        System.out.print("Digite o número do cliente: ");
                        int indice = scanner.nextInt();

                        if (indice < 1 || indice > clientes.size()) {
                            System.out.println("❌ Cliente inválido.");
                        } else {
                            clientes.remove(indice - 1);
                            System.out.println("🗑️ Cliente removido com sucesso!");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("❌ Opção inválida.");
            }
        } while (escolha != 0);
        scanner.close();
    }
}