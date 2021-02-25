$(function (){
    Load();
})
function reLoad(){
    $("#queryMenu").bootstrapTable("refresh");
}

function Load(){
    let url = BASIC_URL+"querymenu";
    $("#queryMenu").bootstrapTable({
        url:url,
        method:'POST',
        dataType:'JSON',
        striped:true, //是否显示行间隔色
        pageNumber:1, //初始化加载第一页
        pagination:true, //是否分页
        sidePagination: 'server', //分页
        pageSize:10, //单页记录数
        queryParams: function (params){
            //上传到服务器的参数
            var temp = {
                offset: params.offset, //sql语句起使索引
                pageSize: params.limit,  //每页显示的数量
                // acc:localStorage.getItem("acc")
            };
            return JSON.stringify(temp);
        },
        columns:[
            {
                title: 'id',
                align: "center",
                halign: "center",
                field: "id",
                width: "300px"
            //     /* formatter:function (value,row,index){
            //          return index+1;
            //      }*/
            //
            },
            {
                title:'菜单名称',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'menuname'
            },
            {
                title:'菜单等级',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field:'menulevel'

            },
            {
                title:'菜单创建时间',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field:'createtime'

            },
            {
                title:'管理',
                align:"center",//水平居中
                halign:"center",//垂直居中
                width: '300px', // 列宽
                formatter:function (value,row,index){
                    //若将来 设计到字符串数据传入参数，需要设置单引号
                    let a = '<a href="javascript:void(0);" onclick="deleteMenu(\''+row.id+'\')">删除</a>'
                    // let b ='<a href="javascript:void(0);" onclick="layerClick()" onclick="modifyInfo(\''+row.id+'\',\''+row.examname+'\',\''+row.createtime+'\'"></a>'
                    // let c = '<a href="javascript:void(0);" onclick="setUser(\''+row.acc+'\',\''+row.username+'\',\''+row.pwd+'\',\''+row.phone+'\',\''+row.email+'\',\''+row.createtime+'\')">修改</a>'
                    return a;
                }
            }]
    })
}

//删除菜单
function deleteMenu(id){
    let jsonData={}
    jsonData.id=id;
    $.ajax({
        url:BASIC_URL+"deleteMenu",
        type:"post",
        contentType:"application/json",
        dataType:"json",
        data:JSON.stringify(jsonData),
        success:function (result){
            if (result){
                reLoad();
            }else {
                alert("删除失败！")
            }
        }
    })

}