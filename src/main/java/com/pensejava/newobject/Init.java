package com.pensejava.newobject;

import com.pensejava.newobject.core.PersistenceProviderNew;
import com.pensejava.newobject.entity.Endereco;
import com.pensejava.newobject.entity.Pessoa;
import com.pensejava.newobject.entity.PessoaList;

import java.util.List;

/**
 * Created by heverton.cruz on 05/12/2016.
 */
public class Init {
    public static void main(String args[]){


        //--------------------------------------------------------------------------------------------------------------

//        List<Pessoa> pessoas = (List<Pessoa>) new PersistenceProviderNew().newProvider(15,
//                new Pessoa(15,"Heverton", "Silva", new Endereco(15, "QMS 03"), "986325705", "Rosanilza", "Antonio"));
        List<Pessoa> pessoas = (List<Pessoa>) new PersistenceProviderNew().newProvider(1, new Pessoa());

        for (Pessoa p : pessoas){
            System.out.print(p.getId()+" - ");
            System.out.print(p.getNome()+" - ");
            System.out.print(p.getNomeMae()+" - ");
            System.out.print(p.getEnderecos().getId()+" - ");
            System.out.print(p.getEnderecos().getNome()+" - ");
            System.out.print(p.getSobrenome()+" - ");
            System.out.print(p.getTelefone()+"\n");
        }

        //--------------------------------------------------------------------------------------------------------------


//        List<PessoaList> pessoas = (List<PessoaList>) new PersistenceProviderNew().newProvider(1, new PessoaList());
//
//        for (PessoaList p : pessoas){
//            System.out.println("getId = "+p.getId());
//            System.out.println("getNome = "+p.getNome());
//            System.out.println("getNomeMae = "+p.getNomeMae());
//
//            for (Endereco end : p.getEnderecos()) {
//                System.out.println("end.getId = "+end.getId() );
//                System.out.println("end.getNome = "+end.getNome() );
//            }
//
//            System.out.println("getSobrenome = "+p.getSobrenome());
//            System.out.println("getTelefone = "+p.getTelefone()+"\n");
//        }

    }
}
