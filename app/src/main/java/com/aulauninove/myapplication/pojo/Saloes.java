package com.aulauninove.myapplication.pojo;

import java.io.Serializable;

public class Saloes implements Serializable {

    public Saloes(){

    }

    public String getSalao() {
        return salao;
    }

    public void setSalao(String salao) {
        this.salao = salao;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }


    public com.aulauninove.myapplication.pojo.Profissionais[] getProfissionais() {
        return Profissionais;
    }

    public void setProfissionais(com.aulauninove.myapplication.pojo.Profissionais[] profissionais) {
        Profissionais = profissionais;
    }


    private String salao;
    private String Endereco;
    private Profissionais[] Profissionais;

}
