package com.example.nhom27_gk.model;

public class QuanTriVien {

    private Integer maQTV;
    private String tenQTV;
    private String tenTK;
    private String matKhau;

    public QuanTriVien(Integer maQTV, String tenQTV, String tenTK, String matKhau) {
        this.maQTV = maQTV;
        this.tenQTV = tenQTV;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
    }

    public QuanTriVien() {
    }

    public Integer getMaQTV() {
        return maQTV;
    }

    public void setMaQTV(Integer maQTV) {
        this.maQTV = maQTV;
    }

    public String getTenQTV() {
        return tenQTV;
    }

    public void setTenQTV(String tenQTV) {
        this.tenQTV = tenQTV;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
