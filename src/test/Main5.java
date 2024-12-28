package test;

import java.io.File;

public class Main5 {
    public static void main(String[] args) {

        String dir = "data/";

        dir += "fnlttSinglAcntAll" + "/" + "00938721";

        File fileDir = new File(dir);

        // 디렉토리 확인 및 파일 목록 가져오기
        if (fileDir.exists() && fileDir.isDirectory()) {
            // 디렉토리 안의 파일 및 서브디렉토리 이름 배열 가져오기
            String[] fileNames = fileDir.list();

            if (fileNames != null) {
                System.out.println("디렉토리 내 파일 목록:");
                for (String fileName : fileNames) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("디렉토리가 비어 있거나 오류가 발생했습니다.");
            }
        } else {
            System.out.println("지정된 경로가 디렉토리가 아니거나 존재하지 않습니다.");
        }
    }
}
