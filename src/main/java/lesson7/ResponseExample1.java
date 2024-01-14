package lesson7;

import java.util.List;

public class ResponseExample1 {
    private Meta meta;
    private List<ResultItem> result;
    private String errors;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<ResultItem> getResult() {
        return result;
    }

    public void setResult(List<ResultItem> result) {
        this.result = result;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}