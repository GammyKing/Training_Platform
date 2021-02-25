$(function (){
    Load();
})
function reLoad(){
    $("#queryAllUser").bootstrapTable("refresh");
}

function Load(){
    let url = BASIC_URL+"queryuser";
    $("#queryAllUser").bootstrapTable({
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
            // {
            //     title: 'id',
            //     align: "center",
            //     halign: "center",
            //     field: "id",
            //     width: "300px"
            //     /* formatter:function (value,row,index){
            //          return index+1;
            //      }*/
            //
            // },
            {
                title:'用户账号',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'acc'
            },
            {
                title:'用户名',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field:'username'

            },
            {
                title:'用户密码',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field:'pwd'

            },
            {
                title:'用户手机号',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field:'phone'

            },
            {
                title:'用户邮箱',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field:'email'

            },
            {
                title:'用户创建时间',
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
                    let a = '<a href="javascript:void(0);" onclick="deleteUser(\''+row.acc+'\')">删除</a>'
                    // let b ='<a href="javascript:void(0);" onclick="layerClick()" onclick="modifyInfo(\''+row.id+'\',\''+row.examname+'\',\''+row.createtime+'\'"></a>'
                    let c = '<a href="javascript:void(0);" onclick="setUser(\''+row.acc+'\',\''+row.username+'\',\''+row.pwd+'\',\''+row.phone+'\',\''+row.email+'\',\''+row.createtime+'\')">修改</a>'
                    return a+" "+" "+c;
                }
            }]
    })
}

//删除用户
function deleteUser(acc){
    let jsonData={};
    jsonData.acc=acc;
    // let arr=new Array();
    // arr.push(jsonData);
    $.ajax({
        url:BASIC_URL+"deleteuser",
        type:"post",
        contentType:"application/json",
        dataType: "json",
        data:JSON.stringify(jsonData),
        success:function (result){
            if (result){
                reLoad();
            }else{
                alert("删除失败！！！")
            }
        }
    })
}

//修改用户
function setUser(user_acc,user_name,user_pwd,user_phone,user_email,user_createtime){
    localStorage.setItem("user_acc",user_acc);
    localStorage.setItem("user_name",user_name);
    localStorage.setItem("user_pwd",user_pwd);
    localStorage.setItem("user_phone",user_phone);
    localStorage.setItem("user_email",user_email);
    localStorage.setItem("user_createtime",user_createtime);
    window.location.href="updateUser.html"
}
