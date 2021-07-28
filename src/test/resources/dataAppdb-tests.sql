INSERT INTO public.role (id, name) VALUES (10, 'ROLE_USER');
INSERT INTO public.role (id, name) VALUES (11, 'ROLE_ADMIN');

INSERT INTO public.users (id, email, username, password, enabled, firstname, lastname, activation_code) VALUES (12, 'kosmas.deligkaris@oist.jp', 'admin', '{bcrypt}$2a$10$tETetU7VullZJ/KDTsS18.Jjl/HngTApB6G.BiRNYm.Q6xRkmuSBW', true, 'AdminFirstName', 'AdminLastName', null);
INSERT INTO public.users (id, email, username, password, enabled, firstname, lastname, activation_code) VALUES (13, 'useremail22@gmail.com', 'user', '{bcrypt}$2a$10$IksdzjARZ2VXzi5LmgZ5q.v6tGo7hZmUYFX4tqUVtMNm1TeI1V6O6', true, 'UserFirstName', 'UserLastName', null);

INSERT INTO public.users_roles (user_id, role_id) VALUES (12, 11);
INSERT INTO public.users_roles (user_id, role_id) VALUES (13, 10);