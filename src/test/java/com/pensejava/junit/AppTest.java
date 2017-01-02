package com.pensejava.junit;

import com.pensejava.newobject.core.PersistenceProviderNew;
import com.pensejava.newobject.entity.Endereco;
import com.pensejava.newobject.entity.Pessoa;
import com.pensejava.newobject.entity.PessoaList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void onetoone(){
        List<Pessoa> pessoas = (List<Pessoa>) new PersistenceProviderNew().newProvider(15,
                new Pessoa(15l,"Heverton", "Silva", new Endereco(15, "QMS 03"), "986325705", "Rosanilza", "Antonio"));

//        for (Pessoa p : pessoas){
//            System.out.println(p.getId()+" - ");
//            System.out.println(p.getNome()+" - ");
//            System.out.println(p.getNomeMae()+" - ");
//            System.out.println(p.getEnderecos().getId()+" - ");
//            System.out.println(p.getEnderecos().getNome()+" - ");
//            System.out.println(p.getSobrenome()+" - ");
//            System.out.println(p.getTelefone());
//        }

        Assert.assertEquals("É uma lista de Pessoa? ", 15, pessoas.size());
    }

    @Test
    public void onetomany1(){
        List<PessoaList> pessoas = (List<PessoaList>) new PersistenceProviderNew().newProvider(1, new PessoaList());

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
//            System.out.println("getTelefone = "+p.getTelefone());
//        }

        Assert.assertEquals("É uma lista de Pessoa? ", 1, pessoas.size());
    }

    @Test
    public void onetomany2(){
        List<Pessoa> pessoas = (List<Pessoa>) new PersistenceProviderNew().newProvider(15,  new Pessoa());

//        for (Pessoa p : pessoas){
//            System.out.print(p.getId()+" - ");
//            System.out.print(p.getNome()+" - ");
//            System.out.print(p.getNomeMae()+" - ");
//            System.out.print(p.getEnderecos().getId()+" - ");
//            System.out.print(p.getEnderecos().getNome()+" - ");
//            System.out.print(p.getSobrenome()+" - ");
//            System.out.print(p.getTelefone()+"\n");
//        }

        Assert.assertEquals("É uma lista de Pessoa? ", 15, pessoas.size());
    }

}
