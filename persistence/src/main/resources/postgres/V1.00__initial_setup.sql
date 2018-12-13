CREATE TABLE profile_user
(
    user_id bigint NOT NULL,
    login_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    login_name_lc character varying(120) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(120) COLLATE pg_catalog."default",
    first_name_nls character varying(240) COLLATE pg_catalog."default",
    last_name character varying(120) COLLATE pg_catalog."default",
    last_name_nls character varying(240) COLLATE pg_catalog."default",
    job_title character varying(245) COLLATE pg_catalog."default",
    deleted_date timestamp without time zone,
    account_type character varying(20) COLLATE pg_catalog."default",
    create_date timestamp without time zone DEFAULT now(),
    update_date timestamp without time zone DEFAULT now(),
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    user_type_id bigint NOT NULL,
    visibility character varying(20) COLLATE pg_catalog."default",
    on_call character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT pk_profile_user PRIMARY KEY (user_id),
    CONSTRAINT uk_profile_user_login_name_lc UNIQUE (login_name_lc),
    CONSTRAINT chk_profile_user_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_PROFILE_USER START WITH 1000;

CREATE TABLE profile_user_detail
(
    user_detail_id bigint NOT NULL,
    address character varying(120) COLLATE pg_catalog."default",
    suite_apt character varying(120) COLLATE pg_catalog."default",
    city character varying(120) COLLATE pg_catalog."default",
    state character varying(120) COLLATE pg_catalog."default",
    state_abbreviation character varying(3) COLLATE pg_catalog."default",
    zip_code character varying(20) COLLATE pg_catalog."default",
    phone character varying(12) COLLATE pg_catalog."default",
    cell character varying(12) COLLATE pg_catalog."default",
    fax character varying(12) COLLATE pg_catalog."default",
    email character varying(320) COLLATE pg_catalog."default",
    email_lc character varying(320) COLLATE pg_catalog."default",
    email_verify boolean  DEFAULT 'F'::boolean,
    CONSTRAINT pk_profile_user_detail PRIMARY KEY (user_detail_id),
    CONSTRAINT chk_profile_user_email_verify CHECK (email_verify::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean])),
);

CREATE SEQUENCE SEQ_PROFILE_USER_DETAIL START WITH 1000;

CREATE TABLE profile_user2detail
(
    user_id bigint NOT NULL,
    user_detail_id bigint NOT NULL,
    CONSTRAINT user_id_account_pk PRIMARY KEY (user_id, user_detail_id),
    CONSTRAINT user_id_fk FOREIGN KEY (user_id)
            REFERENCES profile_user (user_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT user_detail_fk FOREIGN KEY (user_detail_id)
            REFERENCES profile_user_detail (user_detail_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_agency
(
    agency_id bigint NOT NULL,
    name character varying(240) COLLATE pg_catalog."default" NOT NULL,
    name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    address character varying(120) COLLATE pg_catalog."default",
    suite_apt character varying(120) COLLATE pg_catalog."default",
    city character varying(120) COLLATE pg_catalog."default",
    state character varying(120) COLLATE pg_catalog."default",
    state_abbreviation character varying(3) COLLATE pg_catalog."default",
    zip_code character varying(20) COLLATE pg_catalog."default",
    phone character varying(12) COLLATE pg_catalog."default",
    cell character varying(12) COLLATE pg_catalog."default",
    fax character varying(12) COLLATE pg_catalog."default",
    email character varying(320) COLLATE pg_catalog."default",
    email_lc character varying(320) COLLATE pg_catalog."default",
    email_verify boolean  DEFAULT 'F'::boolean,
    CONSTRAINT pk_profile_user_detail PRIMARY KEY (user_detail_id),
    CONSTRAINT uk_profile_agency_name_lc UNIQUE (name_lc),
    CONSTRAINT chk_profile_user_email_verify CHECK (email_verify::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean])),
);

CREATE SEQUENCE SEQ_PROFILE_AGENCY START WITH 1000;

CREATE TABLE profile_user2agency
(
    user_id bigint NOT NULL,
    agency_id bigint NOT NULL,
    CONSTRAINT user_id_account_pk PRIMARY KEY (user_id, agency_id),
    CONSTRAINT user_id_fk FOREIGN KEY (user_id)
            REFERENCES profile_user (user_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT agency_fk FOREIGN KEY (agency_id)
            REFERENCES profile_agency (agency_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_password_recover
(
    pwd_rcvr_id bigint NOT NULL,
    user_id character varying(120) COLLATE pg_catalog."default" NOT NULL,
    expire timestamp without time zone DEFAULT now(),
    security character varying(20) COLLATE pg_catalog."default" NOT NULL,
    allow character varying(100) COLLATE pg_catalog."default",
    email character varying(320) COLLATE pg_catalog."default",
    alt_email character varying(320) COLLATE pg_catalog."default",
    sms_number character varying(20) COLLATE pg_catalog."default",
    token character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT pk_account_pwd_rcvr PRIMARY KEY (pwd_rcvr_id),
    CONSTRAINT cis_account_rcvr_fk FOREIGN KEY (login_name_lc)
        REFERENCES profile_user (login_name_lc) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT chk_profile_password_recover_security CHECK (security::text = ANY (ARRAY['REQUIRED'::character varying::text, 'COMPLETED'::character varying::text, 'NOT_REQUIRED'::character varying::text]))
);

CREATE SEQUENCE SEQ_PASSWORD_RECOVER START WITH 1000;





CREATE TABLE profile_patient
(
    patient_id bigint NOT NULL,
    first_name character varying(120) COLLATE pg_catalog."default",
    first_name_nls character varying(240) COLLATE pg_catalog."default",
    last_name character varying(120) COLLATE pg_catalog."default",
    last_name_nls character varying(240) COLLATE pg_catalog."default",
    medical character varying(245) COLLATE pg_catalog."default",
    email character varying(320) COLLATE pg_catalog."default",
    email_lc character varying(320) COLLATE pg_catalog."default",
    country character varying(128) COLLATE pg_catalog."default",
    email_verify boolean  DEFAULT 'F'::boolean,
    deleted_date timestamp without time zone,
    image_url character varying(2000) COLLATE pg_catalog."default",
    account_type character varying(20) COLLATE pg_catalog."default",
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    --deleted_date timestamp without time zone,
    CONSTRAINT pk_profile_patient PRIMARY KEY (patient_id),
    CONSTRAINT chk_profile_patient_email_verify CHECK (email_verify::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean])),
    CONSTRAINT chk_profile_patient_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

