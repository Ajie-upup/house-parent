package com.example.controller;

import com.example.entity.Admin;
import com.example.service.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/5/16
 * @description:
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    private final static String LIST_ACTION = "redirect:/admin";

    private final static String PAGE_INDEX = "admin/index";
    private final static String PAGE_CREATE = "admin/create";
    private final static String PAGE_EDIT = "admin/edit";
    private final static String PAGE_SUCCESS = "common/successPage";

    /**
     * 列表
     */
    @RequestMapping
    public String index(ModelMap model, HttpServletRequest request) {
        // 获取请求参数
        Map<String, Object> filters = getFilters(request);
        // 将请求参数
        PageInfo<Admin> page = adminService.findPage(filters);

        model.addAttribute("page", page);
        model.addAttribute("filters", filters);
        return PAGE_INDEX;
    }

    /**
     * 进入新增页面
     */
    @GetMapping("/create")
    public String create() {
        return PAGE_CREATE;
    }

    /**
     * 保存新增
     */
    @PostMapping("/save")
    public String save(Admin admin) {
        //设置默认头像
        admin.setHeadUrl("http://47.93.148.192:8080/group1/M00/03/F0/rBHu8mHqbpSAU0jVAAAgiJmKg0o148.jpg");
        adminService.insert(admin);

        return PAGE_SUCCESS;
    }

    /**
     * 进入编辑页面
     */
    @GetMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable Long id) {
        Admin admin = adminService.getById(id);
        model.addAttribute("admin", admin);
        return PAGE_EDIT;
    }

    /**
     * 保存更新
     */
    @PostMapping(value = "/update")
    public String update(Admin admin) {

        adminService.update(admin);

        return PAGE_SUCCESS;
    }

    /**
     * 删除
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        adminService.delete(id);
        return LIST_ACTION;
    }
}

