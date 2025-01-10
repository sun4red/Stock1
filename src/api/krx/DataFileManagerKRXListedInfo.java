package api.krx;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import api.DataFileManager;
import api.krx.model.KRXListedInfoDTO;
import api.krx.model.KRXListedInfoSetDTO;

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
    public KRXListedInfoSetDTO readXmlFile(String filePath) {
        KRXListedInfoSetDTO setDTO = new KRXListedInfoSetDTO();
        Map<String, KRXListedInfoDTO> dtomap = new HashMap();
        List<String> isinCdList = new ArrayList<>();

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

                        String isinCd = dto.getIsinCd();
                        if (!dtomap.containsKey(isinCd)) {
                            // 맵에 ISIN코드 기준으로 넣어서 중복제거처리
                            dtomap.put(dto.getIsinCd(), dto);
                            isinCdList.add(isinCd);
                        }

                    }

                    setDTO.setDtoMap(dtomap);
                    setDTO.setIsinCdList(isinCdList);

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

        return setDTO;
    }

    // #OverLoaded, 전체 Page 작업업
    public KRXListedInfoSetDTO readXmlFile(String beginBasDt, String endBasDt) {
        String resultType = "xml";
        KRXListedInfoSetDTO setDTO = new KRXListedInfoSetDTO();
        Map<String, KRXListedInfoDTO> dtomap = new HashMap();
        List<String> isinCdList = new ArrayList<>();
        DataFileManagerKRXListedInfo dfm = new DataFileManagerKRXListedInfo();

        // 페이지 수 저장 객체 필요
        for (int page = 1; page <= 20; page++) {
            String pageNo = String.valueOf(page);

            String filePath = dfm.filePath(beginBasDt, endBasDt, pageNo, resultType);
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

                            String isinCd = dto.getIsinCd();
                            if (!dtomap.containsKey(isinCd)) {
                                // 맵에 ISIN코드 기준으로 넣어서 중복제거처리
                                dtomap.put(dto.getIsinCd(), dto);
                                isinCdList.add(isinCd);
                            }

                        }

                        setDTO.setDtoMap(dtomap);
                        setDTO.setIsinCdList(isinCdList);

                    } else {
                        System.out.println("xml 데이터 확인: " + filePath);
                    }

                } catch (Exception e) {
                    System.out.println("오류 파일: " + filePath);
                    e.printStackTrace();
                }
            } else {
                System.out.println("존재하지않음: " + filePath);
                break;
            }

        }

        return setDTO;
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
