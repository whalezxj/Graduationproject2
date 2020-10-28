$(function () {
    getsalary();
});

function getsalary() {
    $.ajax({
        url: "/my/salary",
        type: "post",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {

            $("#staffId").text(data.info.salaryStaffId);
            $("#transnational").text(data.info.transportationAllowance);
            $("#lunch").text(data.info.lunchAllowance);
            $("#communication").text(data.info.communicationAllowance);
            $("#salaryBase").text(data.info.salaryBase);
            $("#workDay").text(data.info.salaryWorkDay);
            $("#bonus").text(data.info.salaryBonus);
            $("#salaryTotal").text(data.info.salaryTotal);
        }
    });
}
