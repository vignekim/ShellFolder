package com.folder.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private int no;
	private String name;
	private String email;
	private String pwd;
	private String gender;
	private String delYn;
	private String regDate;
	
}
