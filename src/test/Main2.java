package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import api.model.MDartResult;

public class Main2 {

    public static void main(String[] args) {

 try {
            // XMLStreamReader 생성
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(new File(filePath)));

            // XmlMapper 객체 생성
            XmlMapper xmlMapper = new XmlMapper();
            
            // XMLStreamReader를 XmlMapper에 전달하여 MDartResult 객체로 읽기
            MDartResult mDartResult = xmlMapper.readValue(reader, MDartResult.class);

            // 결과 출력
            mDartResult.getCorpcodeList().forEach(corp -> {
                System.out.println("Corp Code: " + corp.getCorp_code());
                System.out.println("Corp Name: " + corp.getCorp_name());
                System.out.println("Stock Code: " + corp.getStock_code());
                System.out.println("Modify Date: " + corp.getModify_date());
            });

            reader.close();

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }

    }
}
