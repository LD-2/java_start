//window.onload
function jQuery(selector){
    if(typeof selector == "function"){
        window.onload=selector
    }

    //document.get....
    if(typeof selector == "string"){
        if(selector.charAt(0)=="#"){
            domObj=document.getElementById(selector.substring(1))
            return new jQuery()
        }
    }

    //innerHtml
    this.html=function (htmlStr){
        domObj.innerHTML=htmlStr
    }

    //onclick
    this.click=function (fun){
        domObj.onclick=fun
    }

    //onfocus
    this.focus=function (fun){
        domObj.onfocus=fun
    }

    //onchange
    this.change=function (fun){
        domObj.onchange=fun
    }

    //value
    this.val=function (content){
        if(content != undefined){
            domObj.value=content
        }else{
            return domObj.value
        }
    }

    //ajax静态方法
    jQuery.ajax=function (jsonObj){
        // alert("222")
        //1、创建XMLHttpRequest对象
        let xmlObj=new XMLHttpRequest()
        //2、注册状态变化事件
        xmlObj.onreadystatechange=function (){
            if(xmlObj.readyState==4){
                if(xmlObj.status==200){
                    console.log(typeof xmlObj.responseText)
                    console.log("\n"+xmlObj.responseText)
                    let returnJsonObj=JSON.parse(xmlObj.responseText)
                    jsonObj.success(returnJsonObj)
                }else {
                    alert(xmlObj.status)
                }
            }
        }
        //3、建立通道
        //4、发送ajax请求
        if(jsonObj.method.toUpperCase()=="GET"){
            xmlObj.open(jsonObj.method,jsonObj.url+"?t="+new Date().getTime()+"&"+jsonObj.data,jsonObj.async);
            xmlObj.send()
        }else if(jsonObj.method.toUpperCase()=="POST"){
            // alert(jsonObj.method.toUpperCase()+jsonObj.url+jsonObj.data+typeof jsonObj.data)
            xmlObj.open(jsonObj.method,jsonObj.url,jsonObj.async)
            xmlObj.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            xmlObj.send(jsonObj.data)
        }
    }

    //......
}
$=jQuery
new jQuery()