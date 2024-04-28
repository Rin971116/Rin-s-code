package com.project.project3.service;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/16 下午 08:17
 * @Version 1.0
 */
public class TeamException extends RuntimeException{
    static final long serialVersionUID = -7034897190745766930L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }

    public TeamException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeamException(Throwable cause) {
        super(cause);
    }

    public TeamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
