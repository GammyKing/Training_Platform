$(function (){
    load();
})

function reload(){
    $("#myTable").bootstrapTable("refresh");
}

function load(){
    let url = BASIC_URL+"selectStuUser";
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
                title: '学生id',
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
                title:'学生姓名',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'stuname'
            }, {
                title:'实习公司',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'company'
            },{
                title:'论文成绩',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'score'
            },{
                title:'实习成绩',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'companyscore'
            },{
                title:'导师',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'tutor'
            },{
                title:'创建时间',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'createtime'
            },
            {
                title:'操作',
                align:"center",//水平居中
                halign:"center",//垂直居中
                formatter:function (value,row,index) {
                    let a = '<a href="javascript:void(0);" onclick = "modifyUser(\''+row.id+'\',\''+row.pwd+'\',\''+row.stuname+'\',\''+row.tutor+'\')">修改  </a>'
                    let b = '<a href="javascript:void(0);" onclick = "deleteUser(\''+row.id+'\')">删除  </a>'
                    // let c = '<a href="javascript:void(0);" onclick = "registeCompany(\''+row.id+'\')">录入实习单位</a>'
                    return a+b;
                }

            }]
    })
}

function modifyUser(id,pwd,stuname,tutor) {
    layer.open({
        type:2,
        title:"score",
        maxmin:false,
        shapeClose:false,
        area:['80%','80%'],
        content:'ModifyUser.html',
        success:function (layero,index) {
            localStorage.setItem("stuid",id);
            let childBody = layer.getChildFrame('body',index);
            $(childBody).find('.id').text(id);
            $(childBody).find('.pwd').text(pwd);
            $(childBody).find('.name').text(stuname);
            $(childBody).find('.tutor').text(tutor);

        }
    })
}

function deleteUser(id) {
    let jsonData={};
    jsonData.id = id;
    $.ajax({
        url:BASIC_URL+"deleteStuUser",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(jsonData),
        dataType:"json",
        success:function (result) {
            if (result){
                alert("操作成功！！！");
            }else{
                alert("操作失败！！！");
            }
        }
    })
}


/*function registeCompany(id) {
    layer.open({
        type:2,
        title:"score",
        maxmin:false,
        shapeClose:false,
        area:['80%','80%'],
        content:'ModifyUser.html',
        success:function (layero,index) {
            localStorage.setItem("stuid",id);
        }
    })
}*/


