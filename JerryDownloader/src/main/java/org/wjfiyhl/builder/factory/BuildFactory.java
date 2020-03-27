package org.wjfiyhl.builder.factory;

import org.wjfiyhl.builder.Builder;
import org.wjfiyhl.builder.impl.DownloadBuilder;
import org.wjfiyhl.enums.BuilderType;
import org.wjfiyhl.enums.JerryCode;
import org.wjfiyhl.exception.JerryException;

/**
 * @author: WJF
 * @date: 2020/3/27
 * @description:
 */

public class BuildFactory {

    public static Builder builder(BuilderType type) {

        switch (type) {
            case DOWNLOAD:
                return new DownloadBuilder();
            default:
                throw new JerryException(JerryCode.PARAMETER_CANNOT_BE_NULL);
        }

    }

}
