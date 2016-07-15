
var members = [];

//翻页
function pageselectCallback(page_index, jq){
    var items_per_page = $('#items_per_page').val();
    var max_elem = Math.min((page_index + 1) * items_per_page, members.length);
    
    //清空table中除了标题之外的内容
	$("#productTable tbody").html("");
    
    for(var i = page_index * items_per_page; i < max_elem; i++){
    	var code = members[i].productcode;
    	//将空格替换为+
		code = code.replace(/\ /g,'+');
		//拼接一行数据
		var row = '<tr><td>' + members[i].productcode + '</td>' + '<td>' + members[i].productname + '</td>'
		+ '<td>' + members[i].typename + '</td>' + '<td>' + members[i].createtime + '</td>' + '<td>' + 
		'<a href="edit.html?productcode='+code+'" id="edit"  style="margin-right:5px;">' + '编辑</a>  <a href="#" id="del" onClick="deletePro()"  style="margin-right:5px;">删除</a> ' + 
		'  <a href="../version/index.html?productcode='+code+'" >查看版本</a>' + '</td>' + '</tr>';
		
        //向表中增加一行  
		$("#productTable").append(row);
	}

    return false;
}

//设置分页的样式
function getOptionsFromForm(){
    var opt = {callback: pageselectCallback};
    
    $("input:hidden").each(function(){
        opt[this.name] = this.className.match(/numeric/) ? parseInt(this.value) : this.value;
    });
    var htmlspecialchars ={ "&":"&amp;", "<":"&lt;", ">":"&gt;", '"':"&quot;"}
    $.each(htmlspecialchars, function(k,v){
        opt.prev_text = opt.prev_text.replace(k,v);
        opt.next_text = opt.next_text.replace(k,v);
    })
    
    //总记录数小于每页记录数，隐藏页码
    var perPage = $('#items_per_page').val();
    if(members.length <= perPage){
    	$("#Pagination").hide();
    }
    	
    return opt;
}


//页面加载完成后，查询所有的产品
$(function(){
	
	//返回查询结果
	getAllProducts();
	
	//检索
	$('#searchBtn').click(function(){
		search();
	});
	
	$('#addnew').click(function(){
		window.location.href="add.html";
    });
});


//获取所有的产品信息
function getAllProducts(){
	$.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
        data:"",
        url:'../../update/v1.0/product',
		error:function(){
			alert("加载失败！");
			return;
		},
		success:function(data){
			//所有产品信息列表
			members = data.data;
			//分页初始设置
			var optInit = getOptionsFromForm();
			//数据结果members
			$("#Pagination").pagination(members.length, optInit);
		}
   });

}

//根据产品编码，查询产品
function search(){
	
	var searchKeyWord = $("#productcode").val();
	if(searchKeyWord == null)
		searchKeyWord = '';
	else
		searchKeyWord = strTrim(searchKeyWord);
	$.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
        data:"keyWord=" + searchKeyWord,
        url:'../../update/v1.0/productSearch',
		error:function(){
			alert("加载失败！");
		},
		success:function(data){
			//清空table中除了标题之外的内容
			$("#productTable tbody").html("");
			members = data.data;
			//分页初始设置
			var optInit = getOptionsFromForm();
			//数据结果members
			$("#Pagination").pagination(members.length, optInit);
		}
   });	
}

//删除一个产品，传递的参数为productcode
function deletePro(){
	 var conf = confirm("确定要删除吗？");
	 if(conf == '1'){
		 var rowIndex = getRowIndex();
		 //获取要删除的行对应的产品编码
		 var productCode = document.getElementById("productTable").rows[rowIndex].cells[0].innerHTML;
		 $.ajax({
				async:false,
		        type:"POST",
		        dataType:'json',
		        cache:false,
		        data:"productCode=" + productCode,
		        url:'../../update/v1.0/productDelete',
				error:function(){
					alert("删除失败！");
				},
				success:function(data){
					//table中删除一行
					document.getElementById("productTable").deleteRow(rowIndex);
					
					var searchKeyWord = $("#productcode").val();
					if(searchKeyWord == null || strTrim(searchKeyWord).length <= 0){
						//重新绑定产品
						getAllProducts();
					} else {
						search();
					}
					
				}
		 });
     }
}


//获取所在table行号
function getRowIndex(){
	 //获取当前选中的行
	 var e = e || window.event; 
	 var target = e.target || e.srcElement; 
	 var rowIndex = 0;
	 if (target.parentNode.tagName.toLowerCase() == "td") {
	    rowIndex = target.parentNode.parentNode.rowIndex; 
	 } 
	 return rowIndex;
}

//字符串去除空格
function strTrim(str){
	return str.replace(/^\s+|\s+$/g, "");
}
