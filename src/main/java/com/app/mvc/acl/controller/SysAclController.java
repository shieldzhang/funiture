package com.app.mvc.acl.controller;import com.app.mvc.acl.service.SysAclService;import com.app.mvc.acl.service.SysTreeService;import com.app.mvc.acl.vo.AclPara;import com.app.mvc.beans.JsonData;import com.app.mvc.beans.PageQuery;import lombok.extern.slf4j.Slf4j;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.ResponseBody;import org.springframework.web.servlet.ModelAndView;import javax.annotation.Resource;/** * Created by jimin on 16/1/18. */@Slf4j@Controller@RequestMapping("/sys/acl")public class SysAclController {    @Resource    private SysAclService sysAclService;    @Resource    private SysTreeService sysTreeService;    @RequestMapping(value = "/page.do", method = RequestMethod.GET)    public ModelAndView aclPage() {        return new ModelAndView("acl");    }    @ResponseBody    @RequestMapping(value = "/save.json", method = RequestMethod.GET)    public JsonData saveAcl(AclPara para) {        sysAclService.save(para);        return JsonData.success();    }    @ResponseBody    @RequestMapping(value = "/update.json", method = RequestMethod.GET)    public JsonData updateAcl(AclPara para) {        sysAclService.update(para);        return JsonData.success();    }    @ResponseBody    @RequestMapping(value = "/list.json", method = RequestMethod.GET)    public JsonData list(@RequestParam("aclModuleId") int aclModuleId, PageQuery page) {        return JsonData.success(sysAclService.getPageByAclModuleId(aclModuleId, page));    }    @ResponseBody    @RequestMapping(value = "/tree.json", method = RequestMethod.GET)    public JsonData tree() {        return JsonData.success(sysTreeService.aclTree());    }    @ResponseBody    @RequestMapping(value = "/query.json", method = RequestMethod.GET)    public JsonData getAcl(@RequestParam("id") int id) {        return JsonData.success(sysAclService.findById(id));    }    @ResponseBody    @RequestMapping(value = "/urlRegexp.json", method = RequestMethod.GET)    public JsonData urlRegexp(@RequestParam("url") String url) {        return JsonData.success(sysAclService.getByUrlRegexp(url));    }}