DELETE FROM account_2_role;
DELETE FROM account;

-- Accounts --
INSERT INTO account(id, username, hashed_password) VALUES (1, 'admin', 'admin');

-- Roles --
INSERT INTO account_2_role(account_id, role) VALUES (1, 'admin');