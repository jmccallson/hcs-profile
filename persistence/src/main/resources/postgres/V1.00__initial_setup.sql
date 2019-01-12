CREATE TABLE profile_user_type
(
    user_type_id bigint NOT NULL,
    name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_user_type PRIMARY KEY (user_type_id),
    CONSTRAINT uk_profile_user_type_name UNIQUE (name),
    CONSTRAINT chk_profile_user_type_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_USER_TYPE START WITH 1000;

CREATE TABLE profile_physician_type
(
    physician_type_id bigint NOT NULL,
    name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_physician_type PRIMARY KEY (physician_type_id),
    CONSTRAINT uk_profile_phys_type_name UNIQUE (name),
    CONSTRAINT chk_profile_phys_type_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_PHYSICIAN_TYPE START WITH 1000;

CREATE TABLE profile_user
(
    user_id bigint NOT NULL,
    login_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    login_name_lc character varying(120) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(120) COLLATE pg_catalog."default",
    first_name_lc character varying(240) COLLATE pg_catalog."default",
    last_name character varying(120) COLLATE pg_catalog."default",
    last_name_lc character varying(240) COLLATE pg_catalog."default",
    job_title character varying(245) COLLATE pg_catalog."default",
    account_type character varying(20) COLLATE pg_catalog."default",
    create_date timestamp without time zone DEFAULT now(),
    update_date timestamp without time zone DEFAULT now(),
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    user_type_id bigint NOT NULL,
    visibility character varying(20) COLLATE pg_catalog."default",
    on_call character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT pk_profile_user PRIMARY KEY (user_id),
    CONSTRAINT uk_profile_user_login_name_lc UNIQUE (login_name_lc),
    CONSTRAINT fk_profile_user_type FOREIGN KEY (user_type_id)
        REFERENCES profile_user_type (user_type_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
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
    CONSTRAINT chk_profile_user_email_verify CHECK (email_verify::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean]))
);

CREATE SEQUENCE SEQ_PROFILE_USER_DETAIL START WITH 1000;

CREATE TABLE profile_user2detail
(
    user_id bigint NOT NULL,
    user_detail_id bigint NOT NULL,
    CONSTRAINT user_id_detail_pk PRIMARY KEY (user_id, user_detail_id),
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
    state_abbr character varying(3) COLLATE pg_catalog."default",
    zip_code character varying(20) COLLATE pg_catalog."default",
    phone character varying(12) COLLATE pg_catalog."default",
    cell character varying(12) COLLATE pg_catalog."default",
    fax character varying(12) COLLATE pg_catalog."default",
    email character varying(320) COLLATE pg_catalog."default",
    email_lc character varying(320) COLLATE pg_catalog."default",
    email_verify boolean  DEFAULT 'F'::boolean,
    CONSTRAINT pk_profile_agency PRIMARY KEY (agency_id),
    CONSTRAINT uk_profile_agency_name_lc UNIQUE (name_lc),
    CONSTRAINT chk_profile_user_email_verify CHECK (email_verify::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean]))
);

CREATE SEQUENCE SEQ_PROFILE_AGENCY START WITH 1000;

CREATE TABLE profile_user2agency
(
    user_id bigint NOT NULL,
    agency_id bigint NOT NULL,
    CONSTRAINT user_id_agency_pk PRIMARY KEY (user_id, agency_id),
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
    login_name_lc character varying(120) COLLATE pg_catalog."default" NOT NULL,
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
    first_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    first_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    last_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    middle_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    middle_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    medical_record character varying(245) COLLATE pg_catalog."default",
    address character varying(120) COLLATE pg_catalog."default",
    suite_apt character varying(25) COLLATE pg_catalog."default",
    city character varying(120) COLLATE pg_catalog."default",
    state character varying(120) COLLATE pg_catalog."default",
    state_abbr character varying(3) COLLATE pg_catalog."default",
    zip_code character varying(20) COLLATE pg_catalog."default",
    veteran boolean  DEFAULT 'F'::boolean,
    birth_date timestamp without time zone NOT NULL,
    death_date timestamp without time zone,
    ssn character varying(9) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(12) COLLATE pg_catalog."default",
    cell character varying(12) COLLATE pg_catalog."default",
    gender character varying(1) COLLATE pg_catalog."default" NOT NULL,
    marital_status character varying(1) COLLATE pg_catalog."default" NOT NULL,
    lang character varying(5) COLLATE pg_catalog."default",
    ethnicity character varying(5) COLLATE pg_catalog."default",
    status_code character varying(5) COLLATE pg_catalog."default",
    patient_lives character varying(200) COLLATE pg_catalog."default",
    commentType character varying(10) COLLATE pg_catalog."default",
    comments character varying(2000) COLLATE pg_catalog."default",
    image_url character varying(2000) COLLATE pg_catalog."default",
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_patient PRIMARY KEY (patient_id),
    CONSTRAINT chk_profile_patient_veteran CHECK (veteran::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean])),
    CONSTRAINT chk_profile_patient_gender CHECK (gender::text = ANY (ARRAY['M'::character varying::text, 'F'::character varying::text])),
    CONSTRAINT chk_profile_patient_marital_status CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'U'::character varying::text])),
    CONSTRAINT chk_profile_patient_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_PATIENT START WITH 1000;

CREATE TABLE profile_user2patient
(
    user_id bigint NOT NULL,
    patient_id bigint NOT NULL,
    CONSTRAINT user_id_patient_pk PRIMARY KEY (user_id, patient_id),
    CONSTRAINT user_id_fk FOREIGN KEY (user_id)
            REFERENCES profile_user (user_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT patient_fk FOREIGN KEY (patient_id)
            REFERENCES profile_patient (patient_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_forms
(
    form_id bigint NOT NULL,
    name character varying(240) COLLATE pg_catalog."default" NOT NULL,
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_forms PRIMARY KEY (form_id),
    CONSTRAINT chk_profile_forms_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_FORMS START WITH 1000;

CREATE TABLE profile_user2forms
(
    user_id bigint NOT NULL,
    form_id bigint NOT NULL,
    CONSTRAINT user_id_forms_pk PRIMARY KEY (user_id, form_id),
    CONSTRAINT user_id_fk FOREIGN KEY (user_id)
            REFERENCES profile_user (user_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT forms_fk FOREIGN KEY (form_id)
            REFERENCES profile_forms (form_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_patient2forms
(
    patient_id bigint NOT NULL,
    form_id bigint NOT NULL,
    CONSTRAINT patient_id_forms_pk PRIMARY KEY (patient_id, form_id),
    CONSTRAINT patient_id_fk FOREIGN KEY (patient_id)
            REFERENCES profile_patient (patient_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT forms_fk FOREIGN KEY (form_id)
            REFERENCES profile_forms (form_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_allergies
(
    allergy_id bigint NOT NULL,
    name character varying(240) COLLATE pg_catalog."default" NOT NULL,
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_allergies PRIMARY KEY (allergy_id),
    CONSTRAINT chk_profile_allergies_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_ALLERGY START WITH 1000;

CREATE TABLE profile_patient2allergy
(
    patient_id bigint NOT NULL,
    allergy_id bigint NOT NULL,
    CONSTRAINT patient_id_allergy_pk PRIMARY KEY (patient_id, allergy_id),
    CONSTRAINT patient_id_fk FOREIGN KEY (patient_id)
            REFERENCES profile_patient (patient_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT allergy_fk FOREIGN KEY (allergy_id)
            REFERENCES profile_allergies (allergy_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_cahps
(
    cahp_id bigint NOT NULL,
    first_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    first_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    last_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    middle_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    middle_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    address character varying(120) COLLATE pg_catalog."default",
    suite_apt character varying(25) COLLATE pg_catalog."default",
    city character varying(120) COLLATE pg_catalog."default",
    state character varying(120) COLLATE pg_catalog."default",
    state_abbr character varying(3) COLLATE pg_catalog."default",
    zip_code character varying(20) COLLATE pg_catalog."default",
    phone character varying(12) COLLATE pg_catalog."default",
    cell character varying(12) COLLATE pg_catalog."default",
    email character varying(320) COLLATE pg_catalog."default",
    email_lc character varying(320) COLLATE pg_catalog."default",
    email_verify boolean  DEFAULT 'F'::boolean,
    lang character varying(5) COLLATE pg_catalog."default",
    relationship character varying(200) COLLATE pg_catalog."default",
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_cahps PRIMARY KEY (cahp_id),
    CONSTRAINT chk_profile_cahps_email_verify CHECK (email_verify::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean])),
    CONSTRAINT chk_profile_cahps_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_CAHP START WITH 1000;

CREATE TABLE profile_patient2cahps
(
    patient_id bigint NOT NULL,
    cahp_id bigint NOT NULL,
    CONSTRAINT patient_id_cahps_pk PRIMARY KEY (patient_id, cahp_id),
    CONSTRAINT patient_id_fk FOREIGN KEY (patient_id)
            REFERENCES profile_patient (patient_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT cahps_fk FOREIGN KEY (cahp_id)
            REFERENCES profile_cahps (cahp_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_er_contact
(
    er_contact_id bigint NOT NULL,
    first_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    first_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    last_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    middle_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    middle_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    address character varying(120) COLLATE pg_catalog."default",
    suite_apt character varying(25) COLLATE pg_catalog."default",
    city character varying(120) COLLATE pg_catalog."default",
    state character varying(120) COLLATE pg_catalog."default",
    state_abbr character varying(3) COLLATE pg_catalog."default",
    zip_code character varying(20) COLLATE pg_catalog."default",
    phone character varying(12) COLLATE pg_catalog."default",
    cell character varying(12) COLLATE pg_catalog."default",
    priority_code character varying(5) COLLATE pg_catalog."default",
    relationship character varying(200) COLLATE pg_catalog."default",
    comments character varying(2000) COLLATE pg_catalog."default",
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_er_contact PRIMARY KEY (er_contact_id),
    CONSTRAINT chk_profile_er_contact_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_ER_CONTACT START WITH 1000;

CREATE TABLE profile_patient2er_contact
(
    patient_id bigint NOT NULL,
    er_contact_id bigint NOT NULL,
    CONSTRAINT patient_id_er_pk PRIMARY KEY (patient_id, er_contact_id),
    CONSTRAINT patient_id_fk FOREIGN KEY (patient_id)
            REFERENCES profile_patient (patient_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT er_fk FOREIGN KEY (er_contact_id)
            REFERENCES profile_er_contact (er_contact_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_funeral
(
    funeral_id bigint NOT NULL,
    name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    address character varying(120) COLLATE pg_catalog."default",
    city character varying(120) COLLATE pg_catalog."default",
    state character varying(120) COLLATE pg_catalog."default",
    state_abbr character varying(3) COLLATE pg_catalog."default",
    zip_code character varying(20) COLLATE pg_catalog."default",
    phone character varying(12) COLLATE pg_catalog."default",
    contact character varying(200) COLLATE pg_catalog."default",
    county character varying(200) COLLATE pg_catalog."default",
    discharge_reason character varying(2000) COLLATE pg_catalog."default",
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_funeral PRIMARY KEY (funeral_id),
    CONSTRAINT chk_profile_funeral_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_FUNERAL START WITH 1000;

CREATE TABLE profile_patient2funeral
(
    patient_id bigint NOT NULL,
    funeral_id bigint NOT NULL,
    CONSTRAINT patient_id_funeral_pk PRIMARY KEY (patient_id, funeral_id),
    CONSTRAINT patient_id_fk FOREIGN KEY (patient_id)
            REFERENCES profile_patient (patient_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT funeral_fk FOREIGN KEY (funeral_id)
            REFERENCES profile_funeral (funeral_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_insurance
(
    insurance_id bigint NOT NULL,
    name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    suite_apt character varying(25) COLLATE pg_catalog."default",
    address character varying(120) COLLATE pg_catalog."default",
    city character varying(120) COLLATE pg_catalog."default",
    state character varying(120) COLLATE pg_catalog."default",
    state_abbr character varying(3) COLLATE pg_catalog."default",
    zip_code character varying(20) COLLATE pg_catalog."default",
    phone character varying(12) COLLATE pg_catalog."default",
    type character varying(200) COLLATE pg_catalog."default",
    authorized character varying(200) COLLATE pg_catalog."default",
    category character varying(200) COLLATE pg_catalog."default",
    date_from timestamp without time zone,
    date_to timestamp without time zone,
    group_number character varying(200) COLLATE pg_catalog."default",
    group_name character varying(200) COLLATE pg_catalog."default",
    policy_number character varying(200) COLLATE pg_catalog."default",
    eligibility character varying(200) COLLATE pg_catalog."default",
    insurance_verify boolean  DEFAULT 'F'::boolean,
    is_primary boolean  DEFAULT 'F'::boolean,
    comments character varying(2000) COLLATE pg_catalog."default",
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_insurance PRIMARY KEY (insurance_id),
    CONSTRAINT chk_profile_is_primary CHECK (is_primary::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean])),
    CONSTRAINT chk_profile_insurance_verify CHECK (insurance_verify::boolean = ANY (ARRAY['T'::boolean::boolean, 'F'::boolean::boolean])),
    CONSTRAINT chk_profile_insurance_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_INSURANCE START WITH 1000;

CREATE TABLE profile_patient2insurance
(
    patient_id bigint NOT NULL,
    insurance_id bigint NOT NULL,
    CONSTRAINT patient_id_insurance_pk PRIMARY KEY (patient_id, insurance_id),
    CONSTRAINT patient_id_fk FOREIGN KEY (patient_id)
            REFERENCES profile_patient (patient_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE CASCADE,
        CONSTRAINT insurance_fk FOREIGN KEY (insurance_id)
            REFERENCES profile_insurance (insurance_id) MATCH SIMPLE
            ON UPDATE NO ACTION
    ON DELETE CASCADE
);

CREATE TABLE profile_physician
(
    physician_id bigint NOT NULL,
    first_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    first_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    last_name_lc character varying(240) COLLATE pg_catalog."default" NOT NULL,
    suite_apt character varying(25) COLLATE pg_catalog."default",
    address character varying(120) COLLATE pg_catalog."default",
    city character varying(120) COLLATE pg_catalog."default",
    state character varying(120) COLLATE pg_catalog."default",
    state_abbr character varying(3) COLLATE pg_catalog."default",
    zip_code character varying(20) COLLATE pg_catalog."default",
    phone character varying(12) COLLATE pg_catalog."default",
    pecos character varying(20) COLLATE pg_catalog."default",
    upin character varying(20) COLLATE pg_catalog."default",
    npi character varying(20) COLLATE pg_catalog."default",
    protocol character varying(2000) COLLATE pg_catalog."default",
    physician_type_id bigint NOT NULL,
    enabled character varying(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_profile_physician PRIMARY KEY (physician_id),
    CONSTRAINT fk_profile_physician_type_id FOREIGN KEY (physician_type_id)
        REFERENCES profile_physician_type (physician_type_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT chk_profile_physician_enabled CHECK (enabled::text = ANY (ARRAY['T'::character varying::text, 'F'::character varying::text, 'D﻿'::character varying::text]))
);

CREATE SEQUENCE SEQ_PHYSICIAN START WITH 1000;
