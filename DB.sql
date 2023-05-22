DROP DATABASE IF EXISTS `crossjoin`;
CREATE DATABASE `crossjoin`;
USE `crossjoin`;
#--------------------------------------------
#--------------------------------------------
#--------------------------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`(
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    email CHAR(50) NOT NULL,
    loginPw CHAR(100) NOT NULL,
    authLevel SMALLINT UNSIGNED DEFAULT 3 COMMENT '권한 레벨 (3=일반, 7=관리자)',
    nickname CHAR(20) NOT NULL,
    delStatus TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴 여부 (0=탈퇴 전, 1=탈퇴 후)',
    delDate DATETIME COMMENT '탈퇴 날짜'
);
#--------------------------------------------
DESC `member`;
SELECT * FROM `member`;

#테스트 데이터
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
email = 'admin@test.com',
loginPw = 'admin',
authLevel = 7,
nickname = '관리자';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
email = 'test1@test.com',
loginPw = 'test1',
authLevel = 3,
nickname = '테스트닉네임1';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
email = 'test2@test.com',
loginPw = 'test2',
authLevel = 3,
nickname = '테스트닉네임2';

DELETE FROM `member` WHERE id = 17;
#--------------------------------------------
#--------------------------------------------
#--------------------------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`(
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    boardGroup ENUM('GENERAL', 'GATHERING'),
    memberId INT UNSIGNED NOT NULL,
    boardId INT UNSIGNED NOT NULL,
    title CHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);
#--------------------------------------------
DESC `article`;
SELECT * FROM `article`;

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 1,
boardGroup = 'general',
boardId = 1,
title = '테스트 게시글 제목 1',
`body` = '테스트 게시글 내용 1';

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 2,
boardGroup = 'general',
boardId = 1,
title = '테스트 게시글 제목 2',
`body` = '테스트 게시글 내용 2';

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 1,
boardGroup = 'general',
boardId = 1,
title = '테스트 게시글 제목 3',
`body` = '테스트 게시글 내용 3';

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 1,
boardGroup = 'general',
boardId = 1,
title = '테스트 게시글 제목 4',
`body` = '테스트 게시글 내용 4';

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 2,
boardGroup = 'general',
boardId = 1,
title = '테스트 게시글 제목 5',
`body` = '테스트 게시글 내용 5';

DELETE FROM `article` WHERE id >= 6;
#--------------------------------------------
#--------------------------------------------
#--------------------------------------------