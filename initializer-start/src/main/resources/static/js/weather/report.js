/**
 *report下拉框事件
 */
$(function(){
    $("#select").change(function(){
        var cityId=$("select").val();
        var url="/weatherDemo/report/cityId/"+cityId;
        window.location.href=url;

    })
})