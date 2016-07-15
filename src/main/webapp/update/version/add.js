
//页面加载
$(function(){
	//获取页面传递过来的参数
	var url = document.location.href;
	var productcode;
    if (url.indexOf("=") > 0){
    	productcode = url.substring(url.indexOf("=") + 1,url.length);
    }
    
    //将编码中的+还原为空格
    productcode = productcode.replace(/\+/g,' ');
    
    //赋值，不可编辑
    $('#pcode').val(productcode);
    $('#pcode').attr('readonly',true);
   
    //返回列表
    $('#backid').click(function(){
    	var code = productcode.replace(/\ /g,'+');
		window.location.href="index.html?productCode=" + code;
    });
    
    //保存
    $('#saveBtn').click(function(){
    	addVersion(productcode);
    });
    
});

//增加一个版本信息
function addVersion(pcode){
	//获取版本信息
	var vcode = $('#vcode').val();
	var vname = $('#vname').val();
	var vdes = $('#vdes').val();
	
	if(vcode == null || strTrim(vcode).length <= 0){
		alert("版本编码不能为空！");
		return;
	}

	if(vname == null || strTrim(vname).length <= 0){
		alert("版本名称不能为空！");
		return;
	}
	
	if(vdes == null || strTrim(vdes).length <= 0){
		alert("版本描述不能为空！");
		return;
	}
	
	//拼接的json字符串
	var version = '{"code":"'+vcode+'","name":"'+vname+'","description":"'+vdes+'"}';
	
	$.ajax({
		async:false,
        type:"POST",
        dataType:'json',
        cache:false,
        data:"productCode=" + pcode + "&version=" + version,
        url:'../../update/v1.0/versions',
		error:function(){
			alert("保存失败！");
		},
		success:function(data){
			
			if(data.data == 'error'){
				alert('该产品下已存在相同版本！');
			} else{
				alert("保存成功！");
				//将空格替换为+
				var code = pcode.replace(/\ /g,'+');
				window.location.href="index.html?productCode=" + code;
			}
		}
    });
}


//字符串去除空格
function strTrim(str){
	return str.replace(/^\s+|\s+$/g, "");
}