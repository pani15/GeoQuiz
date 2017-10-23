package com.local.pani.geoquiz;

/**
 * Created by usuario on 27/09/2017.
 */

public class Test {
    int id_pregunta;
    boolean resposta;
    int id_pista;
    int id_fpista;


    public int getId_fpista() {
        return id_fpista;
    }

    public void setId_fpista(int id_fpista) {
        this.id_fpista = id_fpista;
    }

    public int getId_pista() {
        return id_pista;
    }

    public void setId_pista(int id_pista) {
        this.id_pista = id_pista;
    }

    public Test(int id_pregunta, boolean resposta,int id_pista,int id_fpista) {
        this.id_pregunta = id_pregunta;
        this.resposta = resposta;
        this.id_pista = id_pista;
        this.id_fpista = id_fpista;
    }

    public int getId_pregunta()
    {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {

        this.id_pregunta = id_pregunta;
    }

    public boolean getResposta() {

        return resposta;
    }

    public void setResposta(boolean resposta) {

        this.resposta = resposta;
    }
}
