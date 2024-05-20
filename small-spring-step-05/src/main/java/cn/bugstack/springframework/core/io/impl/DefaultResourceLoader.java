package cn.bugstack.springframework.core.io.impl;

import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;
import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description 用于根据资源位置获取Resource对象的实用工具类
 *              通过对资源位置的解析，可以获取到类路径下的资源、URL资源或文件系统中的资源，并封装成Resource对象返回
 *              1. 类实现
 *              2. 方法实现
 *              3. 异常处理
 *              4. 资源类型
 */

public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        // 确保资源位置不为空
        Assert.notNull(location, "Location must not be null");

        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            // 如果资源位置以"classpath:"开头，则表示资源位于类路径下，创建并返回ClassPathResource对象
            // substring(CLASSPATH_URL_PREFIX.length())方法截取了去掉"classpath:"前缀后的字符串部分，得到了相对于类路径的资源路径
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }
        else {
            try {
                // 尝试将资源位置解析为URL
                URL url = new URL(location);
                // 如果成功解析为URL, 则返回UrlResource 对象
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 如果解析为URL失败，则将资源位置视为文件系统路径，返回FileSystemResource
                return new FileSystemResource(location);
            }
        }
    }

}
