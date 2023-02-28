package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.folder.app.dto.UserDTO;

@Mapper
public interface UserMapper {
	
//	@Select("SELECT LAST_INSERT_ID() AS no")
	public UserDTO selectNo() throws Exception;
	
//	@Select("SELECT `no`,`name`,`email`,`gender`,`pwd`,`delYN`,date_format(`regDate`, '%Y-%m-%d') as regDate  FROM user")
	public List<UserDTO> selectAll() throws Exception;
	
//	@Select("SELECT `no`,`name`,`email`,`pwd`,`gender`,`delYN`,date_format(`regDate`, '%Y-%m-%d') as regDate  FROM user WHERE no = #{no}")
	public UserDTO selectOne(UserDTO user) throws Exception;
	
//	@Insert("INSERT INTO user (`name`,`email`,`pwd`,`gender`) VALUE (#{name},#{email},#{pwd},#{gender})")
	public int insert(UserDTO user) throws Exception;
	
//	@Update("UPDATE user SET `email` = #{email},`pwd`=#{pwd},`gender` = #{gender} WHERE `no` = #{no}")
	public int update(UserDTO user) throws Exception;
	
//	@Update("UPDATE user SET `delYn` = 'Y' WHERE `no` = #{no}")
	public int delete(UserDTO user) throws Exception;

}
