package database.dart;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import api.model.MDartFnlttSinglAcntAll;
import database.DBConnectionManager;
import utility.EnvReader;

public class DBDartFnlttSinglAcntAll {

    private static final String mssql_url = EnvReader.readEnv().get("MSSQL_URL");
    private static final String mssql_user = EnvReader.readEnv().get("MSSQL_USER");
    private static final String mssql_password = EnvReader.readEnv().get("MSSQL_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(mssql_url, mssql_user, mssql_password);
    }

    public int insertFnlttSinglAcntAll(MDartFnlttSinglAcntAll mDartFnlttSinglAcntAll) {
        int result = 0;

        String sql = "INSERT INTO FnlttSinglAcntAll ";
        sql += "(rcept_no, reprt_code, bsns_year, corp_code, sj_div, sj_nm, account_id, account_nm, account_detail, thstrm_nm, ";
        sql += "thstrm_amount, frmtrm_nm, frmtrm_amount, bfefrmtrm_nm, bfefrmtrm_amount, ord, currency) ";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        BigDecimal thstrm_amount = new BigDecimal("0");
        BigDecimal frmtrm_amount = new BigDecimal("0");
        BigDecimal bfefrmtrm_amount = new BigDecimal("0");

        if (mDartFnlttSinglAcntAll.getThstrm_amount() != null && !mDartFnlttSinglAcntAll.getThstrm_amount().isEmpty()) {
            thstrm_amount = new BigDecimal(mDartFnlttSinglAcntAll.getThstrm_amount());
        }
        if (mDartFnlttSinglAcntAll.getFrmtrm_amount() != null && !mDartFnlttSinglAcntAll.getFrmtrm_amount().isEmpty()) {
            frmtrm_amount = new BigDecimal(mDartFnlttSinglAcntAll.getFrmtrm_amount());
        }
        if (mDartFnlttSinglAcntAll.getBfefrmtrm_amount() != null
                && !mDartFnlttSinglAcntAll.getBfefrmtrm_amount().isEmpty()) {
            bfefrmtrm_amount = new BigDecimal(mDartFnlttSinglAcntAll.getBfefrmtrm_amount());
        }

        result = DBConnectionManager.executeUpdate(sql,
                mDartFnlttSinglAcntAll.getRcept_no(),
                mDartFnlttSinglAcntAll.getReprt_code(),
                mDartFnlttSinglAcntAll.getBsns_year(),
                mDartFnlttSinglAcntAll.getCorp_code(),
                mDartFnlttSinglAcntAll.getSj_div(),
                mDartFnlttSinglAcntAll.getSj_nm(),
                mDartFnlttSinglAcntAll.getAccount_id(),
                mDartFnlttSinglAcntAll.getAccount_nm(),
                mDartFnlttSinglAcntAll.getAccount_detail(),
                mDartFnlttSinglAcntAll.getThstrm_nm(),
                thstrm_amount,
                mDartFnlttSinglAcntAll.getFrmtrm_nm(),
                frmtrm_amount,
                mDartFnlttSinglAcntAll.getBfefrmtrm_nm(),
                bfefrmtrm_amount,
                mDartFnlttSinglAcntAll.getOrd(),
                mDartFnlttSinglAcntAll.getCurrency());

        return result;
    }

    public int insertFnlttSinglAcntAllList(List<MDartFnlttSinglAcntAll> list) {
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            DBDartFnlttSinglAcntAll dbDartFnlttSinglAcntAll = new DBDartFnlttSinglAcntAll();
            dbDartFnlttSinglAcntAll.insertFnlttSinglAcntAll(list.get(i));
        }

        return result;
    }

}
