package database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

}
