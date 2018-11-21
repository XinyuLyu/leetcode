# Redis 对于 key的操作指令
1. del key1 key2 ... Keyn
作用: 删除1个或多个键
返回值: 不存在的key忽略掉,返回真正删除的key的数量

2. rename key newkey
作用: 给key赋一个新的key名
注:如果newkey已存在,则newkey的原值被覆盖

3. renamenx key newkey  
作用: 把key改名为newkey
返回: 发生修改返回1,未发生修改返回0
注: nx--> not exists, 即, newkey不存在时,作改名动作

4. move key db
将key移动到指定的数据库中
<pre>      
      redis 127.0.0.1:6379[1]> select 2
      OK
      redis 127.0.0.1:6379[2]> keys *
      (empty list or set)
      redis 127.0.0.1:6379[2]> select 0
      OK
      redis 127.0.0.1:6379> keys *
      1) "name"
      2) "cc"
      3) "a"
      4) "b"
      redis 127.0.0.1:6379> move cc 2
      (integer) 1
      redis 127.0.0.1:6379> select 2
      OK
      redis 127.0.0.1:6379[2]> keys *
      1) "cc"
      redis 127.0.0.1:6379[2]> get cc
      "3"  
</pre>

5. keys pattern 查询相应的key
在redis里,允许模糊查询key
有3个通配符 *, ? ,[]
*: 通配任意多个字符
?: 通配单个字符
[]: 通配括号内的某1个字符
<pre>
     redis 127.0.0.1:6379[1]> select 2
     OK
     redis 127.0.0.1:6379[2]> keys *
     (empty list or set)
     redis 127.0.0.1:6379[2]> select 0
     OK
     redis 127.0.0.1:6379> keys *
     1) "name"
     2) "cc"
     3) "a"
     4) "b"
     redis 127.0.0.1:6379> move cc 2
     (integer) 1
     redis 127.0.0.1:6379> select 2
     OK
     redis 127.0.0.1:6379[2]> keys *
     1) "cc"
     redis 127.0.0.1:6379[2]> get cc
     "3"
</pre> 

6. randomkey 返回随机key

7. exists key
判断key是否存在,返回1/0

8. type key
返回key存储的值的类型
有string,link,set,order set, hash


9. ttl key 
作用: 查询key的生命周期
返回: 秒数
注:对于不存在的key或已过期的key/不过期的key,都返回-1
Redis2.8中,对于不存在的key,返回-2

10. expire key 整型值
作用: 设置key的生命周期,以秒为单位
同理: 
pexpire key 毫秒数, 设置生命周期
pttl  key, 以毫秒返回生命周期

11. persist key
作用: 把指定key置为永久有效
 

