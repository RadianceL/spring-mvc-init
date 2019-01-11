package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author eddie
 * @createTime 2018-11-08
 * @description 红包实体类
 */
@Data
@Entity
@Table(name = "red_packet")
@NoArgsConstructor
@AllArgsConstructor
public class RedPacket {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "packet")
    private int packet;

    @Column(name = "total")
    private double total;

    @Column(name = "lost")
    private double lost;

    @Column(name = "description")
    private String description;

    public RedPacket(int packet, double total, double lost, String description) {
        this.packet = packet;
        this.total = total;
        this.lost = lost;
        this.description = description;
    }
}
