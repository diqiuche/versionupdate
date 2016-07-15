


$(function(){
	var productcode = "";
    //获取页面传递过来的参数
	var url = document.location.href;
    if (url.indexOf("=") > 0){
    	productcode = url.substring(url.indexOf("=") + 1,url.length);
    }

    //将编码中的+还原为空格
    productcode = productcode.replace(/\+/g,' ');
  
    //查询一个产品的信息
    var product = getOneProduct(productcode);

    
    //绑定产品信息
    if(product != null && product != ''){
    	 //获取当前资源的信息
        $("#pcode").val(product.productcode);
    	$("#pname").val(product.productname);
    	$("#ptype").val(product.typename);
    	
    	$('#pcode').attr('readonly',true);
    	$('#ptype').attr('readonly',true);
    } else {
    	alert("加载异常！");
    }
    
    //点击保存按钮
    $("#saveBtn").click(function (){
    	var productname = $("#pname").val();
    	if(productname == null || strTrim(productname).length <= 0){
    		alert("产品名称输入不能为空！");
    		return;
    	}
    		
    	edit(productcode,productname);
    });
    
    //返回列表
    $('#backid').click(function(){
		window.location.href="index.html";
    });
    
});

//查询一个产品的详细信息
function getOneProduct(productcode){
	var result;
	$.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
       data:"productCode=" + productcode,
        url:'../../update/v1.0/productInfo',
		error:function(){
			alert("查询信息失败！");
		},
		success:function(data){
			//返回查询结果
			result = data.data;
		}
    });
	
	return result;
}

//编辑一个产品
function edit(productcode,productname){
	$.ajax({
		async:false,
        type:"POST",
        dataType:'json',
        cache:false,
        data:"productCode=" + productcode + '&productName=' + productname ,
        url:'../../update/v1.0/productEdit',
		error:function(){
			alert("保存失败！");
		},
		success:function(data){
			alert("编辑成功！");
			//返回
			window.location.href="index.html";
		}
   });
}

//字符串去除空格
function strTrim(str){
	return str.replace(/^\s+|\s+$/g, "");
}


