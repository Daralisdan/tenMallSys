SQL类实现了两类访问方式
    SQL内置一个Connection对象
    1、  通过sql语句，可得到PreparedStatement对象或ResultSet对象，或者实体集合

    2、  通过实体类作为参数，进行增删查改


config包下的所有文件都是为了解决硬编码问题而存在的
    使用时请在：
        DBConfig.properties 文件中填写数据库配置信息
            注：
            开发时使用的jdbc版本为5.1.27
            DRIVER信息为 DRIVER = com.mysql.jdbc.Driver

        mapping.properties 文件中填写实体类与表名的映射

当前存在的问题
    1、没有类的权限控制
    2、部分方法没有注释
    3、类中属性要与数据库中列名的名称、顺序一致
    4、连接池扩容策略没有优化
    5、SQLHelper类中枚举类型有限（与bean属性类型对应），且暂不支持自定义的引用类型作为bean对象属性
    6、有显式父类的bean可能会出现值注入顺序不配的问题
    7、因为大量使用了泛型，当输入错误类型时不会提示
    8、类之间的关系开始变得混乱

开发记录
    2019年11月22日22:28:17
    将Maker重新命名为TimerMaker，并防止放置在基础包中