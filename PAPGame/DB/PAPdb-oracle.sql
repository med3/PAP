drop table UserAnswer;
drop table GameQuestion;
drop table Game;
drop table Question;
drop table T_User;

CREATE TABLE T_User(
	user_id integer GENERATED BY DEFAULT ON NULL AS IDENTITY,
	user_mail varchar(255) NOT NULL,
	user_password varchar(255) NOT NULL,
	UNIQUE (user_mail),
  PRIMARY KEY (user_id)
);

CREATE TABLE Question(
	question_id integer GENERATED BY DEFAULT ON NULL AS IDENTITY,
	question_value varchar(255) NOT NULL,
	question_theme varchar(255) NOT NULL,
	question_proposition1 varchar(255) NOT NULL,
	question_proposition2 varchar(255) NOT NULL,
	question_proposition3 varchar(255) NOT NULL,
	question_proposition4 varchar(255) NOT NULL,
	question_answer varchar(255) NOT NULL,
  PRIMARY KEY (question_id)
);

CREATE TABLE Game(
	game_id integer GENERATED BY DEFAULT ON NULL AS IDENTITY,
	user1_id integer NOT NULL,
	user2_id integer NOT NULL,
  PRIMARY KEY (game_id),
	FOREIGN KEY (user1_id) REFERENCES T_User(user_id),
	FOREIGN KEY (user2_id) REFERENCES T_User(user_id)
);

CREATE TABLE GameQuestion(
	game_id integer,
	question_id integer,
	PRIMARY KEY (game_id, question_id),
	FOREIGN KEY (game_id) REFERENCES Game(game_id),
	FOREIGN KEY (question_id) REFERENCES Question(question_id)
);

CREATE TABLE UserAnswer(
	game_id integer,
	question_id integer,
	user_id integer,
	user_answer_value varchar(255),
	PRIMARY KEY (game_id, question_id, user_id),
	FOREIGN KEY (user_id) REFERENCES T_User(user_id),
	FOREIGN KEY (game_id) REFERENCES Game(game_id),
	FOREIGN KEY (question_id) REFERENCES Question(question_id)
);