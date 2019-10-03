package com.dhxy.xy.scan;

import com.baidu.aip.ocr.AipOcr;
import com.dhxy.xy.answer.Answer;
import com.dhxy.xy.answer.Question;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import javax.sound.midi.Soundbank;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ImageScan {

    //设置APPID/AK/SK
    public static final String APP_ID = "17414803";
    public static final String API_KEY = "prgl75bOsZq1b5TRdmK0aG9Y";
    public static final String SECRET_KEY = "VUuCDybA035YQPGQyocEavh3iyHp4Hfk";


    private static JSONArray accurateGeneral(String path) {

        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("recognize_granularity", "big");
        options.put("detect_direction", "false");
        options.put("vertexes_location", "false");
        options.put("probability", "false");

        // 调用接口
//        String path = "/Users/jiyanlong/Desktop/test2.png";
        JSONObject res = client.accurateGeneral(path, options);
//        JSONObject res = client.generalUrl(path, options);

        return res.getJSONArray("words_result");
    }

    public static Question getQuestion(String path) {

        JSONArray objects = accurateGeneral(path);
        List<Object> questions = objects.toList().stream().filter(o -> {
            Map map = (Map) o;
            String words = (String) map.get("words");
            return words.contains("?") || words.contains("--");
        }).collect(Collectors.toList());

        List<Answer> answers = objects.toList().stream().filter(o -> {
//            Map map = (Map) o;
//            String words = (String) map.get("words");
            return true;
        }).map(word -> {
            Map map = (Map) word;
            Answer answer = new Answer();
            answer.setContent((String) map.get("words"));
            Map location = (Map) map.get("location");
            answer.setX((Integer) location.get("left"));
            answer.setY((Integer) location.get("top"));
            answer.setHeight((Integer) location.get("height"));
            answer.setWidth((Integer) location.get("width"));
            return answer;
        }).collect(Collectors.toList());

        Map map = (Map) questions.get(0);
        String quest = (String) map.get("words");

        return new Question(quest, answers);

    }


    public static void main(String[] args) {

        String path = "/Users/jiyanlong/Desktop/test2.png";

        Question question = getQuestion(path);

        System.out.println(question);

    }
}
