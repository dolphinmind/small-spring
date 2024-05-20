package cn.bugstack.springframework.util;

/**
 * @description 工具栏ClassUtils，包含一个静态方法getDefaultClassLoader
 *              该方法用于获取当前线程的上下文类加载器，
 *              如果获取失败则返回系统类加载器，或者当前类的类加载器
 *  代码分析
 *  1. 类声明
 *  2. 静态方法声明
 *  3. 尝试获取当前线程的上下文类加载器
 *  4. 异常处理
 *  5. 检查类加载器是否为空
 *  6. 返回类加载器
 *
 *  总结：
 *  1. 这个方法的主要功能是获取当前线程的上下文类加载器，如果获取失败，则使用当前类的类加载器。
 *     这样做的好处是可以保证方法总是返回一个有效的类加载器
 *  2. 这种方法通常在需要加载类或资源时使用，尤其是在框架或库中，可以适应不同的运行环境和类加载机制
 *  3. 异常处理部分是为了确保在获取类加载器的过程中不会因异常二导致程序中断！
 */
public class ClassUtils {

    // 静态方法，用于获取默认的类加载器
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classloader = null;
        try {
            // 尝试获取当前线程的上下文类加载器
            classloader = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            /**
             * 1. 如果获取上下文类加载器失败，捕获异常并忽略
             * 2. 打印日志或处理异常逻辑可以在此处添加
             */
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }

        // 如果上下文类加载器为空，使用当前类的类加载器
        if (classloader == null) {
            // No thread context class loader -> use class loader of this class.
            classloader = ClassUtils.class.getClassLoader();
        }
        return classloader; //返回类加载器
    }

}
