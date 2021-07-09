package com.bdip.cockpit.constant;


public enum EnumResultCode implements IErrorCode {
    SUCCESS(200, "操作成功", "OperOk"),

    FAILED(500, "服务异常", "OperShit"),

    PARAM_ERROR(400, "参数错误", "paramError"),

    DUPLICATE_NAME(402, "名称已存在", "NameExist"),

    VALIDATE_FAILED(404, "参数检验失败", "ParamValidateShit"),

    NO_EXISTS_CHANGE(405,"未发现可修改的信息","noExistsChange"),

    VALIDATE_FAILED_XSS(404, "参数包含违反安全规则的字符", "UnsafeStr"),

    UNAUTHORIZED(401, "暂未登录或token已经过期", "TokenExpired"),

    FORBIDDEN(403, "没有相关权限", "OutOfPermission"),

    FORBIDDEN_CSRF(403, "非法请求", "IllegalRequest"),

    RATE_LIMIT(501, "系统繁忙", "SysBusy"),



    CREATE_UPLOAD_TASK_FAILED(600, "创建上传任务失败", "createUploadTaskFailed"),

    FILE_EXIST(601,"文件存在","fileExist"),

    FILE_UPLOAD_FAILED(602,"文件上传失败","fileUploadFailed"),

    BLOCK_FILE_MERGE_FAILED(603,"切块合并失败","blockFileMergeFailed"),

    BLOCK_DEFICIENCY(604,"切块缺失","blockDeficiency"),
    FILE_UNZIP_FAILED(605,"文件解压失败","fileUnzipFailed")
    ;


    private int code;
    private String message;
    private String msgKey;

    EnumResultCode(int code, String message, String msgKey) {
        this.code = code;
        this.message = message;
        this.msgKey = msgKey;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getMsgKey() {
        return msgKey;
    }
}
