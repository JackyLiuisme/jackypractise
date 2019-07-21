object hello {
  def main(args: Array[String]): Unit = {
    /*println("hello")
    var x = 10;
    if (x < 20) {
      println("x < 20");
    }
    var str = "world"
    for (i <- 1 to 10){
      println(i + "的阶乘为： " + jiecheng(i))
    }*/

/*
var result :Int = 1
    result = add(2)(3)
    println(result)
    println(apply(layout,10))
*/


  /*delayed(time())
    printInt(b=3,a=4)

    pringString("hello","world")
*/
   println( "不传参数值"+ addInt())

    println(factorial(0))
    println(factorial(1))
  }

  //函数可以内部嵌套
  def factorial(i:Int):Int ={
    def fact(i:Int,accumulator:Int):Int={
      if (i <= 1){
        accumulator
      }else{
        fact(i-1,i*accumulator)
      }
    }
    fact(i,1)

  }


  //方法中可以设置默认值
  def addInt(a:Int=4,b:Int=5): Int ={
    var sum:Int = 0
    sum = a+b
    return sum
  }


  //通过价格*号来表示可以传递多个参数
  def pringString(a:String*): Unit ={
    var i:Int = 0
    for (arg<-a){
      println("a["+i+"]"+arg)
      i += 1
    }
  }



  //可以通过指定形参来传值
  def printInt(a:Int,b:Int): Unit ={
    println("a:" + a)
    println("b" + b)
  }
//函数有值传递和函数名传递两种
  def time() = {
    println("获取时间")
    System.nanoTime()
  }
  def delayed( t: =>Long) ={
    println("在delayed方法内")
    println("参数： " + t);
  }

//高阶函数，调用函数的函数
def apply(f:Int=>String,v:Int) = f(v)
  def layout[A](x:A) = x.toString
//柯里化，将函数的参数拆开
  def  add(x:Int)(y:Int) = x+y




  def finction(string2: String,string1: String) = string2 + string1
  //递归函数
  def jiecheng(n: BigInt) :BigInt ={
    if (n <= 1){
      1
    }else{
      n * jiecheng(n-1)
    }
  }

  def factorial(n:Int,m:Int): Int = {
    if (n < 0) m
    else factorial(n-1,m * n)
  }
}
