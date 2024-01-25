package lesson7;

public class Response {
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