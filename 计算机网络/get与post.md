get和post的区别和联系

get和post都为http协议获取资源的发送请求的方式
1、get请求内容会在url中显示，？之后为一对键值对，多个参数用&连接，而post请求一般不会在url中显示，而是会出现在请求主体内（body）
2、get是以检索和获取为主，post以创建和更新为主。
3、get在检索是有大小限制的，一般是2048b，而post一般是不受限制的
4、get在url里面使用了绝大部分的字符集ascll，比如{，这个是ascii字符，但是需要编码%编码，编码方式由浏览器来规定，大部分是utf-8.
5. Get安全性非常低，Post安全性较高。但是执行效率却比Post方法好。 
6. Get产生一个TCP数据包；Post产生两个TCP数据包
使用场景：
在做数据查询时，建议用Get方式；而在做数据添加、修改或删除时，建议用Post方式；
Get方式的安全性较Post方式要差些，包含机密信息的话，建议用Post数据提交方式；
