CREATE TABLE notifications
(
    id          BIGSERIAL PRIMARY KEY,
    text        TEXT      NOT NULL,
    exchange    TEXT      NOT NULL,
    routing_key TEXT      NOT NULL,
    created_at  TIMESTAMP NOT NULL,
    is_read     BOOLEAN   NOT NULL DEFAULT FALSE
);