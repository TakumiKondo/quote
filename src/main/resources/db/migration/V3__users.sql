SET SESSION FOREIGN_KEY_CHECKS=0;

-- パスワードカラム追加
ALTER TABLE users ADD password varchar(100) NOT NULL AFTER name;
