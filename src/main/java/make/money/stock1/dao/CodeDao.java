package make.money.stock1.dao;

import make.money.stock1.model.CorpCode;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDao {

    private final SqlSession session;

    public CodeDao(SqlSession session) {
        this.session = session;
    }

    public int insertCode(CorpCode corpCode){

        return session.insert("corpCode.insertcode", corpCode);
    }


}
