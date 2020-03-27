package org.wjfiyhl.test;

import org.wjfiyhl.builder.factory.BuildFactory;
import org.wjfiyhl.enums.BuilderType;
import org.wjfiyhl.service.Service;
import org.wjfiyhl.service.servicer.DownloadService;

/**
 * @author: WJF
 * @date: 2020/3/27
 * @description:
 */

public class DownloadTest {

    public void test() {
        Service build = BuildFactory.builder(BuilderType.DOWNLOAD).build();
        DownloadService download = (DownloadService) build;
        // download.download();
    }


}
