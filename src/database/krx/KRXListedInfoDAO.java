package database.krx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import api.krx.model.KRXListedInfoDTO;
import database.DBConnectionManager;
import utility.EnvReader;

public class KRXListedInfoDAO {

    private static final String mssql_url = EnvReader.readEnv().get("MSSQL_URL");
    private static final String mssql_user = EnvReader.readEnv().get("MSSQL_USER");
    private static final String mssql_password = EnvReader.readEnv().get("MSSQL_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(mssql_url, mssql_user, mssql_password);
    }

    public int insert(KRXListedInfoDTO dto) {
        int result = 0;

        String sql = "INSERT INTO KRXListedInfo ";
        sql += "(basDt, srtnCd, isinCd, mrktCtg, itmsNm, crno, corpNm)";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?)";

        result = DBConnectionManager.executeUpdate(sql,
                dto.getBasDt(),
                dto.getSrtnCd(),
                dto.getIsinCd(),
                dto.getMrktCtg(),
                dto.getItmsNm(),
                dto.getCrno(),
                dto.getCorpNm());

        return result;
    }

    // public int insertKOSPIandKOSDAQ(KRXListedInfoDTO dto) {
    //     int result = 0;

    //     if (dto.getMrktCtg().equals("KOSPI") || dto.getMrktCtg().equals("KOSDAQ")) {
    //         result = insert(dto);
    //     } else if (dto.getMrktCtg().equals("KONEX")) {
    //         // KONEX insert X
    //     }
    //     return result;
    // }

}
