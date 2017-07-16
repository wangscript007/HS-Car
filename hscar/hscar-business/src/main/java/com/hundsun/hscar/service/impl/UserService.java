package com.hundsun.hscar.service.impl;

import org.agile.common.exception.RRException;
import org.agile.common.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hundsun.hscar.dao.UserDao;
import com.hundsun.hscar.entity.UserEntity;
import com.hundsun.hscar.service.api.IUserService;

/**
 * 用户信息
 * 
 * @author zhangmm
 * @email phoenix122411@126.com
 * @date 2017-07-16
 */
@Service("userService")
public class UserService implements IUserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserEntity queryObjectById(Long userId){
		UserEntity user = new UserEntity();
		user.setUserId(userId);
		return userDao.queryObject(user);
	}
	
	@Override
	public UserEntity queryObject(UserEntity user){
		return userDao.queryObject(user);
	}
	
	@Override
	public List<UserEntity> queryList(Map<String, Object> map){
		return userDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDao.queryTotal(map);
	}
	
	@Override
	public void save(UserEntity user){
		user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
		user.setCreateTime(new Date());
		userDao.save(user);
	}
	
	@Override
	public void save(String mobile, String password){
		UserEntity user = new UserEntity();
		user.setMobile(mobile);
		user.setUsername(mobile);
		user.setPassword(DigestUtils.sha256Hex(password));
		user.setCreateTime(new Date());
		userDao.save(user);
	}
	
	@Override
	public void update(UserEntity user){
		user.setUpdateTime(new Date());
		userDao.update(user);
	}
	
	@Override
	public void delete(Long userId){
		userDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		userDao.deleteBatch(userIds);
	}
	
	@Override
	public UserEntity queryByMobile(String mobile) {
		return userDao.queryByMobile(mobile);
	}

	@Override
	public long login(String mobile, String password) {
		UserEntity user = queryByMobile(mobile);
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(password))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}
}