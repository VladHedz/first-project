package lesson7;

import java.util.Comparator;

public class ResultItem implements Comparable<ResultItem> {
    private Long userId;
    private String userHid;
    private Integer distance;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserHid() {
        return userHid;
    }

    public void setUserHid(String userHid) {
        this.userHid = userHid;
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