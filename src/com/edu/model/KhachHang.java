/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.model;

/**
 *
 * @author hma20
 */
public class KhachHang {
    private int maKH;
    private boolean gioiTinh = false;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(int maKH, boolean gioiTinh, String diaChi) {
        this.maKH = maKH;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
}
