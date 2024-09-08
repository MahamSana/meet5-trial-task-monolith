package com.meet5.models;

public class Visit {
    private Long visitorId;
    private Long visitedId;

    public Visit(Long visitorId, Long visitedId) {
        this.visitorId = visitorId;
        this.visitedId = visitedId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getVisitedId() {
        return visitedId;
    }

    public void setVisitedId(Long visitedId) {
        this.visitedId = visitedId;
    }
}
