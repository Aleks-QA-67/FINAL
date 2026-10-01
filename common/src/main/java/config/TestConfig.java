package config;

public class TestConfig {

    public static String getBaseUrl() { return ConfigLoader.get("base.url"); }
    public static String getApiBaseUrl() { return ConfigLoader.get("api.base.url"); }
    public static long getTimeout() { return Long.parseLong(ConfigLoader.get("timeout")); }
    public static boolean isLoggingEnabled() { return Boolean.parseBoolean(ConfigLoader.get("logging.enabled")); }
    public static String getAdminLogin() { return ConfigLoader.get("admin.login"); }
    public static String getAdminPassword() { return ConfigLoader.get("admin.password"); }
    public static String getDefaultProductName() { return ConfigLoader.get("default.product.name"); }
    public static String getDefaultProductPrice() { return ConfigLoader.get("default.product.price"); }

    public static void printConfig() {
        System.out.println("=== Конфигурация ===");
        System.out.println("URL стенда: " + getBaseUrl());
        System.out.println("URL API: " + getApiBaseUrl());
        System.out.println("Таймаут: " + getTimeout() + " мс");
        System.out.println("Логирование: " + isLoggingEnabled());
        System.out.println("Стартовый товар: " + getDefaultProductName() + " / " + getDefaultProductPrice() + " ₽");
        System.out.println("====================");
    }
}