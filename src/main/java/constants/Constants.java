package constants;

public class Constants {

    public static class RunVariables{
        public static String server = "http://localhost:3001";
        public static String path = "";
        public static String jsonBody = "{\n" +
                "\"firstname\":\"Jim\",\n" +
                "\"lastname\":\"Brown\",\n" +
                "\"totalprice\":111,\n" +
                "\"depositpaid\":true,\n" +
                "\"bookingdates\":{\n" +
                "\"checkin\":\"2018-01-01\",\n" +
                "\"checkout\":\"2019-01-01\"\n" +
                "},\n" +
                "\"additionalneeds\":\"Breakfast\"\n" +
                "}";
        public static String jsonBodyUpdate = "{\n" +
                "\"firstname\":\"Jane\",\n" +
                "\"lastname\":\"Brown\",\n" +
                "\"totalprice\":150,\n" +
                "\"depositpaid\":true,\n" +
                "\"bookingdates\":{\n" +
                "\"checkin\":\"2018-01-01\",\n" +
                "\"checkout\":\"2019-01-01\"\n" +
                "},\n" +
                "\"additionalneeds\":\"Breakfast and Pool access\"\n" +
                "}";

        public static String creds = "{\n" +
                "\"username\":\"admin\",\n" +
                "\"password\":\"password123\"\n" +
                "}";

        public static String auth = "YWRtaW46cGFzc3dvcmQxMjM=";
    }


    public static class Server{
        public static String RESTFUL_BOOKER_URL = "http://localhost:3001";

    }

    public static class Path{
        public static String RESTFUL_BOOKER_PATH = "booking/";

    }

    public static class Action{
        public static String RESTFUL_BOOKER_TOKEN = "/auth";
        public static String RESTFUL_BOOKER_POST = "";
        public static String RESTFUL_BOOKER_GET_JANE = "?firstname=Jane";
    }
}
