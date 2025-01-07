-- test.code_mng definition

-- Drop table

-- DROP TABLE test.code_mng;

CREATE TABLE test.code_mng
(
    cd_id    VARCHAR(255) NOT NULL,
    cd_key   VARCHAR(255),
    cd_name  VARCHAR(255),
    order_by VARCHAR(255),
    up_cd_id VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (cd_id)
);


-- test.file_mng definition

-- Drop table

-- DROP TABLE test.file_mng;

CREATE TABLE test.file_mng
(
    created_date       DATETIME,
    file_size          BIGINT,
    last_modified_date DATETIME,
    created_by         VARCHAR(255),
    del_yn             VARCHAR(255),
    file_name          VARCHAR(255),
    file_path          VARCHAR(255),
    file_type          VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    last_modified_by   VARCHAR(255),
    producer_code      VARCHAR(255),
    producer_id        VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- test.language_mng definition

-- Drop table

-- DROP TABLE test.language_mng;

CREATE TABLE test.language_mng
(
    created_date       DATETIME,
    last_modified_date DATETIME,
    created_by         VARCHAR(255),
    del_yn             VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    last_modified_by   VARCHAR(255),
    name               VARCHAR(255),
    note               VARCHAR(255),
    `type`             VARCHAR(255),
    value              VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- test.staff_mng definition

-- Drop table

-- DROP TABLE test.staff_mng;

CREATE TABLE test.staff_mng
(
    created_date       DATETIME,
    last_modified_date DATETIME,
    address            VARCHAR(255),
    avatar             VARCHAR(255),
    created_by         VARCHAR(255),
    `date`             VARCHAR(255),
    del_yn             VARCHAR(255),
    email              VARCHAR(255),
    full_name          VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    last_modified_by   VARCHAR(255),
    nationality        VARCHAR(255),
    password           VARCHAR(255),
    phone              VARCHAR(255),
    user_name          VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- test.user_mng definition

-- Drop table

-- DROP TABLE test.user_mng;

CREATE TABLE test.user_mng
(
    created_date       DATETIME,
    last_modified_date DATETIME,
    address            VARCHAR(255),
    avatar             VARCHAR(255),
    created_by         VARCHAR(255),
    `date`             VARCHAR(255),
    del_yn             VARCHAR(255),
    email              VARCHAR(255),
    full_name          VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    last_modified_by   VARCHAR(255),
    nationality        VARCHAR(255),
    password           VARCHAR(255),
    phone              VARCHAR(255),
    user_name          VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- test.sys_role definition

-- Drop table

-- DROP TABLE test.sys_role;

CREATE TABLE test.sys_role
(
    role_id      VARCHAR(100) NOT NULL,
    role_nm      VARCHAR(100),
    role_desc    VARCHAR(100),
    role_site_cd VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (role_id)
);


-- test.menu definition

-- Drop table

-- DROP TABLE test.menu;

CREATE TABLE test.menu
(
    menu_id       VARCHAR(100) NOT NULL,
    site_type     VARCHAR(100),
    name          VARCHAR(100),
    route         VARCHAR(100),
    parent_id     VARCHAR(100),
    display_order VARCHAR(100),
    del_yn        VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (menu_id)
);


-- test.menu_role definition

-- Drop table

-- DROP TABLE test.menu_role;

CREATE TABLE test.menu_role
(
    menu_id VARCHAR(100) NOT NULL,
    role_id VARCHAR(100) NOT NULL,
    status  VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (menu_id, role_id)
);


-- test.sys_user_role definition

-- Drop table

-- DROP TABLE test.sys_user_role;

CREATE TABLE test.sys_user_role
(
    role_id VARCHAR(100) NOT NULL,
    user_id VARCHAR(100) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (role_id, user_id)
);


-- test.banner definition

-- Drop table

-- DROP TABLE test.banner;

CREATE TABLE test.banner
(
    banner_seq         VARCHAR(100) NOT NULL,
    banner_nm          VARCHAR(100),
    banner_type        VARCHAR(100),
    use_yn             VARCHAR(1),
    start_date         DATETIME,
    end_date           DATETIME,
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    del_yn             VARCHAR(1),
    CONSTRAINT `PRIMARY` PRIMARY KEY (banner_seq)
);


-- test.notification_mng definition

-- Drop table

-- DROP TABLE test.notification_mng;

CREATE TABLE test.notification_mng
(
    notification_seq   VARCHAR(100) NOT NULL,
    title              VARCHAR(4000),
    user_send_seq      VARCHAR(100),
    is_read            VARCHAR(1),
    user_read_seq      VARCHAR(100),
    content            VARCHAR(4000),
    url                VARCHAR(1000),
    type_cd            VARCHAR(100),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    del_yn             VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (notification_seq)
);


-- test.qa definition

-- Drop table

-- DROP TABLE test.qa;

CREATE TABLE test.qa
(
    qa_seq             VARCHAR(100) NOT NULL,
    question           TEXT(65535),
    answer             TEXT(65535),
    question_date      DATETIME,
    answer_date        DATETIME,
    user_question      VARCHAR(100),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    del_yn             VARCHAR(1),
    temp_yn            VARCHAR(1),
    CONSTRAINT `PRIMARY` PRIMARY KEY (qa_seq)
);


-- test.cps_seq_mng definition

-- Drop table

-- DROP TABLE test.cps_seq_mng;

CREATE TABLE test.cps_seq_mng
(
    tbl_name VARCHAR(100) NOT NULL,
    prefix   VARCHAR(100),
    last_num DECIMAL(10, 0),
    CONSTRAINT `PRIMARY` PRIMARY KEY (tbl_name)
);


-- test.articel definition

-- Drop table

-- DROP TABLE test.articel;

CREATE TABLE test.articel
(
    articel_seq        VARCHAR(100),
    content            TEXT(65535),
    title              VARCHAR(100),
    `desc`             VARCHAR(100),
    is_show            VARCHAR(1),
    temp_yn            VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    del_yn             VARCHAR(1)
);