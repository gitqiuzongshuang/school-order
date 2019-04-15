<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../css/layui.css" media="all">
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/vue.min.js"></script>
</head>
<body>
<div class="layui-container" id="app">
    <div class="layui-row ">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>管理人员登录</legend>
        </fieldset>

        <div class="layui-col-md-offset3" style="margin-top: 100px;">
            <form class="layui-form" method="post">

                <div class="layui-form-item ">

                    <label class="layui-form-label"><i class="layui-icon layui-icon-username"></i> </label>
                    <div class="layui-input-inline">
                        <input type="text" name="account"  required lay-verify="required" autocomplete="off"
                               placeholder="请输入账号" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
                    <div class="layui-input-inline">
                        <input type="password" name="password"  required lay-verify="required" placeholder="请输入密码"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="*" onclick="btnLogin()">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="../../layui.js" charset="utf-8"></script>
<script>

    /*function btnLogin() {
        console.log("onclick successful");
        alert($("form").serialize());
        $.ajax({
            type:"post",
            url:"http://localhost:8080/school-order/login/login.do",
            data:{"account":account,"password":password},
            dataType:"text",
            success:function (data) {
                alert(data);
                if (data == "fail") {
                    layer.alert("用户名或密码错误！");
                    window.location.href = "managerLogin.html";
                }
                else {
                    if(data=="1"){
                        window.location.href = "../index1.html";
                        window.event.returnValue=false;
                    }else{
                        window.location.href = "../index2.html";
                        window.event.returnValue=false;
                    }
                }

            },
            error:function (data) {
                console.log("返回数据失败")

            }
        })
    }*/
    $(function () {
        layui.use('form', function () {
            layer=layui.layer;
            var form = layui.form;
            form.on('submit(*)', function (data) {
                //console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
                //console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
                console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                $.ajax({
                    type: "post",
                    url: "http://localhost:8080/school-order/login/login.do",
                    data: $(data.form).serialize(),
                    xhrFields: {
                        withCredentials: true
                    },
                    async: false,
                    success:function (data) {
                        if (data == "fail") {
                            layer.alert("用户名或密码错误！");
                            window.location.href = "managerLogin.html";
                        }
                        else {
                            if(data.substr(0,1)=="1"){
                                window.location.href = "../index1.html";
                                window.event.returnValue=false;
                            }else{
                                window.location.href = "../index2.html";
                                window.event.returnValue=false;
                            }
                        }

                    },
                    error:function (data) {
                        console.log("返回数据失败")

                    }
                });
            });
        });
    });
</script>
</body>
</html>