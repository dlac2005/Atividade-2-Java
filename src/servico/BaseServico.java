package servico;

import java.util.ArrayList;

public abstract class BaseServico<TDominio> {
    public abstract TDominio Criar(TDominio curso);

    public abstract ArrayList<TDominio> LerTodos();

    public abstract TDominio Ler(int codigo);

    public abstract TDominio Atualizar(TDominio curso);

    public abstract TDominio Deletar(int codigo);
}