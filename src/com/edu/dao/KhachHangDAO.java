/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.edu.model.KhachHang;
import com.edu.helper.Xjdbc;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hma20
 */
public class KhachHangDAO extends QuanLySieuThiDAO<KhachHang, Integer>{
    String INSERT_SQL = "Insert into KHACHHANG(GioiTinh, DiaChi)Values(?,?)";
    String UPDATE_SQL = "Update KHACHHANG set GioiTinh = ?, DiaChi = ? where MaKhachHang = ?";
    String DELETE_SQL = "Delete from KHACHHANG where MaKhachHang = ?";
    String SELECT_ALL_SQL = "Select * from KHACHHANG";
    String SELECT_BY_ID_SQL = "Select * from KHACHHANG where MaKhachHang = ?";
    
    @Override
    public void insert(KhachHang entity) {
        try {
            Xjdbc.update(INSERT_SQL, entity.isGioiTinh(), entity.getDiaChi());
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KhachHang entity) {
        try {
            Xjdbc.update(UPDATE_SQL, entity.isGioiTinh()==true?"1":"0", entity.getDiaChi(), entity.getMaKH());
            System.out.println("123");
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            Xjdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public KhachHang selectByid(Integer id) {
        List<KhachHang> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {                
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getInt("MaKhachHang"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDiaChi(rs.getString("DiaChi"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public KhachHang findTV(String timKiem) {
        List<KhachHang> list = this.selectBySql(timKiem);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
