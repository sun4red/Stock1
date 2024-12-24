package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.EnvReader;

public class DBConnectionManager {

    private static final String mssql_url = EnvReader.readEnv().get("MSSQL_URL");
    private static final String mssql_user = EnvReader.readEnv().get("MSSQL_USER");
    private static final String mssql_password = EnvReader.readEnv().get("MSSQL_PASSWORD");

    // DB 연결 생성
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(mssql_url, mssql_user, mssql_password);
    }

    // SQL 실행 메소드 (PreparedStatement 사용)
    // INSERT/UPDATE/DELETE 쿼리 실행 메소드
    public static int executeUpdate(String sql, Object... params) {
        int result = 0;
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // 파라미터 설정
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            // 쿼리 실행
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 다른 클래스로 ResultSet 객체를 보낼 수 없음, try문을 벗어나면 자동으로 객체가 닫힘
    // // SELECT 쿼리 실행 메소드 (결과 반환)
    // public static ResultSet executeQuery(String sql, Object... params) {

    //     ResultSet rs = null;

    //     try (Connection connection = getConnection();
    //             PreparedStatement pstmt = connection.prepareStatement(sql)) {

    //         // 파라미터 설정
    //         for (int i = 0; i < params.length; i++) {
    //             pstmt.setObject(i + 1, params[i]);
    //         }

    //         // 쿼리 실행
    //         rs = pstmt.executeQuery();
            
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }

    //     return rs;
    // }
}
