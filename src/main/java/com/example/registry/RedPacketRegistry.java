package com.example.registry;

import com.example.entity.RedPacket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eddie
 * @createTime 2018-12-13
 * @description 红包持久层
 */
public interface RedPacketRegistry extends JpaRepository<RedPacket,Integer> {

}
