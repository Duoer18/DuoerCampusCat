package com.duoer.campus.service;

import com.duoer.campus.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户业务接口
 *
 * @author duoer
 */
@Transactional
public interface UserService {
    /**
     * 用户登录校验
     *
     * @param u 用户对象
     * @return 状态码
     */
    int loginCheck(User u);

    /**
     * 注册
     *
     * @param u 用户对象
     * @return 状态码
     */
    int registerCheck(User u);

    /**
     * 查重
     *
     * @param u 用户对象
     * @return 状态码
     */
    int existCheck(User u);
}
