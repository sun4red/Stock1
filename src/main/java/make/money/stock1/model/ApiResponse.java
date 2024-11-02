package make.money.stock1.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;
@Data
public class ApiResponse {
    private String status;
    private Data data;

    // Getters and Setters

    public static class Data {


        private List<String> list;

        // Getters and Setters

    }
}