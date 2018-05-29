class Disciplina{

    protected String nome;
    protected int codigo;
    protected String ementa;
    protected int carga_horaria;
    protected String professor_r;

    Disciplina(){
        nome = "não informado";
        codigo = 0;
        ementa = "não informado";
        carga_horaria = 0;
    }

    Disciplina(String nome, int codigo, String ementa, int carga_horaria, String professor_r){
        this.nome = nome;
        this.codigo = codigo;
        this.ementa = ementa;
        this.carga_horaria = carga_horaria;
        this.professor_r = professor_r;
    }

    public static void impressao_responsaveis(Disciplina disciplina) {

        System.out.println(disciplina.nome+" - Professor resposnável: "+disciplina.professor_r);
    }


}