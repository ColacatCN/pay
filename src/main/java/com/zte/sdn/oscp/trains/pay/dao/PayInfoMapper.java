package com.zte.sdn.oscp.trains.pay.dao;

import com.zte.sdn.oscp.trains.pay.pojo.PayInfo;

public interface PayInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PayInfo record);

    int insertSelective(PayInfo record);

    PayInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayInfo record);

    int updateByPrimaryKey(PayInfo record);

    PayInfo selectByOrderNo(Long orderNo);
}
