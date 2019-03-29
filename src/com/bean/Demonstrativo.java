/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author thiago.napoleao
 */
@Entity
@Table
public class Demonstrativo  implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
     private int id;
    private String data;
    private String rota;
    private String liberacaocpd;
    private String impressora;
    private String danfenormal;
    private String danfeepec;
    private String pft4707p;
    private String operador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public String getLiberacaocpd() {
        return liberacaocpd;
    }

    public void setLiberacaocpd(String liberacaocpd) {
        this.liberacaocpd = liberacaocpd;
    }

    public String getImpressora() {
        return impressora;
    }

    public void setImpressora(String impressora) {
        this.impressora = impressora;
    }

    public String getDanfenormal() {
        return danfenormal;
    }

    public void setDanfenormal(String danfenormal) {
        this.danfenormal = danfenormal;
    }

    public String getDanfeepec() {
        return danfeepec;
    }

    public void setDanfeepec(String danfeepec) {
        this.danfeepec = danfeepec;
    }

    public String getPft4707p() {
        return pft4707p;
    }

    public void setPft4707p(String pft4707p) {
        this.pft4707p = pft4707p;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    
    
    
}
