package cn.bugstack.springframework.core.io;

/**
 * @description 接口的主要目的是提供一种统一的方式来获取资源，而不关心资源的具体类型和来源
 *              通过调用getResource()方法，可以获取到特定位置的资源对象，无论这个位置是
 *              类路径、文件系统、网络还是其他地方
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     * 类路径加载的伪URL前缀，用于指示资源位于类路径下
     * 在实际使用时，可以将该前缀加在资源路径的前面，以便识别并加载类路径下的资源
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     *
     * @param location，表示资源的位置
     * @return Resource类型，表示获取到的资源对象
     */
    Resource getResource(String location);

}
