package com.aulauninove.myapplication;

import com.aulauninove.myapplication.pojo.Profissionais;
import com.aulauninove.myapplication.pojo.Saloes;
import com.google.gson.Gson;

public class EditarJson {

    public EditarJson(){
    }

    public Saloes[] getSaloes(){
        return saloes;
    }

    private String json = "[\n" +
            "{\n" +
            "  \"salao\" : \"Salao Cortes +\",\n" +
            "  \"Endereco\" : \" Rua Vergueiro, 235/249 - Liberdade, São Paulo - SP, 01525-000, (11) 2633-9000\",\n" +
            "  \"Profissionais\" : [\n" +
            "      {\n" +
            "        \"nome\" : \"João Souza\",\n" +
            "        \"Servicos\" : [\"Cabelo\", \"Barba\",\"Sobrancelha\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_18\" : [{}],\n" +
            "            \"_20\" : [{}],\n" +
            "            \"_22\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "    {\n" +
            "        \"nome\" : \"Maria Aparecida\",\n" +
            "        \"Servicos\" : [\"Unhas\", \"Hidratação\",\"Maquiagem\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_18\" : [{}],\n" +
            "            \"_20\" : [{}],\n" +
            "            \"_22\" : [{}]\n" +
            "          }\n" +
            "  },\n" +
            "    {\n" +
            "          \"nome\" : \"Daniel Ferreira\",\n" +
            "          \"Servicos\" : [\"Cabelo\", \"Barba\",\"Penteados\",\"Blindados\"],\n" +
            "          \"Horarios\" : {\n" +
            "              \"_8\" : [{}],\n" +
            "              \"_10\" : [{}],\n" +
            "              \"_12\" : [{}],\n" +
            "              \"_14\" : [{}],\n" +
            "              \"_16\" : [{}],\n" +
            "              \"_18\" : [{}],\n" +
            "              \"_20\" : [{}]\n" +
            "            }\n" +
            "  },\n" +
            "  {\n" +
            "          \"nome\" : \"Amanda Wolf\",\n" +
            "          \"Servicos\" : [\"Cabelo\", \"Design de Sobrancelhas\",\"Penteados\",\"Blindados\",\"Maquiagem\"],\n" +
            "          \"Horarios\" : {\n" +
            "              \"_10\" : [{}],\n" +
            "              \"_12\" : [{}],\n" +
            "              \"_14\" : [{}],\n" +
            "              \"_16\" : [{}],\n" +
            "              \"_18\" : [{}],\n" +
            "              \"_20\" : [{}]\n" +
            "            }\n" +
            "  }\n" +
            "  ]\n" +
            "},\n" +
            "{\n" +
            "  \"salao\" : \"Salao Beleza Divina\",\n" +
            "  \"Endereco\" : \"Av. Dr. Adolpho Pinto, 109 - Barra Funda, São Paulo - SP, 01156-050, (11) 94930-6894\",\n" +
            "  \"Profissionais\" : [\n" +
            "      {\n" +
            "        \"nome\" : \"Lucas Bento\",\n" +
            "        \"Servicos\" : [\"Unhas\", \"Lavagem\",\"Barbas\",\"Penteados\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_13\" : [{}],\n" +
            "            \"_17\" : [{}],\n" +
            "            \"_19\" : [{}],\n" +
            "            \"_21\" : [{}],\n" +
            "            \"_23\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "    {\n" +
            "        \"nome\" : \"Bruno Sabat\",\n" +
            "        \"Servicos\" : [\"Cabelos\", \"Barba\",\"Micro Pigmentação\",\"Design de Sobrancelhas\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_7\" : [{}],\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_13\" : [{}],\n" +
            "            \"_18\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "  {\n" +
            "        \"nome\" : \"Denilson Renilson\",\n" +
            "        \"Servicos\" : [\"Cabelos\", \"Barba\",\"Unhas\",\"Lavagem\",\"Hidratação\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_7\" : [{}],\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_18\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "   {\n" +
            "        \"nome\" : \"Victoria Santos\",\n" +
            "        \"Servicos\" : [\"Cabelos\",\"Unhas\",\"Lavagem\",\"Penteados\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_7\" : [{}],\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_18\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  }\n" +
            "  ]\n" +
            "},\n" +
            "{\n" +
            "  \"salao\" : \"Salao Leila Cabeleleira\",\n" +
            "  \"Endereco\" : \" R. Itauna, 429 - Vila Maria Baixa, São Paulo - SP, 02111-030, (11) 2633-9000\",\n" +
            "  \"Profissionais\" : [\n" +
            "      {\n" +
            "        \"nome\" : \"Edward Scissors\",\n" +
            "        \"Servicos\" : [\"Cabelos\", \"Hidratação\",\"Penteados\",\"Barba\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_18\" : [{}],\n" +
            "            \"_20\" : [{}],\n" +
            "            \"_22\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "    {\n" +
            "        \"nome\" : \"Lucas Anjos\",\n" +
            "        \"Servicos\" : [\"Barbas\", \"Sobrancelhas\",\"Lavagem\",\"Hidratação\",\"Penteados\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_18\" : [{}],\n" +
            "            \"_20\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "  {\n" +
            "        \"nome\" : \"Tiago True\",\n" +
            "        \"Servicos\" : [\"Barbas\", \"Sobrancelhas\",\"Lavagem\",\"Hidratação\",\"Penteados\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_18\" : [{}],\n" +
            "            \"_20\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "  {\n" +
            "        \"nome\" : \"Debora Seco\",\n" +
            "        \"Servicos\" : [\"Unhas\", \"Sobrancelhas\",\"Lavagem\",\"Hidratação\",\"Penteados\", \"Design de Sobrancelhas\"],\n" +
            "        \"Horarios\" : {\n" +
            "          \"_7\" : [{}],\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_13\" : [{}],\n" +
            "            \"_18\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  }\n" +
            "  ]\n" +
            "},{\n" +
            "  \"salao\" : \"Salao Hall da Fama\",\n" +
            "  \"Endereco\" : \"R. Amador Bueno, 389/491 - Santo Amaro, São Paulo - SP, 04752-900,(11) 2633-9015\",\n" +
            "  \"Profissionais\" : [\n" +
            "      {\n" +
            "        \"nome\" : \"Edson Melo\",\n" +
            "        \"Servicos\" : [\"Cabelo\", \"Barba\",\"Penteados\",\"Lavagem\",\"Blindados\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_18\" : [{}],\n" +
            "            \"_20\" : [{}],\n" +
            "            \"_22\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "    {\n" +
            "        \"nome\" : \"Deana\",\n" +
            "        \"Servicos\" : [\"Unhas\", \"Hidratação\",\"Design de Sobrancelhas\",\"Maquiagem\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "  {\n" +
            "        \"nome\" : \"Vitor Strong\",\n" +
            "        \"Servicos\" : [\"Cabelo\", \"Barba\",\"Penteados\",\"Lavagem\",\"Blindados\",\"Esfoliação\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_10\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_14\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_18\" : [{}],\n" +
            "            \"_20\" : [{}],\n" +
            "            \"_22\" : [{}]\n" +
            "          }\n" +
            "        \n" +
            "  },\n" +
            "  {\n" +
            "        \"nome\" :\"Billy Jimmy\",\n" +
            "        \"Servicos\" : [\"Cabelo\", \"Barba\",\"Penteados\",\"Lavagem\",\"Blindados\",\"Maquiagem\",\"Esfoliação\",\"Unhas\"],\n" +
            "        \"Horarios\" : {\n" +
            "            \"_8\" : [{}],\n" +
            "            \"_12\" : [{}],\n" +
            "            \"_16\" : [{}],\n" +
            "            \"_20\" : [{}],\n" +
            "            \"_23\" : [{}]\n" +
            "          }\n" +
            "  }\n" +
            "  ]\n" +
            "}\n" +
            "]";

    private Gson gson = new Gson();
    private Saloes[] saloes = gson.fromJson(json,Saloes[].class);

}