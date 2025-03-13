function testVar(){
    if(true){
        var valueOfVar = 10;//在整个testVar函数内可用
    }
    console.log(valueOfVar);//控制台显示值为10
}
function testLet(){
    if(true){
        let valueOfLet = 20;//只在{}内部可以使用
    }
    //console.log(valueOfLet);//报错 valueOfLet is not defined
}

testVar();
testLet();