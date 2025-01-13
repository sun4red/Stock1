package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import api.data.ReadData;
import database.DartCorpcodeDAO;
import model.DartCorpcodeDTO;
import servicebase.DBConnection;

public class Main2 {

    public static void main(String[] args) {

        // System.out.println("Current Directory: " + System.getProperty("user.dir"));
        // File file = new File("data/testdata4.xml"); // XML 파일 경로

        // System.out.println(file);

        // if (file.exists()) {
        // System.out.println("file exists");

        // }

        // try {

        // DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // DocumentBuilder builder = factory.newDocumentBuilder();

        // // XML 파일을 파싱하여 Document 객체 생성
        // Document document = builder.parse(file);
        // document.getDocumentElement().normalize();

        // System.out.println("Root element: " +
        // document.getDocumentElement().getNodeName());

        // // result 태그 안의 하위 요소들을 가져오기
        // NodeList nodeList = document.getElementsByTagName("list");

        // for (int i = 0; i < nodeList.getLength(); i++) {
        // Node node = nodeList.item(i);

        // if (node.getNodeType() == Node.ELEMENT_NODE) {
        // Element element = (Element) node;

        // // name, age, city 값 출력
        // String corp_code =
        // element.getElementsByTagName("corp_code").item(0).getTextContent();
        // String corp_name =
        // element.getElementsByTagName("corp_name").item(0).getTextContent();
        // String stock_code =
        // element.getElementsByTagName("stock_code").item(0).getTextContent();
        // String modify_date =
        // element.getElementsByTagName("modify_date").item(0).getTextContent();

        // System.out.println("corp_code: " + corp_code);
        // System.out.println("corp_name: " + corp_name);
        // System.out.println("stock_code: " + stock_code);
        // System.out.println("modify_date: " + modify_date);
        // }
        // }

        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // ReadData readData = new ReadData();

        // List<MDartCorpcode> list = new ArrayList<>();
        // list = readData.XmlCorpcodeList();

        // System.out.println(list.size());

        // for (int i = 0; i < list.size(); i++) {
        //     DBConnection dbConnection = new DBConnection();
            // dbConnection.insertDCorpCode(list.get(i));
        // }

        DartCorpcodeDAO dbDartCorpcode = new DartCorpcodeDAO();
        List<DartCorpcodeDTO> selectList = dbDartCorpcode.selectCorpcode();

        System.out.println(selectList);

    }
}
