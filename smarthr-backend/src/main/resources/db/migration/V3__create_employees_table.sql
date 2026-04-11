CREATE TABLE employees(
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name      VARCHAR(100) NOT NULL ,
    last_name       VARCHAR(100) NOT NULL ,
    cin             VARCHAR(20) NOT NULL UNIQUE ,
    date_of_birth   DATE ,
    hire_date       DATE NOT NULL,
    contract_type   VARCHAR(20) NOT NULL
                    CHECK ( contract_type IN ('CDI', 'CDD', 'FREELANCE')),
    salary          DECIMAL(12,2) NOT NULL ,
    position        VARCHAR(100) NOT NULL ,
    status          VARCHAR(20) NOT NULL DEFAULT 'ACTIVE'
                    CHECK ( status IN ('ACTIVE', 'INACTIVE', 'ON_LEAVE')),
    photo_url       VARCHAR(500),
    department_id   UUID REFERENCES departments(id),
    created_at      TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMP NOT NULL DEFAULT NOW(),
    deleted_at      TIMESTAMP
);