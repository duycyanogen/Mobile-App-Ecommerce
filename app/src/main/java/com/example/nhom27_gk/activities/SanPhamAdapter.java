package com.example.nhom27_gk.activities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.nhom27_gk.R;
import com.example.nhom27_gk.model.SanPham;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {

    private List<SanPham> listSanPham;
    private Context mContext;

    public List<SanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(List<SanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public SanPhamAdapter() {
    }

    public SanPhamAdapter(List<SanPham> listSanPham, Context mContext) {
        this.listSanPham = listSanPham;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return listSanPham.size();
    }

    @Override
    public Object getItem(int i) {
        return listSanPham.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public static class SanPhamViewHolder{
        public ImageView ivDuongDanAnh;
        public TextView tvMaSanPham;
        public TextView tvXuatXu;
        public TextView tvTenSanPham;
        public TextView tvDonGia;
        public TextView tvTrangThai;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SanPhamViewHolder SanPhamViewHolder = null;
        if (view == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            view = inflater.inflate(R.layout.product_item,null);
            SanPhamViewHolder = new SanPhamViewHolder();
            SanPhamViewHolder.ivDuongDanAnh = view.findViewById(R.id.ivImagePath);
            //SanPhamViewHolder.tvMaSanPham = view.findViewById((R.id.tv));
            SanPhamViewHolder.tvTenSanPham = view.findViewById(R.id.tvPrice);
            SanPhamViewHolder.tvDonGia = view.findViewById((R.id.tvDescription));
            SanPhamViewHolder.tvXuatXu = view.findViewById((R.id.tvDescription));
            SanPhamViewHolder.tvTrangThai = view.findViewById((R.id.tvDescription));
            view.setTag(SanPhamViewHolder);
        }
        else{
            SanPhamViewHolder = (SanPhamViewHolder)view.getTag();

        }
        SanPhamViewHolder.tvMaSanPham.setText(listSanPham.get(i).getMaSP());
        SanPhamViewHolder.tvTenSanPham.setText(listSanPham.get(i).getTenSP());
        SanPhamViewHolder.tvDonGia.setText(listSanPham.get(i).getDonGia().toString());
        SanPhamViewHolder.tvXuatXu.setText(listSanPham.get(i).getXuatXu());

        return view;
    }
}
