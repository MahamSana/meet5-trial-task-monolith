CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    fullname VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_encrypted VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_users_username ON users (username);
CREATE INDEX idx_users_email ON users (email);

CREATE TABLE profile_visits (
    visit_id SERIAL PRIMARY KEY,
    visitor_id INT NOT NULL,
    visited_user_id INT NOT NULL,
    visited_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (visitor_id) REFERENCES users (user_id),
    FOREIGN KEY (visited_user_id) REFERENCES users (user_id)
);

CREATE TABLE user_likes (
    like_id SERIAL PRIMARY KEY,
    liker_id INT NOT NULL,
    liked_user_id INT NOT NULL,
    liked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (liker_id) REFERENCES users (user_id),
    FOREIGN KEY (liked_user_id) REFERENCES users (user_id)
);
