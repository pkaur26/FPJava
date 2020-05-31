/*
 * Parneet Kaur
 * Student ID = 991544633
 * SYST10199-WEB PROGRAMMING
 */
package javafinalproject;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLDocumentController {
  
    @FXML
    private MenuItem PR;
    
    @FXML
    private MenuItem CalC;


    @FXML
    private MenuItem reseT;

    @FXML
    private MenuItem exiT;

    @FXML
    private Button cost;

    @FXML
    private Button reset;

    @FXML
    private Button exit;

    @FXML
    private ToggleGroup mytg;

    @FXML
    private RadioButton white;

    @FXML
    private RadioButton whole;

    @FXML
    private TextField t1;

    @FXML
    private TextField t2;

    @FXML
    private RadioButton non;

    @FXML
    private RadioButton cf;

    @FXML
    private RadioButton fw;

    @FXML
    private RadioButton capp;

    @FXML
    private TextField t3;

    @FXML
    private TextField t4;

    @FXML
    private TextField t5;

    @FXML
    private CheckBox cc;

    @FXML
    private CheckBox but;

    @FXML
    private CheckBox blu;

    @FXML
    private CheckBox rasp;

    @FXML
    private CheckBox nut;

    @FXML
    private CheckBox peac;

    @FXML
    private Label sum;

    @FXML
    private Label subt;

    @FXML
    private Label tax;

    @FXML
    private Label total;
    
    @FXML
    private Label selection;
         
    @FXML
    private Label select;
    
    @FXML
    private TextField p1;

    @FXML
    private TextField p3;
    
    @FXML
    private TextField p2;

    private int Bquan =0;
    double SubTotal =0.0;
    double saleTax = 0;
    double TotalCost = 0;
    
   
    @FXML
    void handleCost(ActionEvent event) {
           
     
      if (white.isSelected())
      {  
          if (t1.getText().isEmpty())
          { selection.setText("**Please enter the quantity");}
          else 
          {
             SubTotal +=  1.25 *Integer.parseInt(t1.getText());
             Bquan = Integer.parseInt(t1.getText());
          }
      }
      if (whole.isSelected())
      { if (t2.getText().isEmpty())
      { selection.setText("**Please enter the quantity.");}
      else { 
          SubTotal += 1.50 *Integer.parseInt(t2.getText());
      Bquan = Integer.parseInt(t2.getText());
      }
      }
       if (cc.isSelected()) {
      SubTotal += 0.5* Bquan;
      }
      if (but.isSelected()) {
        SubTotal += 0.35 * Bquan;
      }
      if (blu.isSelected()) {
       SubTotal += 0.70* Bquan;
      }
      if (rasp.isSelected()) {
        SubTotal += 0.70* Bquan;
      }
      if (peac.isSelected()) {
        SubTotal += 0.25* Bquan;
      }
      if (nut.isSelected()) {
         SubTotal += 0.50* Bquan;
      }
      
      if (cf.isSelected())
      {   
          if (t3.getText().isEmpty())
      {
          select.setText("**Please enter the quantity.");}
      else {
          SubTotal += 1*Integer.parseInt(t3.getText());
      }
      }
      if (fw.isSelected())
      {  if (t4.getText().isEmpty())
      { select.setText("**Please enter the quantity");}
      else {
        SubTotal += 1.25*Integer.parseInt(t4.getText());
      }
      }
      if (capp.isSelected())
      { if (t5.getText().isEmpty())
      { select.setText("**Please enter the quantity.");}
      else {
          SubTotal += 1.50*Integer.parseInt(t5.getText());      }
      }
      saleTax = 0.13*SubTotal;
      TotalCost = SubTotal + saleTax;
      p1.setText(String.format("%.2f",SubTotal) + " dollars");
      p2.setText(saleTax + " dollars");
      p3.setText(TotalCost + " dollars");
      
       
    }
    
    
     @FXML
    void resetform(ActionEvent event) {
      t1.clear();t2.clear();t3.clear();t4.clear();t5.clear();p1.clear();
      p2.clear();p3.clear();
      selection.setText(""); select.setText("");
       whole.setSelected(false);white.setSelected(false);non.setSelected(false);
       cf.setSelected(false); capp.setSelected(false);fw.setSelected(false);
       cc.setSelected(false);but.setSelected(false);blu.setSelected(false);
       rasp.setSelected(false);nut.setSelected(false);peac.setSelected(false);
    }
      
    @FXML
    void close(ActionEvent event) {
          Platform.exit();
    }

    @FXML
    void printR(ActionEvent event) throws Exception {
        
     File file = new File("receipt.txt");
     if (!(file.exists()))
         file.createNewFile();
     FileWriter fileW= new FileWriter(file);
     BufferedWriter buffWrit = new BufferedWriter(fileW);
     buffWrit.write("............SHERIDAN'S BAGEL SHOP..........");
     buffWrit.newLine();
     buffWrit.write(LocalDateTime.now().toString());
     buffWrit.newLine();
     buffWrit.write("Item:\t\t\tQuantity\t");
     buffWrit.newLine();
      if (white.isSelected()) {
        buffWrit.write("White Bagel\t\t");
        buffWrit.write(Bquan + "\t");
        
      }
     if (whole.isSelected()) {
        buffWrit.write("Wheat Bagel\t\t");
        buffWrit.write(Bquan + "\t");
      }
     buffWrit.newLine();
      if (cf.isSelected()) {
        buffWrit.write("Cafe au lait\t\t");
        buffWrit.write(Integer.parseInt(t3.getText()) + "\t");
      }
       if (fw.isSelected()) {
        buffWrit.write("Flat white\t\t");
        buffWrit.write(Integer.parseInt(t4.getText()) + "\t");
      }
     if (capp.isSelected()) {
        buffWrit.write("Cappucino\t\t");
        buffWrit.write(Integer.parseInt(t5.getText()) + "\t");
      }
     buffWrit.newLine();
       if (blu.isSelected()) {
     buffWrit.write("Blueberry Jam\t\t");
       buffWrit.write (Bquan);
       
      }
         if (rasp.isSelected()) {
     buffWrit.write("RaspberryJam\t\t");
       buffWrit.write (Bquan);
       
      }
          if (peac.isSelected()) {
     buffWrit.write("Peach Jelly\t\t");
       buffWrit.write (Bquan);
       
      }
      if (cc.isSelected()) {
     buffWrit.write("Cream Cheese\t\t");
       buffWrit.write (Bquan);
       
      }
      if (nut.isSelected()) {
     buffWrit.write("Nutella\t\t");
       buffWrit.write (Bquan);
       
      } 
       if (but.isSelected()) {
     buffWrit.write("Butter \t\t");
       buffWrit.write (Bquan);
       
      }
      buffWrit.newLine();
      buffWrit.write("Subtotal\t\t" + SubTotal);
      buffWrit.newLine();
      buffWrit.write("SalesTax\t\t" + saleTax);
      buffWrit.newLine();
      buffWrit.write("TotalCost\t\t" + TotalCost);
      
    
     buffWrit.close();
}
}
  
      