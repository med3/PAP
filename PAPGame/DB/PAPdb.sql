--
-- Base de donnees: PAPGame
--


SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

drop table if exists UserAnswer;
drop table if exists GameQuestion;
drop table if exists Game;
drop table if exists Question;
drop table if exists User;

CREATE TABLE User(
	user_id integer PRIMARY KEY AUTO_INCREMENT,
	user_mail varchar(255) NOT NULL,
	user_password varchar(255) NOT NULL,
	UNIQUE (user_mail)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Question(
	question_id integer PRIMARY KEY AUTO_INCREMENT,
	question_value varchar(255) NOT NULL,
	question_theme varchar(255) NOT NULL,
	question_proposition1 varchar(255) NOT NULL,
	question_proposition2 varchar(255) NOT NULL,
	question_proposition3 varchar(255) NOT NULL,
	question_proposition4 varchar(255) NOT NULL,
	question_answer varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Game(
	game_id integer PRIMARY KEY AUTO_INCREMENT,
	user1_id integer NOT NULL,
	user2_id integer NOT NULL,
	FOREIGN KEY (user1_id) REFERENCES User(user_id),
	FOREIGN KEY (user2_id) REFERENCES User(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE GameQuestion(
	game_id integer,
	question_id integer,
	PRIMARY KEY (game_id, question_id),
	FOREIGN KEY (game_id) REFERENCES Game(game_id),
	FOREIGN KEY (question_id) REFERENCES Question(question_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE UserAnswer(
	game_id integer,
	question_id integer,
	user_id integer,
	user_answer_value varchar(255),
	PRIMARY KEY (game_id, question_id, user_id),
	FOREIGN KEY (user_id) REFERENCES User(user_id),
	FOREIGN KEY (game_id) REFERENCES Game(game_id),
	FOREIGN KEY (question_id) REFERENCES Question(question_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;