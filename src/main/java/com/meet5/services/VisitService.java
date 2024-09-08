package com.meet5.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VisitService {

    private final JdbcTemplate jdbcTemplate;

    // constructor-based dependency injection
    public VisitService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void recordVisit(Long visitorId, Long visitedId) {
        String sql = "INSERT INTO profile_visits (visitor_id, visited_id, visited_at) VALUES (?, ?, NOW())";
        jdbcTemplate.update(sql, visitorId, visitedId);
    }

     public int getRecentVisitCount(Long visitorId) {
        String sql = "SELECT COUNT(*) FROM profile_visits WHERE visitor_id = ? AND visited_at > NOW() - INTERVAL 10 MINUTE";
        return jdbcTemplate.queryForObject(sql, Integer.class, visitorId);
    }
}
