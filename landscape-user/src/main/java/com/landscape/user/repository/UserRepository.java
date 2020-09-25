package com.landscape.user.repository;


import com.landscape.user.data.TbUsrUserDTO;

///**
// * 用户数据层
// * <p>
// * 2019-08-15
// *
// * @author eddie
// */
//@Repository
public interface UserRepository {

    /**
     * 插入用户注册信息
     * @param tbUsrUserDTO  用户信息数据
     * @return              影响行数
     */
    Integer insertUserRegisterInfo(TbUsrUserDTO tbUsrUserDTO);

}
