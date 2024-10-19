//package make.money.stock1.dao;
//
//import make.money.stock1.model.CorpCode;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class CodeDao {
//
//    private final SqlSession session;
//
//    public CodeDao(SqlSession session) {
//        this.session = session;
//    }
//
//    public int insertCode(CorpCode corpCode){
//
//        return session.insert("corpCode.insertcode", corpCode);
//    }
//
//    public List<CorpCode> searchByCorpCode(CorpCode corpCode){
//        System.out.println("a" + corpCode);
//        return session.selectList("corpCode.searchbycorpcode", corpCode);
//    }
//
//    public List<CorpCode> searchByCorpName(CorpCode corpCode){
//        System.out.println("b" + corpCode);
//        return session.selectList("corpCode.searchbycorpname", corpCode);
//    }
//
//    public List<CorpCode> searchByStockCode(CorpCode corpCode){
//        System.out.println("c" + corpCode);
//        return session.selectList("corpCode.searchbystockcode", corpCode);
//    }
//
//    public CorpCode getCorpCodeByStockCode(CorpCode corpCode) {
//        return session.selectOne("corpCode.getcorpcodebystockcode", corpCode);
//    }
//}
