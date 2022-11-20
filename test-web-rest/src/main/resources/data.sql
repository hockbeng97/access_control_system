drop table access;
create table access(
    email varchar(255),
    feature_name varchar(255),
    can_access bit,
    PRIMARY KEY (email, feature_name)
);


INSERT INTO access (email, feature_name, can_access) VALUES ('abc@gmail.com', 'view', true);
INSERT INTO access (email, feature_name, can_access) VALUES ('abc@gmail.com', 'modify', true);
INSERT INTO access (email, feature_name, can_access) VALUES ('abc@gmail.com', 'delete', false);