CREATE TABLE filemanager_user (
    id SERIAL PRIMARY KEY,
    public_id VARCHAR(255) UNIQUE,
    email VARCHAR(255),
    password VARCHAR(255)
);