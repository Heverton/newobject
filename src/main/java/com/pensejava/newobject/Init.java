package com.pensejava.newobject;

import com.pensejava.newobject.core.PersistenceProviderNew;
import com.pensejava.newobject.entity.Endereco;
import com.pensejava.newobject.entity.Pessoa;
import java.util.List;

/**
 * Created by heverton.cruz on 05/12/2016.
 */
public class Init {
    public static void main(String args[]){


        //TODO Construir ação quando null

        List<Pessoa> pessoas = (List<Pessoa>) new PersistenceProviderNew().newProvider(15,
                new Pessoa(15,"Heverton", "Silva", new Endereco(15, "QMS 03"), "986325705", "Rosanilza", "Antonio"));
        //List<Pessoa> pessoas = (List<Pessoa>) new PersistenceProviderNew().newProvider(3, new Pessoa());

        for (Pessoa p : pessoas){
            System.out.print(p.getId()+" - ");
            System.out.print(p.getNome()+" - ");
            System.out.print(p.getNomeMae()+" - ");
            //System.out.print(p.getEndereco().getId()+" - ");
            //System.out.print(p.getEndereco().getNome()+" - ");
            System.out.print(p.getSobrenome()+" - ");
            System.out.print(p.getTelefone()+"\n");
        }


    }
}
