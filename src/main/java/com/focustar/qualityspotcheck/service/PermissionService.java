package com.focustar.qualityspotcheck.service;

import java.util.List;

/**
 * @Author yangxiansheng
 * @Since 2021/1/11
 * description:
 */
public interface PermissionService {
    List<String> getPermissionByUserId(Integer id);
}
