// 定义命名空间
namespace java com.mhy.thrift.gen
// 定义Service
service HelloService {
    //定义方法
    string sayHello(1: string username)
}