package com.meet5.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {

    private JdbcTemplate jdbcTemplate;

    // constructor-based dependency injection
    public LikeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void recordLike(Long likerId, Long likedId) {
        String sql = "INSERT INTO user_likes (liker_id, liked_id, liked_at) VALUES (?, ?, NOW())";
        jdbcTemplate.update(sql, likerId, likedId);
    }

    public int getRecentLikeCount(Long likerId) {
        String sql = "SELECT COUNT(*) FROM user_likes WHERE liker_id = ? AND liked_at > NOW() - INTERVAL 10 MINUTE";
        return jdbcTemplate.queryForObject(sql, Integer.class, likerId);
    }
}
