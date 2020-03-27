package org.wjfiyhl.service.servicer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wjfiyhl.exception.JerryException;
import org.wjfiyhl.jerry.Downloader;
import org.wjfiyhl.service.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: WJF
 * @date: 2020/3/27
 * @description:
 */

public final class DownloadService implements Service{

    Logger logger = LoggerFactory.getLogger(DownloadService.class);

    private DownloadService() {}


    public <T> void download(HttpServletRequest request,
                              HttpServletResponse response, String fileName, Downloader downloader) {
        String codeType = "UTF-8";
        String userAgent = request.getHeader("USER-AGENT");
        if (StringUtils.isNotBlank(userAgent) && userAgent.contains("Windows")) {
            codeType = "GBK";
        }
        ServletOutputStream os = null;
        String message = "";
        response.reset();
        try {
            fileName = new String(fileName.getBytes(codeType), "iso-8859-1");// 为了解决中文名称乱码问题
            os = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setHeader("Access-Control-Expose-Headers", "FileName");
            response.setContentType("application/octet-stream; charset=utf-8");

            downloader.download(os);
            os.flush();
        } catch (JerryException e) {
            logger.error(e.getMessage());
            message = e.getMessage();
            try {
                response.setContentType("text/html; charset=utf-8");
                os.write(message.getBytes());
                os.flush();
            } catch (IOException e1) {
                logger.error(e1.getMessage());
            }
        } catch (IOException e) {
            logger.error("操作失败:"+e);
        } catch (Exception e) {
            logger.error("操作失败", e);
            message = e.getMessage();
            try {
                response.setContentType("text/html; charset=utf-8");
                os.write(message.getBytes());
                os.flush();
            } catch (IOException e1) {
                logger.error(e1.getMessage());
            }
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                logger.error("操作失败:"+e);
            }
        }
    }

    @Override
    public void service() {

    }

    public enum Download {

        MAIN

        ;

        private DownloadService downloadService;

        Download() {
            downloadService = new DownloadService();
        }

        public DownloadService getInstance() {
            return downloadService;
        }

    }


    public static DownloadService getInstance() {
        return Download.MAIN.getInstance();
    }


}
