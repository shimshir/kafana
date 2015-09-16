
-- Home Sidebar --
INSERT INTO sidebar (id, path) VALUES (1, '/home');

-- Home Sidebar Links --
INSERT INTO nav_link (id, name, url) VALUES (101, 'Wall', '/home/wall');
INSERT INTO nav_link (id, name, url) VALUES (102, 'Projects', '/home/projects');
INSERT INTO nav_link (id, name, url) VALUES (103, 'Achievements', '/home/achievements');
INSERT INTO nav_link (id, name, url) VALUES (104, 'Scores', '/home/scores');
INSERT INTO nav_link (id, name, url) VALUES (105, 'Discussions', '/home/discussions');
INSERT INTO nav_link (id, name, url) VALUES (106, 'Calendar', '/home/calendar');
INSERT INTO nav_link (id, name, url) VALUES (107, 'Messages', '/home/messages');

-- sidebar_2_nav_link relations --
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (1001, 1, 101);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (1002, 1, 102);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (1003, 1, 103);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (1004, 1, 104);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (1005, 1, 105);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (1006, 1, 106);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (1007, 1, 107);


-- Academics SidebarModel --
INSERT INTO sidebar (id, path) VALUES (2, '/academic');

-- Academics Sidebar Links --
INSERT INTO nav_link (id, name, url) VALUES (201, 'Courses', '/academic/courses');
INSERT INTO nav_link (id, name, url) VALUES (202, 'Exams', '/academic/exams');
INSERT INTO nav_link (id, name, url) VALUES (203, 'Teachers', '/academic/teachers');
INSERT INTO nav_link (id, name, url) VALUES (204, 'Colleagues', '/academic/colleagues');
INSERT INTO nav_link (id, name, url) VALUES (205, 'Groups', '/academic/groups');

-- sidebar_2_nav_link relations --
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (2001, 2, 201);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (2002, 2, 202);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (2003, 2, 203);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (2004, 2, 204);
INSERT INTO sidebar_2_nav_link (id, sidebar_id, nav_link_id) VALUES (2005, 2, 205);
