import java.util.*;

public class OfertaDeDisciplina {

    protected Disciplina disciplina;
    protected Professor professor;
    protected String horario_inicio;
    protected String horario_final;
    protected Pessoa monitor;
    protected ArrayList<Aluno> ListaAlunos = new ArrayList<Aluno>();

    OfertaDeDisciplina(){

        disciplina = null;
        professor = null;
        horario_inicio = null;
        horario_final = null;
    }

    OfertaDeDisciplina(Disciplina disciplina, Professor professor, String horario_inicio, String horario_final){
        this.disciplina = disciplina;
        this.professor = professor;
        this.horario_inicio = horario_inicio;
        this.horario_final = horario_final;
    }

    public static void oferecerDisciplina(Disciplina disciplina,Professor professor, String horario_inicio, String horario_final) {

        new OfertaDeDisciplina(disciplina,professor,horario_inicio,horario_final);
    }

    public void inscreverAluno(OfertaDeDisciplina oferta, Aluno aluno) {
        oferta.ListaAlunos.add(aluno);
    }

    public int quantosAlunosPossui(OfertaDeDisciplina oferta) {

        return oferta.ListaAlunos.size();
    }

    public static void associarMonitor(OfertaDeDisciplina oferta, Pessoa pessoa) {
        if(podeSerMonitor(Pessoa pessoa, OfertaDeDisciplina oferta) == true) {
            oferta.monitor = pessoa;
        }
        else {
            System.out.println("Essa pessoa não pode ser monitor dessa oferta de disciplina");
        }
    }
}