$(function (){
    load();
})

function reload(){
    $("#myTable").bootstrapTable("refresh");
}

function load(){
    let url = BASIC_URL+"selectCompany";
    $("#myTable").bootstrapTable({
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
            let temp = {
                offset: params.offset, //sql语句起使索引
                pageNumber: params.limit,  //每页显示的数量
            };
            return JSON.stringify(temp);
        },
        columns:[
            {
                title: '公司id',
                align: "center",
                halign: "center",
                field: "id",
                width: "150px"
            },{
                title:'密码',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'pwd'
            },{
                title:'公司名称',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'company'
            },{
                title:'操作',
                align:"center",//水平居中
                halign:"center",//垂直居中
                formatter:function (value,row,index) {
                    let a = '<a href="javascript:void(0);" onclick = "modifyCompany(\''+row.id+'\',\''+row.pwd+'\',\''+row.company+'\')">修改  </a>'
                    let b = '<a href="javascript:void(0);" onclick = "deleteCompany(\''+row.id+'\')">删除  </a>'
                    return a+b;
                }

            }]
    })
}

function modifyCompany(id,pwd,company) {
    layer.open({
        type:2,
        title:"score",
        maxmin:false,
        shapeClose:false,
        area:['80%','80%'],
        content:'MgModifyCompany.html',
        success:function (layero,index) {
            localStorage.setItem("companyId",id);
            let childBody = layer.getChildFrame('body',index);
            $(childBody).find('.id').text(id);
            $(childBody).find('.pwd').text(pwd);
            $(childBody).find('.name').text(company);
        }
    })
}

function deleteCompany(id) {
    let jsonData={};
    jsonData.id = id;
    $.ajax({
        url:BASIC_URL+"deleteCompany",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(jsonData),
        dataType:"json",
        success:function (result) {
            if (result){
                alert("操作成功！！！");
                reload();
            }else{
                alert("操作失败！！！");
            }
        }
    })
}




