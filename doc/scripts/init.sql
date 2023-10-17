CREATE TABLE CUSTOMER (
    id BIGSERIAL PRIMARY KEY not null ,
    name varchar(50) not null,
    surname varchar(100) not null,
    identification_code varchar(16) unique not null,
    customer_pass_id BIGSERIAL not null,
    birth timestamp not null
);

INSERT INTO CUSTOMER (id, name, surname, identification_code, birth)
VALUES (1, 'admin', 'admin', '000000000000000', now());

create table CUSTOMER_PASS (
    id BIGSERIAL PRIMARY KEY not null,
    customer_id BIGSERIAL not null,
    pwd bytea not null,
    changed_ts timestamp not null
);

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
VALUES (2, 1, CAST(encode('admin', 'base64') as bytea), now());
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

commit;