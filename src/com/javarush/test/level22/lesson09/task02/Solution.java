package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    static Map<String, String> para = new HashMap<>();

    public static void main(String[] args)
    {
        para.put("name", "Ivanov");
        para.put("country", "Ukraine");
        para.put("city", "Kiev");
        para.put("age", null);

        System.out.println(getCondition(para));

    }

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> pair : params.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            if(value !=null){

                if (sb.toString().equals(""))
                sb.append(key).append(" = '" ).append(value).append("'");
                else
                    sb.append(" and ").append(key).append(" = '").append(value).append("'");

            }
        }
        return sb;
    }
}