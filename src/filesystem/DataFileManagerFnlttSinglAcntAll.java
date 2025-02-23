package filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.DartFnlttSinglAcntAllDTO;

public class DataFileManagerFnlttSinglAcntAll extends DataFileManager {

    // protected final String corpcodeFilePath = "documents/CORPCODE.xml";
    // protected final String dataDir = "data/";
    // protected final String dartDir = dataDir + "dart/";
    // protected final String fnlttSinglAcntAllDir = dartDir + "fnlttSinglAcntAll/";

    // protected final String stockDir = dataDir + "stock/";

    // protected String directory = dataDir + "bin/";

    protected String corpDir = "corp_code/";

    // #Base Method
    public String dir(String corp_code) {

        if (corp_code != null && !corp_code.isEmpty()) {
            corpDir = corp_code + "/";
            directory = fnlttSinglAcntAllDir + corpDir;

        }
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return directory;
    }

    // #Base Method
    public String fileName(String corp_code, String bsns_year, String reprt_code, String fs_div) {

        String fileName = "";

        if (corp_code != null && !corp_code.isEmpty()) {
            fileName += corp_code
                    + "_";
        }
        if (bsns_year != null && !bsns_year.isEmpty()) {
            fileName += bsns_year
                    + "_";
        }
        if (reprt_code != null && !reprt_code.isEmpty()) {
            fileName += reprt_code
                    + "_";
        }
        if (fs_div != null && !fs_div.isEmpty()) {
            fileName += fs_div;
            // + "_" ;
        }

        return fileName;
    }

    // #Base Method
    public String filePath(String corp_code, String bsns_year, String reprt_code, String fs_div,
            String extension) {

        String filePath = dir(corp_code)
                + fileName(corp_code, bsns_year, reprt_code, fs_div)
                + "." + extension;

        return filePath;
    }

    // #Base Method
    public List<DartFnlttSinglAcntAllDTO> readXmlFile(String filePath) {
        List<DartFnlttSinglAcntAllDTO> list = new ArrayList<>();

        File file = new File(filePath);

        if (file.exists()) {

            try {

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();

                Document document = builder.parse(filePath);
                document.getDocumentElement().normalize();

                NodeList statusNodeList = document.getElementsByTagName("status");
                String statusValue = "";
                if (statusNodeList.getLength() > 0) {
                    Node statusNode = statusNodeList.item(0);
                    statusValue = statusNode.getTextContent();
                    System.out.println("Status: " + statusValue);
                }

                if (statusValue.equals("000")) {

                    NodeList nodeList = document.getElementsByTagName("list");

                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Node node = nodeList.item(i);
                        DartFnlttSinglAcntAllDTO dto = parseNodeToDTO(node);

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

    private DartFnlttSinglAcntAllDTO parseNodeToDTO(Node node) {
        DartFnlttSinglAcntAllDTO dto = new DartFnlttSinglAcntAllDTO();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;

            // getTagValue 메소드로 태그가 없는 경우 "" 공백으로 처리
            dto.setRcept_no(getTagValue(element, "rcept_no"));
            dto.setReprt_code(getTagValue(element, "reprt_code"));
            dto.setBsns_year(getTagValue(element, "bsns_year"));
            dto.setCorp_code(getTagValue(element, "corp_code"));
            dto.setSj_div(getTagValue(element, "sj_div"));
            dto.setSj_nm(getTagValue(element, "sj_nm"));
            dto.setAccount_id(getTagValue(element, "account_id"));
            dto.setAccount_nm(getTagValue(element, "account_nm"));
            dto.setAccount_detail(getTagValue(element, "account_detail"));
            dto.setThstrm_nm(getTagValue(element, "thstrm_nm"));
            dto.setThstrm_amount(getTagValue(element, "thstrm_amount"));
            dto.setFrmtrm_nm(getTagValue(element, "frmtrm_nm"));
            dto.setFrmtrm_amount(getTagValue(element, "frmtrm_amount"));
            dto.setBfefrmtrm_nm(getTagValue(element, "bfefrmtrm_nm"));
            dto.setBfefrmtrm_amount(getTagValue(element, "bfefrmtrm_amount"));
            dto.setOrd(getTagValue(element, "ord"));
            dto.setCurrency(getTagValue(element, "currency"));
        }
        return dto;
    }

    // #OverLoaded
    public List<DartFnlttSinglAcntAllDTO> readXmlFile(String corp_code, String bsns_year, String reprt_code,
            String fs_div) {

        List<DartFnlttSinglAcntAllDTO> list = new ArrayList<>();

        directory = dir(corp_code);

        String fileName = fileName(corp_code, bsns_year, reprt_code, fs_div);
        String filePath = directory + fileName + ".xml";

        list = readXmlFile(filePath);

        return list;
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

                NodeList statusNodeList = document.getElementsByTagName("status");

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
    public List<String> fileList(String corp_code) {
        List<String> fileList = new ArrayList<>();

        directory = dir(corp_code);
        File fileDir = new File(directory);

        // 디렉토리 확인 및 파일 목록 가져오기
        if (fileDir.exists() && fileDir.isDirectory()) {
            // 디렉토리 안의 파일 및 서브디렉토리 이름 배열 가져오기
            String[] fileNames = fileDir.list();

            if (fileNames != null) {
                System.out.println("디렉토리 내 파일 목록:");
                for (String fileName : fileNames) {
                    fileList.add(fileName);
                    System.out.println(fileName);
                }
            } else {
                System.out.println("디렉토리가 비어 있거나 오류가 발생했습니다.");
            }
        } else {
            System.out.println("지정된 경로가 디렉토리가 아니거나 존재하지 않습니다.");
        }

        return fileList;

    }

}
