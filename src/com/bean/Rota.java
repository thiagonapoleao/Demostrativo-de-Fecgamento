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
public class Rota implements Serializable{
  
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String rota;
   private String previsaoliberacao;
   private String previsaosaida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public String getPrevisaoliberacao() {
        return previsaoliberacao;
    }

    public void setPrevisaoliberacao(String previsaoliberacao) {
        this.previsaoliberacao = previsaoliberacao;
    }

    public String getPrevisaosaida() {
        return previsaosaida;
    }

    public void setPrevisaosaida(String previsaosaida) {
        this.previsaosaida = previsaosaida;
    }
   
   
   
    
    
}
