package make.money.stock1.dao;

import make.money.stock1.model.CorpCode;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodeDao {

    private final SqlSession session;

    public CodeDao(SqlSession session) {
        this.session = session;
    }

    public int insertCode(CorpCode corpCode){

        return session.insert("corpCode.insertcode", corpCode);
    }

    public List<CorpCode> searchByCorpCode(CorpCode corpCode){
        return session.selectList("corpCode.searchbycorpcode", corpCode);
    }

    public List<CorpCode> searchByCorpName(CorpCode corpCode){
        return session.selectList("corpCode.searchbycorpname", corpCode);
    }

    public List<CorpCode> searchByStockCode(CorpCode corpCode){
        return session.selectList("corpCode.searchbystockcode", corpCode);
    }



}
