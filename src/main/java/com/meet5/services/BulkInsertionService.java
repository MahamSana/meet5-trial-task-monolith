package com.meet5.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class BulkInsertService {

    private final JdbcTemplate jdbcTemplate;

    // constructor-based dependency injection
    public BulkInsertService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // inserts a list of user visits into the database using batch processing.
    public void insertVisitsInBulk(List<Visit> visits) {
        String sql = "INSERT INTO profile_visits (visitor_id, visited_id, visited_at) VALUES (?, ?, NOW())";

        // using batch update for bulk insertion
        jdbcTemplate.batchUpdate(sql, visits, 1000, (PreparedStatement ps, Visit visit) -> {
            ps.setLong(1, visit.getVisitorId());
            ps.setLong(2, visit.getVisitedId());
        });
    }

    // inserts a list of user likes into the database using batch processing.
    public void insertLikesInBulk(List<Like> likes) {
        String sql = "INSERT INTO user_likes (liker_id, liked_id, liked_at) VALUES (?, ?, NOW())";

        // using batch update for bulk insertion
        jdbcTemplate.batchUpdate(sql, likes, 1000, (PreparedStatement ps, Like like) -> {
            ps.setLong(1, like.getLikerId());
            ps.setLong(2, like.getLikedId());
        });
    }
}
