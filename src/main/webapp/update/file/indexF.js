
var members = [];
var versionId ='';

//翻页
function pageselectCallback(page_index, jq){
    var items_per_page = $('#items_per_page').val();
    var max_elem = Math.min((page_index + 1) * items_per_page, members.length);
    
    //清空table中除了标题之外的内容
	$("#filesTable tbody").html("");
    
	for(var i = page_index * items_per_page; i < max_elem; i++){
		var type = members[i].filetype;
		var isreg = members[i].isreg;
		var dec = members[i].deccompressfile;
		if(type == 1){
			type = '程序';
		}else if(type == 2){
			type = '数据';
		}else if(type == 3){
			type = '脚本';
		}
		
		if(isreg == 1)
			isreg = '是';
		else
			isreg = '否';
		
		if(dec == 1)
			dec = '是';
		else
			dec = '否';
		
		//拼接一行数据
		var row = '<tr><td>' + versionId + '</td>' + '<td>' + members[i].filename + '</td>'
		+ '<td>' + members[i].address + '</td>' + '<td>' + members[i].location + '</td>' + '<td>' + type + '</td>'
		+ '<td>' + isreg + '</td>'
		+ '<td>' + dec + '</td>' + '<td>' + members[i].createtime + '</td>' + '<td>' + 
		'<a href="#" id="del" onClick="deleteFile()">删除</a> ' + 
		'</td>' + '</tr>';
		
        //向表中增加一行  
		$("#filesTable").append(row);
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
$(function (){
	
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
    
    //将编码中的+还原为空格
    versionCode = versionCode.replace(/\+/g,' ');
    
    //生成版本id
	versionId = productCode + versionCode;
	
	
	
	//根据versionId查询所有的升级文件
	getAllFiles(versionId);
	
	//新建文件，传递参数versionId
	$('#addnew').click(function(){
		var code = productCode.replace(/\ /g,'+');
		var vCode = versionCode.replace(/\ /g,'+');
		window.location.href="add.html?productCode=" + code + '&versionCode=' + vCode;
    });
	
	//返回到版本查询页面
	$('#returnToVersion').click(function(){
		var code = productCode.replace(/\ /g,'+');
		window.location.href="../version/index.html?productCode=" + code;
    });
	
	//根据关键字查询文件信息
	$('#searchBtn').click(function(){
		searchFiles(versionId);
    });
})

//根据版本id，查询所有的文件
function getAllFiles(vId){
	$.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
        data:"versionId=" + vId,
        url:'../../update/v1.0/files',
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

//根据关键字查询文件
function searchFiles(versionId){
	var searchKeyWord = $("#filename").val();
	if(searchKeyWord == null)
		searchKeyWord = '';
	else
		searchKeyWord = strTrim(searchKeyWord);
	$.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
        data:"keyWord=" + searchKeyWord + '&versionId=' + versionId,
        url:'../../update/v1.0/filesSearch',
		error:function(){
			alert("加载失败！");
		},
		success:function(data){
			//清空table中除了标题之外的内容
			$("#filesTable tbody").html("");
			
			//所有产品信息列表
			members = data.data;
			
			//分页初始设置
			var optInit = getOptionsFromForm();
			//数据结果members
			$("#Pagination").pagination(members.length, optInit);
		}
    });
}

//删除一个文件
function deleteFile(){
	 var conf = confirm("确定要删除吗？");
	 if(conf == '1'){
		 var rowIndex = getRowIndex();
		 var versionId = document.getElementById("filesTable").rows[rowIndex].cells[0].innerHTML;
		 var fileName = document.getElementById("filesTable").rows[rowIndex].cells[1].innerHTML;
		 $.ajax({
				async:false,
		        type:"POST",
		        dataType:'json',
		        cache:false,
		        data:"versionId=" + versionId + '&fileName=' + fileName,
		        url:'../../update/v1.0/filesDelete',
				error:function(){
					alert("删除失败！");
				},
				success:function(data){
					//table中删除一行
					document.getElementById("filesTable").deleteRow(rowIndex);
					
					var searchKeyWord = $("#filename").val();
					if(searchKeyWord == null || strTrim(searchKeyWord).length <= 0){
						getAllFiles(versionId);
					} else {
						searchFiles(versionId);
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


