package com.pensejava.newobject.core;

import com.pensejava.newobject.entity.Endereco;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by heverton.cruz on 05/12/2016.
 */
public class PersistenceProviderNew<U> {

    private Config config = new Config();

    public List<U> newProvider(U classe) {
        return newProviders(1, classe);
    }

    public  List<U> newProvider(Config config, U classe) {
        this.config = config;
        return  newProviders(this.config.getCountList(), classe);
    }

    public  List<U> newProvider(int size, U classe) {
        return  newProviders(size, classe);
    }

    private  List<U> newProviders(int size, U classe) {

        List<U> uList = new ArrayList<U>();

        try {
            //Define quantas repetiçõe serão utilizadas para a fábrica
            for (int i=0; i < size; i++) {
                //Fabrica uma nova instancia do objeto
                U cla = (U) Class.forName(classe.getClass().getName()).newInstance();
                //Clona o objeto para receber os dados
                BeanUtils.copyProperties(cla, classe);
                //Recebe o campo e trata os dados, resuta em objetos com dados novos
                //Apartir do objeto mae
                for (Field fil : cla.getClass().getDeclaredFields()) {
                    fil.setAccessible(true);
                    cla = generatedData(cla, fil);
                }

                uList.add(cla);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return uList;
    }

    private  U newProviderDep(U cldep) {

        try {

            //Recebe o campo e trata os dados, resuta em objetos com dados novos
            //Apartir do objeto mae
            for (Field fil : cldep.getClass().getDeclaredFields()) {
                cldep = generatedData(cldep, fil);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return cldep;
    }

    private U generatedData(U cla, Field fil) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException {

        if (fil.getType().getName().equals("java.util.List") &&  fil.get(cla) != null){
            ArrayList list = (ArrayList) fil.get(cla);
            ArrayList listObj = new ArrayList();
            for (Object o : list) {
                for (Object ob : new PersistenceProviderNew().newProvider(this.config.getCountListDependent(), o)) {
                    listObj.add(ob);
                }
            }

            //Limpar lista
            list.clear();

            for (Object o :  listObj){
                list.add(o);
            }

            fil.set(cla, list);

        } else if (fil.getType().equals(int.class)) {
            if(Integer.parseInt(fil.get(cla) + "") == 0) {
                fil.setInt(cla, Parce.nextInt(this.config.getCountNumber()));
            } else {
                fil.setInt(cla, Parce.nextInt(Integer.parseInt(fil.get(cla) + "")));
            }
        } else if (fil.getType().equals(long.class)) {
            if(Long.parseLong(fil.get(cla) + "") == 0) {
                fil.setLong(cla, Parce.nextLong(this.config.getCountNumber()));
            } else {
                fil.setLong(cla, Parce.nextLong(Long.parseLong(fil.get(cla) + "")));
            }

        } else if (fil.get(cla) instanceof String) {
            if(((String) fil.get(cla)).length() == 0) {
                fil.set(cla, Parce.nextString(null));
            } else {
                fil.set(cla, Parce.nextString((String) fil.get(cla)));
            }
        } else if (fil.getType() instanceof Class &&  fil.get(cla) != null) {
            U mae = (U) fil.get(cla);
            U dep = (U) Class.forName((fil.get(cla)).getClass().getName()).newInstance();
            //Clona o objeto para receber os dados
            BeanUtils.copyProperties(dep, mae);
            dep = newProviderDep(dep);
            fil.set(cla, dep);

        } else if (fil.getType().getName().equals("java.util.List") &&  fil.get(cla) == null) {
            //remove os dados necessario para a instacia do dado
            String str = (fil.getGenericType().toString().replace("java.util.List<","")).replace(">","");
            ArrayList list = new ArrayList();
            list.add(Class.forName(str).newInstance());
            fil.set(cla, list);
            generatedData(cla, fil);


        //Caso de null seta o valor default
        } else if(fil.get(cla) == null) {
            U dep = (U) Class.forName(fil.getType().getName()).newInstance();
            fil.set(cla, dep);
            generatedData(cla, fil);
        }

        return cla;
    }

    /*
    public void PersistenceProviderNew1() {

        try {
            List<Pessoa> pessoaLis = new ArrayList();

            for (int i=0; i < 10; i++) {
                //Origem e onde se encontra a base das palavas do objeto especifico
                Pessoa pessoa = new Pessoa(15,"Heverton", "Silva", new Endereco("QMS 03"), "986325705", "Rosanilza", "Antonio");
                //Pessoa pessoa = new Pessoa();
                //Versão são os dados que serão defivado
                Class<?> clas = pessoa.getClass();

                for (Field fil : clas.getDeclaredFields()) {
                    //É uma String
                    if (fil.get(pessoa) instanceof String) {
                        fil.set(pessoa, Parce.nextString((String) fil.get(pessoa)));
                    }
                    if (fil.getType().equals(int.class)) {
                        fil.setInt(pessoa, Parce.nextInt(Integer.parseInt(fil.get(pessoa) + "")));
                    }
                }
                pessoaLis.add(pessoa);
            }

            for (Pessoa p : pessoaLis){
                System.out.println(p.getId());
                System.out.println(p.getNome());
                System.out.println(p.getNomeMae());
                System.out.println(p.getSobrenome());
                System.out.println(p.getTelefone());
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    */

}
