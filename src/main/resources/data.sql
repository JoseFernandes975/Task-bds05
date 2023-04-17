INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Green', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('Suspense');
INSERT INTO tb_genre (name) VALUES ('Aventura');

INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('O Predador', 'A Caçada Vai Começar!', 1987, 'https://www.cafecomfilme.com.br/media/k2/items/cache/0072fc861f8558ddd0a5b9efefe3ec0b_L.jpg?t=20171030_011209', 'Você está na sua selva e você é a caça!', 1);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('Avatar', 'Descubra um novo mundo!', 2009, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHIyixfPe9-oByS_IinH_kvlmHYGh6CZEEJjRS6BFN76EJZ3jDD3B_QmzxU_npL-svUwU&usqp=CAU', 'Entre em um mundo!', 2);


INSERT INTO tb_review (id, text, user_id, movie_id) VALUES (null, 'Melhor filme que assisti na minha vida!', 2, 1);
INSERT INTO tb_review (id, text, user_id, movie_id) VALUES (null, null, 2, 2);