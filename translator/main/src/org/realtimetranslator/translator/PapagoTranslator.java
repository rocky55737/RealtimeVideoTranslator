package org.realtimetranslator.translator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.realtimetranslator.Translator;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PapagoTranslator implements Translator {
    private static final String clientId = "_mLgROuXC_v0ByKVfrXv";// 애플리케이션 클라이언트 아이디값
    private static final String clientSecret = "u7XMv1IeKY";// 애플리케이션 클라이언트 시크릿값
    private static String srcLang = "en";
    private static String tgtLang = "ko";

    public void setSrcLang(String sourceLang) { srcLang = sourceLang; }
    public void setTgtLang(String targetLang) { tgtLang = targetLang; }

    public String translate(String OCRedText) {
//        Scanner input = new Scanner(System.in);
//        String clientId = "";//애플리케이션 클라이언트 아이디값";
//        String clientSecret = "";//애플리케이션 클라이언트 시크릿값";

        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
        String text;
//        String textInputByUser;
//        System.out.println("번역할 문장을 입력해주세요...");
//        textInputByUser = input.nextLine();
        try {
            text = URLEncoder.encode(OCRedText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        }

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

        String responseBody = post(apiURL, requestHeaders, text);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(responseBody);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JSONObject objMessage = (JSONObject) jsonObject.get("message");
        JSONObject objResult = (objMessage==null)? new JSONObject((Collections.singletonMap("translatedText", "결과 없음"))) : (JSONObject) objMessage.get("result");
        String translatedText = (String) objResult.get("translatedText");

        return translatedText;
    }

    private static String post(String apiUrl, Map<String, String> requestHeaders, String text) {
        HttpURLConnection con = connect(apiUrl);
//        String postParams = "source=en&target=ko&text=" + text; // Source Lang: en -> Target lang: ko
        String postParams = "source=" + srcLang + "&target=" + tgtLang + "&text=" + text;
        try {
            con.setRequestMethod("POST");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL 이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
