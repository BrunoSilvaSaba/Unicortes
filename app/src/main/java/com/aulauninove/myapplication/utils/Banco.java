package com.aulauninove.myapplication.utils;

import java.io.Serializable;

public class Banco implements Serializable {
    private static String banco = "db_usuario.db";
    private static String tabela = "usuario";
    private static String tabela_reserva = "reserva";

    public static String banco() {
        return banco;
    }

    public static String criaTabela() {
        return "CREATE TABLE IF NOT EXISTS " + tabela() + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR NOT NULL, " +
                "cep VARCHAR NOT NULL, " +
                "celular VARCHAR NOT NULL, " +
                "email VARCHAR NOT NULL, " +
                "senha VARCHAR NOT NULL);";
    }
    public static String tabelaReserva() {
        return tabela_reserva;
    }

    public static String criaTabelaReserva() {
        return "CREATE TABLE IF NOT EXISTS " + tabelaReserva() + "(" +
                "id INTEGER NOT NULL, " +
                "hora VARCHAR NOT NULL, " +
                "salao VARCHAR NOT NULL, " +
                "profissional VARCHAR NOT NULL, " +
                "dia VARCHAR NOT NULL);";
    }
    public static String tabela() {
        return tabela;
    }
}