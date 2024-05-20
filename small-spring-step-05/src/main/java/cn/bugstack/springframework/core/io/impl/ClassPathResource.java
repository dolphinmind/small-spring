package cn.bugstack.springframework.core.io.impl;

import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.util.ClassUtils;
import cn.hutool.core.lang.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description 用于获取类路径资源输入流的实用工具类
 *              通过提供资源路径和类加载器，可以灵活地加载类路径下的资源，并获取其输入流进行处理
 *              该类适用于需要在类路径下获取资源的场景，如加载配置文件、读取模板文件等。
 *              通过合理的异常处理机制，保证了在资源不存在时能够及时发现问题并进行处理
 */
public class ClassPathResource implements Resource {

    // 1. 资源路径
    private final String path;

    // 2. 类加载器
    private ClassLoader classLoader;

    // 3. 使用给定的资源路径初始化对象，使用默认类加载器
    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    // 4. 带类加载器的构造函数，初始化资源路径和指定类加载器
    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        //如果提供的类加载器为空，则使用默认类加载器
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    //实现接口中的方法，获取资源输入流
    @Override
    public InputStream getInputStream() throws IOException {
        // 使用类加载器获取资源输入流
        InputStream is = classLoader.getResourceAsStream(path);

        //如果获取到的输入流为空，抛出文件未找到异常
        if (is == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
