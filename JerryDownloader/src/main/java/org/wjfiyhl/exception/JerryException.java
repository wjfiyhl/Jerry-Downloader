package org.wjfiyhl.exception;

import org.wjfiyhl.enums.JerryCode;

/**
 * @author: WJF
 * @date: 2020/3/27
 * @description:
 */

public class JerryException extends RuntimeException {

    public JerryException(JerryCode code) {
        super(code.getName());
    }

}
