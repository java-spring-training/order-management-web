package example.configuration;

/**
 * class này để chứa các entry path của web
 */
public class WebPathConfig {

    // ngăn chặn việc khởi tạo
    private WebPathConfig() {}

    public static final String LIST_ORDER_BY_CUSTOMER = "/orders/{customerNumber}";

}
