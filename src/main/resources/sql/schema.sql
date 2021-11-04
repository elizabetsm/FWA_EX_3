DROP TABLE IF EXISTS signModel;
DROP TABLE IF EXISTS users;

CREATE TABLE        users(
    id              SERIAL NOT NULL CONSTRAINT PK_USERS PRIMARY KEY,
    first_name      varchar(254) NOT NULL ,
    last_name       varchar(254) NOT NULL ,
    phone_number    varchar(254) UNIQUE NOT NULL ,
    password        varchar(100) NOT NULL
                         );

CREATE TABLE        signModel(
    user_id         int NOT NULL,
    ip              varchar(254),
    date            timestamp,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
)

