package com.guoxinan.day02.homework;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class homework3 {

    public static void main(String[] args) {
        //创建MP3信息
        Map<String, Object> mp3 = new HashMap<>();
        mp3.put("品牌","爱国者F928");
        mp3.put("重量",12.4);
        mp3.put("电池类型","内置锂电池");
        mp3.put("价格",499);
        //格式化输出信息
        System.out.println("MP3:");
        for(Map.Entry<String, Object> entry : mp3.entrySet()){
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
