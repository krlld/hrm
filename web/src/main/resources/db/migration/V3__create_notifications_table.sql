CREATE TABLE notifications
(
    id         BIGSERIAL PRIMARY KEY,
    text       TEXT      NOT NULL,
    topic      TEXT      NOT NULL,
    created_at TIMESTAMP NOT NULL,
    is_read    BOOLEAN   NOT NULL DEFAULT FALSE
);