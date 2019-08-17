package com.landscape.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_usr_user
 * 插入用户注册信息实体类
 * <p>
 * 2019-08-15
 * @author eddie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUsrUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 别名
     */
    private String userAlias;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 是否有效 0-失效 其他-有效
     */
    private Integer disabled;

    /**
     * 建档时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 邀请人
     */
    private String invitePerson;

    public TbUsrUserDTO(String userCode, String userPhone, String userAlias) {
        this.userCode = userCode;
        this.userPhone = userPhone;
        this.userAlias = userAlias;
    }

    public TbUsrUserDTO(String userCode, String userPhone, String userAlias, String invitePerson) {
        this.userCode = userCode;
        this.userPhone = userPhone;
        this.userAlias = userAlias;
        this.invitePerson = invitePerson;
    }
}