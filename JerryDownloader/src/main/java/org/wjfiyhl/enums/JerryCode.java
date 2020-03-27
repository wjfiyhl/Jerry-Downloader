package org.wjfiyhl.enums;

/**
 * @author: WJF
 * @date: 2020/3/27
 * @description:
 */

public enum JerryCode {

    PARAMETER_CANNOT_BE_NULL("the parameter cannot be null.")

    ;
    private String name;

    JerryCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
