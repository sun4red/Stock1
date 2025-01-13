package database;

import model.KRXListedInfoDTO;

public class KRXListedInfoDAO {

    // #Base Method
    public int insert(KRXListedInfoDTO dto) {
        int result = 0;

        String sql = "INSERT INTO KRXListedInfo ";
        sql += "(basDt, srtnCd, isinCd, mrktCtg, itmsNm, crno, corpNm) ";
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

}
