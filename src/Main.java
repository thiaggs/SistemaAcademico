import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner entrada1 = new Scanner(System.in); //Scanner para inteiros e float
        Scanner entrada2 = new Scanner(System.in); //Scanner para String
        int num_alunos,num_prof,num_discip, dia, mes, ano, matricula_aluno,ano_aluno,semestre_aluno,siape,codigo,carga_h,aux_num;
        String nome, login, curso_aluno,departamento_professor,ementa,professor_r,professor_ori_nome;
        boolean aux_orientador=false;
        Professor professor_ori;

        //ArrayList para guardar os dias e meses de nascimento de cada pessoa, assumindo que os
        //índex pares são dias e os ímpares são meses
        ArrayList<Integer> array_datas = new ArrayList<Integer>();



        //_______________________________CADASTRO DE PROFESSORES_________________________________________

        System.out.println("Quantos professores deseja cadastrar?");
        num_prof = entrada1.nextInt();

        Professor[] array_prof = new Professor[num_prof];

        for (int j = 0; j < num_prof; j++) {

            System.out.println("Insira o nome do professor");
            nome = entrada2.nextLine();

            System.out.println("Insira o dia, o mês e o ano de nascimento do professor, respectivamente");
            dia = entrada1.nextInt();
            array_datas.add(dia);
            mes = entrada1.nextInt();
            array_datas.add(mes);
            ano = entrada1.nextInt();

            System.out.println("Insira o login do professor");
            login = entrada2.nextLine();

            System.out.println("Insira o departamento do professor");
            departamento_professor = entrada2.nextLine();

            System.out.println("Insira o SIAPE do professor");
            siape = entrada1.nextInt();

            array_prof[j] = new Professor(nome, dia, mes, ano, login, departamento_professor,siape);



        }

        //________________________________CADASTRO DE ALUNOS________________________________________





        System.out.println("Quantos ALUNOS deseja cadastrar?");
        num_alunos = entrada1.nextInt();


        Aluno[] array_alunos = new Aluno[num_alunos];


        for (int i = 0; i < num_alunos; i++) {

            System.out.println("Insira o nome do aluno");
            nome = entrada2.nextLine();

            System.out.println("Insira o dia, o mês e o ano de nascimento do aluno, respectivamente");
            dia = entrada1.nextInt();
            array_datas.add(dia);
            mes = entrada1.nextInt();
            array_datas.add(mes);
            ano = entrada1.nextInt();

            System.out.println("Insira o login do aluno");
            login = entrada2.nextLine();

            System.out.println("Insira o curso do aluno");
            curso_aluno = entrada2.nextLine();

            System.out.println("Insira o ano e o semestre de ingressão, respectivamente.");
            ano_aluno = entrada1.nextInt();
            semestre_aluno = entrada1.nextInt();

            System.out.println("Insira a matricula do aluno");
            matricula_aluno = entrada1.nextInt();


            // Se o usuário informar algum número que não seja 1 nem 2, haverá um erro
            while (aux_orientador == false){

                System.out.println("O aluno em questão possui professor orientador?");
                System.out.println("1 - SIM");
                System.out.println("2 - NÃO");
                aux_num = entrada1.nextInt();

                // Se houver professor orientador, será direcionado para o construtor com professor orientador

                if (aux_num == 1)
                {

                    System.out.println("Insira o nome do professor orientador do aluno");
                    professor_ori_nome = entrada2.nextLine();

                    for(int contador = 0; contador < array_prof.length; contador++ ) {

                        if( professor_ori_nome.equals(array_prof[contador].nome)) {

                            array_alunos[i] = new Aluno(nome, dia, mes, ano, login, curso_aluno,array_prof[contador],
                                    ano_aluno,semestre_aluno, matricula_aluno);
                        }
                    }



                    aux_orientador = true;
                }
                // Se não houver professor orientador, será direcionado para o construtor sem professor orientador

                else if( aux_num == 2){

                    array_alunos[i] = new Aluno(nome, dia, mes, ano, login, curso_aluno,
                            ano_aluno, semestre_aluno, matricula_aluno);


                    aux_orientador  = true;


                }

            }

            aux_orientador = false;


        }



        //_________________________________CADASTRO DE DISCIPLINAS______________________________

        System.out.println("Quantas disciplinas deseja cadastrar?");
        num_discip = entrada1.nextInt();

        Disciplina[] array_discip = new Disciplina[num_discip];

        for (int k = 0; k < num_discip; k++) {

            System.out.println("Insira o nome da disciplina");
            nome = entrada2.nextLine();

            System.out.println("Insira o código da disciplina");
            codigo = entrada1.nextInt();

            System.out.println("Insira a ementa da disciplina");
            ementa = entrada2.nextLine();

            System.out.println("Insira a carga horária da disciplina");
            carga_h = entrada1.nextInt();

            System.out.println("Insira o professor responsável pela disciplina");
            professor_r = entrada2.nextLine();

            array_discip[k] = new Disciplina(nome,codigo,ementa,carga_h,professor_r);
        }
        //______________________IMPRESSÕES ATRAVÉS DE MÉTODOS E LAÇOS________________________________

        System.out.println(array_alunos[0].calcula_qnt_periodos());
        System.out.println(array_alunos[1].calcula_qnt_periodos());

        array_alunos[0].apadrinhar(array_alunos[1]);

        System.out.println(array_alunos[0].periodoMax());
        System.out.println(array_alunos[0].periodoMax());
        System.out.println(array_alunos[0].calcula_tamFamilia());

        for (int i = 0; i < num_alunos; i++) {
            Aluno.impressao_email(array_alunos[i]);
        }

        for (int j = 0; j < num_prof; j++) {
            Professor.impressao_siape(array_prof[j]);
        }

        for (int k = 0; k < num_discip; k++) {
            Disciplina.impressao_responsaveis(array_discip[k]);
        }



    }
}