package com.yang.portal.core;

public interface CoreConstant {

    Boolean IS_DELETE = false;
    String CHAR_SET = "UTF-8";
    int BEGIN_INDEX = 0;
    String ERROR_KEY = "error";
    String SERVER_ZONE = "Asia/Shanghai";

    interface Pagination {
        String BASE_STR = " ORDER BY";
        String ASC = "ASC";
        String DESC = "DESC";
        String DESC_SYMBOL = "-";
        String COMMA = ",";
        String FORMAT = " %s %s,";
        int BEGIN_INDEX = 1;
    }

    interface ExceptionMessage {
        String METHOD_ARGUMENT_NOT_VALID_EXCEPTION_MESSAGE = "请求传参问题";
        String BASE_WARN_MESSAGE = "service error:{}";
    }

    interface SpringFox {
        String TITLE_SUFFIX = "Restful APIs";
        String BASE_PACKAGE = "com.yang.portal";
    }

    interface Shedlock {
        String TABLE_NAME = "SHEDLOCK";
        String NAME = "NAME";
        String LOCK_UNTIL = "LOCK_UNTIL";
        String LOCKED_AT = "LOCKED_AT";
        String LOCKED_BY = "LOCKED_BY";
    }
}
