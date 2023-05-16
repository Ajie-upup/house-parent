package com.example.service.impl;

import com.example.dao.BaseDao;
import com.example.dao.RoleDao;
import com.example.entity.Role;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ajie
 * @date 2023/5/2
 * @description:
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    protected BaseDao<Role> getEntityDao() {
        return roleDao;
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }

}