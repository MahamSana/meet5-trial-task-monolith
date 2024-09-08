package com.meet5.models;

public class Like {
    private Long likerId;
    private Long likedId;

    public Like(Long likerId, Long likedId) {
        this.likerId = likerId;
        this.likedId = likedId;
    }

    public Long getLikerId() {
        return likerId;
    }

    public void setLikerId(Long likerId) {
        this.likerId = likerId;
    }

    public Long getLikedId() {
        return likedId;
    }

    public void setLikedId(Long likedId) {
        this.likedId = likedId;
    }
}
