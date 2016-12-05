package com.pensejava.newobject.core;

import com.pensejava.newobject.entity.Endereco;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heverton.cruz on 05/12/2016.
 */
public class PersistenceProviderNew<U> {

    public List<U> newProvider(U classe) {
        return newProviders(1, classe);
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

          if (fil.getType().equals(int.class)) {
              int a = Parce.nextInt(Integer.parseInt(fil.get(cla) + ""));
              fil.setInt(cla, a);
          } else if (fil.get(cla) instanceof String) {
              String a = Parce.nextString((String) fil.get(cla));
              fil.set(cla, a);
          } else if (fil.getType().equals(long.class)) {
              fil.setInt(cla, Parce.nextInt(Integer.parseInt(fil.get(cla) + "")));
          } else if (fil.getType() instanceof Class) {
              U mae = (U) fil.get(cla);
              U dep = (U) Class.forName((fil.get(cla)).getClass().getName()).newInstance();
              //Clona o objeto para receber os dados
              BeanUtils.copyProperties(dep, mae);
              dep = newProviderDep(dep);
              fil.set(mae, dep);
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
