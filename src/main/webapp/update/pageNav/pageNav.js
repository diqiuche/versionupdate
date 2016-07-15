
$(document).ready(function(){
    var optInit = getOptionsFromForm();
    //数据结果members
    $("#Pagination").pagination(members.length, optInit);
});

function pageselectCallback(page_index, jq){
    var items_per_page = $('#items_per_page').val();
    var max_elem = Math.min((page_index + 1) * items_per_page, members.length);
    var newcontent = '';

    // 分页展示
    for(var i = page_index * items_per_page; i < max_elem; i++){
        newcontent += '<dt>' + members[i][0] + '</dt>';
        newcontent += '<dd class="state">' + members[i][2] + '</dd>';
        newcontent += '<dd class="party">' + members[i][3] + '</dd>';
    }

    //查询结果
    $('#Searchresult').html(newcontent);

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
    return opt;
}
