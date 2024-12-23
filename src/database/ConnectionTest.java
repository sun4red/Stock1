package database;

import java.sql.*;

import utility.EnvReader;

public class ConnectionTest {

    EnvReader envReader = new EnvReader();

    // MSSQL 연결 정보
    private static final String mssql_url = EnvReader.readEnv().get("MSSQL_URL");
    private static final String mssql_user = EnvReader.readEnv().get("MSSQL_USER");
    private static final String mssql_password = EnvReader.readEnv().get("MSSQL_PASSWORD");

    
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // 1. 데이터베이스 연결
            connection = DriverManager.getConnection(mssql_url, mssql_user, mssql_password);
            System.out.println("데이터베이스에 성공적으로 연결되었습니다.");

            // // 2. 데이터 삽입 예제
            // String insertQuery = "INSERT INTO YourTableName (column1, column2) VALUES (?,
            // ?)";
            // try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            // pstmt.setString(1, "value1");
            // pstmt.setString(2, "value2");
            // int rowsInserted = pstmt.executeUpdate();
            // System.out.println(rowsInserted + "개의 행이 삽입되었습니다.");
            // }

            // // 3. 데이터 조회 예제
            // String selectQuery = "SELECT * FROM YourTableName";
            // try (Statement stmt = connection.createStatement();
            // ResultSet rs = stmt.executeQuery(selectQuery)) {
            // while (rs.next()) {
            // System.out.println("Column1: " + rs.getString("column1") +
            // ", Column2: " + rs.getString("column2"));
            // }
            // }

            // // 4. 데이터 업데이트 예제
            // String updateQuery = "UPDATE YourTableName SET column2 = ? WHERE column1 =
            // ?";
            // try (PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
            // pstmt.setString(1, "newValue");
            // pstmt.setString(2, "value1");
            // int rowsUpdated = pstmt.executeUpdate();
            // System.out.println(rowsUpdated + "개의 행이 업데이트되었습니다.");
            // }

            // // 5. 데이터 삭제 예제
            // String deleteQuery = "DELETE FROM YourTableName WHERE column1 = ?";
            // try (PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
            // pstmt.setString(1, "value1");
            // int rowsDeleted = pstmt.executeUpdate();
            // System.out.println(rowsDeleted + "개의 행이 삭제되었습니다.");
            // }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 연결 닫기
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("데이터베이스 연결이 닫혔습니다.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
