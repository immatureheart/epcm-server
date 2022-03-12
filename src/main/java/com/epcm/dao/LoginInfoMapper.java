package com.epcm.dao;

import com.epcm.entity.LoginInfo;
import com.epcm.entity.example.LoginInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginInfoMapper {
    long countByExample(LoginInfoExample example);

    int deleteByExample(LoginInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoginInfo record);

    int insertSelective(LoginInfo record);

    List<LoginInfo> selectByExample(LoginInfoExample example);

    LoginInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoginInfo record, @Param("example") LoginInfoExample example);

    int updateByExample(@Param("record") LoginInfo record, @Param("example") LoginInfoExample example);

    int updateByPrimaryKeySelective(LoginInfo record);

    int updateByPrimaryKey(LoginInfo record);
}