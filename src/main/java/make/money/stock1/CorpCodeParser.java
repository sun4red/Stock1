package make.money.stock1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CorpCodeParser {

    public int parsingXml(){

        int result = 0;

        // 프로젝트 시작 파일의 클래스 파일이 위치한 디렉토리를 기준으로 상대 경로 계산
        String classFilePath = CorpCodeParser.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String projectDirectory = classFilePath.substring(0, classFilePath.indexOf("/Stock1/")); // 프로젝트 디렉토리
        String xmlFilePath = projectDirectory + "/Stock1/documents/CORPCODE.xml";

        try {
            // XML 파일을 읽기 위한 DocumentBuilder 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // XML 파일을 파싱하여 Document 객체 생성
            Document doc = builder.parse(new File(xmlFilePath));

            // <list> 요소들을 NodeList로 가져옴
            NodeList listNodes = doc.getElementsByTagName("list");

            // 각 <list> 요소를 순회하면서 데이터 추출
            for (int i = 0; i < listNodes.getLength(); i++) {
                Element listElement = (Element) listNodes.item(i);
                String corpCode = listElement.getElementsByTagName("corp_code").item(0).getTextContent();
                String corpName = listElement.getElementsByTagName("corp_name").item(0).getTextContent();
                String stockCode = listElement.getElementsByTagName("stock_code").item(0).getTextContent();
                String modifyDate = listElement.getElementsByTagName("modify_date").item(0).getTextContent();

                // 추출한 데이터를 사용하여 원하는 작업 수행
                System.out.println("Corp Code: " + corpCode);
                System.out.println("Corp Name: " + corpName);
                System.out.println("Stock Code: " + stockCode);
                System.out.println("Modify Date: " + modifyDate);
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

}