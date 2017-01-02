package com.pensejava.groovy

import com.pensejava.newobject.core.PersistenceProviderNew
import com.pensejava.newobject.entity.Endereco
import com.pensejava.newobject.entity.Pessoa
import spock.lang.Specification

/**
 * Created by heverton.cruz on 02/01/2017.
 */
class IntegralSpec extends Specification {

    def "Teste de criação de objetos"() {
        when: "analisar objeto"
        def pessoas = (List<Pessoa>) new PersistenceProviderNew().newProvider(15, new Pessoa(15l,"Heverton", "Silva", new Endereco(15, "QMS 03"), "986325705", "Rosanilza", "Antonio"));
        then: " verificar se os dados estão preenchidos"
        pessoas.get(0) !=  null
    }

    def "Teste de criação de objetos 2"() {
        when: "analisar objeto 2"
        def pessoas = (List<Pessoa>) new PersistenceProviderNew().newProvider(15, new Pessoa(15l,"Heverton", "Silva", new Endereco(15, "QMS 03"), "986325705", "Rosanilza", "Antonio"));
        then: " verificar se os dados estão preenchidos 2"
        pessoas.get(0) ==  null
    }

}
