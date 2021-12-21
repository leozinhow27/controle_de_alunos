package lab4;
import java.util.Objects;
public class Aluno {

    private String matricula;
    private String nome;
    private String curso;



    public Aluno(String matricula, String nome, String curso) {

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;

    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        return Objects.equals(matricula, other.matricula);
    }


    public int hashCode() {
        return Objects.hash(matricula);
    }


    public String toString() {
        return matricula + " - " + nome + " - " + curso;

    }


}


