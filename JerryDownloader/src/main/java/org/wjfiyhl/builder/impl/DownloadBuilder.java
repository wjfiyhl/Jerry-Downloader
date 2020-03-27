package org.wjfiyhl.builder.impl;

import org.wjfiyhl.builder.Builder;
import org.wjfiyhl.service.Service;
import org.wjfiyhl.service.servicer.DownloadService;

/**
 * @author: WJF
 * @date: 2020/3/27
 * @description:
 */

public class DownloadBuilder implements Builder {


    @Override
    public Service build() {
        return DownloadService.getInstance();
    }


}
