// alert("弹窗");
// function first(a,b) {
//     var result = 0;
//     for (var i = 0;i<arguments.length;i++){
//         result += arguments[i];
//     }
//     return result;
// }
// alert(first(102,23,232,2,2,2,1,2,23,33,3,3,3));
//Object类型
var obj = new Object();
obj.name = "华仔";
obj.age = 18;
obj.fun = function () {
    alert("姓名："+this.name+",年龄："+this.age);
}
alert(obj.fun());