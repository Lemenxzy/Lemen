$(function(){if(window.localStorage){var storm=localStorage.getItem("username");if(storm){$("#username").val(storm);$("#password").focus()}}});function login(obj){var w=$(window).width();var username=$("#username").val();var password=$("#password").val();$(obj).text("登录中..").removeAttr("onclick");if(isNotEmpty(username)&&isNotEmpty(password)){$.ajax({type:"post",url:basePath+"/server/logindata.jsp",data:{"username":username,"password":password},success:function(data){$(obj).text("登录").attr("onclick","login(this)");data=data.trim();if(data=="null"){$("#reader").html("用户名者密码不能为空!");var bw=$("#reader").width();$("#reader").animate({left:((w/2)-(bw/2))+"px"},"slow");$("#username").focus();return false}else{if(data=="success"){var curl=document.referrer;window.location.href=(isNotEmpty(curl)&&curl.indexOf("reg")==-1)?curl:basePath}else{$("#reader").html("账号密码不正确!");var bw=$("#reader").width();$("#reader").animate({left:((w/2)-(bw/2))+"px"},"slow");$("#password").val("");$("#password").focus();return false}}}})}else{$("#reader").html("用户名者密码不能为空!");var bw=$("#reader").width();$("#reader").animate({left:((w/2)-(bw/2))+"px"},"slow");$(obj).text("登录").attr("onclick","login(this)");$("#username").focus();return false}if(window.localStorage){localStorage.setItem("username",username)}}$($("body").keydown(function(){if(event.keyCode=="13"){$("#btnSumit").click()}}));