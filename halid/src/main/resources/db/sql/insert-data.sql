-- Home Sidebar --
INSERT INTO sidebar (path) VALUES ('/home');

-- Home SidebarModel Links --
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Wall', '/home/wall', '/home');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Projects', '/home/projects', '/home');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Achievements', '/home/achievements', '/home');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Scores', '/home/scores', '/home');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Discussions', '/home/discussions', '/home');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Calendar', '/home/calendar', '/home');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Messages', '/home/messages', '/home');

-- Academics SidebarModel --
INSERT INTO sidebar (path) VALUES ('/academic');

-- Academics SidebarModel Links --
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Courses', '/academic/courses', '/academic');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Exams', '/academic/exams', '/academic');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Teachers', '/academic/teachers', '/academic');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Colleagues', '/academic/colleagues', '/academic');
INSERT INTO sidebar_nav_link (name, url, sidebar_path) VALUES ('Groups', '/academic/groups', '/academic');