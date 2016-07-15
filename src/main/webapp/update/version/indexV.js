

var members = [];

var productcode = '';

//翻页
function pageselectCallback(page_index, jq){
    var items_per_page = $('#items_per_page').val();
    var max_elem = Math.min((page_index + 1) * items_per_page, members.length);
    
    //清空table中除了标题之外的内容
	$("#versionTable tbody").html("");
    
	for(var i = page_index * items_per_page; i < max_elem; i++){
		
		//将编码中的+还原为空格
	    var code = productcode.replace(/\ /g,'+');
	    var vCode = members[i].code.replace(/\ /g,'+');
		//拼接一行数据
		var row = '<tr><td>' + productcode + '</td>' + '<td>' + members[i].code + '</td>'
		+ '<td>' + productcode + members[i].code +'</td>' + '<td>' + members[i].name + '</td>' 
		+ '<td>' + members[i].description + '</td>'
		+ '<td>' + members[i].createtime + '</td>'
		+ '<td><a href="edit.html?pcode='+code+'&vcode='+vCode+'"  style="margin-right:5px;">编辑</a>' +  
		'<a href="#" onClick="del()" style="margin-right:5px;">删除</a> <a href="../file/index.html?productCode='+code+'&versionCode='+vCode+'"> 查看文件</a></td>' + '</tr>';
		
        //向表中增加一行  
		$("#versionTable").append(row);
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


//页面加载
$(function(){
	//获取页面传递过来的参数
	var url = document.location.href;

    if (url.indexOf("=") > 0){
    	productcode = url.substring(url.indexOf("=") + 1,url.length);
    }
    
    //将编码中的+还原为空格
    productcode = productcode.replace(/\+/g,' ');
    
    
    
    getAllVersions(productcode);

    
    //新建版本信息
    $('#addnew').click(function(){
    	//将编码中的空格再替换为+
    	var code = productcode.replace(/\ /g,'+');
		window.location.href="add.html?productCode=" + code;
	});
    
    //版本检索
    $('#searchBtn').click(function(){
    	searchVersions(productcode);
    });
    
    $('#returnToProduct').click(function(){
    	window.location.href="../product/index.html";
    });
    
});

/**
 * 根据关键字，进行版本检索
 */
function searchVersions(pcode){
	var searchKeyWord = $("#vcode").val();
	if(searchKeyWord == null)
		searchKeyWord = '';
	else
		searchKeyWord = strTrim(searchKeyWord);
	
	$.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
        data:"productCode=" + pcode + "&keyWord=" + searchKeyWord,
        url:'../../update/v1.0/versionsSearch',
		error:function(){
			alert("加载失败！");
		},
		success:function(data){
			//清空table中除了标题之外的内容
			$("#versionTable tbody").html("");
			
			//所有产品信息列表
			members = data.data;
			
			//分页初始设置
			var optInit = getOptionsFromForm();
			//数据结果members
			$("#Pagination").pagination(members.length, optInit);
			
		}
   });
}

/**
 * 删除版本
 * @param pcode
 * @param vcode
 */
function del(){
	var conf = confirm("确定要删除吗？");
	if(conf == '1'){
		 var rowIndex = getRowIndex();
		 //获取要删除的行对应的产品编码
		 var productCode = document.getElementById("versionTable").rows[rowIndex].cells[0].innerHTML;
		 var versionCode = document.getElementById("versionTable").rows[rowIndex].cells[1].innerHTML;
		 $.ajax({
				async:false,
		        type:"POST",
		        dataType:'json',
		        cache:false,
		        data:"productCode=" + productCode + "&versionCode=" + versionCode,
		        url:'../../update/v1.0/versionsDelete',
				error:function(){
					alert("删除失败！");
				},
				success:function(data){
					//table中删除一行
					document.getElementById("versionTable").deleteRow(rowIndex);
					
					var searchKeyWord = $("#vcode").val();
					if(searchKeyWord == null || strTrim(searchKeyWord).length <= 0){
						//重新绑定版本
						getAllVersions(productCode);
					} else {
						searchVersions(productCode);
					}
				}
		 });
    }
}

/**
 * 根据产品编码，查询所有的版本
 * @param pcode
 */
function getAllVersions(pcode){
	//根据productcode查询该产品下的所有版本信息
    $.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
        data:"productCode=" + pcode,
        url:'../../update/v1.0/versions',
		error:function(){
			alert("加载失败！");
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