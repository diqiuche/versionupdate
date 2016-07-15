
//页面加载完成后，查询所有的产品
$(function(){
	//点击保存按钮
	$("#saveBtn").click(function (){
		var code = $("#pCode").val();
		var name = $("#pName").val();
		if(code == null || strTrim(code).length <= 0){
			alert("产品编码不能为空！");
			return;
		}
		
		if(name == null || strTrim(name).length <= 0){
			alert("产品名称不能为空！");
			return;
		}
		
		//产品类型当前选中的值
		var type = $('#types option:selected').val();
		
		
		//添加一个产品
		$.ajax({
			async:false,
	        type:"POST",
	        dataType:'json',
	        cache:false,
	        data:"productCode=" + code + "&productName=" + name + "&productType=" + type,
	        url: '../../update/v1.0/product',
			error:function(){
				alert("保存失败！");
				return;
			},
			success:function(data){
				
				if(data.data == 'error'){
					alert("已存在相同产品！");
				} else {
					alert("保存成功！");
					//返回列表
					window.location.href="index.html";
				}
			}
	    });
			
	});
	
	//返回列表
	$('#backid').click(function(){
		window.location.href="index.html";
    });
});

//字符串去除空格
function strTrim(str){
	return str.replace(/^\s+|\s+$/g, "");
}