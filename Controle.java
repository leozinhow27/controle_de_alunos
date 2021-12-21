package lab4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Controle {
    /**
     * Mapas responsáveis por guardar os alunos e grupos(sem tamanho específico, que podem ser infinitos)
     * e o "ArrayList", para guardar os grupos com tamanho determinado pelo usúario.
     */
    HashMap<String, Aluno> alunos;
    HashMap<String, Grupo> grupos;
    ArrayList<Aluno> alunosQueRespondem;

    /**
     * Construtor que irá iniciar os mapas e o "ArrayList".
     */
    public Controle() {

        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
        this.alunosQueRespondem = new ArrayList<>();
    }

    /**
     *
     * @param matricula -> Matricula do aluno.
     * @param nome Nome -> do aluno
     * @param curso -> Curso que o aluno faz.
     */
    public void cadastraAluno(String matricula, String nome, String curso) {
        this.alunos.put(matricula, new Aluno(matricula, nome, curso));
    }

    public String cadastraAlunoJaRegistrado(String matricula, String nome, String curso){

        if(this.alunos.containsKey(matricula)) {
            return "Aluno ou matrícula já registrado!";

        }else {

            this.alunos.put(matricula, new Aluno(matricula, nome, curso));
            return "Aluno registrado!";
        }
    }






    /**
     *
     * @param matricula -> Chave de indentificação do aluno.
     * @return -> Caso a matrícula seja nula retorna a mensagem "Aluno não cadastrado.", e não cadastra o aluno.
     */
    public String exibeAluno(String matricula) {

        if (this.alunos.get(matricula) != null) {
            return this.alunos.get(matricula).toString();
        }
        return "Aluno não cadastrado.";


    }

    /**
     * @param grupo -> Grupo que será composto pelos alunos, adicionando os mesmos pela matrícula que será sua chave.

     * @param tamanho -> Responsável por determinar se o tamanho do grupo terá tamanho ou não,  nesse caso abaixo o
     * grupo não terá tamanho determinado então os alunos serão grardados no mapa.
     */
    public void novoGrupo(String grupo, String tamanho) {

        if (tamanho.isEmpty()) {
            this.grupos.put(grupo, new Grupo(grupo));

        } else {

            int tamanhoNum = Integer.parseInt(tamanho);

            this.grupos.put(grupo, new Grupo(grupo, tamanhoNum));



        }
    }

    /**
     * @param matricula -> Responsável por indentificar o aluno que será guardado no grupo.

     * @param grupo -> Mapa onde o aluno será armazenado.
     */

    public void alocaAluno(String matricula, String grupo) {

        Aluno aluno = this.alunos.get(matricula);
        Grupo grupoDeAlunos = this.grupos.get(grupo);
        grupoDeAlunos.alocaAluno(aluno);


    }

    /**
     * Metodo que irá ver
     * @param grupo -> Onde estão armazenados os alunos.
     * @param matricula -> Indentificação dos alunos.
     * @return -> Caso o aluno já pertença ao grupo será retornado uma mensagem ao usuário.
     */
    public boolean pertinenteAoGrupo(String grupo, String matricula) {

        Aluno aluno = this.alunos.get(matricula);
        Grupo grupoDeAlunos = this.grupos.get(grupo);

        return grupoDeAlunos.pertinenteAoGrupo(aluno);
    }

    /**
     * Metodo que vai adicionar os alunos no quadro através do ArrayList que será manipulado.
     * @param matricula -> Indentificação do aluno.
     */
    public void registraAlunoQueRespondeu(String matricula) {

        this.alunosQueRespondem.add(this.alunos.get(matricula));

    }

    /**
     * Metodo que irá imprimir a lista de alunos que respodenram no quadro, com o diferencial de imprimir com ordem já que é uma lista que será manipulada.
     * @return -> Alunos que responderam no quadro.
     */
    public String imprimeAlunoQueRespondeu() {

        String listaAlunosQueRespondemQuadro = "";
        for (int i = 0; i < alunosQueRespondem.size(); i++) {
            Aluno aluno = alunosQueRespondem.get(i);
            listaAlunosQueRespondemQuadro += (i + 1) + ". " + aluno.toString() + "\n";
        }

        return listaAlunosQueRespondemQuadro;
    }

    /**
     *
     * @param matricula -> Indentificação do aluno.
     * @return -> Os grupos ao qual os alunos pertencem.
     */
    public String exibeGrupoDeAlunos(String matricula) {

        String grupoAluno = "";
        Aluno aluno = this.alunos.get(matricula);
        for (Grupo grupo : grupos.values()) {

            if (grupo.pertinenteAoGrupo(aluno)) {
                grupoAluno += "- " + grupo.getGrupo() + "\n";
            }

        }
        return grupoAluno;
    }
}
