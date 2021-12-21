package lab4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainAluno {


    public static void main(String[] args) {
        Controle controle = new Controle();


        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, controle, scanner);
        }

    }

    /**
     * Interface responsavel pela interação do usuario com o sistema.
     *
     * @param scanner -> Capturar a opção designada pelo usuario.
     * @return -> funcionalidade escolhida.
     */
    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "Opção-> \n" +
                        "(C)adastrar Aluno\n" +
                        "(E)xibir Aluno\n" +
                        "(N)ovo Grupo\n" +
                        "(A)locar Aluno em um Grupo\n" +
                        "(P)ertinencia do aluno a algum grupo\n" +
                        "(R)egistrar Alunos que Responderam no quadro\n" +
                        "(I)mprimir Alunos que Responderam no quadro\n" +
                        "(V)izualiza os grupos ao qual o aluno pertence\n" +
                        "(S)im, desejo encerrar o sistema\n");
        return scanner.nextLine().toUpperCase();
    }

    private static void comando(String opcao, Controle controle, Scanner scanner) {
        switch (opcao) {
            case "C":
                cadastraAluno(controle, scanner);
                break;
            case "E":
                exibeAluno(controle, scanner);
                break;
            case "N":
                novoGrupo(controle, scanner);
                break;
            case "A":
                alocarAluno(controle, scanner);
                break;
            case "P":
                pertinenteAoGrupo(controle, scanner);
                break;
            case "R":
                registraAlunoQueRespondeu(controle, scanner);
                break;
            case "I":
                imprimeAlunoQueRespondeu(controle);
                break;
            case "V":
                exibeGrupoDeAlunos(controle, scanner);
                break;

            case "S":
                sai();
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }


    /**
     * Cadastra os alunos a partir dos parametros pedidos: matricula, nome e curso.
     *
     * @param controle -> Onde fica salvas as informações dos alunos.
     * @param scanner -> Responsável por pegar as informações do aluno que será registrado no sistema.
     */

    private static void cadastraAluno(Controle controle, Scanner scanner) {

        System.out.println("Matrícula : ");
        String matricula = scanner.nextLine();

        System.out.println("Nome : ");
        String nome = scanner.nextLine();

        System.out.println("Curso : ");
        String curso = scanner.nextLine();

        System.out.println(controle.cadastraAlunoJaRegistrado(matricula, nome, curso));


    }

    /**
     * @param controle -> De onde será pego o aluno.
     * @param scanner -> Pega a matricula "chave", responsável pela indentificação do aluno que será exibido.
     */
    private static void exibeAluno(Controle controle, Scanner scanner) {

        System.out.println("Matrícula : ");
        String matricula = scanner.nextLine();

        System.out.println("Aluno: " + controle.exibeAluno(matricula));


    }

    /**
     * @param controle -> Onde o grupo será criado.
     * @param scanner -> Determina o nome do grupo, se ele terá um tamanho definido ou não.
     */
    private static void novoGrupo(Controle controle, Scanner scanner) {

        System.out.println("Grupo : ");
        String grupo = scanner.nextLine();

        System.out.println("Tamanho : ");
        String tamanho = scanner.nextLine();

        controle.novoGrupo(grupo, tamanho);

        System.out.println("CADASTRO REALIZADO!");

    }

    /**
     * @param controle -> Onde o aluno será adicionado ao grupo desejado.
     * @param scanner -> Pega a matricula do aluno e o grupo ao qual o mesmo deseja pertencer.
     */
    private static void alocarAluno(Controle controle, Scanner scanner) {

        System.out.println("Matricula: ");
        String matricula = scanner.nextLine();

        System.out.println("Grupo: ");
        String grupo = scanner.nextLine();

        controle.alocaAluno(matricula, grupo);

        System.out.println("CADASTRO REALIZADO!");

    }

    /**
     * @param controle -> Onde ele será cadastrado.
     * @param scanner -> Pegará a matrícula do aluno que respondeu as questões no quadro.
     */
    private static void registraAlunoQueRespondeu(Controle controle, Scanner scanner) {

        System.out.println("Matricula: ");
        String matricula = scanner.nextLine();

        controle.registraAlunoQueRespondeu(matricula);

        System.out.println(" ALUNO REGISTRADO! ");

    }

    /**
     * @param controle -> Responsável por imprimir os alunos que responderam.
     */
    private static void imprimeAlunoQueRespondeu(Controle controle) {

        System.out.println("Alunos: ");
        System.out.println(controle.imprimeAlunoQueRespondeu());
    }

    /**
     *
     * @param controle -> Onde será manipulada as informações.
     * @param scanner -> Pega as informações do usuário pra ver se ele pertence ou não ao grupo.
     */
    private static void pertinenteAoGrupo(Controle controle, Scanner scanner) {

        System.out.println("Grupo: ");
        String grupo = scanner.nextLine();

        System.out.println("Matricula: ");
        String matricula = scanner.nextLine();

        if (controle.pertinenteAoGrupo(grupo, matricula)) {
            System.out.println("ALUNO PERTENCE AO GRUPO");

        } else {
            System.out.println("ALUNO NÃO PERTENCE AO GRUPO");

        }
    }

    /**
     *
     * @param controle -> Responsável por achar e exibir os grupos que o saluno pertence.
     * @param scanner -> Pega as informações do usuário pra ver os grupos ao qual o aluno pertence.
     */
    private static void exibeGrupoDeAlunos(Controle controle, Scanner scanner) {

        System.out.println("Aluno(matrícula):");
        String matricula = scanner.nextLine();

        System.out.println("Grupos:");

        System.out.println(controle.exibeGrupoDeAlunos(matricula));


    }

    private static void sai() {
        System.out.println("\nSuave meu sócio, volte sempre S2!!!");
        System.exit(0);
    }
}

