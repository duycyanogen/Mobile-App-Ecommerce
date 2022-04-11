package com.example.nhom27_gk.model;

public class ThongTinDH {

    private Integer maCTDH;
    private Integer maDDH;
    private Integer maSP;
    private Integer soLuong;
    private Double donGia;


    public ThongTinDH() {
    }

    public ThongTinDH(Integer maCTDH, Integer maDDH, Integer maSP, Integer soLuong, Double donGia) {
        this.maCTDH = maCTDH;
        this.maDDH = maDDH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public Integer getMaCTDH() {
        return maCTDH;
    }

    public void setMaCTDH(Integer maCTDH) {
        this.maCTDH = maCTDH;
    }

    public Integer getMaDDH() {
        return maDDH;
    }

    public void setMaDDH(Integer maDDH) {
        this.maDDH = maDDH;
    }

    public Integer getMaSP() {
        return maSP;
    }

    public void setMaSP(Integer maSP) {
        this.maSP = maSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
}
