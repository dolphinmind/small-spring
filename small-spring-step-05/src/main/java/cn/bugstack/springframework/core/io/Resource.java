package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description
 * 1. 接口声明：为公共接口，定义了获取资源输入流的方法
 * 2. 方法声明：抽象方法，返回值为InputStream；声明了可能抛出的IOException异常，因为获取资源的过程
 *    可能涉及到IO操作，比如文件读取、网络连接等
 * 3. 接口用途：接口的目的是提供一种抽象的方式来获取资源的输入流，而不关心资源的具体类型和来源。
 *    这种抽象性使得可以轻松地切换不同类型的资源，例如文件、网络资源、数据库Blob等，而不需要修改依赖于Resource接口的代码
 * 4. 适应场景：这种接口通常在需要加载、读取或处理各种类型的资源时使用，例如在Web应用程序中加载配置文件、模板文件、静态资源等
 * 5. 异常处理: 保证程序的稳定性和健壮性
 *
 * 总结：
 * `Resource`接口定义了获取资源输入流的标准方法，为处理各种类型的资源提供了一种统一的接口。
 * 通过该结构，可以使代码更加灵活、可扩展，并且降低了代码间的耦合度。
 * 在实际应用中，可以通过不同的实现类来适配不同类型的资源，从而实现资源的统一管理和访问
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
