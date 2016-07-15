
//页面加载
$(function(){
	//获取页面传递过来的参数
	var url = document.location.href;
	var paramters;
    if (url.indexOf("=") > 0){
    	paramters = url.substring(url.indexOf("=") + 1,url.length);
    }
    
    var index = paramters.indexOf("&");
    //第一个参数
    var productCode = paramters.substring(0,index);
    var subStr = paramters.substring(index + 1,paramters.length);
    //第二个参数
    var versionCode = subStr.substring(subStr.indexOf("=") + 1,paramters.length);

    //将编码中的+还原为空格
    productCode = productCode.replace(/\+/g,' ');
    
    //将版本编码中的+还原为空格
    versionCode = versionCode.replace(/\+/g,' ');
    
    //获取一个版本的详细信息
    getOneVersion(productCode,versionCode);
    
    //返回到版本列表
    $('#backid').click(function(){
    	var code = productCode.replace(/\ /g,'+');
		window.location.href="index.html?productCode=" + code;
    });
    
    //保存编辑
    $("#saveBtn").click(function(){
    	edit(productCode,versionCode);
    });
    
});

//绑定版本信息
function getOneVersion(productCode,versionCode){
	//查询版本信息
	$.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
        data:"productCode=" + productCode + '&versionCode=' + versionCode,
        url:'../../update/v1.0/versionInfo',
		error:function(){
			alert("加载失败！");
		},
		success:function(data){
			var version = data.data;
			//获取当前资源的信息
	        $("#pcode").val(productCode);
	    	$("#vcode").val(version.code);
	    	$("#vname").val(version.name);
	    	$("#vdes").val(version.description);
	    	
	    	$('#pcode').attr('readonly',true);
	    	$('#vcode').attr('readonly',true);
		}
    });
}

//编辑信息
function edit(pcode,vcode){
	
	var vname = $("#vname").val();
	var vdes = $("#vdes").val();
	if(vname == null || strTrim(vname).length <= 0){
		alert("版本名称不能为空");
		return;
	}
	if(vdes == null || strTrim(vdes).length <= 0){
		alert("版本描述不能为空");
		return;
	}
	
	//拼接的json字符串
	var version = '{"code":"'+vcode+'","name":"'+vname+'","description":"'+vdes+'"}';
	
	$.ajax({
		async:false,
        type:"POST",
        dataType:'json',
        cache:false,
        data:"productCode=" + pcode + '&version=' + version,
        url:'../../update/v1.0/versionsEdit',
		error:function(){
			alert("保存失败！");
		},
		success:function(data){
			alert("保存成功");
			var code = pcode.replace(/\ /g,'+');
			window.location.href="index.html?productCode=" + code;
		}
    });	
}

//字符串去除空格
function strTrim(str){
	return str.replace(/^\s+|\s+$/g, "");
}


