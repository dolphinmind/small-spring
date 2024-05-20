package cn.bugstack.springframework.core.io.impl;

import cn.bugstack.springframework.core.io.Resource;
import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @description 表示URL对应的资源的实用工具类
 *              允许用户通过URL对象来访问远程资源，比如网络上的文件或网页内容
 *              该类的设计使得获取资源输入流的过程变得简单而方便，并且在获取输入流时进行了适当的异常处理，
 *              确保资源能够被正确地释放和关闭

 */
public class UrlResource implements Resource {
    // URL对象
    private final URL url;

    // 构造函数，接受URL对象作为参数
    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }

    // 实现接口中的方法，获取资源输入流
    @Override
    public InputStream getInputStream() throws IOException {
        // 打开URL连接
        URLConnection connection = this.url.openConnection();
        try {
            // 获取输入流并返回
            return connection.getInputStream();
        }
        catch (IOException ex){
            // 如果发生异常，尝试关闭连接
            if (connection instanceof HttpURLConnection){
                // instanceof 运算符的使用，用于检查对象 connection 是否是 HttpURLConnection 类型的实例
                // 检查的目的是为了判断 connection 是否是 HTTP 连接
                ((HttpURLConnection) connection).disconnect();
            }
            throw ex;
        }
    }

}
