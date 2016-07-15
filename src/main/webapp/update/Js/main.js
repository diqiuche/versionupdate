
    // 登录超时设置，60分钟不操作，重新登录  
    var myTime = setTimeout("Timeout()", 3600000);   
	function resetTime() {   
	    clearTimeout(myTime);   
	    myTime = setTimeout('Timeout()', 3600000);   
	}  
	function Timeout() {   
	    alert("您的登录已超时, 请点确定后重新登录!");   
	    document.location.href='../index.html';   
	}   
	document.documentElement.onkeydown = resetTime;  
	
	//页面加载
	$(function(){
		//获取页面传递过来的参数
		var url = document.location.href;

		var username = '';
	    if (url.indexOf("=") > 0){
	    	var index = url.lastIndexOf("=");
	    	username = url.substring(url.indexOf("=") + 1,index);
	    }
	    
	    
	    //将编码中的+还原为空格
	    username = username.replace(/\+/g,' ');
	    $('#username').html(username);
	});