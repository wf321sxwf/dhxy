package com.dhxy.xy.answer;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Question {

    private static HashMap<String, String> map = new HashMap<>();
    private String question;
    private List<Answer> answers;

    //回答问题
    public Answer answer(){

        HashMap<String, Integer> innerMap = new HashMap<>();
        map.keySet().forEach(key -> {
            String str = question;
            while (!key.contains(str)) {
                str = str.substring(1, str.length() - 1);

                if (str.length() < 4) {
                    break;
                }
            }

            innerMap.put(key, str.length());
        });

        String content = innerMap.keySet().stream().max(Comparator.comparingInt(innerMap::get)).map(key -> map.get(key)).orElse(null);

        for (Answer answer : answers) {
            if (answer.getContent().contains(content)) {
                return answer;
            }
        }
        System.out.println("没有找到答案");
        return null;
    }

    public Question(String question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }


    //初始化题库
    static {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("db.txt");

        Reader reader = new InputStreamReader(resourceAsStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = "";


        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
                String[] array;
                if(line.contains("——")) {
                    array = line.split("——");
                } else {
                    array = line.split("\\?");
                }

                map.put(array[0].trim(), array[1].trim());


            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("初始化数据失败");
            }

        }

    }
}
