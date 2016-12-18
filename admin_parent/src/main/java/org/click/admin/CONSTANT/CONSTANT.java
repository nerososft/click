package org.click.admin.CONSTANT;

/**
 * 全局String ,以便国际化
 * Author :  root
 * Email  :  nerosoft@outlook.com
 * Date   :  16-11-7
 * Time   :  下午7:51
 */
public enum CONSTANT {
    //page
    PAGE_SET_FAILED("设置失败"),
    PAGE_DEL_FAILED("删除失败"),
    PAGE_SET_SUCCESS("设置成功"),
    PAGE_DEL_SUCCESS("删除成功"),
    PAGE_ADD_SUCCESS("添加成功"),
    PAGE_ADD_FAILED("添加失败"),

    ADMIN_AUTH_FAILED("管理员认证失败"),

    FILE_NULL("文件为空"),
    FILE_FORMAT_UNSUPPORED("文件格式不允许上传"),
    FILE_ERROR("未知的文件错误"),
    FILE_UPLOAD_SUCCESS("文件上传成功"),
    FILE_UPLOAD_FAILED("文件上传失败"),
    FILE_STORE_FAILED("文件储存失败"),

    MODULE_ADD_ERROE("模块添加失败"),
    MODULE_UPDATE_ERROR("模块更新失败"),
    MODULE_DELETE_ERROR("模块删除失败");

    public String DESC;
    CONSTANT(String desc){
        this.DESC = desc;
    }
}
