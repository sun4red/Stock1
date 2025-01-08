package api.krx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import api.DataFileManager;
import api.dart.model.DartFnlttSinglAcntAllDTO;
import api.krx.model.KRXListedInfoDTO;

public class DataFileManagerKRXListedInfo extends DataFileManager {

    public String dir(String basDat) {

        if (basDat != null && !basDat.isEmpty()) {
            basDat = basDat + "/";
            directory = krxDir + basDat;

            File dir = new File(directory);

            if (!dir.exists()) {
                dir.mkdirs();
            }

        }
        return directory;

    }

    public String fileName(String beginBasDt, String endBasDt, String pageNo) {
        String fileName = beginBasDt + "_" + endBasDt + "_" + pageNo;

        return fileName;
    }

    public String filePath(String beginBasDt, String endBasDt, String pageNo, String resultType) {
        String filePath = dir(endBasDt) + fileName(beginBasDt, endBasDt, pageNo) + "." + resultType;

        return filePath;
    }



// #Base Method
    public List<KRXListedInfoDTO> readXmlFile(String filePath) {
        List<KRXListedInfoDTO> list = new ArrayList<>();

        File file = new File(filePath);

        if (file.exists()) {

            try {

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();

                Document document = builder.parse(filePath);
                document.getDocumentElement().normalize();

                NodeList statusNodeList = document.getElementsByTagName("resultCode");
                String statusValue = "";
                if (statusNodeList.getLength() > 0) {
                    Node statusNode = statusNodeList.item(0);
                    statusValue = statusNode.getTextContent();
                    System.out.println("resultCode: " + statusValue);
                }

                if (statusValue.equals("00")) {

                    NodeList nodeList = document.getElementsByTagName("item");

                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Node node = nodeList.item(i);
                        KRXListedInfoDTO dto = parseNodeToDTO(node);

                       list.add(dto);
                    
                    }
                } else {
                    System.out.println("xml 데이터 확인: " + filePath);
                }

            } catch (Exception e) {
                System.out.println("오류 파일: " + filePath);
                e.printStackTrace();
            }
        } else {
            System.out.println("존재하지않음: " + filePath);
        }

        return list;
    }

    private KRXListedInfoDTO parseNodeToDTO(Node node) {
        KRXListedInfoDTO dto = new KRXListedInfoDTO();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
    
            
            dto.setBasDt(getTagValue(element, "basDt"));
            dto.setSrtnCd(getTagValue(element, "srtnCd"));
            dto.setIsinCd(getTagValue(element, "isinCd"));
            dto.setMrktCtg(getTagValue(element, "mrktCtg"));
            dto.setItmsNm(getTagValue(element, "itmsNm"));
            dto.setCrno(getTagValue(element, "crno"));
            dto.setCorpNm(getTagValue(element, "corpNm"));
  
        }
        return dto;
    }

 // #Base Method
 public String xmlFileStatus(String filePath) {
    String status = "";

    File file = new File(filePath);

    if (file.exists()) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(filePath);
            document.getDocumentElement().normalize();

            NodeList statusNodeList = document.getElementsByTagName("resultCode");

            if (statusNodeList.getLength() > 0) {
                Node statusNode = statusNodeList.item(0);
                status = statusNode.getTextContent();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return status;
}

 // #Base Method
 public String xmlFileTotalCount(String filePath) {
    String status = "";

    File file = new File(filePath);

    if (file.exists()) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(filePath);
            document.getDocumentElement().normalize();

            NodeList statusNodeList = document.getElementsByTagName("totalCount");

            if (statusNodeList.getLength() > 0) {
                Node statusNode = statusNodeList.item(0);
                status = statusNode.getTextContent();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return status;
}


}
