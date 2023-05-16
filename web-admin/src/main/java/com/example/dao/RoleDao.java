package com.example.dao;

import com.example.entity.Role;

import java.util.List;

/**
 * @author ajie
 * @date 2023/5/2
 * @description:
 */
public interface RoleDao extends BaseDao<Role> {

    List<Role> findAll();
}
