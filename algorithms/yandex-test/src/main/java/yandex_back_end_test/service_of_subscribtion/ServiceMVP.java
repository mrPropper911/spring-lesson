package yandex_back_end_test.service_of_subscribtion;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ServiceMVP {
    public static void main(String[] args) throws JsonProcessingException {

        int n; //[1,50] number of service
        int m; //[1,10_000] number of update requests


//        ObjectMapper objectMapper = new ObjectMapper();
//        Message message = objectMapper.readValue(jsonStr, Message.class);


    }

    public static List<String> execution(int n, int m, List<String> serviceDescription,
                                  List<String> jsonRequest){





        return new ArrayList<>();
    }

    @Getter
    @Setter
    public static class Service{

    }


    @Getter
    @Setter
    public static class Message{
        private String trace_id;
        private Offer offer;
    }

    @Getter
    @Setter
    public static class Offer{
        private String id;
        private int price;
        private int stock_count;
        @JsonProperty("partner_content")
        private PartnerContent partnerContent;
    }

    @Getter
    @Setter
    public static class PartnerContent{
        private String title;
        private String description;
    }
}
