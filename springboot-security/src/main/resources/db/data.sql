INSERT INTO USER (ID, USERNAME, PASSWORD) VALUES (1, 'oaa', '$2a$10$n4mjtGI4lq303AZ93JEMc.vFfjL71QNuoK3DAYRDkokU8jdgTcGkW');
INSERT INTO USER (ID, USERNAME, PASSWORD) VALUES (2, 'tom', '$2a$10$n4mjtGI4lq303AZ93JEMc.vFfjL71QNuoK3DAYRDkokU8jdgTcGkW');
INSERT INTO "ROLE"(ID, ROLE_NAME, ROLE_DESC)VALUES(1, 'admin', '管理员');
INSERT INTO "ROLE"(ID, ROLE_NAME, ROLE_DESC)VALUES(2, 'normal', '普通用户');
INSERT INTO "USER_ROLE"(USER_ID, ROLE_ID)VALUES(1, 1);
INSERT INTO "USER_ROLE"(USER_ID, ROLE_ID)VALUES(2, 2);