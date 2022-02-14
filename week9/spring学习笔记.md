# Spring学习笔记
Spring就是一个轻量级的控制反转（IOC）和面向切面编程（AOP）的框架

## IOC
控制反转IoC(Inversion of Control)，是一种设计思想，DI(依赖注入)是实现IoC的一种方法。

Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从Ioc容器中取出需要的对象。
![](src/img/640.webp)

控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入（Dependency Injection,DI）。

## IOC创建对象的方法
### 通过无参构造方法来创建
User.java

    public class User {
    
        private String name;
        
        public User() {
            System.out.println("user无参构造方法");
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public void show(){
            System.out.println("name="+ name );
        }
    
    }

beans.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    
       <bean id="user" class="com.kuang.pojo.User">
           <property name="name" value="kuangshen"/>
       </bean>
    
    </beans>

测试类

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //在执行getBean的时候, user已经创建好了 , 通过无参构造
        User user = (User) context.getBean("user");
        //调用对象的方法 .
        user.show();
    }

### 通过有参构造方法来创建
UserT.java

    public class UserT {
    
        private String name;
    
        public UserT(String name) {
            this.name = name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public void show(){
            System.out.println("name="+ name );
        }
    
    }

beans.xml 有三种方式编写

    <!-- 第一种根据index参数下标设置 -->
    <bean id="userT" class="com.kuang.pojo.UserT">
       <!-- index指构造方法 , 下标从0开始 -->
       <constructor-arg index="0" value="kuangshen2"/>
    </bean>
    <!-- 第二种根据参数名字设置 -->
    <bean id="userT" class="com.kuang.pojo.UserT">
       <!-- name指参数名 -->
       <constructor-arg name="name" value="kuangshen2"/>
    </bean>
    <!-- 第三种根据参数类型设置(不推荐使用) -->
    <bean id="userT" class="com.kuang.pojo.UserT">
       <constructor-arg type="java.lang.String" value="kuangshen2"/>
    </bean>

测试

    @Test
    public void testT(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserT user = (UserT) context.getBean("userT");
        user.show();
    }

## Spring配置
alias 设置别名 , 为bean设置别名 , 可以设置多个别名

    <!--设置别名：在获取Bean的时候可以使用别名获取-->
    <alias name="userT" alias="userNew"/>

Bean的配置

    <!--bean就是java对象,由Spring创建和管理-->
    
    <!--
       id 是bean的标识符,要唯一,如果没有配置id,name就是默认标识符
       如果配置id,又配置了name,那么name是别名
       name可以设置多个别名,可以用逗号,分号,空格隔开
       如果不配置id和name,可以根据applicationContext.getBean(.class)获取对象;
    
    class是bean的全限定名=包名+类名
    -->
    <bean id="hello" name="hello2 h2,h3;h4" class="com.kuang.pojo.Hello">
       <property name="name" value="Spring"/>
    </bean>

团队的合作通过import来实现。

    <import resource="{path}/beans.xml"/>

## DI依赖注入
### set方式注入
要求被注入的属性 , 必须有set方法 , set方法的方法名由set + 属性首字母大写 , 如果属性是boolean类型 , 没有set方法 , 是 is .

测试pojo类 :

Address.java

    public class Address {
    
         private String address;
     
         public String getAddress() {
             return address;
        }
     
         public void setAddress(String address) {
             this.address = address;
        }
    }

Student.java

    package com.kuang.pojo;
    
    import java.util.List;
    import java.util.Map;
    import java.util.Properties;
    import java.util.Set;
    
    public class Student {
    
         private String name;
         private Address address;
         private String[] books;
         private List<String> hobbys;
         private Map<String,String> card;
         private Set<String> games;
         private String wife;
         private Properties info;
     
         public void setName(String name) {
             this.name = name;
        }
     
         public void setAddress(Address address) {
             this.address = address;
        }
     
         public void setBooks(String[] books) {
             this.books = books;
        }
     
         public void setHobbys(List<String> hobbys) {
             this.hobbys = hobbys;
        }
     
         public void setCard(Map<String, String> card) {
             this.card = card;
        }
     
         public void setGames(Set<String> games) {
             this.games = games;
        }
     
         public void setWife(String wife) {
             this.wife = wife;
        }
     
         public void setInfo(Properties info) {
             this.info = info;
        }
     
         public void show(){
             System.out.println("name="+ name
                     + ",address="+ address.getAddress()
                     + ",books="
            );
             for (String book:books){
                 System.out.print("<<"+book+">>\t");
            }
             System.out.println("\n爱好:"+hobbys);
     
             System.out.println("card:"+card);
     
             System.out.println("games:"+games);
     
             System.out.println("wife:"+wife);
     
             System.out.println("info:"+info);
     
        }
    }

#### 常量注入

     <bean id="student" class="com.kuang.pojo.Student">
         <property name="name" value="小明"/>
     </bean>
测试：

    @Test
    public void test01(){
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
         Student student = (Student) context.getBean("student");
     
         System.out.println(student.getName());
    
    }

#### Bean注入

     <bean id="addr" class="com.kuang.pojo.Address">
         <property name="address" value="重庆"/>
     </bean>
    
     <bean id="student" class="com.kuang.pojo.Student">
         <property name="name" value="小明"/>
         <property name="address" ref="addr"/>
     </bean>

#### 数组注入

     <bean id="student" class="com.kuang.pojo.Student">
         <property name="name" value="小明"/>
         <property name="address" ref="addr"/>
         <property name="books">
             <array>
                 <value>西游记</value>
                 <value>红楼梦</value>
                 <value>水浒传</value>
             </array>
         </property>
     </bean>

#### List注入

     <property name="hobbys">
         <list>
             <value>听歌</value>
             <value>看电影</value>
             <value>爬山</value>
         </list>
     </property>

#### Map注入

     <property name="card">
         <map>
             <entry key="中国邮政" value="456456456465456"/>
             <entry key="建设" value="1456682255511"/>
         </map>
     </property>

#### set注入

     <property name="games">
         <set>
             <value>LOL</value>
             <value>BOB</value>
             <value>COC</value>
         </set>
     </property>

###Bean的作用域
bean就是由IoC容器初始化、装配及管理的对象。
![](src/img/641.webp)

