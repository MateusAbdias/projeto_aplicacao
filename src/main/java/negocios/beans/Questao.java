package negocios.beans;

import java.io.Serializable;

public class Questao implements Serializable {

    private String enunciado;
    private static int contadorId = 1;
    private int questaoId;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private static final long serialVersionUID = -2936766067409686658L;

    private String respostaCorreta;

    public Questao(String enunciado, String alternativaA, String alternativaB, String alternativaC, String alternativaD, String respostaCorreta){
        this.questaoId = contadorId++;
        this.enunciado = enunciado;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.respostaCorreta = respostaCorreta;

    }

    public String getEnunciado(){
        return enunciado;
    }
    public void setEnunciado(String enunciado){
        this.enunciado = enunciado;
    }

    public String getAlternativaA(){
        return alternativaA;
    }
    public void setAlternativaA(String alternativaA){
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB(){
        return alternativaB;
    }
    public void setAlternativaB(String alternativaB){
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC(){
        return alternativaC;
    }
    public void setAlternativaC(String alternativaC){
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD(){
        return alternativaD;
    }
    public void setAlternativaD(String alternativaD){
        this.alternativaD = alternativaD;
    }

    public String getRespostaCorreta(){
        return respostaCorreta;
    }
    public void setRespostaCorreta(String respostaCorreta){
        this.respostaCorreta = respostaCorreta;
    }

    public int getQuestaoId() {
        return questaoId;
    }

}
