USE edu;

CREATE OR REPLACE TABLE user (
	`no` 				INT 						NOT NULL		PRIMARY KEY		AUTO_INCREMENT, 
	`name`			VARCHAR(100)	NOT NULL,
	`email`			VARCHAR(100)	NOT NULL,
	`pwd`			VARCHAR(50)		NOT NULL,
	`gender`		CHAR(1)				NULL				DEFAULT 0,
	`delYN`			CHAR(1)				NOT NULL		DEFAULT 'N',
	`regDate`		DATETIME			NOT NULL		DEFAULT NOW()
);

