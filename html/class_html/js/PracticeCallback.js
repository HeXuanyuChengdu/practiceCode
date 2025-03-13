function doSomething(callback){
    console.log("执行某些操作");
    callback(); //调用回调函数
}

function mycallback(){
    console.log("执行回调函数");
}

doSomething(mycallback);