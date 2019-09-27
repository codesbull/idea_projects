layui.use('jquery', function () {
    var $ = layui.jquery;

    /**
     * 获取数据ajax请求
     */
    $.getJSON = function (url, data, callback) {
        $.ajax({
            url: url,
            type: "get",
            contentType: "application/json",
            dataType: "json",
            timeout: 10000,
            data: data,
            success: function (data) {
                callback(data);
            }
        });
    };

    /**
     * 提交json数据的post请求
     */
    $.postJSON = function (url, data, callback) {
        $.ajax({
            url: url,
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: data,
            timeout: 60000,
            success: function (msg) {
                callback(msg);
            },
            error: function (xhr, textstatus, thrown) {

            }
        });
    };

    /**
     * 修改数据的ajax请求
     */
    $.putJSON = function (url, data, callback) {
        $.ajax({
            url: url,
            type: "put",
            contentType: "application/json",
            dataType: "json",
            data: data,
            timeout: 20000,
            success: function (msg) {
                callback(msg);
            },
            error: function (xhr, textstatus, thrown) {

            }
        });
    };
    /**
     * 删除数据的ajax请求
     */
    $.deleteJSON = function (url, data, callback) {
        $.ajax({
            url: url,
            type: "delete",
            contentType: "application/json",
            dataType: "json",
            data: data,
            success: function (msg) {
                callback(msg);
            },
            error: function (xhr, textstatus, thrown) {

            }
        });
    };
});
