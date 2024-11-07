package fakeDB;

import java.util.ArrayList;

import dominio.Curso;

public class CursoFakeDB
        extends BaseFakeDB<Curso> {

    public CursoFakeDB() {
        super();
    }

    @Override
    protected void preencherDados() {
        this.tabela = new ArrayList<>();
        this.tabela.add(new Curso(1, "Matemática", "Curso de Matemática", 60));
        this.tabela.add(new Curso(2, "Português", "Curso de Português", 40));
        this.tabela.add(new Curso(3, "Ciências", "Curso de Ciências", 50));
        this.tabela.add(new Curso(4, "História", "Curso de História", 40));
        this.tabela.add(new Curso(5, "Geografia", "Curso de Geografia", 45));
    }
}