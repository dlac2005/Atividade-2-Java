package servico;

import java.util.ArrayList;

import dominio.Curso;
import repositorio.CursoRepositorio;

public class CursoServico extends BaseServico<Curso> {

    private CursoRepositorio repositorio;

    public CursoServico() {
        this.repositorio = new CursoRepositorio();
    }

    @Override
    public Curso Criar(Curso curso) {
        return this.repositorio.Create(curso);
    }

    @Override
    public ArrayList<Curso> LerTodos() {
        return this.repositorio.ReadAll();
    }

    @Override
    public Curso Ler(int codigo) {
        return this.repositorio.Read(codigo);
    }

    @Override
    public Curso Atualizar(Curso curso) {
        return this.repositorio.Update(curso);
    }

    @Override
    public Curso Deletar(int codigo) {
        return this.repositorio.Delete(codigo);
    }
}