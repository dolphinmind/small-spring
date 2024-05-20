package cn.bugstack.springframework.core.io.impl;

import cn.bugstack.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource {
    // 文件对象
    private final File file;

    // 资源路径
    private final String path;

    // 构造函数，接受文件对象作为参数
    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    // 构造函数，接受文件路径作为参数
    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    // 实现接口中的方法，获取资源输入流
    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    // 获取资源路径
    public final String getPath() {
        return this.path;
    }

}
