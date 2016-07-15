

//字符串去除空格
function strTrim(str){
	return str.replace(/^\s+|\s+$/g, "");
}

function keyLogin(){
	 if(event.keyCode==13)  //回车键的键值为13
	     $('#loginBtn').click(); //调用登录按钮的登录事件
}

/**
 * 点击登录按钮，调用登录的controller
 */
function login(){
	
	var username = $('#username').val();
	var password = $('#password').val();
	
	if(strTrim(username).length <= 0){
		alert("请输入用户名！");
		return;
	}
		
	if(strTrim(password).length <= 0){
		alert("请输入密码！");
		return;
	}

	$.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
        data:"username="+username+"&userpwd="+password,
        url:'login/v1.0/getUserInfo',
        success:function(data){
             if(data.code == 'OK'){
            	
            	//将用户名中的空格用+替换
            	 username = username.replace(/\ /g,'+');
            	//打开新页面
            	window.open('update/main.html?username='+username+'=', '_self');
            	
             }	 
        },
        error:function(){
             alert("用户名或密码错误！");
             return;
        }
    });
};
