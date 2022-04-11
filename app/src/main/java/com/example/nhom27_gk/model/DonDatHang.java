package com.example.nhom27_gk.model;

import java.util.Date;

public class DonDatHang {

    private Integer maDDH;
    private Date ngayDH;
    private Boolean trangThai;
    private Integer maKH;

    public DonDatHang() {
    }

    public DonDatHang(Integer maDDH, Date ngayDH, Integer maKH, Boolean trangThai) {
        this.maDDH = maDDH;
        this.ngayDH = ngayDH;
        this.maKH = maKH;
        this.trangThai = trangThai;
    }

    public Integer getMaDDH() {
        return maDDH;
    }

    public void setMaDDH(Integer maDDH) {
        this.maDDH = maDDH;
    }

    public Date getNgayDH() {
        return ngayDH;
    }

    public void setNgayDH(Date ngayDH) {
        this.ngayDH = ngayDH;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

}
