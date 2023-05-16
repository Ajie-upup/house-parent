package com.example.controller;

import com.example.entity.Role;
import com.example.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ajie
 * @date 2023/5/2
 * @description:
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    private final static String LIST_ACTION = "redirect:/role";
    private final static String PAGE_INDEX = "role/index";
    private final static String PAGE_CREATE = "role/create";
    private final static String PAGE_EDIT = "role/edit";
    private final static String PAGE_SUCCESS = "common/successPage";

    @RequestMapping
    public String index(ModelMap model, HttpServletRequest request) {
        Map<String, Object> filters = getFilters(request);
        PageInfo<Role> page = roleService.findPage(filters);

        model.addAttribute("page", page);
        model.addAttribute("filters", filters);
        return PAGE_INDEX;
    }

    @GetMapping("/create")
    public String create(ModelMap model) {
        return PAGE_CREATE;
    }

    @PostMapping("/save")
    public String save(Role role) {
        roleService.insert(role);
        return PAGE_SUCCESS;
    }

    @GetMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        Role role = roleService.getById(id);
        model.addAttribute("role", role);
        return PAGE_EDIT;
    }

    @PostMapping(value = "/update")
    public String update(Role role) {

        roleService.update(role);
        return PAGE_SUCCESS;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        roleService.delete(id);
        return LIST_ACTION;
    }

}
