-- FUNCTION COMMON
-- CREATE FUNCTION FN_GET_CODE_NAME(p_cd_id VARCHAR(255))
--     RETURNS VARCHAR(255)
--     DETERMINISTIC
-- BEGIN
--     DECLARE v_CODE_NAME VARCHAR(255);
--
--     IF p_cd_id IS NULL THEN
--         SET v_CODE_NAME = NULL;
-- ELSE
-- SELECT cd_name
-- INTO v_CODE_NAME
-- FROM code_mng
-- WHERE cd_id = p_cd_id
--     LIMIT 1;
-- END IF;
--
-- RETURN v_CODE_NAME;
-- END

-- Data Code_mng
INSERT INTO financial_tool.code_mng (cd_id,up_cd_id,cd_name,cd_key,order_by) VALUES
('10010','10000','Sử dụng','code.use','1'),
('10020','10000','Không sử dụng','code.not_use','2'),
('10110','10100','Tiếng Việt','code.viet_nam_ese','1'),
('10120','10100','Tiếng Anh','code.english','2'),
('10210','10200','Admin','code.role_admin','1'),
('10220','10200','Client','code.role_client','2'),
('10230','10200','Staff','code.role_staff','3');

-- Data Language

-- Data Menu

-- Data Resource

-- Data Role

-- Data Module


-- financial_tool.code_mng definition

-- Drop table

-- DROP TABLE financial_tool.code_mng;

CREATE TABLE financial_tool.code_mng
(
    cd_id    VARCHAR(100) NOT NULL,
    up_cd_id VARCHAR(100),
    cd_name  VARCHAR(255),
    cd_key   VARCHAR(100),
    order_by VARCHAR(20),
    CONSTRAINT `PRIMARY` PRIMARY KEY (cd_id)
);


-- financial_tool.cps_api_menu_permission definition

-- Drop table

-- DROP TABLE financial_tool.cps_api_menu_permission;

CREATE TABLE financial_tool.cps_api_menu_permission
(
    id                 VARCHAR(255) NOT NULL,
    api_id             VARCHAR(255),
    menu_id            VARCHAR(255),
    role_id            VARCHAR(255),
    name               VARCHAR(255),
    note               VARCHAR(255),
    del_yn             VARCHAR(255),
    created_date       DATETIME,
    created_by         VARCHAR(255),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.cps_menu_mng definition

-- Drop table

-- DROP TABLE financial_tool.cps_menu_mng;

CREATE TABLE financial_tool.cps_menu_mng
(
    id                 VARCHAR(255) NOT NULL,
    name               VARCHAR(255),
    icon               VARCHAR(30),
    url                VARCHAR(255),
    module             VARCHAR(255),
    key_lang           VARCHAR(255),
    parent_id          VARCHAR(255),
    use_yn             VARCHAR(1),
    `type`             VARCHAR(100),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.cps_module_mng definition

-- Drop table

-- DROP TABLE financial_tool.cps_module_mng;

CREATE TABLE financial_tool.cps_module_mng
(
    id                 VARCHAR(255) NOT NULL,
    code               VARCHAR(100),
    name               VARCHAR(255),
    note               VARCHAR(255),
    token              VARCHAR(255),
    use_yn             VARCHAR(1),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.cps_resource_mng definition

-- Drop table

-- DROP TABLE financial_tool.cps_resource_mng;

CREATE TABLE financial_tool.cps_resource_mng
(
    id                 VARCHAR(255) NOT NULL,
    menu               VARCHAR(255),
    module             VARCHAR(255),
    api                VARCHAR(255),
    name               VARCHAR(100),
    `role`             VARCHAR(255),
    `type`             VARCHAR(100),
    `method`           VARCHAR(20),
    use_yn             VARCHAR(1),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.cps_role_mng definition

-- Drop table

-- DROP TABLE financial_tool.cps_role_mng;

CREATE TABLE financial_tool.cps_role_mng
(
    id                 VARCHAR(255) NOT NULL,
    code               VARCHAR(100),
    name               VARCHAR(100),
    note               VARCHAR(255),
    use_yn             VARCHAR(1),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.cps_seq_mng definition

-- Drop table

-- DROP TABLE financial_tool.cps_seq_mng;

CREATE TABLE financial_tool.cps_seq_mng
(
    tbl_name VARCHAR(100) NOT NULL,
    last_num DECIMAL(10, 0),
    prefix   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (tbl_name)
);


-- financial_tool.cps_tool_mng definition

-- Drop table

-- DROP TABLE financial_tool.cps_tool_mng;

CREATE TABLE financial_tool.cps_tool_mng
(
    id                 VARCHAR(255) NOT NULL,
    name               VARCHAR(255),
    del_yn             VARCHAR(1),
    note               VARCHAR(255),
    use_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(100),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(100),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.file_mng definition

-- Drop table

-- DROP TABLE financial_tool.file_mng;

CREATE TABLE financial_tool.file_mng
(
    id                 VARCHAR(255) NOT NULL,
    file_name          VARCHAR(255),
    file_path          VARCHAR(255),
    file_type          VARCHAR(50),
    producer_code      VARCHAR(100),
    producer_id        VARCHAR(255),
    file_size          BIGINT,
    created_date       DATETIME,
    created_by         VARCHAR(255),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(255),
    del_yn             VARCHAR(1),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.language_mng definition

-- Drop table

-- DROP TABLE financial_tool.language_mng;

CREATE TABLE financial_tool.language_mng
(
    id                 VARCHAR(255) NOT NULL,
    name               VARCHAR(255) NOT NULL,
    `type`             VARCHAR(100),
    value              VARCHAR(255),
    note               VARCHAR(255),
    del_yn             VARCHAR(1),
    created_date       DATETIME,
    created_by         VARCHAR(255),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.staff_mng definition

-- Drop table

-- DROP TABLE financial_tool.staff_mng;

CREATE TABLE financial_tool.staff_mng
(
    id                 VARCHAR(255) NOT NULL,
    user_name          VARCHAR(255),
    full_name          VARCHAR(255),
    address            VARCHAR(255),
    avatar             VARCHAR(255),
    `date`             VARCHAR(255),
    email              VARCHAR(255),
    nationality        VARCHAR(255),
    password           VARCHAR(255),
    phone              VARCHAR(255),
    del_yn             VARCHAR(255),
    created_date       DATETIME,
    created_by         VARCHAR(255),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.user_mng definition

-- Drop table

-- DROP TABLE financial_tool.user_mng;

CREATE TABLE financial_tool.user_mng
(
    id                 VARCHAR(255) NOT NULL,
    user_name          VARCHAR(255),
    full_name          VARCHAR(255),
    address            VARCHAR(255),
    avatar             VARCHAR(255),
    `date`             VARCHAR(255),
    email              VARCHAR(255),
    nationality        VARCHAR(255),
    password           VARCHAR(255),
    phone              VARCHAR(255),
    del_yn             VARCHAR(255),
    created_date       DATETIME,
    created_by         VARCHAR(255),
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);


-- financial_tool.user_permission definition

-- Drop table

-- DROP TABLE financial_tool.user_permission;

CREATE TABLE financial_tool.user_permission
(
    api_menu_per_id    VARCHAR(255),
    id                 VARCHAR(255) NOT NULL,
    user_id            VARCHAR(255),
    del_yn             VARCHAR(255),
    created_date       DATETIME,
    last_modified_date DATETIME,
    last_modified_by   VARCHAR(255),
    created_by         VARCHAR(255),
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);