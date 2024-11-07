package repositorio;

import java.util.ArrayList;

public abstract class BaseRepositorio<TDominio> {

    protected ArrayList<TDominio> fonteDeDados;

    public abstract TDominio Create(TDominio curso);

    public ArrayList<TDominio> ReadAll() {
        return this.fonteDeDados;
    }

    public abstract TDominio Read(int codigo);

    public abstract TDominio Update(TDominio curso);

    public abstract TDominio Delete(int codigo);

}