package visao;

import java.util.ArrayList;

import dominio.Curso;
import servico.CursoServico;

public class CursoMenu extends BaseMenu {

    private CursoServico srv;

    public CursoMenu() {
        super();
        this.srv = new CursoServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while (opcao != 6) {
            Util.ClearConsole();
            System.out.println("Cursos");
            System.out.println("Menu de Opções");
            System.out.println("1 - Listar todos os cursos");
            System.out.println("2 - Localizar um curso");
            System.out.println("3 - Adicionar um novo curso");
            System.out.println("4 - Atualizar um curso");
            System.out.println("5 - Remover um curso");
            System.out.println("6 - Encerrar Programa");
            System.out.print("Digite sua opção: ");
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 6:
                    System.out.println("Encerrando Programa...");
                    break;
                default:
                    System.out.println("Opção inválida, Tente Novamente.");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.ClearConsole();
        System.out.println("Listando...");

        ArrayList<Curso> lista = this.srv.LerTodos();
        for (Curso cursoatual : lista) {
            this.ImprimirEmLinha(cursoatual);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.ClearConsole();
        System.out.println("Localizando...");

        System.out.print("Informe o código do Curso : ");
        int codigo = this.scanner.nextInt();

        Curso cursoatual = this.srv.Ler(codigo);
        if (cursoatual != null) {
            this.ImprimirEmLinha(cursoatual);
        } else {
            System.out.println("Curso não encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.ClearConsole();
        System.out.println("Adicionando...");

        System.out.print("Informe o nome do curso : ");
        String nome = this.scanner.next();

        System.out.print("Informe a descrição do curso : ");
        String descricao = this.scanner.next();

        System.out.print("Informe a carga horária do curso : ");
        int cargaHoraria = this.scanner.nextInt();

        Curso cursoatual = new Curso();
        cursoatual.setCodigo(0);
        cursoatual.setNome(nome);
        cursoatual.setDescricao(descricao);
        cursoatual.setCargaHoraria(cargaHoraria);

        Curso cursonovo = this.srv.Criar(cursoatual);
        if (cursonovo != null) {
            System.out.println("Novo curso adicionado com sucesso");
        } else {
            System.out.println("Erro - Curso não foi adicionado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.ClearConsole();
        System.out.println("Atualizando...");

        System.out.print("Informe o código do Curso: ");
        int codigo = this.scanner.nextInt();

        Curso cursoatual = this.srv.Ler(codigo);
        if (cursoatual != null) {

            System.out.print("Informe o novo nome do curso : ");
            String nome = this.scanner.next();

            System.out.print("Informe a nova descrição do Curso : ");
            String descricao = this.scanner.next();

            System.out.print("Informe a nova carga horária do curso : ");
            int cargaHoraria = this.scanner.nextInt();

            cursoatual.setNome(nome);
            cursoatual.setDescricao(descricao);
            cursoatual.setCargaHoraria(cargaHoraria);
            if (this.srv.Atualizar(cursoatual) != null) {
                System.out.println("Curso atualizado com sucesso");
            } else {
                System.out.println("Erro - Curso não atualizado");
            }
        } else {
            System.out.println("Curso não encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.ClearConsole();
        System.out.println("Removendo...");

        System.out.print("Informe o código do Curso: ");
        int codigo = this.scanner.nextInt();

        Curso cursoatual = this.srv.Ler(codigo);
        if (cursoatual != null) {
            if (this.srv.Deletar(codigo) != null) {
                System.out.println("Curso removido com sucesso");
            } else {
                System.out.println("Erro - Curso não removido");
            }
        } else {
            System.out.println("Curso não encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void ImprimirEmLinha(Curso cursoatual) {
        String msg = "Cursos - ";
        msg += "Código : " + cursoatual.getCodigo() + " | ";
        msg += "Nome : " + cursoatual.getNome() + " | ";
        msg += "Descrição : " + cursoatual.getDescricao() + " | ";
        msg += "Carga Horária : " + cursoatual.getCargaHoraria();
        System.out.println(msg);
    }
}