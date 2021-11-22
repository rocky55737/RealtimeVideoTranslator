package RealtimeVideoTranslator.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("myTesseract Result: ");
        myTesseract tesseract = new myTesseract();
        // 파일 경로는 이 프로젝트의 cwd\src\img 로 preset, 열 파일 이름은 설정 가능.
        // 설정 언어는 default 값이 eng, setImgLang 으로 변경 가능
        tesseract.setImgLang("eng");
        String OCRedText = tesseract.imgToString("K-009.png");
        System.out.println(OCRedText);

        System.out.println("myPapago Result: ");
        myPapago papago = new myPapago();
        // 파파고에 보낼 원본 언어, 번역 결과를 받을 타겟 언어 설정 추가
        // 설정 언어가 default 가 en -> ko, setSrcLang / setTgtLang 으로 변경 가능
        // clientId, clientSecret 값은 private static final 로 myPapago 클래스 내에 고정.
        papago.setSrcLang("en");
        papago.setTgtLang("ko");
        String translatedText = papago.Translate(OCRedText);
        System.out.println(translatedText);
    }
}
