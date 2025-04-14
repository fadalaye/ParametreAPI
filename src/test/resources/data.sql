CREATE TABLE departement (
                            id BIGINT NOT NULL,
                            nomDepartement VARCHAR(10) NOT NULL,
                            createby VARCHAR(10) NOT NULL,
                            createAt VARCHAR(15) DEFAULT NULL,
                            PRIMARY KEY (id)
);
INSERT INTO `enseignant` (`nomDepartement`, `createby`, `createAt`)
VALUES
    ('Informatique', '1', '12/02/2024'),
    ('mathematique', '1', '12/02/2024'),
    ('Physique', '1', '12/02/2024');