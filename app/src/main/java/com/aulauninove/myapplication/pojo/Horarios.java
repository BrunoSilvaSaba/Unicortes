package com.aulauninove.myapplication.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class Horarios  implements Serializable {


    public ArrayList<String> getHorarios(){
        ArrayList<String> horarios = new ArrayList<>();

        if(this._8 != null){
           horarios.add("8h00");
        }
        if(this._9 != null){
            horarios.add("9h00");
        }
        if(this._10 != null){
            horarios.add("10h00");
        }
        if(this._11 != null){
            horarios.add("11h00");
        }
        if(this._12 != null){
            horarios.add("12h00");
        }
        if(this._13 != null){
            horarios.add("13h00");
        }
        if(this._14 != null){
            horarios.add("14h00");
        }
        if(this._15 != null){
            horarios.add("15h00");
        }
        if(this._16 != null){
            horarios.add("16h00");
        }
        if(this._17 != null){
            horarios.add("17h00");
        }
        if(this._18 != null){
            horarios.add("18h00");
        }
        if(this._19 != null){
            horarios.add("19h00");
        }
        if(this._20 != null){
            horarios.add("20h00");
        }
        if(this._21 != null){
            horarios.add("21h00");
        }
        if(this._22 != null){
            horarios.add("22h00");
        }

        return horarios;
    }

    public ArrayList<Horarios_Reservas> converteHorarios(String horarios){

        if(horarios.equals("8h00")){
            return _8;
        } else if(horarios.equals("9h00")){
                return _9;
        } else if(horarios.equals("10h00")){
            return _10;
        } else if(horarios.equals("11h00")){
            return _11;
        } else if(horarios.equals("12h00")){
            return _12;
        } else if(horarios.equals("13h00")){
            return _13;
        } else if(horarios.equals("14h00")){
            return _14;
        } else if(horarios.equals("15h00")){
            return _15;
        } else if(horarios.equals("16h00")){
            return _16;
        } else if(horarios.equals("17h00")){
            return _17;
        } else if(horarios.equals("18h00")){
            return _18;
        } else if(horarios.equals("19h00")){
            return _19;
        } else if(horarios.equals("20h00")){
            return _20;
        } else if(horarios.equals("21h00")){
            return _21;
        } else if(horarios.equals("22h00")) {
            return _22;
        } else {
            return null;
        }
    }

    public ArrayList<Horarios_Reservas> get_8() {
        return _8;
    }

    public void set_8(ArrayList<Horarios_Reservas> _8) {
        this._8 = _8;
    }

    public ArrayList<Horarios_Reservas> get_9() {
        return _9;
    }

    public void set_9(ArrayList<Horarios_Reservas> _9) {
        this._9 = _9;
    }

    public ArrayList<Horarios_Reservas> get_10() {
        return _10;
    }

    public void set_10(ArrayList<Horarios_Reservas> _10) {
        this._10 = _10;
    }

    public ArrayList<Horarios_Reservas> get_11() {
        return _11;
    }

    public void set_11(ArrayList<Horarios_Reservas> _11) {
        this._11 = _11;
    }

    public ArrayList<Horarios_Reservas> get_12() {
        return _12;
    }

    public void set_12(ArrayList<Horarios_Reservas> _12) {
        this._12 = _12;
    }

    public ArrayList<Horarios_Reservas> get_13() {
        return _13;
    }

    public void set_13(ArrayList<Horarios_Reservas> _13) {
        this._13 = _13;
    }

    public ArrayList<Horarios_Reservas> get_14() {
        return _14;
    }

    public void set_14(ArrayList<Horarios_Reservas> _14) {
        this._14 = _14;
    }

    public ArrayList<Horarios_Reservas> get_15() {
        return _15;
    }

    public void set_15(ArrayList<Horarios_Reservas> _15) {
        this._15 = _15;
    }

    public ArrayList<Horarios_Reservas> get_16() {
        return _16;
    }

    public void set_16(ArrayList<Horarios_Reservas> _16) {
        this._16 = _16;
    }

    public ArrayList<Horarios_Reservas> get_17() {
        return _17;
    }

    public void set_17(ArrayList<Horarios_Reservas> _17) {
        this._17 = _17;
    }

    public ArrayList<Horarios_Reservas> get_18() {
        return _18;
    }

    public void set_18(ArrayList<Horarios_Reservas> _18) {
        this._18 = _18;
    }

    public ArrayList<Horarios_Reservas> get_19() {
        return _19;
    }

    public void set_19(ArrayList<Horarios_Reservas> _19) {
        this._19 = _19;
    }

    public ArrayList<Horarios_Reservas> get_20() {
        return _20;
    }

    public void set_20(ArrayList<Horarios_Reservas> _20) {
        this._20 = _20;
    }

    public ArrayList<Horarios_Reservas> get_21() {
        return _21;
    }

    public void set_21(ArrayList<Horarios_Reservas> _21) {
        this._21 = _21;
    }

    public ArrayList<Horarios_Reservas> get_22() {
        return _22;
    }

    public void set_22(ArrayList<Horarios_Reservas> _22) {
        this._22 = _22;
    }


    private ArrayList<Horarios_Reservas> _8;
    private ArrayList<Horarios_Reservas> _9;
    private ArrayList<Horarios_Reservas> _10;
    private ArrayList<Horarios_Reservas> _11;
    private ArrayList<Horarios_Reservas> _12;
    private ArrayList<Horarios_Reservas> _13;
    private ArrayList<Horarios_Reservas> _14;
    private ArrayList<Horarios_Reservas> _15;
    private ArrayList<Horarios_Reservas> _16;
    private ArrayList<Horarios_Reservas> _17;
    private ArrayList<Horarios_Reservas> _18;
    private ArrayList<Horarios_Reservas> _19;
    private ArrayList<Horarios_Reservas> _20;
    private ArrayList<Horarios_Reservas> _21;
    private ArrayList<Horarios_Reservas> _22;

}
