SELECT visitor_id, visited_at
FROM profile_visits
WHERE visited_user_id = :user_id_param
ORDER BY visited_at DESC;
