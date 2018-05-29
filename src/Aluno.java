import java.util.*;

class Aluno extends Pessoa { // Subclasse Aluno da superclasse Pessoa

    protected String login;
    protected String curso;
    protected Professor professor_ori;
    protected int ano_aluno;
    protected int semestre_aluno;
    protected int matricula;
    protected ArrayList<Aluno> afilhados = new ArrayList<Aluno>();

    Aluno(){ // Cosntrutor base da subclasse Aluno
        login = null;
        curso = null;
        professor_ori = null;
        ano_aluno = 0;
        semestre_aluno = 0;
        matricula = 0;

    }

    // Construtor para quando o aluno não tem um professor orientador
    Aluno(String nome, int dia, int mes, int ano,String login, String curso, int ano_aluno, int semestre_aluno, int matricula){
        super(nome,dia,mes,ano);
        this.login = login;
        this.curso = curso;
        this.ano_aluno = ano_aluno;
        this.semestre_aluno = semestre_aluno;
        this.matricula = matricula;
    }

    //Construtor para quando o aluno tem um professor orientador
    Aluno(String nome,int dia,int mes,int ano,String login, String curso,Professor professor_ori, int ano_aluno, int semestre_aluno, int matricula){
        super(nome,dia,mes,ano);
        this.login = login;
        this.curso = curso;
        this.professor_ori = professor_ori;
        this.ano_aluno = ano_aluno;
        this.semestre_aluno = semestre_aluno;
        this.matricula = matricula;
    }

    //Método para juntar o login a string de email
    public String login_to_email(String login) {
        String email;

        email = (login+"@uniriotec.br");
        return email;
    }

    // Método que recebe os alunos e imprime seus emails
    public static void impressao_email(Aluno aluno) {
        String email = aluno.login_to_email(aluno.login);

        System.out.println(aluno.nome+" - "+email);
    }

    // Método que testa se o aluno em questão pode apadrinhar o outro, se pode, faz
    public void apadrinhar(Aluno afilhado){

        if( calcula_qnt_periodos() - afilhado.calcula_qnt_periodos() > 3){
            System.out.println("Você não pode apadrinhar esse aluno pois a diferença de periodo acadêmico é muito grande");
        }

        else{
            afilhados.add(afilhado);
        }
    }

    //Método para calcular a quantidade de perídos, baseado no ano e semestre de ingressão
    public int calcula_qnt_periodos(){
        int qnt_anos,qnt_periodos;

        qnt_anos = 2018 - ano_aluno;
        qnt_periodos = qnt_anos * 3;

        if (semestre_aluno == 1){
            qnt_periodos++;
        }
        else if( semestre_aluno == 2){
            qnt_periodos += 2;
        }
        else if( semestre_aluno == 3){
            qnt_periodos += 3;
        }

        return qnt_periodos;

    }

    //Método que calcula o tamanho da familia de um aluno através de recurssão
    int total = 1;
    public int calcula_tamFamilia(){


        for(Aluno aluno : afilhados){
            total += aluno.calcula_tamFamilia();
        }


        return total;
    }

    //Método que calcula o período máximo em que o aluno pode se formar
    public String periodoMax(){
        int  ano_max = ano_aluno,semestre_max = semestre_aluno,num_periodos_max = 12;
        String periodo_max;

        for(Aluno aluno: afilhados){
            if( num_periodos_max < 18)
                num_periodos_max ++;
        }

        for( int i = 1; i < num_periodos_max; i ++){

            if( semestre_max == 3){

                ano_max++;
                semestre_max = 1;

            }
            else{
                semestre_max ++;
            }
        }

        periodo_max = ano_max+"."+semestre_max;

        return periodo_max;


    }


    public static boolean podeSerMonitor(Aluno aluno,OfertaDeDisciplina oferta) {
        if( aluno.professor_ori == oferta.professor) {
            return true;
        }
        else {
            return false;
        }
    }

}