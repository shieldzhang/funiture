package com.app.mvc.acl.dao;import com.app.mvc.acl.domain.SysRole;import com.app.mvc.common.DatabaseRepository;import org.apache.ibatis.annotations.Param;import java.util.List;/** * Created by jimin on 16/1/18. */@DatabaseRepositorypublic interface SysRoleDao {    void save(SysRole sysRole);    void update(SysRole sysRole);    SysRole findById(@Param("id") int id);    List<SysRole> getBySupplierId(@Param("supplierId") int supplierId);}