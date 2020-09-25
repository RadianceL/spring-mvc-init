package com.landscape.user.service.impl;

import com.landscape.user.data.Response;
import com.landscape.user.data.TbUsrUserDTO;
import com.landscape.user.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户登录服务
 * <p>
 * 2019-08-15
 *
 * @author eddie
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserLoginServiceImpl implements UserLoginService {

    /**
     * redis操作工具
     */
    private final ValueOperations<String, Object> valueOperations;

//    private final UserRepository userRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response userAccountRegister(String userPhone, String userAlias, String code) {
        TbUsrUserDTO tbUsrUserDTO = new TbUsrUserDTO("", userPhone, userAlias);
//        userRepository.insertUserRegisterInfo(tbUsrUserDTO);
        return null;
    }

    @Override
    public Response userLoginByPassword(String phoneNumber, String password) {

        return null;
    }

    @Override
    public Response userLoginBySmsCode(String phoneNumber, String smsCode) {

        return null;
    }
}
