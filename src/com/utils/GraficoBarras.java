/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author thiago.napoleao
 * 
 */

public class GraficoBarras extends ApplicationFrame {

    public ChartPanel chartPanel;
    private List<String> estacoes;
    private List<String> erros;
    private List<String> upm;
   
 

    public GraficoBarras(String chartTitle, int x, int y, List<String> estacoes, List<String> erros) {
        super(chartTitle);
        this.estacoes = estacoes;
        this.erros = erros;
        
        
        //criando tipo de grafico
        JFreeChart chart =   ChartFactory.createBarChart(
                chartTitle,
                "",
                "",
                createDataset(),
                PlotOrientation.VERTICAL,//legenda
                false, true, true);
                 
                //Cor da barra do Charts
              chart.getCategoryPlot().getRenderer(0).setSeriesPaint(0, Color.red);  
                
                //Cor de Fundo de tela do Charts
		chart.setBackgroundPaint(Color.white);
		CategoryPlot plot = chart.getCategoryPlot();
                        
		//Cor de Fundo do Chrats
		plot.setBackgroundPaint(Color.white);
                        
		 // colocando o gráfico em um painel
                 this.chartPanel = new ChartPanel(chart);
                 chartPanel.setPreferredSize(new java.awt.Dimension(x, y));
              
                // colocando valores no gráfico 
                  CategoryItemRenderer itemRerender = plot.getRenderer();
                  itemRerender.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0")));
                  itemRerender.setItemLabelsVisible(true);
                 
                  
                      BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
                      renderer.setMaximumBarWidth(0.03); //seta a largura da barra
           
             
               }
    
    /**
     * Cria um conjunto de dados
     */
    private CategoryDataset createDataset() {

        final String erros = "";
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < this.estacoes.size(); i++) {

            dataset.addValue(Double.parseDouble(this.erros.get(i)), erros, this.estacoes.get(i));
           
                   
        }
        
        return dataset;

    }

  
}
