package lab4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Objects;


public class Grupo {

    private String grupo;
    private int tamanho;
    /**
     * ArrayList para representar o grupo de alunos com tamanho definido, e o mapa quando não tiver tamanho definido.
     */
    Aluno[] grupoDeAlunos;
    ArrayList<Aluno> grupoSemTamanho;

    /**
     *
     * @param grupo -> grupo composto por alunos
     * @param tamanho -> tamanho que o grupo terá caso seja determinado pelo usuário.
     */
    public Grupo(String grupo, int tamanho) {

        this.grupo = grupo;
        this.tamanho = tamanho;
        this.grupoDeAlunos = new Aluno[tamanho];


    }

    /**
     * Construtor que iniciará a lista caso o grupo tenha tamanho determinado.
     * @param grupo -> Grupo que será composto por alunos.
     */
    public Grupo(String grupo) {

        this.grupo = grupo;
        this.grupoSemTamanho = new ArrayList<>();


    }




    public String getGrupo() {
        return this.grupo;
    }

    /**
     * Metodo para alocar os alunos aos grupos desejados.
     * @param aluno -> O que será adicionado ao grupo.
     */
    public void alocaAluno(Aluno aluno) {
        if (this.tamanho != 0) {

            for (int i = 0; i < tamanho; i++) {
                if (grupoDeAlunos[i] == null) {
                    grupoDeAlunos[i] = aluno;
                    break;

                }

            }
        } else {
            grupoSemTamanho.add(aluno);
        }

    }


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Grupo other = (Grupo) obj;
        return Objects.equals(grupo, other.grupo);
    }


    public int hashCode() {
        return Objects.hash(grupo);
    }

    /**
     * Metodo que checará se o aluno pertence ou não ao grupo.
     * @param aluno -> Será checado se pertence ou não ao grupo.
     * @return -> Se o aluno pertence ou não ao grupo.
     */
    public boolean pertinenteAoGrupo(Aluno aluno) {
        boolean pertence = false;
        if (this.tamanho != 0) {

            for (int i = 0; i < tamanho; i++) {
                if (grupoDeAlunos[i].equals(aluno)) {
                    pertence = true;
                    break;


                }

            }
        }
        return pertence;

    }
}



