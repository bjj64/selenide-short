package models;

import lombok.Data;
import java.util.List;

@Data
public class DataItem {
    private String url;
    private List<String> expressions;

    public String getUrl() {
        return url;
    }

    public List<String> getExpressions() {
        return expressions;
    }
}
