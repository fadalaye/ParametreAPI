CREATE TABLE departement (
                             id BIGINT NOT NULL,
                             nomDepartement VARCHAR(20) NOT NULL,
                             createby VARCHAR(20) NOT NULL,
                             createAt VARCHAR(15) DEFAULT NULL,
                             PRIMARY KEY (id)
);
INSERT INTO departement (id, nomDepartement, createby, createAt) VALUES
                                                                     (1, 'Informatique', '1', '2024-02-10'),
                                                                     (2, 'mathematique', '1', '2024-02-12'),
                                                                     (3, 'Physique', '1', '2024-02-15');