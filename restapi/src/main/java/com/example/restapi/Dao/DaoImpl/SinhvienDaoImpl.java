package com.example.restapi.Dao.DaoImpl;

import com.example.restapi.Dao.SinhvienDAO;
import com.example.restapi.Model.SinhvienDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SinhvienDaoImpl implements SinhvienDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<SinhvienDTO> getAllSinhvien() {

        String sql = "SELECT * FROM studentdemo.sinhvien;";

        return jdbcTemplate.query(sql, new RowMapper<SinhvienDTO>() {
            @Override
            public SinhvienDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                SinhvienDTO sv = new SinhvienDTO();
                sv.setMasv(rs.getString("masv"));
                sv.setHoDem(rs.getString("ho_dem"));
                sv.setTen(rs.getString("ten"));
                sv.setNgaySinh(rs.getDate("ngay_sinh"));
                sv.setGioiTinh(rs.getString("gioi_tinh"));
                sv.setTinh(rs.getString("tinh"));
                sv.setMaLop(rs.getString("ma_lop"));
                return sv;
            }
        });
    }

    @Override
    public List<SinhvienDTO> findSinhvienByMa(String masv) {
        String sql = "SELECT * FROM studentdemo.sinhvien where masv LIKE '%" + masv + "%'";

        return jdbcTemplate.query(sql, new RowMapper<SinhvienDTO>() {
            @Override
            public SinhvienDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                SinhvienDTO sv = new SinhvienDTO();
                sv.setMasv(rs.getString("masv"));
                sv.setHoDem(rs.getString("ho_dem"));
                sv.setTen(rs.getString("ten"));
                sv.setNgaySinh(rs.getDate("ngay_sinh"));
                sv.setGioiTinh(rs.getString("gioi_tinh"));
                sv.setTinh(rs.getString("tinh"));
                sv.setMaLop(rs.getString("ma_lop"));
                return sv;
            }
        });
    }

    @Override
    public void addSinhvien(SinhvienDTO sv) {

        String sql = "INSERT INTO `studentdemo`.`sinhvien` VALUES (?, ?, ?, ?, ?, ?, ?);";
        Connection connection;
        try{
            jdbcTemplate.update(sql, sv.getMasv(), sv.getHoDem(), sv.getTen(), sv.getGioiTinh(), sv.getNgaySinh(), sv.getTinh(), sv.getMaLop());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void updateSinhvien(SinhvienDTO sv) {

        String sql = "UPDATE `studentdemo`.`sinhvien` SET `ho_dem` = ?, `ten` = ?, `gioi_tinh` = ?, `ngay_sinh` = ?, `tinh` = ?, `ma_lop` = ? WHERE  (`masv` = ?);";
        Connection connection;
        try{
            jdbcTemplate.update(sql,sv.getHoDem(), sv.getTen(), sv.getGioiTinh(), sv.getNgaySinh(), sv.getTinh(), sv.getMaLop(),sv.getMasv());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void deleteSinhvien(String masv) {
        String sql = "DELETE FROM `studentdemo`.`sinhvien` WHERE (`masv` = ?);";
        Connection connection;
        try{
            jdbcTemplate.update(sql,masv);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<SinhvienDTO> findSinhvienNuByMaLop(String maLop) {
        String sql="";
        if(maLop==""){
            sql = "SELECT * FROM studentdemo.sinhvien where gioi_tinh = 'Nữ';";
        }else{
            sql = "SELECT * FROM studentdemo.sinhvien where gioi_tinh = 'Nữ' and ma_lop = '"+maLop+"';";
        }
        return jdbcTemplate.query(sql, new RowMapper<SinhvienDTO>() {
            @Override
            public SinhvienDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                SinhvienDTO sv = new SinhvienDTO();
                sv.setMasv(rs.getString("masv"));
                sv.setHoDem(rs.getString("ho_dem"));
                sv.setTen(rs.getString("ten"));
                sv.setNgaySinh(rs.getDate("ngay_sinh"));
                sv.setGioiTinh(rs.getString("gioi_tinh"));
                sv.setTinh(rs.getString("tinh"));
                sv.setMaLop(rs.getString("ma_lop"));
                return sv;
            }
        });
    }
}
