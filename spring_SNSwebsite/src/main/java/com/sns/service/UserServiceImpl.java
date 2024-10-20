package com.sns.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.dao.UserDao;
import com.sns.dto.UserDto;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void createUser(UserDto dto) throws Exception {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		dao.createUser(dto);
	}

	@Override
	public UserDto selectUser(String nickname) throws Exception {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		return dao.selectUser(nickname);
	}

	@Override
	public void updateUser(UserDto dto) throws Exception {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		dao.updateUser(dto);
	}

	@Override
	public void deleteUser(String nickname) throws Exception {
		UserDao dao = sqlSession.getMapper(UserDao.class);
		dao.deleteUser(nickname);
	}

}
