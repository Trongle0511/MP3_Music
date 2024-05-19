use DuAnMP3_Music
go
-- delete from Userinfo
-- go
-- delete from Account
-- go


INSERT INTO Accounts (Username, Email, Hashed_Password, is_admin) VALUES ('john.doe','trongle311021@gmail.com','$2a$12$HEOZxVFs3Fn771yu1RPAYOVd/o7pKT6tnvJ6di13Esmg035Pk.Iaa', 0);
INSERT INTO Accounts (username, email, hashed_password, is_admin) VALUES ('jane.smith','trongle@gmail.com', '$2a$12$HEOZxVFs3Fn771yu1RPAYOVd/o7pKT6tnvJ6di13Esmg035Pk.Iaa', 0);
INSERT INTO Accounts (username, email, hashed_password, is_admin) VALUES ('admin', 'admin@gmail.com', '$2a$12$en5ZfBVuv44iqK6IktThDOUw3QYoKnbPpRymLs1o1Duc.cy4G7Hy.', 1);
INSERT INTO Accounts (username, email, hashed_password, is_admin) VALUES ('site_user', 'abc@gmail.com', '$2a$12$qTSuT5h7Y3tsXQ/YO63iEecCyKmu.Bgg0K6Lr.lktxdAwxc8MhJE6', 0);
