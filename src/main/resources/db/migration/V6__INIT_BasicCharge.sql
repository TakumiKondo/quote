SET SESSION FOREIGN_KEY_CHECKS=0;

TRUNCATE table basic_charge;
INSERT INTO basic_charge (price, description, created_at, createt_user, updated_at, updated_user, deleted_at, deleted_user, version)
 VALUES (0, '初期化', now(), 'SYSTEM', now(), 'SYSTEM', null, null, 0);
