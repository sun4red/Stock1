package database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DartFnlttSinglAcntAllDTO;

public class DartFnlttSinglAcntAllDAO {

    public int insert(DartFnlttSinglAcntAllDTO dto) {
        int result = 0;

        String sql = "INSERT INTO FnlttSinglAcntAll ";
        sql += "(rcept_no, reprt_code, bsns_year, corp_code, sj_div, sj_nm, account_id, account_nm, account_detail, thstrm_nm, ";
        sql += "thstrm_amount, frmtrm_nm, frmtrm_amount, bfefrmtrm_nm, bfefrmtrm_amount, ord, currency) ";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        BigDecimal thstrm_amount = new BigDecimal("0");
        BigDecimal frmtrm_amount = new BigDecimal("0");
        BigDecimal bfefrmtrm_amount = new BigDecimal("0");

        if (dto.getThstrm_amount() != null && !dto.getThstrm_amount().isEmpty()) {
            thstrm_amount = new BigDecimal(dto.getThstrm_amount());
        }
        if (dto.getFrmtrm_amount() != null && !dto.getFrmtrm_amount().isEmpty()) {
            frmtrm_amount = new BigDecimal(dto.getFrmtrm_amount());
        }
        if (dto.getBfefrmtrm_amount() != null
                && !dto.getBfefrmtrm_amount().isEmpty()) {
            bfefrmtrm_amount = new BigDecimal(dto.getBfefrmtrm_amount());
        }

        result = DBConnectionManager.executeUpdate(sql,
                dto.getRcept_no(),
                dto.getReprt_code(),
                dto.getBsns_year(),
                dto.getCorp_code(),
                dto.getSj_div(),
                dto.getSj_nm(),
                dto.getAccount_id(),
                dto.getAccount_nm(),
                dto.getAccount_detail(),
                dto.getThstrm_nm(),
                thstrm_amount,
                dto.getFrmtrm_nm(),
                frmtrm_amount,
                dto.getBfefrmtrm_nm(),
                bfefrmtrm_amount,
                dto.getOrd(),
                dto.getCurrency());

        return result;
    }

    public int insertList(List<DartFnlttSinglAcntAllDTO> list) {
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            DartFnlttSinglAcntAllDAO dbDartFnlttSinglAcntAll = new DartFnlttSinglAcntAllDAO();
            dbDartFnlttSinglAcntAll.insert(list.get(i));
        }

        return result;
    }

    public String select_rcept_no(String reprt_code, String bsns_year, String corp_code) {
        String rcept_no = "";

        String sql = "select distinct(rcept_no) from FnlttSinglAcntAll where reprt_code = ? and bsns_year = ? and corp_code = ?";

        try {

            Connection connection = DBConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = null;

            pstmt.setString(1, reprt_code);
            pstmt.setString(2, bsns_year);
            pstmt.setString(3, corp_code);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                rcept_no = rs.getString(1);
            }

            DBConnectionManager.closeConnection(connection, pstmt, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rcept_no;
    }

    public int delete(String rcept_no) {
        int result = 0;

        String sql = "delete from FnlttSinglAcntAll where rcept_no = ?";

        result = DBConnectionManager.executeUpdate(sql, rcept_no);

        return result;
    }

    public List<DartFnlttSinglAcntAllDTO> selectByRcept_no(String rcept_no) {

        List<DartFnlttSinglAcntAllDTO> list = new ArrayList<>();

        String sql = "select * from FnlttSinglAcntAll where rcept_no = ? order by sj_div, ord asc";

        try {

            Connection connection = DBConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = null;

            pstmt.setString(1, rcept_no);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                DartFnlttSinglAcntAllDTO dto = new DartFnlttSinglAcntAllDTO();

                // String rcept_no = rs.getString("rcept_no");
                String reprt_code = rs.getString("reprt_code");
                String bsns_year = rs.getString("bsns_year");
                String corp_code = rs.getString("corp_code");
                String sj_div = rs.getString("sj_div");
                String sj_nm = rs.getString("sj_nm");
                String account_id = rs.getString("account_id");
                String account_nm = rs.getString("account_nm");
                String account_detail = rs.getString("account_detail");
                String thstrm_nm = rs.getString("thstrm_nm");
                String thstrm_amount = rs.getString("thstrm_amount");
                String frmtrm_nm = rs.getString("frmtrm_nm");
                String frmtrm_amount = rs.getString("frmtrm_amount");
                String bfefrmtrm_nm = rs.getString("bfefrmtrm_nm");
                String bfefrmtrm_amount = rs.getString("bfefrmtrm_amount");
                String ord = rs.getString("ord");
                String currency = rs.getString("currency");

                dto.setRcept_no(rcept_no);
                dto.setReprt_code(reprt_code);
                dto.setBsns_year(bsns_year);
                dto.setCorp_code(corp_code);
                dto.setSj_div(sj_div);
                dto.setSj_nm(sj_nm);
                dto.setAccount_id(account_id);
                dto.setAccount_nm(account_nm);
                dto.setAccount_detail(account_detail);
                dto.setThstrm_nm(thstrm_nm);
                dto.setThstrm_amount(thstrm_amount);
                dto.setFrmtrm_nm(frmtrm_nm);
                dto.setFrmtrm_amount(frmtrm_amount);
                dto.setBfefrmtrm_nm(bfefrmtrm_nm);
                dto.setBfefrmtrm_amount(bfefrmtrm_amount);
                dto.setOrd(ord);
                dto.setCurrency(currency);

                list.add(dto);
            }

            DBConnectionManager.closeConnection(connection, pstmt, rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
