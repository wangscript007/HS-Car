package com.hundsun.hscar.service.api;

import java.util.List;
import java.util.Map;

import com.hundsun.hscar.entity.DriverEntity;
import com.hundsun.hscar.entity.UserEntity;

/**
 * 司机信息
 * 
 * @author zhangmm
 * @email phoenix122411@126.com
 * @date 2017-07-16
 */
public interface IDriverService {
	
	DriverEntity queryObjectById(Long driverId);
	
	DriverEntity queryObjectByUserId(Long userId);
	
	DriverEntity queryObject(DriverEntity driver);
	
	List<DriverEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DriverEntity driver);
	
	void update(DriverEntity driver);
	
	void delete(Long driverId);
	
	void deleteBatch(Long[] driverIds);
	
	/**
	 * 车主用户注册
	 * @param mobile    			手机号
	 * @param password  			密码
	 * @param driverLicenseNumber	驾照号码
	 * @param plateNumber  			车牌号
	 */
	void register(String mobile, String password, String driverLicenseNumber, String plateNumber);
	
	/**
	 * 司机用户注册
	 * @param userId    			用户Id
	 * @param driverLicenseNumber	驾照号码
	 * @param plateNumber  			车牌号
	 */
	void register(Long userId, String driverLicenseNumber, String plateNumber);

	/**
	 * 车主用户登录
	 * @param mobile    手机号
	 * @param password  密码
	 * @return          返回用户ID
	 */
	long login(String mobile, String password);
	
	/**
	 * 修改司机用户信息
	 * @param user    用户信息
	 * @param driver  司机信息
	 */
	void updateDriverUser(UserEntity user, DriverEntity driver);
}
