package lesson7;

import java.util.Comparator;
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

    public static class Meta {
        private Response response;

        public void setResponse(Response response) {
            this.response = response;
        }
    }

    public static class Response {
        private Buckets buckets;
        private int total;
        private double took;

        public Buckets getBuckets() {
            return buckets;
        }

        public void setBuckets(Buckets buckets) {
            this.buckets = buckets;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public double getTook() {
            return took;
        }

        public void setTook(double took) {
            this.took = took;
        }
    }

    public static class Buckets {
        private int total;
        private int successful;
        private int skipped;
        private int failed;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSuccessful() {
            return successful;
        }

        public void setSuccessful(int successful) {
            this.successful = successful;
        }

        public int getSkipped() {
            return skipped;
        }

        public void setSkipped(int skipped) {
            this.skipped = skipped;
        }

        public int getFailed() {
            return failed;
        }

        public void setFailed(int failed) {
            this.failed = failed;
        }
    }

    public static class ResultItem implements Comparable<ResultItem> {
        private Long user_id;
        private String user_hid;
        private Integer distance;

        public Long getUser_id() {
            return user_id;
        }

        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

        public String getUser_hid() {
            return user_hid;
        }

        public void setUser_hid(String user_hid) {
            this.user_hid = user_hid;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(ResultItem other) {
            return Comparator
                    .nullsFirst(Comparator.comparingInt(ResultItem::getDistance))
                    .compare(this, other);
        }
    }
}