$(function (){
    load();
})

function reload(){
    $("#myTable").bootstrapTable("refresh");
}

function load(){
    let url = BASIC_URL+"showStuQuestion";
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
                //此时id为老师的id
                id: localStorage.getItem("id")
            };
            return JSON.stringify(temp);
        },
        columns:[
            {
                title: '学生学号',
                align: "center",
                halign: "center",
                field: "id",
                width: "300px"
            },{
                title:'问题',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'question'
            }, {
                title:'答案',
                align:"center",//水平居中
                halign:"center",//垂直居中
                field: 'answer'
            },
            {
                title:'操作',
                align:"center",//水平居中
                halign:"center",//垂直居中
                formatter:function (value,row,index) {
                    let score = '<a href="javascript:void(0);" onclick = "Pscore(\''+row.id+'\',\''+row.question+'\')">回答</a>'
                    return score;
                }

            }]
    })
}

function Pscore(id,question) {
    layer.open({
        type:2,
        title:"答疑",
        maxmin:false,
        shapeClose:false,
        area:['80%','80%'],
        content:'AnswerQuestion.html',
        success:function (layero,index) {
            localStorage.setItem("stuid",id);
            localStorage.setItem("question",question);
        }
    })
}



