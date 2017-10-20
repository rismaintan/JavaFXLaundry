/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author rismaintanw
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField nama;
    @FXML
    private TextField alamat;
    @FXML
    private TextField berat;
    @FXML
    private TextField tlf;
    @FXML
    private TextField tanggal;
    @FXML
    private RadioButton CK;
    @FXML
    private ToggleGroup PILIH;
    @FXML
    private RadioButton S;
    @FXML
    private RadioButton CKS;
    @FXML
    private Button oke;
    @FXML
    private Button hapus;
    @FXML
    private TextArea Hasil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Proses(ActionEvent event) {
        String paket="";
        if(CK.isSelected())
           paket = "Cuci Kering";
        else if (CKS.isSelected())
           paket = "Cucui Kering Setrika";
        else if(S.isSelected())
           paket = "Setrika";
        else 
           paket ="";
        
        if(!(CK.isSelected() || CKS.isSelected() || S.isSelected() )){
            JOptionPane.showMessageDialog(null, "Harap Pilih Paket Layanan");
        }else{
            int harga =0;
            String Nama = nama.getText();
            String Alamat = alamat.getText();
            String Berat = berat.getText()+"kg";
            String Tanggal = tanggal.getText();
            int hitung = Integer.parseInt(berat.getText());
            
            if (CK.isSelected()){
                harga = hitung*5000;}
            if (CKS.isSelected()){
                harga = hitung*6000;}
            if (S.isSelected()){
                harga = hitung*4000;
            }
            
            String nohp = tlf.getText();
            
            Hasil.setText("Nama  : "+Nama+"\n"+"Alamat : "+Alamat+"\n"+"Berat Cucian : "+Berat+"\n"+"Nomor Telp : "+nohp+"\n"+"Pilihan Paket : "+paket+"\n"+"Tanggal Pengambilan : "+Tanggal+"\n"+
                    "Pembayaran yang Harus Dibayar : "+harga);
            
        }
    }
       @FXML
    private void Hapus(ActionEvent event) {
nama.setText("");
        alamat.setText("");
        berat.setText("");
        tlf.setText("");
        CK.setSelected(false);
        CKS.setSelected(false);
        S.setSelected(false);
        tanggal.setText("");
        Hasil.setText("");
    }
    
}
