学习材料：
- https://github.com/fuzhengwei/small-spring
- [小傅哥博客](https://bugstack.cn/md/spring/develop-spring/2021-05-16-%E7%AC%AC1%E7%AB%A0%EF%BC%9A%E5%BC%80%E7%AF%87%E4%BB%8B%E7%BB%8D%EF%BC%8C%E6%89%8B%E5%86%99Spring%E8%83%BD%E7%BB%99%E4%BD%A0%E5%B8%A6%E6%9D%A5%E4%BB%80%E4%B9%88%EF%BC%9F.html)



学习过程：
1. 第一阶段
   1. fork 小傅哥的[small-spring] 源项目到自己的代码仓库，git clone到本地
   2. 添加pom.xml文件，导入所有模块进行本地调试

2. 第二阶段
   1. 利用Liner对博客文档内容进行标记，并进行相应批注思考
   2. 利用语雀小记记录下自己本章节的疑惑点
   3. 利用ProcessOn对源码进行UML绘图，分析设计过程，整个项目的UML会不停迭代
   4. 阅读源码过程，进行适当注释，添加入自己天马行空的思考
   5. 利用ChatGPT来解答自己的部分困惑
   6. 对前人的成果进行思考并吸纳
   7. 按照思路进行自行编码，真正认知是个混沌的过程，可能需要直接抄写的过程，也可能要反复写了又删除，给自己写个步骤模板，自己能够通过思考自行写下来，啃下一个项目，事半功倍
   8. 利用Git进行版本管理，对于里程碑形式的胜利，需要进行截图记录
   9. 过程中学习到的编程技巧，通过语雀小记贴上标签进行记录
   10. 语雀文档是最终的手段，进行系统性总结，一个项目一篇核心文章即可

阶段思考：
2024/5/25
1. 版本控制的思想，每个里程碑都具有意义
2. 项目的结构的合理编排，随着项目的壮大，在接口和类众多的情况下，很容易迷失
3. UML图绘制与项目结构的编排具备逻辑一致性，文字描述不如图来的清晰，对UML图的每一步都要进行专业把控
4. 设计模式在编码中的使用，可以让代码具有高度扩展性，添加额外的功能只需修改少量代码即可
5. 自行编码的过程，不是抄写，而是深刻体会这些看起来很简单的代码在这个地方的作用
6. 在编写文档的过程中，也需要有技巧，一股脑儿堆叠起来的文档，后面自己也是不怎会看的，Simple is more
7. 不要吝啬给项目进行注释，注释也要遵循规范，主要为了方便自己
8. 学习是个十分混沌的过程，先胡乱入局，可能到某个阶段又推倒重来，就是因为当时对那个板块并没有体会非常深刻，迭代思维
9. 勤记录，从最细小的事情中培养自己的习惯
10. 写文档不用贪多，不用去贪婪汲取当前还用不到的资料，适当地封闭信息，是为了让问题更尖锐化，那个时候再去寻求外界的帮助将会非常有效
11. 多用Chat-GPT进行关键内容的辅助思考，但不能过度依赖，它是辅助，你要把控主体方向
12. 学会使用Javadoc方式生成当前项目文档，来辅助自己

2024/5/26
1. 在庞大的项目面前，多使用规范注释


参考源码：
- https://github.com/code4craft/tiny-spring
- https://github.com/DerekYRC/mini-spring
