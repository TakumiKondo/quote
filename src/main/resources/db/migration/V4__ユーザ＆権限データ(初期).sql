-- 権限
INSERT INTO roles (cd, name, created_at, createt_user, updated_at, updated_user, deleted_at, deleted_user) VALUES ('user', '一般ユーザ', '2020-08-23 12:14:51', 'initial', '2020-08-23 12:15:00', 'initial', null, null);
INSERT INTO roles (cd, name, created_at, createt_user, updated_at, updated_user, deleted_at, deleted_user) VALUES ('admin', '管理者', '2020-08-23 12:15:27', 'initial', '2020-08-23 12:15:45', 'initial', null, null);

-- ユーザー
INSERT INTO users (id, name, password, role_cd, created_at, createt_user, updated_at, updated_user, deleted_at, deleted_user) VALUES ('user', 'ユーザ', '$2a$10$X.QxXMwxvIBgIMx7wp4x3evJfmSlrCVuHFK9bYUG.B1ZzTtspdnFC', 'user', '2020-08-23 12:12:24', 'initial', '2020-08-23 12:12:50', 'initial', null, null);
INSERT INTO users (id, name, password, role_cd, created_at, createt_user, updated_at, updated_user, deleted_at, deleted_user) VALUES ('admin', '管理者', '$2a$10$X.QxXMwxvIBgIMx7wp4x3evJfmSlrCVuHFK9bYUG.B1ZzTtspdnFC', 'admin', '2020-08-23 12:13:55', 'initial', '2020-08-23 12:14:09', 'initial', null, null);
