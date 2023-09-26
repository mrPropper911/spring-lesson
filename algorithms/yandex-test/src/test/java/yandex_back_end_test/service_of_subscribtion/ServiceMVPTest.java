package yandex_back_end_test.service_of_subscribtion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceMVPTest {


    @Test
    public void execution(){
        int n = 2;
        int m = 5;
        String str1 = "2 0 price stock_count";
        String str2 = "1 0 partner_content";
        List<String> stringList1 = List.of(str1, str2);
        String s1 = "{\"trace_id\": \"1\", \"offer\": {\"id\": \"1\", \"price\": 9990}}";
        String s2 = "{\"trace_id\": \"2\", \"offer\": {\"id\": \"1\", \"stock_count\": 100}}";
        String s3 = "{\"trace_id\": \"3\", \"offer\": {\"id\": \"2\", \"partner_content\": {\"title\": \"Backpack\"}}}";
        String s4 = "{\"trace_id\": \"4\", \"offer\": {\"id\": \"1\", \"stock_count\": 100}}";
        String s5 = "{\"trace_id\": \"5\", \"offer\": {\"id\": \"2\", \"partner_content\": {\"description\": \"Best backpack ever\"}}}";
        List<String> stringList2 = List.of(s1, s2, s3, s4, s5);

        String a1 = "{\"trace_id\":\"1\",\"offer\":{\"id\":\"1\",\"price\":9990}}";
        String a2 = "{\"trace_id\":\"2\",\"offer\":{\"id\":\"1\",\"price\":9990,\"stock_count\":100}}";
        String a3 = "{\"trace_id\":\"3\",\"offer\":{\"id\":\"2\",\"partner_content\":{\"title\":\"Backpack\"}}}";
        String a4 = "{\"trace_id\":\"5\",\"offer\":{\"id\":\"2\",\"partner_content\":{\"description\":\"Best backpack ever\",\"title\":\"Backpack\"}}}";
        List<String> expectedList = List.of(a1, a2, a3, a4);

        List<String> actualList = ServiceMVP.execution(n, m, stringList1, stringList2);
        assertThat(actualList).containsExactlyInAnyOrderElementsOf(expectedList);
    }

}