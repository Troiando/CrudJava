/*
Autor: JP(Troia)
Test Versao
 */
package main;
import model.Pessoas;
import dao.pessoasDAO;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //Classe CRUD
        pessoasDAO pessoas = new pessoasDAO();

        //Classe da tabela pessoa
        Pessoas Pessoa = new Pessoas();

        //Input
        Scanner sc = new Scanner(System.in);

        //Dados
        int id;

        //Menu
        int m = 0;

        do{
            System.out.println("\nMenu \n1-Create \n2-Head\n3-Update \n4-Deletar \n0-Sair");
            m = sc.nextInt();
            switch (m){
                case 1:
                    //Inserir dados
                    System.out.println("Nome: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.println("Idade: ");
                    int idade = sc.nextInt();

                    Pessoa.setNome(nome);
                    Pessoa.setIdade(idade);

                    //Dados Salvos
                    pessoas.save(Pessoa);
                    break;
                case 2:
                    pessoas.head();
                    break;
                case 3:
                    //Atualizar dados da tabela
                    System.out.println("Nome novo");
                    sc.nextLine();
                    String namenovo = sc.nextLine();
                    Pessoa.setNome(namenovo);

                    System.out.println("Idade Nova");
                    int idadeNovo = sc.nextInt();
                    Pessoa.setIdade(idadeNovo);

                    System.out.println("Id");
                    id = sc.nextInt();
                    Pessoa.setId(id);

                    pessoas.update(Pessoa);
                    break;
                case 4:
                    //Deletar Pessoa
                    System.out.println("Id para deletar pessoa");
                    id = sc.nextInt();
                    Pessoa.setId(id);

                    pessoas.delete(Pessoa);
                    break;
            }

        }while(m!=0);

    }
}
