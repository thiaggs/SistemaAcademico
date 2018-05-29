class Professor extends Pessoa{  // Subclasse Profesor da superclasse Pessoa

    protected String login;
    protected String departamento;
    protected int siape;

    Professor(){
        login = "não informado";
        departamento = "não informado";
        siape = 0;
    }

    Professor(String nome, int dia, int mes, int ano,String login, String departamento, int siape){
        super(nome,dia,mes,ano);
        this.login = login;
        this.departamento = departamento;
        this.siape = siape;
    }

    public String login_email(String login) {
        String email;

        email = (login+"@uniriotec.br");
        return email;
    }

    public static void impressao_siape(Professor professor) {

        System.out.println(professor.nome+" - SIAPE: "+professor.siape);
    }

    public static boolean podeSerMonitor(Professor professor,OfertaDeDisciplina oferta) {

        if(oferta.professor != professor) {
            return true;
        }
        else {
            return false;
        }
    }
}
