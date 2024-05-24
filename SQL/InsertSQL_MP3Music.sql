use DuAnMP3_Music
go
-- delete from Userinfo
-- go
-- delete from Account
-- go

-- Insert data into the Users table
INSERT INTO Users (name, phone, image)
VALUES 
('John Doe', '123-456-7890', 'path/to/image1.jpg'),
('Jane Smith', '987-654-3210', 'path/to/image2.jpg');

-- Insert data into the Account table using the retrieved UserIDs
INSERT INTO Account (username, email, hashed_password, role, UserID)
VALUES 
('johndoe', 'abc@gmail.com', '$2a$12$HEOZxVFs3Fn771yu1RPAYOVd/o7pKT6tnvJ6di13Esmg035Pk.Iaa', 0, 1),
('janesmith', 'admin@gmail.com', '$2a$12$HEOZxVFs3Fn771yu1RPAYOVd/o7pKT6tnvJ6di13Esmg035Pk.Iaa', 1, 2);

select * from Account a join Users u on a.UserID=u.UserID
