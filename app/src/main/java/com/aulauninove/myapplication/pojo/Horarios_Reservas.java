package com.aulauninove.myapplication.pojo;

import java.io.Serializable;

public class Horarios_Reservas  implements Serializable {
    private int id;
    private String dia;
    private String hora;
    private String salao;
    private String profisisonal;


    public String getProfisisonal() {
        return profisisonal;
    }

    public void setProfisisonal(String profisisonal) {
        this.profisisonal = profisisonal;
    }

    public String getSalao() {
        return salao;
    }

    public void setSalao(String salao) {
        this.salao = salao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String allReserva(){
        return "Salão: " + salao + "\nDia: " + dia + "\nHora: " + hora + "\nProfissional " + profisisonal;
    }
}
