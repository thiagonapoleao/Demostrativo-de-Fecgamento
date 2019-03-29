/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.bean.Dados;
import com.bean.Demonstrativo;
import com.bean.Laser;
import com.bean.Pln0030p;
import com.bean.Rota;
import com.bean.SaidaRota;
import com.dao.DadosDAO;
import com.dao.DemonstrativoJpaDAO;
import com.dao.LaserJpaDAO;
import com.dao.Pln0030pJpaDAO;
import com.dao.RotaJpaDAO;
import com.dao.SaidaRotaDAO;
import com.utils.DataHora;
import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author thiago.napoleao
 */
public class FrameMonitor extends javax.swing.JPanel {

    /**
     * Creates new form Frame
     */
    public FrameMonitor() throws ParseException {
        initComponents();
        MaskFormatter maskData = new MaskFormatter("##/##/####");  
        maskData.install(DataTxt); 
        DataHora dataHora = new DataHora();
       
        defaults();
    }
    
     public void defaults() {        
         
           new Thread() {
             public void run() {
                while (true){
                    try {
                        preencherTabela();
                    } catch (IOException ex) {
                        Logger.getLogger(FrameMonitor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 try{
                    Thread.sleep(30000);
                 }catch(Exception e){
                   e.printStackTrace();  
                 }
                } 
            }
         }.start(); 
    }
     
      public void preencherTabela() throws IOException{    
          limpar();
          prevLib();
          prevSaida();
          unidades();
          libCPD();
          impressora();   
          danfeNormal();
          danfeEpec();
          saida();
          operador();
          laser();          
      }
          
      
      public void limpar(){
          Unidades731.setText("");
          Unidades732.setText("");
          Unidades733.setText("");
          Unidades722.setText("");
          Unidades764.setText("");
          Unidades720.setText("");
          Unidades721.setText("");
          Unidades770.setText("");
          Unidades761.setText("");
          Unidades741.setText("");
          Unidades700.setText("");
          Unidades750.setText("");
          Unidades756.setText("");
          Unidades754.setText("");
          Unidades723.setText("");         
          Unidades783.setText("");
          Unidades762.setText("");
          Unidades766.setText("");
          Unidades790.setText("");
          
          LibCPD731.setText("");
          LibCPD732.setText("");
          LibCPD733.setText("");
          LibCPD764.setText("");
          LibCPD722.setText("");
          LibCPD720.setText("");
          LibCPD721.setText("");
          LibCPD770.setText("");
          LibCPD761.setText("");
          LibCPD741.setText("");
          LibCPD700.setText("");
          LibCPD750.setText("");
          LibCPD754.setText("");
          LibCPD756.setText("");
          LibCPD723.setText("");          
          LibCPD783.setText("");
          LibCPD762.setText("");
          LibCPD766.setText("");
          LibCPD790.setText("");
          
          Imp731.setText(""); 
          Imp732.setText(""); 
          Imp733.setText(""); 
          Imp722.setText(""); 
          Imp764.setText(""); 
          Imp720.setText(""); 
          Imp721.setText(""); 
          Imp770.setText(""); 
          Imp761.setText(""); 
          Imp741.setText(""); 
          Imp700.setText(""); 
          Imp750.setText(""); 
          Imp754.setText(""); 
          Imp756.setText(""); 
          Imp723.setText("");          
          Imp783.setText(""); 
          Imp762.setText(""); 
          Imp766.setText(""); 
          Imp790.setText(""); 
          
          DanfeEPEC731.setText("");
          DanfeEPEC732.setText("");
          DanfeEPEC733.setText("");
          DanfeEPEC764.setText("");
          DanfeEPEC722.setText("");
          DanfeEPEC720.setText("");
          DanfeEPEC721.setText("");
          DanfeEPEC770.setText("");
          DanfeEPEC761.setText("");
          DanfeEPEC741.setText("");
          DanfeEPEC700.setText("");
          DanfeEPEC750.setText("");
          DanfeEPEC754.setText("");
          DanfeEPEC756.setText("");
          DanfeEPEC723.setText("");          
          DanfeEPEC783.setText("");
          DanfeEPEC762.setText("");
          DanfeEPEC766.setText("");
          DanfeEPEC790.setText("");
          
          Danfe731.setText(""); 
          Danfe732.setText("");
          Danfe733.setText("");
          Danfe764.setText("");
          Danfe722.setText("");
          Danfe720.setText("");
          Danfe721.setText("");
          Danfe770.setText("");
          Danfe761.setText("");
          Danfe741.setText("");
          Danfe700.setText("");
          Danfe750.setText("");
          Danfe754.setText("");
          Danfe756.setText("");
          Danfe723.setText("");        
          Danfe783.setText("");
          Danfe762.setText("");
          Danfe766.setText("");
          Danfe790.setText("");
         
          Operador731.setText(""); 
          Operador732.setText(""); 
          Operador733.setText(""); 
          Operador764.setText(""); 
          Operador722.setText(""); 
          Operador720.setText(""); 
          Operador721.setText(""); 
          Operador770.setText(""); 
          Operador761.setText(""); 
          Operador741.setText(""); 
          Operador700.setText(""); 
          Operador750.setText(""); 
          Operador754.setText(""); 
          Operador756.setText(""); 
          Operador723.setText("");        
          Operador783.setText(""); 
          Operador762.setText(""); 
          Operador766.setText(""); 
          Operador790.setText(""); 
          
          TerminoImp731.setText(""); 
          TerminoImp732.setText(""); 
          TerminoImp733.setText(""); 
          TerminoImp764.setText(""); 
          TerminoImp722.setText(""); 
          TerminoImp720.setText(""); 
          TerminoImp721.setText(""); 
          TerminoImp770.setText(""); 
          TerminoImp761.setText(""); 
          TerminoImp741.setText(""); 
          TerminoImp700.setText(""); 
          TerminoImp750.setText(""); 
          TerminoImp754.setText(""); 
          TerminoImp756.setText(""); 
          TerminoImp723.setText("");           
          TerminoImp783.setText(""); 
          TerminoImp762.setText(""); 
          TerminoImp766.setText(""); 
          TerminoImp790.setText(""); 
        
          Saida731.setText("");
          Saida732.setText("");
          Saida733.setText("");
          Saida722.setText("");
          Saida764.setText("");
          Saida720.setText("");
          Saida721.setText("");
          Saida741.setText("");
          Saida770.setText("");
          Saida761.setText("");
          Saida700.setText("");
          Saida750.setText("");
          Saida754.setText("");
          Saida756.setText("");
          Saida723.setText("");
          Saida783.setText("");
          Saida762.setText("");
          Saida766.setText("");
          Saida790.setText("");
          
          
      }
      
       public void unidades(){
          
           List<Pln0030p> dados = Pln0030pJpaDAO.getInstance().findByData(DataTxt.getText());
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
             
             
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRota().equals("731")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getUnidades().replace("", "");
                rota731 = rota731Temp;
                Unidades731.setText(rota731);                 
              }
              if(dados.get(b).getRota().equals("732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getUnidades().replace("", "");
                rota732 = rota732Temp;
                Unidades732.setText(rota732); 
              }
              if(dados.get(b).getRota().equals("733")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getUnidades().replace("", "");
                rota733 = rota733Temp;
                Unidades733.setText(rota733); 
              }
              if(dados.get(b).getRota().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getUnidades().replace("", "");
                rota764 = rota764Temp;
                Unidades764.setText(rota764); 
              }
              if(dados.get(b).getRota().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getUnidades().replace("", "");
                rota722 = rota722Temp;
                Unidades722.setText(rota722); 
              }
              if(dados.get(b).getRota().equals("720")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getUnidades().replace("", "");
                rota720 = rota720Temp;
                Unidades720.setText(rota720); 
              }
              if(dados.get(b).getRota().equals("721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getUnidades().replace("", "");
                rota721 = rota721Temp;
                Unidades721.setText(rota721); 
              }
              if(dados.get(b).getRota().equals("761")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getUnidades().replace("", "");
                rota761 = rota761Temp;
                Unidades761.setText(rota761); 
              }
              if(dados.get(b).getRota().equals("770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getUnidades().replace("", "");
                rota770 = rota770Temp;
                Unidades770.setText(rota770); 
              }
              if(dados.get(b).getRota().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getUnidades().replace("", "");
                rota741 = rota741Temp;
                Unidades741.setText(rota741); 
              }
              if(dados.get(b).getRota().equals("700")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getUnidades().replace("", "");
                rota700 = rota700Temp;
                Unidades700.setText(rota700); 
              }
              if(dados.get(b).getRota().equals("750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getUnidades().replace("", "");
                rota750 = rota750Temp;
                Unidades750.setText(rota750); 
              }
              if(dados.get(b).getRota().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getUnidades().replace("", "");
                rota754 = rota754Temp;
                Unidades754.setText(rota754); 
              }
              if(dados.get(b).getRota().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getUnidades().replace("", "");
                rota756 = rota756Temp;
                Unidades756.setText(rota756); 
              }
              if(dados.get(b).getRota().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getUnidades().replace("", "");
                rota723 = rota723Temp;
                Unidades723.setText(rota723); 
              }
              if(dados.get(b).getRota().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getUnidades().replace("", "");
                rota783 = rota783Temp;
                Unidades783.setText(rota783); 
              }
              if(dados.get(b).getRota().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getUnidades().replace("", "");
                rota762 = rota762Temp;
                Unidades762.setText(rota762); 
              }
              if(dados.get(b).getRota().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getUnidades().replace("", "");
                rota766 = rota766Temp;
                Unidades766.setText(rota766); 
              }
              if(dados.get(b).getRota().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getUnidades().replace("", "");
                rota790 = rota790Temp;
                Unidades790.setText(rota790); 
              }
                            
             }                  
      }
      
      public void prevLib(){
          
           List<Rota> dados = RotaJpaDAO.getInstance().findAll();
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
             
             
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRota().equals("731")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota731 = rota731Temp;
                PrevLib731.setText(rota731); 
              }
              if(dados.get(b).getRota().equals("732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota732 = rota732Temp;
                PrevLib732.setText(rota732); 
              }
              if(dados.get(b).getRota().equals("733")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota733 = rota733Temp;
                PrevLib733.setText(rota733); 
              }
              if(dados.get(b).getRota().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota764 = rota764Temp;
                PrevLib764.setText(rota764); 
              }
              if(dados.get(b).getRota().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota722 = rota722Temp;
                PrevLib722.setText(rota722); 
              }
              if(dados.get(b).getRota().equals("720")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota720 = rota720Temp;
                PrevLib720.setText(rota720); 
              }
              if(dados.get(b).getRota().equals("721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota721 = rota721Temp;
                PrevLib721.setText(rota721); 
              }
              if(dados.get(b).getRota().equals("761")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota761 = rota761Temp;
                PrevLib761.setText(rota761); 
              }
              if(dados.get(b).getRota().equals("770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota770 = rota770Temp;
                PrevLib770.setText(rota770); 
              }
              if(dados.get(b).getRota().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota741 = rota741Temp;
                PrevLib741.setText(rota741); 
              }
              if(dados.get(b).getRota().equals("700")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota700 = rota700Temp;
                PrevLib700.setText(rota700); 
              }
              if(dados.get(b).getRota().equals("750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota750 = rota750Temp;
                PrevLib750.setText(rota750); 
              }
              if(dados.get(b).getRota().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota754 = rota754Temp;
                PrevLib754.setText(rota754); 
              }
              if(dados.get(b).getRota().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota756 = rota756Temp;
                PrevLib756.setText(rota756); 
              }
              if(dados.get(b).getRota().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota723 = rota723Temp;
                PrevLib723.setText(rota723); 
              }
              if(dados.get(b).getRota().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota783 = rota783Temp;
                PrevLib783.setText(rota783); 
              }
              if(dados.get(b).getRota().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota762 = rota762Temp;
                PrevLib762.setText(rota762); 
              }
              if(dados.get(b).getRota().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota766 = rota766Temp;
                PrevLib766.setText(rota766); 
              }
              if(dados.get(b).getRota().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getPrevisaoliberacao().replace("", "");
                rota790 = rota790Temp;
                PrevLib790.setText(rota790); 
              }
                            
             }                  
      }
      
       public void prevSaida(){
          
           List<Rota> dados = RotaJpaDAO.getInstance().findAll();
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
             
             
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRota().equals("731")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota731 = rota731Temp;
                PrevSaida731.setText(rota731); 
              }
              if(dados.get(b).getRota().equals("732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota732 = rota732Temp;
                PrevSaida732.setText(rota732); 
              }
              if(dados.get(b).getRota().equals("733")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota733 = rota733Temp;
                PrevSaida733.setText(rota733); 
              }
              if(dados.get(b).getRota().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota764 = rota764Temp;
                PrevSaida764.setText(rota764); 
              }
              if(dados.get(b).getRota().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota722 = rota722Temp;
                PrevSaida722.setText(rota722); 
              }
              if(dados.get(b).getRota().equals("720")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota720 = rota720Temp;
                PrevSaida720.setText(rota720); 
              }
              if(dados.get(b).getRota().equals("721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota721 = rota721Temp;
                PrevSaida721.setText(rota721); 
              }
              if(dados.get(b).getRota().equals("761")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota761 = rota761Temp;
                PrevSaida761.setText(rota761); 
              }
              if(dados.get(b).getRota().equals("770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota770 = rota770Temp;
                PrevSaida770.setText(rota770); 
              }
              if(dados.get(b).getRota().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota741 = rota741Temp;
                PrevSaida741.setText(rota741); 
              }
              if(dados.get(b).getRota().equals("700")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota700 = rota700Temp;
                PrevSaida700.setText(rota700); 
              }
              if(dados.get(b).getRota().equals("750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota750 = rota750Temp;
                PrevSaida750.setText(rota750); 
              }
              if(dados.get(b).getRota().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota754 = rota754Temp;
                PrevSaida754.setText(rota754); 
              }
              if(dados.get(b).getRota().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota756 = rota756Temp;
                PrevSaida756.setText(rota756); 
              }
              if(dados.get(b).getRota().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota723 = rota723Temp;
                PrevSaida723.setText(rota723); 
              }              
              if(dados.get(b).getRota().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota783 = rota783Temp;
                PrevSaida783.setText(rota783); 
              }
              if(dados.get(b).getRota().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota762 = rota762Temp;
                PrevSaida762.setText(rota762); 
              }
              if(dados.get(b).getRota().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota766 = rota766Temp;
                PrevSaida766.setText(rota766); 
              }
              if(dados.get(b).getRota().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getPrevisaosaida().replace("", "");
                rota790 = rota790Temp;
                PrevSaida790.setText(rota790); 
              }                            
            }                  
      }
       
        public void libCPD(){
          
           List<Demonstrativo> dados = DemonstrativoJpaDAO.getInstance().findByData(DataTxt.getText());
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
                         
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRota().equals("731")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota731 = rota731Temp;
                LibCPD731.setText(rota731); 
                String horacompleta = rota731;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("minutos " + minutos );
                if(minutos < 40 || minutos > 500){                  
                 LibCPD731.setForeground(new Color(0,100,0));
                } else{
                 LibCPD731.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota732 = rota732Temp;
                LibCPD732.setText(rota732); 
                String horacompleta = rota732;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total               
                 if(minutos < 40 || minutos > 500){                  
                 LibCPD732.setForeground(new Color(0,100,0));
                } else{
                 LibCPD732.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("733")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota733 = rota733Temp;
                LibCPD733.setText(rota733); 
                String horacompleta = rota733;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total               
                if(minutos < 40 || minutos > 500){                  
                 LibCPD733.setForeground(new Color(0,100,0));
                } else{
                 LibCPD733.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota722 = rota722Temp;
                LibCPD722.setText(rota722);
                String horacompleta = rota722;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total               
                if(minutos < 160 || minutos > 500){                  
                 LibCPD722.setForeground(new Color(0,100,0));
                } else{
                 LibCPD722.setForeground(Color.red);                  
                }
              }              
              if(dados.get(b).getRota().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota764 = rota764Temp;
                LibCPD764.setText(rota764); 
                String horacompleta = rota764;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total               
                if(minutos < 90 || minutos > 500){                  
                 LibCPD764.setForeground(new Color(0,100,0));
                } else{
                 LibCPD764.setForeground(Color.red);                  
                }
               }
               if(dados.get(b).getRota().equals("720")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota720 = rota720Temp;
                LibCPD720.setText(rota720); 
                String horacompleta = rota720;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total               
                 if(minutos < 120 || minutos > 500){                  
                 LibCPD720.setForeground(new Color(0,100,0));
                } else{
                 LibCPD720.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota721 = rota721Temp;
                LibCPD721.setText(rota721); 
                String horacompleta = rota721;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total               
                if(minutos < 120 || minutos > 500){                  
                 LibCPD721.setForeground(new Color(0,100,0));
                } else{
                 LibCPD721.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("761")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota761 = rota761Temp;
                LibCPD761.setText(rota761); 
                 String horacompleta = rota761;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total             
                if(minutos < 160 || minutos > 500){
                  LibCPD761.setForeground(new Color(0,100,0));                
                  } else{                  
                  LibCPD761.setForeground(Color.red); 
                  }   
              }
              if(dados.get(b).getRota().equals("770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota770 = rota770Temp;
                LibCPD770.setText(rota770); 
                String horacompleta = rota770;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total                
                if(minutos < 160 || minutos > 500){
                 LibCPD770.setForeground(new Color(0,100,0));
                } else{
                 LibCPD770.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota741 = rota741Temp;
                LibCPD741.setText(rota741); 
                String horacompleta = rota741;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total                
                if(minutos < 200 || minutos > 500){
                    System.out.println("741 " + minutos);
                 LibCPD741.setForeground(new Color(0,100,0));
                } else{
                 LibCPD741.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("700")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota700 = rota700Temp;
                LibCPD700.setText(rota700); 
                String horacompleta = rota700;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total                
                 if(minutos < 210 || minutos > 500){
                 LibCPD700.setForeground(new Color(0,100,0));
                } else{
                 LibCPD700.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota750 = rota750Temp;
                LibCPD750.setText(rota750); 
                String horacompleta = rota750;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total                
                if(minutos < 220 || minutos > 500){
                 LibCPD750.setForeground(new Color(0,100,0));
                } else{
                 LibCPD750.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota754 = rota754Temp;
                LibCPD754.setText(rota754);
                String horacompleta = rota754;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total                
                 if(minutos < 240 || minutos > 500){
                 LibCPD754.setForeground(new Color(0,100,0));
                } else{
                 LibCPD754.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota756 = rota756Temp;
                LibCPD756.setText(rota756); 
                String horacompleta = rota756;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total                
                 if(minutos < 250 || minutos > 500){
                 LibCPD756.setForeground(new Color(0,100,0));
                } else{
                 LibCPD756.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota723 = rota723Temp;
                LibCPD723.setText(rota723); 
                String horacompleta = rota723;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total                
                 if(minutos < 270 || minutos > 500){
                 LibCPD723.setForeground(new Color(0,100,0));
                } else{
                 LibCPD723.setForeground(Color.red);                  
                }
              }            
              if(dados.get(b).getRota().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota783 = rota783Temp;
                LibCPD783.setText(rota783);
                String horacompleta = rota783;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total                
                 if(minutos < 410 || minutos > 500){
                 LibCPD783.setForeground(new Color(0,100,0));
                } else{
                 LibCPD783.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRota().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota762 = rota762Temp;
                LibCPD762.setText(rota762);                 
              }
              if(dados.get(b).getRota().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota766 = rota766Temp;
                LibCPD766.setText(rota766);                 
              }
              if(dados.get(b).getRota().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getLiberacaocpd().replace("", "");
                rota790 = rota790Temp;
                LibCPD790.setText(rota790);       
              }                            
            }                  
      }
        
         public void impressora(){
          
           List<Demonstrativo> dados = DemonstrativoJpaDAO.getInstance().findByData(DataTxt.getText());
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
             
             
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRota().equals("731")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getImpressora().replace("", "");
                rota731 = rota731Temp;
                Imp731.setText(rota731); 
              }
              if(dados.get(b).getRota().equals("732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getImpressora().replace("", "");
                rota732 = rota732Temp;
                Imp732.setText(rota732); 
              }
              if(dados.get(b).getRota().equals("733")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getImpressora().replace("", "");
                rota733 = rota733Temp;
                Imp733.setText(rota733); 
              }
              if(dados.get(b).getRota().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getImpressora().replace("", "");
                rota764 = rota764Temp;
                Imp764.setText(rota764); 
              }
              if(dados.get(b).getRota().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getImpressora().replace("", "");
                rota722 = rota722Temp;
                Imp722.setText(rota722); 
              }
              if(dados.get(b).getRota().equals("720")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getImpressora().replace("", "");
                rota720 = rota720Temp;
                Imp720.setText(rota720); 
              }
              if(dados.get(b).getRota().equals("721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getImpressora().replace("", "");
                rota721 = rota721Temp;
                Imp721.setText(rota721); 
              }
              if(dados.get(b).getRota().equals("761")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getImpressora().replace("", "");
                rota761 = rota761Temp;
                Imp761.setText(rota761); 
              }
              if(dados.get(b).getRota().equals("770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getImpressora().replace("", "");
                rota770 = rota770Temp;
                Imp770.setText(rota770); 
              }
              if(dados.get(b).getRota().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getImpressora().replace("", "");
                rota741 = rota741Temp;
                Imp741.setText(rota741); 
              }
              if(dados.get(b).getRota().equals("700")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getImpressora().replace("", "");
                rota700 = rota700Temp;
                Imp700.setText(rota700); 
              }
              if(dados.get(b).getRota().equals("750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getImpressora().replace("", "");
                rota750 = rota750Temp;
                Imp750.setText(rota750); 
              }
              if(dados.get(b).getRota().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getImpressora().replace("", "");
                rota754 = rota754Temp;
                Imp754.setText(rota754); 
              }
              if(dados.get(b).getRota().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getImpressora().replace("", "");
                rota756 = rota756Temp;
                Imp756.setText(rota756); 
              }
              if(dados.get(b).getRota().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getImpressora().replace("", "");
                rota723 = rota723Temp;
                Imp723.setText(rota723); 
              }             
              if(dados.get(b).getRota().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getImpressora().replace("", "");
                rota783 = rota783Temp;
                Imp783.setText(rota783); 
              }
              if(dados.get(b).getRota().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getImpressora().replace("", "");
                rota762 = rota762Temp;
                Imp762.setText(rota762); 
              }
              if(dados.get(b).getRota().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getImpressora().replace("", "");
                rota766 = rota766Temp;
                Imp766.setText(rota766); 
              }
              if(dados.get(b).getRota().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getImpressora().replace("", "");
                rota790 = rota790Temp;
                Imp790.setText(rota790); 
              }                            
            }                  
      }
     
          public void danfeNormal(){
          
           List<Demonstrativo> dados = DemonstrativoJpaDAO.getInstance().findByData(DataTxt.getText());
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
             
             
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRota().equals("731")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getDanfenormal().replace("", "");
                rota731 = rota731Temp;
                Danfe731.setText(rota731); 
              }
              if(dados.get(b).getRota().equals("732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getDanfenormal().replace("", "");
                rota732 = rota732Temp;
                Danfe732.setText(rota732); 
              }
              if(dados.get(b).getRota().equals("733")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getDanfenormal().replace("", "");
                rota733 = rota733Temp;
                Danfe733.setText(rota733); 
              }
              if(dados.get(b).getRota().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getDanfenormal().replace("", "");
                rota764 = rota764Temp;
                Danfe764.setText(rota764); 
              }
              if(dados.get(b).getRota().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getDanfenormal().replace("", "");
                rota722 = rota722Temp;
                Danfe722.setText(rota722); 
              }
              if(dados.get(b).getRota().equals("720")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getDanfenormal().replace("", "");
                rota720 = rota720Temp;
                Danfe720.setText(rota720); 
              }
              if(dados.get(b).getRota().equals("721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getDanfenormal().replace("", "");
                rota721 = rota721Temp;
                Danfe721.setText(rota721); 
              }
              if(dados.get(b).getRota().equals("761")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getDanfenormal().replace("", "");
                rota761 = rota761Temp;
                Danfe761.setText(rota761); 
              }
              if(dados.get(b).getRota().equals("770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getDanfenormal().replace("", "");
                rota770 = rota770Temp;
                Danfe770.setText(rota770); 
              }
              if(dados.get(b).getRota().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getDanfenormal().replace("", "");
                rota741 = rota741Temp;
                Danfe741.setText(rota741); 
              }
              if(dados.get(b).getRota().equals("700")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getDanfenormal().replace("", "");
                rota700 = rota700Temp;
                Danfe700.setText(rota700); 
              }
              if(dados.get(b).getRota().equals("750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getDanfenormal().replace("", "");
                rota750 = rota750Temp;
                Danfe750.setText(rota750); 
              }
              if(dados.get(b).getRota().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getDanfenormal().replace("", "");
                rota754 = rota754Temp;
                Danfe754.setText(rota754); 
              }
              if(dados.get(b).getRota().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getDanfenormal().replace("", "");
                rota756 = rota756Temp;
                Danfe756.setText(rota756); 
              }
              if(dados.get(b).getRota().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getDanfenormal().replace("", "");
                rota723 = rota723Temp;
                Danfe723.setText(rota723); 
              }             
              if(dados.get(b).getRota().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getDanfenormal().replace("", "");
                rota783 = rota783Temp;
                Danfe783.setText(rota783); 
              }
              if(dados.get(b).getRota().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getDanfenormal().replace("", "");
                rota762 = rota762Temp;
                Danfe762.setText(rota762); 
              }
              if(dados.get(b).getRota().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getDanfenormal().replace("", "");
                rota766 = rota766Temp;
                Danfe766.setText(rota766); 
              }
              if(dados.get(b).getRota().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getDanfenormal().replace("", "");
                rota790 = rota790Temp;
                Danfe790.setText(rota790); 
              }                            
            }                  
      }
          
           public void danfeEpec(){
          
           List<Demonstrativo> dados = DemonstrativoJpaDAO.getInstance().findByData(DataTxt.getText());
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
             
             
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRota().equals("731")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getDanfeepec().replace("", "");
                rota731 = rota731Temp;
                DanfeEPEC731.setText(rota731); 
              }
              if(dados.get(b).getRota().equals("732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getDanfeepec().replace("", "");
                rota732 = rota732Temp;
                DanfeEPEC732.setText(rota732); 
              }
              if(dados.get(b).getRota().equals("733")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getDanfeepec().replace("", "");
                rota733 = rota733Temp;
                DanfeEPEC733.setText(rota733); 
              }
              if(dados.get(b).getRota().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getDanfeepec().replace("", "");
                rota764 = rota764Temp;
                DanfeEPEC764.setText(rota764); 
              }
              if(dados.get(b).getRota().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getDanfeepec().replace("", "");
                rota722 = rota722Temp;
                DanfeEPEC722.setText(rota722); 
              }
              if(dados.get(b).getRota().equals("720")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getDanfeepec().replace("", "");
                rota720 = rota720Temp;
                DanfeEPEC720.setText(rota720); 
              }
              if(dados.get(b).getRota().equals("721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getDanfeepec().replace("", "");
                rota721 = rota721Temp;
                DanfeEPEC721.setText(rota721); 
              }
              if(dados.get(b).getRota().equals("761")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getDanfeepec().replace("", "");
                rota761 = rota761Temp;
                DanfeEPEC761.setText(rota761); 
              }
              if(dados.get(b).getRota().equals("770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getDanfeepec().replace("", "");
                rota770 = rota770Temp;
                DanfeEPEC770.setText(rota770); 
              }
              if(dados.get(b).getRota().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getDanfeepec().replace("", "");
                rota741 = rota741Temp;
                DanfeEPEC741.setText(rota741); 
              }
              if(dados.get(b).getRota().equals("700")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getDanfeepec().replace("", "");
                rota700 = rota700Temp;
                DanfeEPEC700.setText(rota700); 
              }
              if(dados.get(b).getRota().equals("750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getDanfeepec().replace("", "");
                rota750 = rota750Temp;
                DanfeEPEC750.setText(rota750); 
              }
              if(dados.get(b).getRota().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getDanfeepec().replace("", "");
                rota754 = rota754Temp;
                DanfeEPEC754.setText(rota754); 
              }
              if(dados.get(b).getRota().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getDanfeepec().replace("", "");
                rota756 = rota756Temp;
                DanfeEPEC756.setText(rota756); 
              }
              if(dados.get(b).getRota().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getDanfeepec().replace("", "");
                rota723 = rota723Temp;
                DanfeEPEC723.setText(rota723); 
              }             
              if(dados.get(b).getRota().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getDanfeepec().replace("", "");
                rota783 = rota783Temp;
                DanfeEPEC783.setText(rota783); 
              }
              if(dados.get(b).getRota().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getDanfeepec().replace("", "");
                rota762 = rota762Temp;
                DanfeEPEC762.setText(rota762); 
              }
              if(dados.get(b).getRota().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getDanfeepec().replace("", "");
                rota766 = rota766Temp;
                DanfeEPEC766.setText(rota766); 
              }
              if(dados.get(b).getRota().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getDanfeepec().replace("", "");
                rota790 = rota790Temp;
                DanfeEPEC790.setText(rota790); 
              }                            
            }                  
      }
           
            public void saida(){
          
           List<SaidaRota> dados = SaidaRotaDAO.getInstance().findByData(DataTxt.getText());
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
             
             
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRt().equals("731-732")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getSaida().replace("", "");
                rota731 = rota731Temp;
                Saida731.setText(rota731); 
                String horacompleta = rota731;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 90 || minutos > 500 ){                  
                 Saida731.setForeground(new Color(0,100,0));
                } else{
                 Saida731.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("731-732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getSaida().replace("", "");
                rota732 = rota732Temp;
                Saida732.setText(rota732); 
                String horacompleta = rota732;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 90 || minutos > 500 ){                  
                 Saida732.setForeground(new Color(0,100,0));
                } else{
                 Saida732.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("731-732")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getSaida().replace("", "");
                rota733 = rota733Temp;
                Saida733.setText(rota733);
                String horacompleta = rota733;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 90 || minutos > 500 ){                  
                 Saida733.setForeground(new Color(0,100,0));
                } else{
                 Saida733.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getSaida().replace("", "");
                rota764 = rota764Temp;
                Saida764.setText(rota764); 
                 String horacompleta = rota764;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 140 || minutos > 500 ){                  
                 Saida764.setForeground(new Color(0,100,0));
                } else{
                 Saida764.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getSaida().replace("", "");
                rota722 = rota722Temp;
                Saida722.setText(rota722); 
                 String horacompleta = rota722;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 200 || minutos > 500 ){                  
                 Saida722.setForeground(new Color(0,100,0));
                } else{
                 Saida722.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("720-721")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getSaida().replace("", "");
                rota720 = rota720Temp;
                Saida720.setText(rota720);
                String horacompleta = rota720;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 220 || minutos > 500 ){                  
                 Saida720.setForeground(new Color(0,100,0));
                } else{
                 Saida720.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("720-721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getSaida().replace("", "");
                rota721 = rota721Temp;
                Saida721.setText(rota721); 
                String horacompleta = rota721;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 220 || minutos > 500 ){                  
                 Saida721.setForeground(new Color(0,100,0));
                } else{
                 Saida721.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("761-770")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getSaida().replace("", "");
                rota761 = rota761Temp;
                Saida761.setText(rota761);
                 String horacompleta = rota761;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 220 || minutos > 500 ){                  
                 Saida761.setForeground(new Color(0,100,0));
                } else{
                 Saida761.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("761-770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getSaida().replace("", "");
                rota770 = rota770Temp;
                Saida770.setText(rota770);
                String horacompleta = rota770;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 220 || minutos > 500 ){                  
                 Saida770.setForeground(new Color(0,100,0));
                } else{
                 Saida770.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getSaida().replace("", "");
                rota741 = rota741Temp;
                Saida741.setText(rota741); 
                String horacompleta = rota741;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 235 || minutos > 500 ){                  
                 Saida741.setForeground(new Color(0,100,0));
                } else{
                 Saida741.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("700-750")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getSaida().replace("", "");
                rota700 = rota700Temp;
                Saida700.setText(rota700); 
                 String horacompleta = rota700;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 250 || minutos > 500 ){                  
                 Saida700.setForeground(new Color(0,100,0));
                } else{
                 Saida700.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("700-750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getSaida().replace("", "");
                rota750 = rota750Temp;
                Saida750.setText(rota750); 
                 String horacompleta = rota750;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 250 || minutos > 500 ){                  
                 Saida750.setForeground(new Color(0,100,0));
                } else{
                 Saida750.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getSaida().replace("", "");
                rota754 = rota754Temp;
                Saida754.setText(rota754);
                String horacompleta = rota754;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 280 || minutos > 500 ){                  
                 Saida754.setForeground(new Color(0,100,0));
                } else{
                 Saida754.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getSaida().replace("", "");
                rota756 = rota756Temp;
                Saida756.setText(rota756);
                String horacompleta = rota756;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 280 || minutos > 800 ){                  
                 Saida756.setForeground(new Color(0,100,0));
                } else{
                 Saida756.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getSaida().replace("", "");
                rota723 = rota723Temp;
                Saida723.setText(rota723); 
                String horacompleta = rota723;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 300 || minutos > 800 ){                  
                 Saida723.setForeground(new Color(0,100,0));
                } else{
                 Saida723.setForeground(Color.red);                  
                }
              }              
              if(dados.get(b).getRt().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getSaida().replace("", "");
                rota783 = rota783Temp;
                Saida783.setText(rota783); 
                String horacompleta = rota783;
                String[] horamin = horacompleta.split(":");
                int hora = Integer.parseInt(horamin[0]);
                int min = Integer.parseInt(horamin[1]);
                int minutos = (hora * 60) + min; //Pega o total      
                System.out.println("saida " + minutos );
                if(minutos <= 440 || minutos > 800 ){                  
                 Saida783.setForeground(new Color(0,100,0));
                } else{
                 Saida783.setForeground(Color.red);                  
                }
              }
              if(dados.get(b).getRt().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getSaida().replace("", "");
                rota762 = rota762Temp;
                Saida762.setText(rota762); 
              }
              if(dados.get(b).getRt().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getSaida().replace("", "");
                rota766 = rota766Temp;
                Saida766.setText(rota766); 
              }
              if(dados.get(b).getRt().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getSaida().replace("", "");
                rota790 = rota790Temp;
                Saida790.setText(rota790); 
              }                            
            }                  
      }
            
          public void operador(){
          
           List<Demonstrativo> dados = DemonstrativoJpaDAO.getInstance().findByData(DataTxt.getText());
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
             
             
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRota().equals("731")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getOperador().replace("", "");
                rota731 = rota731Temp;
                Operador731.setText(rota731); 
              }
              if(dados.get(b).getRota().equals("732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getOperador().replace("", "");
                rota732 = rota732Temp;
                Operador732.setText(rota732); 
              }
              if(dados.get(b).getRota().equals("733")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getOperador().replace("", "");
                rota733 = rota733Temp;
                Operador733.setText(rota733); 
              }
              if(dados.get(b).getRota().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getOperador().replace("", "");
                rota764 = rota764Temp;
                Operador764.setText(rota764); 
              }
              if(dados.get(b).getRota().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getOperador().replace("", "");
                rota722 = rota722Temp;
                Operador722.setText(rota722); 
              }
              if(dados.get(b).getRota().equals("720")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getOperador().replace("", "");
                rota720 = rota720Temp;
                Operador720.setText(rota720); 
              }
              if(dados.get(b).getRota().equals("721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getOperador().replace("", "");
                rota721 = rota721Temp;
                Operador721.setText(rota721); 
              }
              if(dados.get(b).getRota().equals("761")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getOperador().replace("", "");
                rota761 = rota761Temp;
                Operador761.setText(rota761); 
              }
              if(dados.get(b).getRota().equals("770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getOperador().replace("", "");
                rota770 = rota770Temp;
                Operador770.setText(rota770); 
              }
              if(dados.get(b).getRota().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getOperador().replace("", "");
                rota741 = rota741Temp;
                Operador741.setText(rota741); 
              }
              if(dados.get(b).getRota().equals("700")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getOperador().replace("", "");
                rota700 = rota700Temp;
                Operador700.setText(rota700); 
              }
              if(dados.get(b).getRota().equals("750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getOperador().replace("", "");
                rota750 = rota750Temp;
                Operador750.setText(rota750); 
              }
              if(dados.get(b).getRota().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getOperador().replace("", "");
                rota754 = rota754Temp;
                Operador754.setText(rota754); 
              }
              if(dados.get(b).getRota().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getOperador().replace("", "");
                rota756 = rota756Temp;
                Operador756.setText(rota756); 
              }
              if(dados.get(b).getRota().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getOperador().replace("", "");
                rota723 = rota723Temp;
                Operador723.setText(rota723); 
              }              
              if(dados.get(b).getRota().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getOperador().replace("", "");
                rota783 = rota783Temp;
                Operador783.setText(rota783); 
              }
              if(dados.get(b).getRota().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getOperador().replace("", "");
                rota762 = rota762Temp;
                Operador762.setText(rota762); 
              }
              if(dados.get(b).getRota().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getOperador().replace("", "");
                rota766 = rota766Temp;
                Operador766.setText(rota766); 
              }
              if(dados.get(b).getRota().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getOperador().replace("", "");
                rota790 = rota790Temp;
                Operador790.setText(rota790); 
              }                            
            }                  
      }
          
      
    
     
      public void laser(){
          
           List<Laser> dados = LaserJpaDAO.getInstance().findByData(DataTxt.getText());
           
             String rota731 = ""; 
             String rota732 = ""; 
             String rota733 = ""; 
             String rota764 = ""; 
             String rota722 = ""; 
             String rota720 = ""; 
             String rota721 = ""; 
             String rota761 = ""; 
             String rota770 = ""; 
             String rota741 = ""; 
             String rota700 = ""; 
             String rota750 = "";
             String rota754 = ""; 
             String rota756 = ""; 
             String rota723 = ""; 
             String rota742 = ""; 
             String rota783 = "";
             String rota762 = ""; 
             String rota766 = ""; 
             String rota790 = ""; 
             
             
             for(int b = 0; b < dados.size(); b ++){                 
              
              if(dados.get(b).getRota().equals("731")){
                String rota731Temp = "0";
                rota731Temp = dados.get(b).getHora().replace("", "");
                rota731 = rota731Temp;
                TerminoImp731.setText(rota731);                   
              }
              if(dados.get(b).getRota().equals("732")){
                String rota732Temp = "0";
                rota732Temp = dados.get(b).getHora().replace("", "");
                rota732 = rota732Temp;
                TerminoImp732.setText(rota732); 
              }
              if(dados.get(b).getRota().equals("733")){
                String rota733Temp = "0";
                rota733Temp = dados.get(b).getHora().replace("", "");
                rota733 = rota733Temp;
                TerminoImp733.setText(rota733); 
              }
              if(dados.get(b).getRota().equals("764")){
                String rota764Temp = "0";
                rota764Temp = dados.get(b).getHora().replace("", "");
                rota764 = rota764Temp;
                TerminoImp764.setText(rota764); 
              }
              if(dados.get(b).getRota().equals("722")){
                String rota722Temp = "0";
                rota722Temp = dados.get(b).getHora().replace("", "");
                rota722 = rota722Temp;
                TerminoImp722.setText(rota722); 
              }
              if(dados.get(b).getRota().equals("720")){
                String rota720Temp = "0";
                rota720Temp = dados.get(b).getHora().replace("", "");
                rota720 = rota720Temp;
                TerminoImp720.setText(rota720); 
              }
              if(dados.get(b).getRota().equals("721")){
                String rota721Temp = "0";
                rota721Temp = dados.get(b).getHora().replace("", "");
                rota721 = rota721Temp;
                TerminoImp721.setText(rota721); 
              }
              if(dados.get(b).getRota().equals("761")){
                String rota761Temp = "0";
                rota761Temp = dados.get(b).getHora().replace("", "");
                rota761 = rota761Temp;
                TerminoImp761.setText(rota761); 
              }
              if(dados.get(b).getRota().equals("770")){
                String rota770Temp = "0";
                rota770Temp = dados.get(b).getHora().replace("", "");
                rota770 = rota770Temp;
                TerminoImp770.setText(rota770); 
              }
              if(dados.get(b).getRota().equals("741")){
                String rota741Temp = "0";
                rota741Temp = dados.get(b).getHora().replace("", "");
                rota741 = rota741Temp;
                TerminoImp741.setText(rota741); 
              }
              if(dados.get(b).getRota().equals("700")){
                String rota700Temp = "0";
                rota700Temp = dados.get(b).getHora().replace("", "");
                rota700 = rota700Temp;
                TerminoImp700.setText(rota700); 
              }
              if(dados.get(b).getRota().equals("750")){
                String rota750Temp = "0";
                rota750Temp = dados.get(b).getHora().replace("", "");
                rota750 = rota750Temp;
                TerminoImp750.setText(rota750); 
              }
              if(dados.get(b).getRota().equals("754")){
                String rota754Temp = "0";
                rota754Temp = dados.get(b).getHora().replace("", "");
                rota754 = rota754Temp;
                TerminoImp754.setText(rota754); 
              }
              if(dados.get(b).getRota().equals("756")){
                String rota756Temp = "0";
                rota756Temp = dados.get(b).getHora().replace("", "");
                rota756 = rota756Temp;
                TerminoImp756.setText(rota756); 
              }
              if(dados.get(b).getRota().equals("723")){
                String rota723Temp = "0";
                rota723Temp = dados.get(b).getHora().replace("", "");
                rota723 = rota723Temp;
                TerminoImp723.setText(rota723); 
              }              
              if(dados.get(b).getRota().equals("783")){
                String rota783Temp = "0";
                rota783Temp = dados.get(b).getHora().replace("", "");
                rota783 = rota783Temp;
                TerminoImp783.setText(rota783); 
              }
              if(dados.get(b).getRota().equals("762")){
                String rota762Temp = "0";
                rota762Temp = dados.get(b).getHora().replace("", "");
                rota762 = rota762Temp;
                TerminoImp762.setText(rota762); 
              }
              if(dados.get(b).getRota().equals("766")){
                String rota766Temp = "0";
                rota766Temp = dados.get(b).getHora().replace("", "");
                rota766 = rota766Temp;
                TerminoImp766.setText(rota766); 
              }
              if(dados.get(b).getRota().equals("790")){
                String rota790Temp = "0";
                rota790Temp = dados.get(b).getHora().replace("", "");
                rota790 = rota790Temp;
                TerminoImp790.setText(rota790); 
              }                            
            }                  
      }
          
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Unidades732 = new javax.swing.JLabel();
        Unidades733 = new javax.swing.JLabel();
        Unidades764 = new javax.swing.JLabel();
        Unidades722 = new javax.swing.JLabel();
        Unidades720 = new javax.swing.JLabel();
        Unidades721 = new javax.swing.JLabel();
        Unidades761 = new javax.swing.JLabel();
        Unidades770 = new javax.swing.JLabel();
        Unidades741 = new javax.swing.JLabel();
        Unidades700 = new javax.swing.JLabel();
        Unidades750 = new javax.swing.JLabel();
        Unidades754 = new javax.swing.JLabel();
        Unidades756 = new javax.swing.JLabel();
        Unidades723 = new javax.swing.JLabel();
        Unidades731 = new javax.swing.JLabel();
        Unidades783 = new javax.swing.JLabel();
        Unidades762 = new javax.swing.JLabel();
        Unidades766 = new javax.swing.JLabel();
        Unidades790 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PrevLib731 = new javax.swing.JLabel();
        PrevLib732 = new javax.swing.JLabel();
        PrevLib733 = new javax.swing.JLabel();
        PrevLib764 = new javax.swing.JLabel();
        PrevLib722 = new javax.swing.JLabel();
        PrevLib720 = new javax.swing.JLabel();
        PrevLib721 = new javax.swing.JLabel();
        PrevLib761 = new javax.swing.JLabel();
        PrevLib770 = new javax.swing.JLabel();
        PrevLib741 = new javax.swing.JLabel();
        PrevLib700 = new javax.swing.JLabel();
        PrevLib750 = new javax.swing.JLabel();
        PrevLib754 = new javax.swing.JLabel();
        PrevLib756 = new javax.swing.JLabel();
        PrevLib723 = new javax.swing.JLabel();
        PrevLib783 = new javax.swing.JLabel();
        PrevLib762 = new javax.swing.JLabel();
        PrevLib766 = new javax.swing.JLabel();
        PrevLib790 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        LibCPD731 = new javax.swing.JLabel();
        LibCPD732 = new javax.swing.JLabel();
        LibCPD733 = new javax.swing.JLabel();
        LibCPD764 = new javax.swing.JLabel();
        LibCPD722 = new javax.swing.JLabel();
        LibCPD720 = new javax.swing.JLabel();
        LibCPD721 = new javax.swing.JLabel();
        LibCPD761 = new javax.swing.JLabel();
        LibCPD770 = new javax.swing.JLabel();
        LibCPD741 = new javax.swing.JLabel();
        LibCPD700 = new javax.swing.JLabel();
        LibCPD750 = new javax.swing.JLabel();
        LibCPD754 = new javax.swing.JLabel();
        LibCPD756 = new javax.swing.JLabel();
        LibCPD723 = new javax.swing.JLabel();
        LibCPD783 = new javax.swing.JLabel();
        LibCPD762 = new javax.swing.JLabel();
        LibCPD766 = new javax.swing.JLabel();
        LibCPD790 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Imp731 = new javax.swing.JLabel();
        Imp732 = new javax.swing.JLabel();
        Imp733 = new javax.swing.JLabel();
        Imp764 = new javax.swing.JLabel();
        Imp722 = new javax.swing.JLabel();
        Imp720 = new javax.swing.JLabel();
        Imp721 = new javax.swing.JLabel();
        Imp761 = new javax.swing.JLabel();
        Imp770 = new javax.swing.JLabel();
        Imp741 = new javax.swing.JLabel();
        Imp700 = new javax.swing.JLabel();
        Imp750 = new javax.swing.JLabel();
        Imp754 = new javax.swing.JLabel();
        Imp756 = new javax.swing.JLabel();
        Imp723 = new javax.swing.JLabel();
        Imp783 = new javax.swing.JLabel();
        Imp762 = new javax.swing.JLabel();
        Imp766 = new javax.swing.JLabel();
        Imp790 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        Danfe731 = new javax.swing.JLabel();
        Danfe732 = new javax.swing.JLabel();
        Danfe733 = new javax.swing.JLabel();
        Danfe764 = new javax.swing.JLabel();
        Danfe722 = new javax.swing.JLabel();
        Danfe720 = new javax.swing.JLabel();
        Danfe721 = new javax.swing.JLabel();
        Danfe761 = new javax.swing.JLabel();
        Danfe770 = new javax.swing.JLabel();
        Danfe741 = new javax.swing.JLabel();
        Danfe700 = new javax.swing.JLabel();
        Danfe750 = new javax.swing.JLabel();
        Danfe754 = new javax.swing.JLabel();
        Danfe756 = new javax.swing.JLabel();
        Danfe723 = new javax.swing.JLabel();
        Danfe783 = new javax.swing.JLabel();
        Danfe762 = new javax.swing.JLabel();
        Danfe766 = new javax.swing.JLabel();
        Danfe790 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        DanfeEPEC731 = new javax.swing.JLabel();
        DanfeEPEC732 = new javax.swing.JLabel();
        DanfeEPEC733 = new javax.swing.JLabel();
        DanfeEPEC764 = new javax.swing.JLabel();
        DanfeEPEC722 = new javax.swing.JLabel();
        DanfeEPEC720 = new javax.swing.JLabel();
        DanfeEPEC721 = new javax.swing.JLabel();
        DanfeEPEC761 = new javax.swing.JLabel();
        DanfeEPEC770 = new javax.swing.JLabel();
        DanfeEPEC741 = new javax.swing.JLabel();
        DanfeEPEC700 = new javax.swing.JLabel();
        DanfeEPEC750 = new javax.swing.JLabel();
        DanfeEPEC754 = new javax.swing.JLabel();
        DanfeEPEC756 = new javax.swing.JLabel();
        DanfeEPEC723 = new javax.swing.JLabel();
        DanfeEPEC783 = new javax.swing.JLabel();
        DanfeEPEC762 = new javax.swing.JLabel();
        DanfeEPEC766 = new javax.swing.JLabel();
        DanfeEPEC790 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        TerminoImp731 = new javax.swing.JLabel();
        TerminoImp732 = new javax.swing.JLabel();
        TerminoImp733 = new javax.swing.JLabel();
        TerminoImp764 = new javax.swing.JLabel();
        TerminoImp722 = new javax.swing.JLabel();
        TerminoImp720 = new javax.swing.JLabel();
        TerminoImp721 = new javax.swing.JLabel();
        TerminoImp761 = new javax.swing.JLabel();
        TerminoImp770 = new javax.swing.JLabel();
        TerminoImp741 = new javax.swing.JLabel();
        TerminoImp700 = new javax.swing.JLabel();
        TerminoImp750 = new javax.swing.JLabel();
        TerminoImp754 = new javax.swing.JLabel();
        TerminoImp756 = new javax.swing.JLabel();
        TerminoImp723 = new javax.swing.JLabel();
        TerminoImp783 = new javax.swing.JLabel();
        TerminoImp762 = new javax.swing.JLabel();
        TerminoImp766 = new javax.swing.JLabel();
        TerminoImp790 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        PrevSaida731 = new javax.swing.JLabel();
        PrevSaida732 = new javax.swing.JLabel();
        PrevSaida733 = new javax.swing.JLabel();
        PrevSaida764 = new javax.swing.JLabel();
        PrevSaida722 = new javax.swing.JLabel();
        PrevSaida720 = new javax.swing.JLabel();
        PrevSaida721 = new javax.swing.JLabel();
        PrevSaida761 = new javax.swing.JLabel();
        PrevSaida770 = new javax.swing.JLabel();
        PrevSaida741 = new javax.swing.JLabel();
        PrevSaida700 = new javax.swing.JLabel();
        PrevSaida750 = new javax.swing.JLabel();
        PrevSaida754 = new javax.swing.JLabel();
        PrevSaida756 = new javax.swing.JLabel();
        PrevSaida723 = new javax.swing.JLabel();
        PrevSaida783 = new javax.swing.JLabel();
        PrevSaida762 = new javax.swing.JLabel();
        PrevSaida766 = new javax.swing.JLabel();
        PrevSaida790 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        Saida731 = new javax.swing.JLabel();
        Saida732 = new javax.swing.JLabel();
        Saida733 = new javax.swing.JLabel();
        Saida764 = new javax.swing.JLabel();
        Saida722 = new javax.swing.JLabel();
        Saida720 = new javax.swing.JLabel();
        Saida721 = new javax.swing.JLabel();
        Saida761 = new javax.swing.JLabel();
        Saida770 = new javax.swing.JLabel();
        Saida741 = new javax.swing.JLabel();
        Saida700 = new javax.swing.JLabel();
        Saida750 = new javax.swing.JLabel();
        Saida754 = new javax.swing.JLabel();
        Saida756 = new javax.swing.JLabel();
        Saida723 = new javax.swing.JLabel();
        Saida783 = new javax.swing.JLabel();
        Saida762 = new javax.swing.JLabel();
        Saida766 = new javax.swing.JLabel();
        Saida790 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        Operador731 = new javax.swing.JLabel();
        Operador732 = new javax.swing.JLabel();
        Operador733 = new javax.swing.JLabel();
        Operador764 = new javax.swing.JLabel();
        Operador722 = new javax.swing.JLabel();
        Operador720 = new javax.swing.JLabel();
        Operador721 = new javax.swing.JLabel();
        Operador761 = new javax.swing.JLabel();
        Operador770 = new javax.swing.JLabel();
        Operador741 = new javax.swing.JLabel();
        Operador700 = new javax.swing.JLabel();
        Operador750 = new javax.swing.JLabel();
        Operador754 = new javax.swing.JLabel();
        Operador756 = new javax.swing.JLabel();
        Operador723 = new javax.swing.JLabel();
        Operador783 = new javax.swing.JLabel();
        Operador762 = new javax.swing.JLabel();
        Operador766 = new javax.swing.JLabel();
        Operador790 = new javax.swing.JLabel();
        Unidades734 = new javax.swing.JLabel();
        Unidades735 = new javax.swing.JLabel();
        Unidades736 = new javax.swing.JLabel();
        Unidades765 = new javax.swing.JLabel();
        Unidades724 = new javax.swing.JLabel();
        Unidades725 = new javax.swing.JLabel();
        Unidades726 = new javax.swing.JLabel();
        Unidades763 = new javax.swing.JLabel();
        Unidades771 = new javax.swing.JLabel();
        Unidades743 = new javax.swing.JLabel();
        Unidades701 = new javax.swing.JLabel();
        Unidades751 = new javax.swing.JLabel();
        Unidades755 = new javax.swing.JLabel();
        Unidades757 = new javax.swing.JLabel();
        Unidades727 = new javax.swing.JLabel();
        Unidades784 = new javax.swing.JLabel();
        Unidades767 = new javax.swing.JLabel();
        Unidades768 = new javax.swing.JLabel();
        Unidades791 = new javax.swing.JLabel();
        DataTxt = new javax.swing.JFormattedTextField();

        jPanel4.setBackground(new java.awt.Color(0, 0, 187));

        jLabel25.setFont(new java.awt.Font("Lucida Fax", 2, 40)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Demonstrativo dos Fechamentos Diário - CPD");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 187));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(187, 187, 187));

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Unidades");

        Unidades732.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades733.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades764.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades722.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades720.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades721.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades761.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades770.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades741.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades700.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades750.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades754.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades756.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades723.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades731.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades783.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades762.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades766.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades790.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Unidades790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Prev. Lib.");

        PrevLib731.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib731.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib732.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib732.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib733.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib733.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib764.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib764.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib722.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib722.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib720.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib720.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib721.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib721.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib761.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib761.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib770.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib770.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib741.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib741.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib700.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib700.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib750.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib750.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib754.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib754.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib756.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib756.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib723.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib723.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib783.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib783.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib762.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib762.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib766.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib766.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevLib790.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevLib790.setForeground(new java.awt.Color(255, 0, 0));
        PrevLib790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel31.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Lib. CPD");

        LibCPD731.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD732.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD733.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD764.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD722.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD720.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD721.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD761.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD770.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD741.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD700.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD750.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD754.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD756.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD723.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD783.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD762.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD766.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LibCPD790.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        LibCPD790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel32.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 51));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Impressora");

        Imp731.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp732.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp733.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp764.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp722.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp720.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp721.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp761.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp770.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp741.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp700.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp750.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp754.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp756.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp723.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp783.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp762.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp766.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Imp790.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Imp790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel33.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 51));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Danfe Nor.");

        Danfe731.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe732.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe733.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe764.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe722.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe720.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe721.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe761.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe770.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe741.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe700.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe750.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe754.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe756.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe723.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe783.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe762.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe766.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Danfe790.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Danfe790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel34.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 51));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Danfe EPEC");

        DanfeEPEC731.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC732.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC733.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC764.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC722.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC720.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC721.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC761.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC770.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC741.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC700.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC750.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC754.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC756.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC723.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC783.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC762.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC766.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        DanfeEPEC790.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        DanfeEPEC790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel35.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 51));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Termino Imp");

        TerminoImp731.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp732.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp733.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp764.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp722.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp720.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp721.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp761.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp770.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp741.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp700.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp750.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp754.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp756.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp723.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp783.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp762.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp766.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TerminoImp790.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        TerminoImp790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel36.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 51));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Prev. Saida");

        PrevSaida731.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida731.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida732.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida732.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida733.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida733.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida764.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida764.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida722.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida722.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida720.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida720.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida721.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida721.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida761.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida761.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida770.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida770.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida741.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida741.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida700.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida700.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida750.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida750.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida754.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida754.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida756.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida756.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida723.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida723.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida783.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida783.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida762.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida762.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida766.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida766.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        PrevSaida790.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        PrevSaida790.setForeground(new java.awt.Color(255, 0, 0));
        PrevSaida790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel37.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 51));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Saída CD");

        Saida731.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida732.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida733.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida764.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida722.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida720.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida721.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida761.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida770.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida741.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida700.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida750.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida754.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida756.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida723.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida783.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida762.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida766.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Saida790.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Saida790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel38.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 51));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Operador");

        Operador731.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador731.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador732.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador732.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador733.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador733.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador764.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador764.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador722.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador722.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador720.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador720.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador721.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador721.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador761.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador761.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador770.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador770.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador741.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador741.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador700.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador700.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador750.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador750.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador754.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador754.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador756.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador756.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador723.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador723.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador783.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador783.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador762.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador762.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador766.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador766.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Operador790.setFont(new java.awt.Font("Lucida Fax", 2, 14)); // NOI18N
        Operador790.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Unidades734.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades734.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades734.setText("731");

        Unidades735.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades735.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades735.setText("732");

        Unidades736.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades736.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades736.setText("733");

        Unidades765.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades765.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades765.setText("764");

        Unidades724.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades724.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades724.setText("722");

        Unidades725.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades725.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades725.setText("720");

        Unidades726.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades726.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades726.setText("721");

        Unidades763.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades763.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades763.setText("761");

        Unidades771.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades771.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades771.setText("770");

        Unidades743.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades743.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades743.setText("741");

        Unidades701.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades701.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades701.setText("700");

        Unidades751.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades751.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades751.setText("750");

        Unidades755.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades755.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades755.setText("754");

        Unidades757.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades757.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades757.setText("756");

        Unidades727.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades727.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades727.setText("723");

        Unidades784.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades784.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades784.setText("783");

        Unidades767.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades767.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades767.setText("762");

        Unidades768.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades768.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades768.setText("766");

        Unidades791.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        Unidades791.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Unidades791.setText("790");

        DataTxt.setBackground(new java.awt.Color(187, 187, 187));
        DataTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        DataTxt.setFont(new java.awt.Font("Lucida Fax", 0, 10)); // NOI18N
        DataTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataTxtActionPerformed(evt);
            }
        });
        DataTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DataTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Unidades767, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades768, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades791, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades765, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades725, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades726, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades763, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades771, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades743, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades701, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades751, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades755, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades757, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades727, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades735, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades736, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades734, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades724, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Unidades784, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(Unidades731, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades732, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades733, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades764, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades722, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades720, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades721, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades761, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades770, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades741, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades700, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades750, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades754, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades723, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades756, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades783, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades762, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades766, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Unidades790, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib731, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib732, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib733, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib764, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib722, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib720, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib721, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib761, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib770, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib741, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib700, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib750, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib754, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib756, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib723, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib783, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib762, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib766, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevLib790, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LibCPD762, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LibCPD766, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LibCPD790, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LibCPD764, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD720, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD721, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD761, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD770, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD741, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD700, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD750, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD754, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD756, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD723, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD732, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD733, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD731, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD722, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LibCPD783, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Imp762, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Imp766, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Imp790, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Imp764, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp720, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp721, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp761, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp770, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp741, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp700, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp750, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp754, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp756, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp723, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp732, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp733, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp731, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp722, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Imp783, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Danfe762, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Danfe766, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Danfe790, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Danfe764, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe720, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe721, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe761, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe770, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe741, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe700, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe750, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe754, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe756, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe723, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe732, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe733, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe731, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe722, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Danfe783, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DanfeEPEC762, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DanfeEPEC766, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DanfeEPEC790, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(DanfeEPEC764, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC720, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC721, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC761, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC770, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC741, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC700, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC750, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC754, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC756, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC723, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC732, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC733, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC731, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC722, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DanfeEPEC783, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TerminoImp762, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TerminoImp766, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TerminoImp790, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TerminoImp764, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp720, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp721, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp761, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp770, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp741, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp700, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp750, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp754, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp756, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp723, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp732, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp733, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp731, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp722, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TerminoImp783, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrevSaida762, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevSaida766, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrevSaida790, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(PrevSaida764, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida720, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida721, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida761, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida770, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida741, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida700, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida750, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida754, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida756, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida723, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida732, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida733, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida731, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida722, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PrevSaida783, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Saida762, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida766, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Saida790, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Saida764, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida720, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida721, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida761, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida770, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida741, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida700, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida750, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida754, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida756, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida723, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida732, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida733, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida731, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida722, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Saida783, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Operador762, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Operador766, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Operador790, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Operador764, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador720, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador721, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador761, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador770, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador741, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador700, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador750, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador754, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador756, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador723, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador732, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador733, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador731, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador722, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Operador783, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Unidades734, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades735, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades736, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades765, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades724, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades725, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades726, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades763, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades771, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades743, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades701, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades751, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades755, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades757, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades727, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(Unidades784, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(Unidades767, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(Unidades768, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Unidades791, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Operador731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Operador723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(Operador783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(Operador762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(Operador766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Operador790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Saida731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Saida723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(Saida783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(Saida762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(Saida766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Saida790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(PrevSaida731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevSaida723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(PrevSaida783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(PrevSaida762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(PrevSaida766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PrevSaida790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TerminoImp731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerminoImp723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(TerminoImp783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(TerminoImp762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(TerminoImp766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TerminoImp790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(DanfeEPEC731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DanfeEPEC723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(DanfeEPEC783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(DanfeEPEC762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(DanfeEPEC766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DanfeEPEC790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Danfe731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Danfe723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(Danfe783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(Danfe762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(Danfe766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Danfe790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Imp731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Imp723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(Imp783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(Imp762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(Imp766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Imp790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(LibCPD731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LibCPD723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(LibCPD783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(LibCPD762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(LibCPD766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LibCPD790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(PrevLib731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PrevLib723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(PrevLib783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(PrevLib762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(PrevLib766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PrevLib790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Unidades731, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades732, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades733, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades764, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades722, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades720, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades721, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades761, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades770, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades741, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades700, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades750, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades754, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades756, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Unidades723, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                            .addComponent(Unidades783, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27))
                                    .addComponent(Unidades762, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addComponent(Unidades766, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Unidades790, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DataTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DataTxtKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10){
            try {
                jLabel25.requestFocus();
                preencherTabela();
            } catch (IOException ex) {
                Logger.getLogger(FrameMonitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DataTxtKeyReleased

    private void DataTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Danfe700;
    private javax.swing.JLabel Danfe720;
    private javax.swing.JLabel Danfe721;
    private javax.swing.JLabel Danfe722;
    private javax.swing.JLabel Danfe723;
    private javax.swing.JLabel Danfe731;
    private javax.swing.JLabel Danfe732;
    private javax.swing.JLabel Danfe733;
    private javax.swing.JLabel Danfe741;
    private javax.swing.JLabel Danfe750;
    private javax.swing.JLabel Danfe754;
    private javax.swing.JLabel Danfe756;
    private javax.swing.JLabel Danfe761;
    private javax.swing.JLabel Danfe762;
    private javax.swing.JLabel Danfe764;
    private javax.swing.JLabel Danfe766;
    private javax.swing.JLabel Danfe770;
    private javax.swing.JLabel Danfe783;
    private javax.swing.JLabel Danfe790;
    private javax.swing.JLabel DanfeEPEC700;
    private javax.swing.JLabel DanfeEPEC720;
    private javax.swing.JLabel DanfeEPEC721;
    private javax.swing.JLabel DanfeEPEC722;
    private javax.swing.JLabel DanfeEPEC723;
    private javax.swing.JLabel DanfeEPEC731;
    private javax.swing.JLabel DanfeEPEC732;
    private javax.swing.JLabel DanfeEPEC733;
    private javax.swing.JLabel DanfeEPEC741;
    private javax.swing.JLabel DanfeEPEC750;
    private javax.swing.JLabel DanfeEPEC754;
    private javax.swing.JLabel DanfeEPEC756;
    private javax.swing.JLabel DanfeEPEC761;
    private javax.swing.JLabel DanfeEPEC762;
    private javax.swing.JLabel DanfeEPEC764;
    private javax.swing.JLabel DanfeEPEC766;
    private javax.swing.JLabel DanfeEPEC770;
    private javax.swing.JLabel DanfeEPEC783;
    private javax.swing.JLabel DanfeEPEC790;
    private javax.swing.JFormattedTextField DataTxt;
    private javax.swing.JLabel Imp700;
    private javax.swing.JLabel Imp720;
    private javax.swing.JLabel Imp721;
    private javax.swing.JLabel Imp722;
    private javax.swing.JLabel Imp723;
    private javax.swing.JLabel Imp731;
    private javax.swing.JLabel Imp732;
    private javax.swing.JLabel Imp733;
    private javax.swing.JLabel Imp741;
    private javax.swing.JLabel Imp750;
    private javax.swing.JLabel Imp754;
    private javax.swing.JLabel Imp756;
    private javax.swing.JLabel Imp761;
    private javax.swing.JLabel Imp762;
    private javax.swing.JLabel Imp764;
    private javax.swing.JLabel Imp766;
    private javax.swing.JLabel Imp770;
    private javax.swing.JLabel Imp783;
    private javax.swing.JLabel Imp790;
    private javax.swing.JLabel LibCPD700;
    private javax.swing.JLabel LibCPD720;
    private javax.swing.JLabel LibCPD721;
    private javax.swing.JLabel LibCPD722;
    private javax.swing.JLabel LibCPD723;
    private javax.swing.JLabel LibCPD731;
    private javax.swing.JLabel LibCPD732;
    private javax.swing.JLabel LibCPD733;
    private javax.swing.JLabel LibCPD741;
    private javax.swing.JLabel LibCPD750;
    private javax.swing.JLabel LibCPD754;
    private javax.swing.JLabel LibCPD756;
    private javax.swing.JLabel LibCPD761;
    private javax.swing.JLabel LibCPD762;
    private javax.swing.JLabel LibCPD764;
    private javax.swing.JLabel LibCPD766;
    private javax.swing.JLabel LibCPD770;
    private javax.swing.JLabel LibCPD783;
    private javax.swing.JLabel LibCPD790;
    private javax.swing.JLabel Operador700;
    private javax.swing.JLabel Operador720;
    private javax.swing.JLabel Operador721;
    private javax.swing.JLabel Operador722;
    private javax.swing.JLabel Operador723;
    private javax.swing.JLabel Operador731;
    private javax.swing.JLabel Operador732;
    private javax.swing.JLabel Operador733;
    private javax.swing.JLabel Operador741;
    private javax.swing.JLabel Operador750;
    private javax.swing.JLabel Operador754;
    private javax.swing.JLabel Operador756;
    private javax.swing.JLabel Operador761;
    private javax.swing.JLabel Operador762;
    private javax.swing.JLabel Operador764;
    private javax.swing.JLabel Operador766;
    private javax.swing.JLabel Operador770;
    private javax.swing.JLabel Operador783;
    private javax.swing.JLabel Operador790;
    private javax.swing.JLabel PrevLib700;
    private javax.swing.JLabel PrevLib720;
    private javax.swing.JLabel PrevLib721;
    private javax.swing.JLabel PrevLib722;
    private javax.swing.JLabel PrevLib723;
    private javax.swing.JLabel PrevLib731;
    private javax.swing.JLabel PrevLib732;
    private javax.swing.JLabel PrevLib733;
    private javax.swing.JLabel PrevLib741;
    private javax.swing.JLabel PrevLib750;
    private javax.swing.JLabel PrevLib754;
    private javax.swing.JLabel PrevLib756;
    private javax.swing.JLabel PrevLib761;
    private javax.swing.JLabel PrevLib762;
    private javax.swing.JLabel PrevLib764;
    private javax.swing.JLabel PrevLib766;
    private javax.swing.JLabel PrevLib770;
    private javax.swing.JLabel PrevLib783;
    private javax.swing.JLabel PrevLib790;
    private javax.swing.JLabel PrevSaida700;
    private javax.swing.JLabel PrevSaida720;
    private javax.swing.JLabel PrevSaida721;
    private javax.swing.JLabel PrevSaida722;
    private javax.swing.JLabel PrevSaida723;
    private javax.swing.JLabel PrevSaida731;
    private javax.swing.JLabel PrevSaida732;
    private javax.swing.JLabel PrevSaida733;
    private javax.swing.JLabel PrevSaida741;
    private javax.swing.JLabel PrevSaida750;
    private javax.swing.JLabel PrevSaida754;
    private javax.swing.JLabel PrevSaida756;
    private javax.swing.JLabel PrevSaida761;
    private javax.swing.JLabel PrevSaida762;
    private javax.swing.JLabel PrevSaida764;
    private javax.swing.JLabel PrevSaida766;
    private javax.swing.JLabel PrevSaida770;
    private javax.swing.JLabel PrevSaida783;
    private javax.swing.JLabel PrevSaida790;
    private javax.swing.JLabel Saida700;
    private javax.swing.JLabel Saida720;
    private javax.swing.JLabel Saida721;
    private javax.swing.JLabel Saida722;
    private javax.swing.JLabel Saida723;
    private javax.swing.JLabel Saida731;
    private javax.swing.JLabel Saida732;
    private javax.swing.JLabel Saida733;
    private javax.swing.JLabel Saida741;
    private javax.swing.JLabel Saida750;
    private javax.swing.JLabel Saida754;
    private javax.swing.JLabel Saida756;
    private javax.swing.JLabel Saida761;
    private javax.swing.JLabel Saida762;
    private javax.swing.JLabel Saida764;
    private javax.swing.JLabel Saida766;
    private javax.swing.JLabel Saida770;
    private javax.swing.JLabel Saida783;
    private javax.swing.JLabel Saida790;
    private javax.swing.JLabel TerminoImp700;
    private javax.swing.JLabel TerminoImp720;
    private javax.swing.JLabel TerminoImp721;
    private javax.swing.JLabel TerminoImp722;
    private javax.swing.JLabel TerminoImp723;
    private javax.swing.JLabel TerminoImp731;
    private javax.swing.JLabel TerminoImp732;
    private javax.swing.JLabel TerminoImp733;
    private javax.swing.JLabel TerminoImp741;
    private javax.swing.JLabel TerminoImp750;
    private javax.swing.JLabel TerminoImp754;
    private javax.swing.JLabel TerminoImp756;
    private javax.swing.JLabel TerminoImp761;
    private javax.swing.JLabel TerminoImp762;
    private javax.swing.JLabel TerminoImp764;
    private javax.swing.JLabel TerminoImp766;
    private javax.swing.JLabel TerminoImp770;
    private javax.swing.JLabel TerminoImp783;
    private javax.swing.JLabel TerminoImp790;
    private javax.swing.JLabel Unidades700;
    private javax.swing.JLabel Unidades701;
    private javax.swing.JLabel Unidades720;
    private javax.swing.JLabel Unidades721;
    private javax.swing.JLabel Unidades722;
    private javax.swing.JLabel Unidades723;
    private javax.swing.JLabel Unidades724;
    private javax.swing.JLabel Unidades725;
    private javax.swing.JLabel Unidades726;
    private javax.swing.JLabel Unidades727;
    private javax.swing.JLabel Unidades731;
    private javax.swing.JLabel Unidades732;
    private javax.swing.JLabel Unidades733;
    private javax.swing.JLabel Unidades734;
    private javax.swing.JLabel Unidades735;
    private javax.swing.JLabel Unidades736;
    private javax.swing.JLabel Unidades741;
    private javax.swing.JLabel Unidades743;
    private javax.swing.JLabel Unidades750;
    private javax.swing.JLabel Unidades751;
    private javax.swing.JLabel Unidades754;
    private javax.swing.JLabel Unidades755;
    private javax.swing.JLabel Unidades756;
    private javax.swing.JLabel Unidades757;
    private javax.swing.JLabel Unidades761;
    private javax.swing.JLabel Unidades762;
    private javax.swing.JLabel Unidades763;
    private javax.swing.JLabel Unidades764;
    private javax.swing.JLabel Unidades765;
    private javax.swing.JLabel Unidades766;
    private javax.swing.JLabel Unidades767;
    private javax.swing.JLabel Unidades768;
    private javax.swing.JLabel Unidades770;
    private javax.swing.JLabel Unidades771;
    private javax.swing.JLabel Unidades783;
    private javax.swing.JLabel Unidades784;
    private javax.swing.JLabel Unidades790;
    private javax.swing.JLabel Unidades791;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
