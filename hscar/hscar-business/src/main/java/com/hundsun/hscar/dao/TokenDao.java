package com.hundsun.hscar.dao;

import org.agile.dao.BaseDao;

import com.hundsun.hscar.entity.TokenEntity;

/**
 * 用户Token
 * 
 * @author zhangmm
 * @email phoenix122411@126.com
 * @date 2017-07-16
 */
public interface TokenDao extends BaseDao<TokenEntity> {
	
	TokenEntity queryByUserId(Long userId);

    TokenEntity queryByToken(String token);
    
}