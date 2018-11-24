# Redis
## Redis启动、测试、关闭
1. 使用配置文件启动redis server <pre>$ redis-server /usr/local/etc/redis.conf</pre>
2. 测试redis server是否启动  <pre>L$ redis-cli ping</pre>
3. redis关闭<pre>redis-cli -p 6379 shutdown</pre> 
4. 进入数据库 <pre>redis-cli</pre>

## Redis 对于 key的操作指令
1. <code>del key1 key2 ... Keyn</code>  
作用: 删除1个或多个键  
返回值: 不存在的key忽略掉,返回真正删除的key的数量  

2. <code>rename key newkey </code>   
作用: 给key赋一个新的key名  
注:如果newkey已存在,则newkey的原值被覆盖  

3. <code>renamenx key newkey </code>  
作用: 把key改名为newkey  
返回: 发生修改返回1,未发生修改返回0  
注: nx--> not exists, 即, newkey不存在时,作改名动作  

4. <code>move key db</code>  
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

5. <code>keys pattern</code>   
查询相应的key,在redis里,允许模糊查询key
有3个通配符 *, ? ,[]:  
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

6. <code>randomkey</code> 返回随机key  

7. <code>exists key</code>  
判断key是否存在,返回1/0

8. <code>type key</code>  
返回key存储的值的类型  
有string,link,set,order set, hash  

9. <code>ttl key</code>   
作用: 查询key的生命周期  
返回: 秒数  
注:对于不存在的key或已过期的key/不过期的key,都返回-1  
Redis2.8中,对于不存在的key,返回-2  

10. <code>expire key</code> 整型值    
作用: 设置key的生命周期,以秒为单位  
同理:   
pexpire key 毫秒数, 设置生命周期  
pttl  key, 以毫秒返回生命周期  

11. <code>persist key</code>  
作用: 把指定key置为永久有效  

## Redis字符串类型的操作
1. <code>set key value [ex 秒数] / [px 毫秒数]  [nx] /[xx]</code>  
如: set a 1 ex 10 , 10秒有效  
Set a 1 px 9000  , 9秒有效  
注: ex, px 不能那个同时  
nx: 表示key不存在时,执行操作  
xx: 表示key存在时,执行操作  


2. <code>mset  multi set</code>    
一次性设置多个键值  
例: mset key1 v1 key2 v2 ....

3. <code>mget key1 key2 ..keyn</code>  
作用:获取多个key的值


4. <code>setrange key offset value</code>  
作用:把字符串的offset偏移字节,改成value  
<pre>
redis 127.0.0.1:6379> set greet hello
OK
redis 127.0.0.1:6379> setrange greet 2 x
(integer) 5
redis 127.0.0.1:6379> get greet
"hexlo"
</pre>
注意: 如果偏移量>字符长度, 该字符自动补0x00
<pre>
redis 127.0.0.1:6379> setrange greet 6 !
(integer) 7
redis 127.0.0.1:6379> get greet
"heyyo\x00!"
</pre>
append key value
作用: 把value追加到key的原值上

5. <code>getrange key start stop</code>
作用: 是获取字符串中 [start, stop]范围的值  
注意: 对于字符串的下标,左数从0开始,右数从-1开始  
<pre>
redis 127.0.0.1:6379> set title 'chinese'
OK
redis 127.0.0.1:6379> getrange title 0 3
"chin"
redis 127.0.0.1:6379> getrange title 1 -2
"hines"
</pre>
注意:   
1: start>=length, 则返回空字符串  
2: stop>=length,则截取至字符结尾  
3: 如果start 所处位置在stop右边, 返回空字符串  

6. <code>getset key newvalue</code>  
作用: 获取并返回旧值,设置新值  
<pre>
redis 127.0.0.1:6379> set cnt 0
OK
redis 127.0.0.1:6379> getset cnt 1
"0"
redis 127.0.0.1:6379> getset cnt 2
"1"
</pre>

7. <code>incr key</code>  
作用: 指定的key的值加1,并返回加1后的值
注意:  
1:不存在的key当成0,再incr操作  
2: 范围为64有符号   

8. <code>incrby key number</code>
<pre>
redis 127.0.0.1:6379> incrby age  90
(integer) 92
</pre>

9. <code>incrbyfloat key floatnumber</code>  
<pre>
redis 127.0.0.1:6379> incrbyfloat age 3.5
"95.5"
</pre>

10. <code>decr key</code>
<pre>
redis 127.0.0.1:6379> set age 20
OK
redis 127.0.0.1:6379> decr age
(integer) 19
</pre>

11. <code>decrby key number</code>
<pre>
redis 127.0.0.1:6379> decrby age 3
(integer) 16
</pre>

12. <code>getbit key offset</code>  
作用:获取值的二进制表示,对应位上的值(从左,从0编号)  
<pre>
redis 127.0.0.1:6379> set char A
OK
redis 127.0.0.1:6379> getbit char 1
(integer) 1
redis 127.0.0.1:6379> getbit char 2
(integer) 0
redis 127.0.0.1:6379> getbit char 7
(integer) 1
</pre>

13. <code>setbit  key offset value</code>  
设置offset对应二进制位上的值  
返回: 该位上的旧值  
注意:   
1:如果offset过大,则会在中间填充0,  
2: offset最大大到多少  
3:offset最大2^32-1,可推出最大的的字符串为512M  

14. <code>bitop operation destkey key1 [key2 ...]</code>
对key1,key2..keyN作operation,并将结果保存到 destkey 上。  
operation 可以是 AND 、 OR 、 NOT 、 XOR  
大写变小写：  
<pre>
//redis 127.0.0.1:6379> setbit lower 7 0
//(integer) 0
redis 127.0.0.1:6379> setbit lower 2 1 默认将其他位设为0
(integer) 0
redis 127.0.0.1:6379> get lower
" "
redis 127.0.0.1:6379> set char Q
OK
redis 127.0.0.1:6379> get char
"Q"
redis 127.0.0.1:6379> bitop or char char lower
(integer) 1
redis 127.0.0.1:6379> get char
"q"
小写变大写：
//setbit upper 2 0 不对，不默认将其他位设为1 
127.0.0.1:6379> set char a
127.0.0.1:6379> setbit upper 0 1
(integer) 0
127.0.0.1:6379> setbit upper 1 1
(integer) 0
127.0.0.1:6379> setbit upper 2 0
(integer) 0
127.0.0.1:6379> setbit upper 3 1
(integer) 0
127.0.0.1:6379> setbit upper 4 1
(integer) 0
127.0.0.1:6379> setbit upper 5 1
(integer) 0
127.0.0.1:6379> setbit upper 6 1
(integer) 0
127.0.0.1:6379> setbit upper 7 1
(integer) 0
127.0.0.1:6379> bitop and char char upper
(integer) 1
127.0.0.1:6379> get char
"A"
127.0.0.1:6379>
OK注意: 对于NOT操作, key不能多个
</pre>

## link 链表结构

1. <code>lpush key value</code>     
作用: 把值插入到链接头部

2. <code>rpop key</code>    
作用: 返回并删除链表尾元素

3. <code>lrange key start  stop</code>    
作用: 返回链表中[start ,stop]中的元素  
规律: 左数从0开始,右数从-1开始  

4. <code>lrem key count value</code>  
作用: 从key链表中删除 value值  
注: 删除count的绝对值个value后结束  
Count>0 从表头删除  
Count<0 从表尾删除  

5. <code>ltrim key start stop</code>    
作用: 剪切key对应的链接,切[start,stop]一段,并把该段重新赋给key

6. <code>lindex key index</code>  
作用: 返回index索引上的值,  如  lindex key 2  
  
7. <code>llen key</code>  
作用:计算链接表的元素个数  
<pre>
redis 127.0.0.1:6379> llen task
(integer) 3
redis 127.0.0.1:6379> 
</pre>

8. <code>linsert  key after|before search value</code>  
作用: 在key链表中寻找’search’,并在search值之前|之后,.插入value  
注: 一旦找到一个search后,命令就结束了,因此不会插入多个value  

9. <code>rpoplpush source dest</code>  
作用: 把source的尾部拿出,放在dest的头部,  
并返回 该单元值  
场景: task + bak 双链表完成安全队列  
业务逻辑:  
1:Rpoplpush task bak  
2:接收返回值,并做业务处理  
3:如果成功,rpop bak 清除任务. 如不成功,下次从bak表里取任务  

10. <code>brpop ,blpop  key timeout</code>  
作用:等待弹出key的尾/头元素,   
Timeout为等待超时时间  
如果timeout为0,则一直等待  
场景: 长轮询Ajax,在线聊天时,能够用到  

