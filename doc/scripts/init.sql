-- GRANT INSERT, UPDATE, SELECT, DELETE
--     ON ALL TABLES IN SCHEMA public
--     TO atm_admin;


ALTER TABLE CUSTOMER_ROLE
    DROP CONSTRAINT fk_customer_role;

ALTER TABLE CUSTOMER_PASS
    DROP CONSTRAINT fk_customer_pass;

ALTER TABLE ACCOUNT
    DROP CONSTRAINT fk_customer_account;
drop table CUSTOMER;
drop table CUSTOMER_PASS;
drop table CUSTOMER_ROLE;
drop table ACCOUNT;
drop type role_type;


CREATE TABLE CUSTOMER (
    id BIGSERIAL PRIMARY KEY not null ,
    username varchar(50) not null,
    name varchar(50) not null,
    surname varchar(100) not null,
    email varchar(100) not null,
    identification_code varchar(16) unique not null,
    customer_pass_id BIGSERIAL not null,
    birth timestamp not null
);

INSERT INTO CUSTOMER (id, username, name, surname, email, identification_code, customer_pass_id, birth)
VALUES (1, 'admin', 'admin', 'admin', 'admin_atm@gmail.com', '000000000000000', 2, now());

create table CUSTOMER_PASS (
    id BIGSERIAL PRIMARY KEY not null,
    customer_id BIGSERIAL not null,
    pwd varchar(255) not null,
    changed_ts timestamp not null
);

CREATE TYPE role_type AS ENUM ('ADMIN', 'ACCOUNT_MGMT', 'USER_MGMT');

CREATE TABLE CUSTOMER_ROLE (
    id BIGSERIAL PRIMARY KEY not null ,
    name role_type not null,
    customer_id BIGSERIAL not null
);

ALTER TABLE CUSTOMER_ROLE
    ADD CONSTRAINT fk_customer_role
        FOREIGN KEY (customer_id)
            REFERENCES CUSTOMER (id);

INSERT INTO CUSTOMER_ROLE (id, name, customer_id)
VALUES (1, 'ADMIN', 1);

-- ALTER TABLE CUSTOMER_PASS
--     ADD CONSTRAINT fk_customer_pass
--         FOREIGN KEY (customer_id)
--             REFERENCES CUSTOMER (id);
--
-- ALTER TABLE CUSTOMER
--     ADD CONSTRAINT fk_customer_pass_1
--         FOREIGN KEY (customer_pass_id)
--             REFERENCES CUSTOMER_PASS (id);

INSERT INTO CUSTOMER_PASS (id, customer_id, pwd, changed_ts)
VALUES (2, 1, 'admin', now());
-- JDJhJDEwJDFOQ1hkdGdlNno5V0NGbTdPL0x4VmVaLlBlb0dLWXZIQTBNY0UvQ1Y5TExLc2gySmQ1ejJ5
-- YWRtaW4=
-- create table Role (
--     id int PRIMARY KEY not null,
--     name varchar(15) not null
-- );

-- create table User_Role (
--     id int PRIMARY KEY not null,
--     user_id int not null,
--     role_id int not null
-- );

create table ACCOUNT(
    id BIGSERIAL PRIMARY KEY not null,
    code varchar(30) not null,
    customer_id BIGSERIAL not null,
    value int not null default 0
);

ALTER TABLE ACCOUNT
    ADD CONSTRAINT fk_customer_account
        FOREIGN KEY (customer_id)
            REFERENCES CUSTOMER (id);

