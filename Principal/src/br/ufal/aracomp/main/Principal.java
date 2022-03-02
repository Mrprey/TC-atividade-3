package br.ufal.aracomp.main;

import br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.emprestimo.spec.dt.UsuarioDT;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;
import connRMI.ConnCli;


public class Principal {
    public static void main(String[] args) {
        //Instanciando emprestimo
        IManager compEmp = ComponentFactory.createInstance();
        ConnCli conector = new ConnCli();

        //bindings
        compEmp.setRequiredInterface("ILimiteReq", conector);

        //calcula o emprestimo
        IEmprestimoOps objEmpOps = (IEmprestimoOps)compEmp.getProvidedInterface("IEmprestimoOps");
        UsuarioDT usuario = new UsuarioDT();

        usuario.rendimentos = String.valueOf(1099);
        System.out.println("Valor liberado: R$"+objEmpOps.liberarEmprestimoAutomatico(usuario));
        System.out.println("*---------------------------------------------------------------------*");

    }
}
