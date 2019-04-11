/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Datos {
    
    public String nombproduct,pmayoreo,pindiv,marca;
    public int barcode,undis;
    public Datos() {
    }

    public Datos(String nombproduct, String pmayoreo, String pindiv, int undis, String marca, int barcode) {
        this.barcode = barcode;
        this.nombproduct = nombproduct;
        this.pmayoreo = pmayoreo;
        this.pindiv = pindiv;
        this.undis = undis;
        this.marca = marca;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getNombproduc() {
        return nombproduct;
    }

    public void setNombproduct(String nombproduct) {
        this.nombproduct = nombproduct;
    }

    public String getPmayoreo() {
        return pmayoreo;
    }

    public void setPmayoreo(String pmayoreo) {
        this.pmayoreo = pmayoreo;
    }

    public String getPindiv() {
        return pindiv;
    }

    public void setPindiv(String pindiv) {
        this.pindiv = pindiv;
    }

    public int getUndis() {
        return undis;
    }

    public void setUndis(int undis) {
        this.undis = undis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
}
