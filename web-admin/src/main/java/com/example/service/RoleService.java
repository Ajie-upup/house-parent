package com.example.service;

import com.example.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/5/2
 * @description:
 */

public interface RoleService extends BaseService<Role> {

    List<Role> findAll();

}
