package sender;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by igor on 10.12.16.
 */
public class HttpRequestSender {

    public static void main(String[] args) throws UnirestException {

        //getPage();
        getNumbersList();
        //addNumber("523/1991/15-ц");
        //deleteNumber();
        //showCaseList();


    }

    private static void getPage() throws UnirestException {
        HttpResponse<String> response = Unirest.get("http://localhost:8080/")
                .header("accept", "text/html")
                .asString();

        System.out.println(response.getBody());
    }


    private static void getNumbersList() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/tracked_numbers")
                .header("accept", "application/json")
                .asJson();

        System.out.println(response.getBody());
    }

    private static void addNumber(String number) throws UnirestException {
        HttpResponse<String> response = Unirest.post("http://localhost:8080/tracked_numbers")
                .header("accept", "application/json")
                .body(number)
                .asString();

        System.out.println(response.getBody());
    }

    private static void deleteNumber(String number) throws UnirestException {
        HttpResponse<String> response = Unirest.delete("http://localhost:8080/tracked_numbers/"+number)
                .header("accept", "application/json")
                .asString();
        System.out.println(response.getBody());
    }

    private static void showCaseList() throws UnirestException {
        HttpResponse<String> response = Unirest.get("http://localhost:8080/hearings")
                .header("accept", "application/json")
                .asString();
        System.out.println(response.getBody());
    }






}
