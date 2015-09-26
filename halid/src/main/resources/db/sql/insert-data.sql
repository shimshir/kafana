-- Home Sidebar --
INSERT INTO sidebar (id, path) VALUES (1, '/home');

-- Home Sidebar Links --
INSERT INTO nav_link (id, name, url, display_priority) VALUES (101, 'Wall', '/home/wall', 1);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (102, 'Projects', '/home/projects', 2);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (103, 'Achievements', '/home/achievements', 3);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (104, 'Scores', '/home/scores', 4);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (105, 'Discussions', '/home/discussions', 5);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (106, 'Calendar', '/home/calendar', 6);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (107, 'Messages', '/home/messages', 7);

INSERT INTO nav_link (id, name, url, display_priority) VALUES (112, 'Programming', '/home/projects/programming', 1);

-- Home sidebar_2_nav_link relations --
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (1, 101);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (1, 102);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (1, 103);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (1, 104);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (1, 105);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (1, 106);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (1, 107);

INSERT INTO nav_link_2_nav_link (parent_link_id, child_link_id) VALUES (102, 112);

-- Academics Sidebar --
INSERT INTO sidebar (id, path) VALUES (2, '/academic');

-- Academics Sidebar Links --
INSERT INTO nav_link (id, name, url, display_priority) VALUES (201, 'Courses', '/academic/courses', 1);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (202, 'Exams', '/academic/exams', 2);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (203, 'Staff', '/academic/staff', 3);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (204, 'Students', '/academic/students', 4);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (205, 'Groups', '/academic/groups', 5);

-- Academics sidebar_2_nav_link relations --
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (2, 201);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (2, 202);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (2, 203);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (2, 204);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (2, 205);


-- Social Sidebar --
INSERT INTO sidebar (id, path) VALUES (3, '/social');

-- Social Sidebar Links --
INSERT INTO nav_link (id, name, url, display_priority) VALUES (301, 'Chat', '/social/chat', 1);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (302, 'Discussions', '/social/discussions', 2);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (303, 'Events', '/social/events', 3);

-- Social sidebar_2_nav_link relations --
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (3, 301);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (3, 302);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (3, 303);

-- Courses Sidebar
INSERT INTO sidebar (id, path) VALUES (201, '/academic/courses');

-- Courses Sidebar Links --
INSERT INTO nav_link (id, name, url, display_priority) VALUES (221, 'Materials', '/academic/courses/materials', 1);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (222, 'Challenges', '/academic/courses/challenges', 2);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (223, 'Students', '/academic/courses/students', 3);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (224, 'Staff', '/academic/courses/staff', 4);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (225, 'Calendar', '/academic/courses/calendar', 5);
INSERT INTO nav_link (id, name, url, display_priority) VALUES (226, 'Discussions', '/academic/courses/discussions', 6);

-- Courses sidebar_2_nav_link relations --
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (201, 221);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (201, 222);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (201, 223);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (201, 224);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (201, 225);
INSERT INTO sidebar_2_nav_link (sidebar_id, nav_link_id) VALUES (201, 226);
