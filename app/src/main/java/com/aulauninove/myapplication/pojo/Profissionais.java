package com.aulauninove.myapplication.pojo;

import java.io.Serializable;

public class Profissionais implements Serializable {
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getServicos() {
        return Servicos;
    }

    public void setServicos(String[] servicos) {
        this.Servicos = servicos;
    }

    public Horarios getHorarios() {
        return Horarios;
    }

    public void setHorarios(Horarios horarios) {
        this.Horarios = horarios;
    }

    public String getAllServicos(String[] servicosArray){
        int i;
        String servicos = "";
        for(i=0;i<3;i++){
            servicos +=  " - " + servicosArray[i];
        }
        servicos += " - ";

        return servicos;
    }

    private String nome;
    private  String[] Servicos;
    private String allServicos;
    private Horarios Horarios;
}
