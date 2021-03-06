CREATE TABLE IF NOT EXISTS "USER" (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    USERNAME VARCHAR(100) NOT NULL UNIQUE,
    PASSWORD VARCHAR(255) NOT NULL,
    ACCOUNT_NON_EXPIRED CHAR(1) DEFAULT 'Y' NOT NULL,
    ACCOUNT_NON_LOCKED CHAR(1) DEFAULT 'Y' NOT NULL,
    CREDENTIALS_NON_EXPIRED CHAR(1) DEFAULT 'Y' NOT NULL,
    ENABLED CHAR(1) DEFAULT 'Y' NOT NULL,
    DEL_FLAG TINYINT DEFAULT 0 NOT NULL,
    CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    EDIT_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL
);

CREATE TABLE IF NOT EXISTS "ROLE" (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ROLE_NAME VARCHAR(100) NOT NULL UNIQUE,
    ROLE_DESC VARCHAR(255),
    DEL_FLAG TINYINT DEFAULT 0 NOT NULL,
    CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    EDIT_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL
);

CREATE TABLE IF NOT EXISTS "USER_ROLE" (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    USER_ID INT NOT NULL,
    ROLE_ID INT NOT NULL,
    DEL_FLAG TINYINT DEFAULT 0 NOT NULL,
    CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    EDIT_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL
);