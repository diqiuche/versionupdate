
var isUpLoad = '';
//页面加载
$(function(){
	
	var filename = null;
	var filesize;
	
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
	var versionId = productCode + versionCode;

	$('#vId').val(versionId);
	$('#vId').attr('readonly',true);
	
	//绑定路径
	selectpaths(versionId);
	
	//文件存储位置
	var rHost = '/files/' + productCode + '/Program';
	
	//是否需要上传文件
	isUpLoad = $("input[name='isNeedUp']:checked").val();
	//要上传文件，则只能上传到本地
	if(isUpLoad == 1){
		
		$('#onlyName').hide();
		//不显示地址
		$('#rserver').hide();
		
		$('#serverPath').hide();
		
		$('#upFile').show();
		
	} else {
		$('#upFile').hide();
		
		$('#onlyName').show();

		$('#rserver').show();
		
		$('#serverPath').show();
		
		$('#rpath').val('');
	}
	
	$('input:radio[name="isNeedUp"]').change( function(){
		//是否需要上传文件
		isUpLoad = $("input[name='isNeedUp']:checked").val();
		//要上传文件，则只能上传到本地
		if(isUpLoad == 1){
			
			$('#onlyName').hide();
			//不显示地址
			$('#rserver').hide();
			$('#serverPath').hide();
			
			$('#pathsSpan').show();
			$('#paths').show();
			$('#upFile').show();
		} else {
			$('#upFile').hide();
			$('#paths').hide();
			$('#pathsSpan').hide();
			
			$('#onlyName').show();

			$('#rserver').show();
			
			$('#serverPath').show();
			
			$('#rpath').val('');
		}
	});
	

    //保存
	$('#saveBtn').click(function(){
		if(isUpLoad == 1){
			
			saveFile(rHost,filename,filesize,productCode,versionCode);
			
		} else{
			
			//其他服务器上文件的全路径
			var address = $('#rserver').val();
			
			var location = $('#rpath').val().replace(/\\/,'/');
			
			var fname = $('#fileName').val();
			
			if(address == null || strTrim(address).length <= 0){
				alert("请输入服务器地址！");
				return;
			}
			
			if(fname == null || strTrim(fname).length <= 0){
				alert("请输入文件名！");
				return;
			}
			
			saveFileOther(address,location,fname,productCode,versionCode);
		}
		
	});
	
	 //返回到文件列表
    $('#backid').click(function(){
    	var code = productCode.replace(/\ /g,'+');
    	var vCode = versionCode.replace(/\ /g,'+');
		window.location.href="index.html?productCode=" + code + '&versionCode=' + vCode;
    });
	
	//ajax增加文件信息
	$("#file_upload").uploadify({  
		  
        //是否自动上传 true or false  
        'auto':false,  
  
        //超时时间上传成功后，将等待服务器的响应时间。  
        //在此时间后，若服务器未响应，则默认为成功(因为已经上传,等待服务器的响应) 单位：秒  
        'successTimeout':99999,  
  
        //附带值 JSON对象数据，将与每个文件一起发送至服务器端。  
        //如果为动态值，请在onUploadStart()中使用settings()方法更改该JSON值  
        'formData':{
           
         },   
         //动态值，在这里设置
        'onUploadStart': function(file){   
             
        	//将相对路径中的反斜杠替换为斜杠
        	var rp = $('#rpath').val().replace(/\\/,'/');
            $("#file_upload").uploadify("settings","formData",
                {
                   'savePath': rHost + rp
                } 
            );  
         },   
      
        'swf': "../../uploadify/uploadify.swf",  
  
         //文件选择后的容器div的id值   
        'queueID':'uploadfileQueue',  
  
         //将要上传的文件对象的名称，必须与后台controller中抓取的文件名保持一致      
        'fileObjName':'pic',  
  
         //上传地址  
        'uploader':'../../update/v1.0/uploadFile',  
  
        //浏览按钮的宽度  
        'width':'100',  
  
        //浏览按钮的高度  
        'height':'32',  
  
        //允许上传的文件的最大数量。当达到或超过这个数字，onSelectError事件被触发。  
        'queueSizeLimit' : 10,  
  
        //返回一个错误，选择文件的时候触发  
        'onSelectError':function(file, errorCode, errorMsg){  
            switch(errorCode){  
                case -100:  
                    alert("上传的文件数量已经超出系统限制的"  
                     +$('#file_upload').uploadify('settings','queueSizeLimit')+"个文件！");  
                    break;  
  
                case -110:  
                    alert("文件 ["+file.name+"] 大小超出系统限制的"  
                     +$('#file_upload').uploadify('settings','fileSizeLimit')+"大小！");  
                    break;  
  
                case -120:  
                    alert("文件 ["+file.name+"] 大小异常！");  
                    break;  
  
                case -130:  
                    alert("文件 ["+file.name+"] 类型不正确！");  
                    break;  
            }  
        },  
  
        //上传到服务器，服务器返回相应信息到data里  
        'onUploadSuccess':function(file, data, response){ 
        	filename = file.name;
        	filesize = file.size;
            alert("上传成功");  
         },  
  
        //当单个文件上传出错时触发  
        'onUploadError': function (file, errorCode, errorMsg, errorString) {   
            alert("上传失败"); 
         }   
    });  
	
});

//文件在其他服务器上
function saveFileOther(address,location,filename,productCode,versionCode){
	var versionId = productCode + versionCode;
	var filetype = $('#types option:selected').val();
	var isreg = $("input[name='reg']:checked").val();
	var compress = $("input[name='compr']:checked").val();
	
	var file = '{"filename":"'+filename+'","address":"'+address+'","location":"'+location+'",' +
	'"filetype":"'+filetype+'","isreg":"'+isreg+'","deccompressfile":"'+compress+'"}';
    
	//向数据库中插入记录
	$.ajax({
		async:false,
        type:"POST",
        dataType:'json',
        cache:false,
        data:'versionId=' + versionId + '&fileInfo=' + file + '&flag=remote',
        url:'../../update/v1.0/files',
		error:function(){
			alert("保存失败！");
		},
		success:function(data){
			alert("保存成功！");
			var code = productCode.replace(/\ /g,'+');
			var vCode = versionCode.replace(/\ /g,'+');
			//返回到升级文件列表
			window.location.href="../file/index.html?productCode=" + code + '&versionCode=' + vCode;
		}
	});
}


//保存上传的文件属性
function saveFile(rHost,filename,filesize,productCode,versionCode){
	
	if(filename == null || strTrim(filename).length <= 0){
		alert("请选择并上传文件！");
		return;
	}
	
	var location = $('#rpath').val().replace(/\\/,'/');
	
	var address = rHost + location + '/' + filename;
	
	var versionId = productCode + versionCode;
	var filetype = $('#types option:selected').val();
	var isreg = $("input[name='reg']:checked").val();
	var compress = $("input[name='compr']:checked").val();
	
	var file = '{"filename":"'+filename+'","address":"'+address+'","location":"'+location+'",' +
	'"filetype":"'+filetype+'","filesize":"'+filesize+'","isreg":"'+isreg+'","deccompressfile":"'+compress+'"}';
    
	//向数据库中插入记录
	$.ajax({
		async:false,
        type:"POST",
        dataType:'json',
        cache:false,
        data:'versionId=' + versionId + '&fileInfo=' + file + '&flag=local',
        url:'../../update/v1.0/files',
		error:function(){
			alert("保存失败！");
		},
		success:function(data){
			alert("保存成功！");
			var code = productCode.replace(/\ /g,'+');
			var vCode = versionCode.replace(/\ /g,'+');
			//返回到升级文件列表
			window.location.href="../file/index.html?productCode=" + code + '&versionCode=' + vCode;
		}
	});
}

//更改路径
function select(pathSelect){
	$('#rpath').val(pathSelect.options[pathSelect.selectedIndex].text);
}

//查询路径
function selectpaths(versionId){

	$.ajax({
		async:false,
        type:"GET",
        dataType:'json',
        cache:false,
        data:'versionId=' + versionId,
        url:'../../update/v1.0/allPaths',
		error:function(){
			alert("加载失败！");
		},
		success:function(data){
			//清空
			$("#paths").find("option").remove();
			
			//重新绑定
			var list = data.data;
			for (var i = 0; i < list.length; i++) {
			    $("#paths").append("<option value='" + (i + 1) + "'>" + list[i] + "</option>"); 
			}
			
			//默认路径
			$('#rpath').val($("#paths").find("option:selected").text());
		}
	});

}

//字符串去除空格
function strTrim(str){
	return str.replace(/^\s+|\s+$/g, "");
}
