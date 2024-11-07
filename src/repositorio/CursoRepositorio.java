package repositorio;

import dominio.Curso;
import fakeDB.CursoFakeDB;

public class CursoRepositorio
        extends BaseRepositorio<Curso> {

    private CursoFakeDB db;

    public CursoRepositorio() {
        this.db = new CursoFakeDB();
        this.fonteDeDados = this.db.getTabela();
    }

    @Override
    public Curso Create(Curso curso) {

        int pos = this.fonteDeDados.size() - 1;
        Curso cursoatual = this.fonteDeDados.get(pos);
        int proxCodigo = cursoatual.getCodigo() + 1;

        curso.setCodigo(proxCodigo);
        this.fonteDeDados.add(curso);
        return curso;
    }

    @Override
    public Curso Read(int codigo) {
        for (Curso cursoatual : this.fonteDeDados) {
            if (cursoatual.getCodigo() == codigo) {
                return cursoatual;
            }
        }
        return null;
    }

    @Override
    public Curso Update(Curso curso) {
        Curso cursoatual = this.Read(curso.getCodigo());
        if (cursoatual != null) {
            cursoatual.setDescricao(curso.getDescricao());
            return cursoatual;
        } else {
            return null;
        }
    }

    @Override
    public Curso Delete(int codigo) {
        Curso cursoatual = this.Read(codigo);
        if (cursoatual != null) {
            this.fonteDeDados.remove(cursoatual);
            return cursoatual;
        } else {
            return null;
        }
    }
}