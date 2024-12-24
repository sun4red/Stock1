package api.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import api.model.MDartCorpcode;

public class ReadData {

    private final String corpcodeFilePath = "documents/CORPCODE.xml";
    // private final String corpcodeFilePath = "data/testdata4.xml";

    public List<MDartCorpcode> XmlCorpcodeList() {
        List<MDartCorpcode> list = new ArrayList<>();

        File file = new File(corpcodeFilePath);

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // XML 파일을 파싱하여 Document 객체 생성
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            // System.out.println("Root element: " +
            // document.getDocumentElement().getNodeName());

            // result 태그 안의 하위 요소들을 가져오기
            NodeList nodeList = document.getElementsByTagName("list");

            System.out.println(nodeList.getLength());

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                MDartCorpcode mDartCorpcode = new MDartCorpcode();

                String corp_code = "";
                String corp_name = "";
                String stock_code = "";
                String modify_date = "";

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // name, age, city 값 출력
                    corp_code = element.getElementsByTagName("corp_code").item(0).getTextContent();
                    corp_name = element.getElementsByTagName("corp_name").item(0).getTextContent();
                    stock_code = element.getElementsByTagName("stock_code").item(0).getTextContent();
                    modify_date = element.getElementsByTagName("modify_date").item(0).getTextContent();

                }

                if (stock_code == null || stock_code.trim().isEmpty()) {
                    continue;
                }

                mDartCorpcode.setCorp_code(corp_code);
                mDartCorpcode.setCorp_name(corp_name);
                mDartCorpcode.setStock_code(stock_code);
                mDartCorpcode.setModify_date(modify_date);

                list.add(mDartCorpcode);

                // System.out.println("corp_code: " + corp_code);
                // System.out.println("corp_name: " + corp_name);
                // System.out.println("stock_code: " + stock_code);
                // System.out.println("modify_date: " + modify_date);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    };

}