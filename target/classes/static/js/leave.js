$(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    initlaydate();
    $(".radio-inline").change(function () {


        checkval = $("input[name='type']:checked").val();

        console.log(checkval);
        if (checkval == 3) {
            $("#otherdiv").show("slow");
        } else {
            $("#otherdiv").hide("slow");
        }
    });

});

var checkval = "1";

/*function initlaydate() {
	//日期范围限制
	var start = {
		elem : '#start',
		format : 'YYYY/MM/DD hh:mm:ss',
		min : laydate.now(), //设定最小日期为当前日期
		max : '2099-06-16 23:59:59', //最大日期
		istime : true,
		istoday : false,
		choose : function(datas) {
			end.min = datas; //开始日选好后，重置结束日的最小日期
			end.start = datas //将结束日的初始值设定为开始日
		}
	};
	var end = {
		elem : '#end',
		format : 'YYYY/MM/DD hh:mm:ss',
		min : laydate.now(),
		max : '2099-06-16 23:59:59',
		istime : true,
		istoday : false,
		choose : function(datas) {
			start.max = datas; //结束日选好后，重置开始日的最大日期
		}
	};
	laydate(start);
	laydate(end);
}*/

function toDate(id) {
    var now = "";
    var x = $(id).val();
    now += (parseInt(x.substring(0, 4)));
    now += "-";
    now += (parseInt(x.substring(5, 7)));
    now += "-";
    now += (parseInt(x.substring(8, 10)));
    now += " ";
    now += (parseInt(x.substring(11, 13)));
    now += ":";
    now += (parseInt(x.substring(14, 16)));
    return now;
}


function submitleave() {

    if ($('#start').val().length == "" || $('#end').val().length == "" || $('#reason').val().length == "" || $('input:radio:checked').val().length == "") {
        alert("信息不能为空");
        return;
    }
    var str = {
        "leaveType": $('input:radio:checked').val(),
        "starttime": toDate("#start"),
        "endtime": toDate("#end"),
        "leaveReason": $('#reason').val()
    };
    $.ajax({
        url: "/my/addleave",
        type: "post",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(str),
        success: function (data) {
            if (data.info == "提交成功") {
                alert("已提交,请等待领导审核");
                window.location.reload();
            }
        }
    });
}


function toform() {
    $("#leaveformdiv").show("slow");
    $("#leavetable").hide("slow");
    $("#btnform").attr("class", "btn btn-w-m btn-danger");
    $("#btntable").attr("class", "btn btn-w-m btn-default");
}

function totable() {
    $("#leaveformdiv").hide("slow");
    $("#leavetable").show("slow");
    $("#btnform").attr("class", "btn btn-w-m btn-default");
    $("#btntable").attr("class", "btn btn-w-m btn-danger");
    toSomePage(1);

}

/*$(function () {
    toSomePage(1);
});*/

//每次调用此函数都发送一次请求，变量pn是默认开始页面
function toSomePage(pn) {
    $.ajax({
        url: "/my/getleave", type: "post",
        data: "pn=" + pn,
        success: function (result) {
            build_user_table(result);//构建用户表格
            build_pagination_info(result);//构建分页信息
            build_pagination_nav(result);//构建分页导航
        }
    })
};
var array = new Array();

function build_user_table(result) {
    //先清空表格，不然会直接回追加到上次查询结果上
    $("dept").empty();
    //获取服务器返回的json数据
    var departments = result.info.pageInfo.list;
    dept = "";
    //$.each()是jquery的遍历方法
    $.each(departments, function (index, item) {
        array.push(item.leaveId);
        dept += "<tr><td id='leaveId'>" + item.leaveId + "</td>";
        dept += "<td id='staffId'>" + item.leaveStaffId + "</td>";
        dept += "<td id='staffName'>" + item.leaveStaffName + "</td>";
        dept += "<td id='leaveType'>" + item.leaveType + "</td>";
        dept += "<td id='leaveReason'>" + item.leaveReason + "</td>";
        dept += "<td id='starttime'>" + item.starttime + "</td>";
        dept += "<td id='endtime'>" + item.endtime + "</td>";
        dept += "<td id='leaveStatus'>" + item.leaveStatus + "</td></tr>";
    });
    $("#dept").html(dept);
}

/**
 创建分页信息
 */
function build_pagination_info(result) {
    $("#dataTableExample_info").empty();
    //得到服务器返回的jason数据里的分页信息，然后拼接
    var pageNum = result.info.pageInfo.pageNum;
    var pageSize = result.info.pageInfo.pages;
    var total = result.info.pageInfo.total;
    $("#dataTableExample_info").append("当前" + pageNum + "页,共" + pageSize + "页,总" + total + "条记录")
}

/**
 创建分页导航条：
 根据bootstrap文档里的分页说明，使用jquery创建元素。
 */

function build_pagination_nav(result) {
    $("#dataTableExample_paginate").empty();
    //首页
    var fristPageLi = $("<li></li>").append($("<a></a>").attr("href", "javacript:void(0);").append("首页"));
    //前一页
    var prePageLi = $("<li></li>").append($("<a></a>").attr("href", "javacript:void(0);").append($("<span></span>").append("&laquo;")));
    //如果没有前一页，就让按钮不能被点击,否则绑定点击事件，重新发送ajax请求，访问相应页面
    if (result.info.pageInfo.hasPreviousPage == false) {
        fristPageLi.addClass("disable");
        prePageLi.addClass("disable");
    } else {
        fristPageLi.click(function () {
            toSomePage(1);
        });
        prePageLi.click(function () {
            toSomePage(result.info.pageInfo.pageNum - 1);
        });
    }
    var ul = $("<ul class=\"pagination\" style=\"float: right\"></ul>").addClass("pagination").append(fristPageLi).append(prePageLi);
    $.each(result.info.pageInfo.navigatepageNums, function (index, element) {

        var numLi = $("<li></li>").append($("<a></a>").attr("href", "javacript:void(0);").append(element));

        //如果遍历的页码等于当前页面，就高亮显示，然后添加点击事件，如果有点击，就重新发送ajax请求，访问当前页面（pn=element）
        if (result.info.pageInfo.pageNum == element) {
            numLi.addClass("active");
        }

        numLi.click(function () {
            toSomePage(element);
        })
        ul.append(numLi);
    })

    //下一页
    var nextPageLi = $("<li></li>").append($("<a></a>").attr("href", "javacript:void(0);").append($("<span></span>").append("&raquo;")));
    //末页
    var lastPageLi = $("<li></li>").append($("<a></a>").attr("href", "javacript:void(0);").append("末页"));
    //如果没有后一页，就让按钮不能被点击,否则绑定点击事件，重新发送ajax请求，访问相应页面
    if (result.info.pageInfo.hasNextPage == false) {
        nextPageLi.addClass("disable");
        lastPageLi.addClass("disable");
    } else {
        nextPageLi.click(function () {
            toSomePage(result.info.pageInfo.pageNum + 1);
        });
        lastPageLi.click(function () {
            toSomePage(result.info.pageInfo.pages);
        });
    }
    ul.append(nextPageLi).append(lastPageLi);
    $("<nav></nav>").append(ul).appendTo("#dataTableExample_paginate");
}




