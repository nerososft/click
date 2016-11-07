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

    ADMIN_AUTH_FAILED("管理员认证失败");

    public String DESC;
    CONSTANT(String desc){
        this.DESC = desc;
    }
}
