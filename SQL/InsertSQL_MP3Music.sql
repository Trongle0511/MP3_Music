use DuAnMP3_Music
go
-- delete from Userinfo
-- go
-- delete from Account
-- go

-- Insert data into the Users table
-- Inserting data into Account table
INSERT INTO Account (username, email, hashed_password, role) VALUES 
('johndoe', 'abc@gmail.com', '$2a$12$NtnhefK8AlaqnheWo0VruObg3LVe.W45MhJupHLulRjR7rNdP5tKu', 0),
('janedoe', 'janedoe@gmail.com', '$2a$12$NtnhefK8AlaqnheWo0VruObg3LVe.W45MhJupHLulRjR7rNdP5tKu', 0),
('adminuser', 'admin@gmail.com', '$2a$12$NtnhefK8AlaqnheWo0VruObg3LVe.W45MhJupHLulRjR7rNdP5tKu', 1);

-- Inserting data into Users table
INSERT INTO Users (name, phone, image, account_ID) VALUES
('John Doe', '123-456-7890', 'john_image.png', 1),
('Jane Doe', '987-654-3210', 'jane_image.png', 2),
('Admin User', '555-555-5555', 'admin_image.png', 3);
