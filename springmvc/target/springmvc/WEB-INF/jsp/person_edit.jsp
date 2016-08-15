<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="static/ace/css/chosen.css"/>
    <link rel="stylesheet" href="static/ace/css/datepicker.css"/>
    <script src="js/jquery-1.9.1.min.js"></script>
    <script src="js/json2.js"></script>
    <script>
        $(document).ready(function () {
            $('#btnAdd').bind("click", function () {
                var p = new Object();
                p.NAME = $('#NAME').val();
                p.GENDER = $('#GENDER').val();

                $.ajax({
                    type: "POST",
                    url: "/springmvc/person/save1.dsf",
                    contentType: "application/json",
                    data: JSON.stringify(p),
                    success: function (data) {
                        console.log(data);
                    }
                });
            });
        });
    </script>
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <form action="person/save1.do" name="Form" id="Form" method="post">
                            <div id="zhongxin" style="padding-top: 13px;">
                                <table id="table_report" class="table table-striped table-bordered table-hover">
                                    <tr>
                                        <td style="width:75px;text-align: right;padding-top: 13px;">姓名:</td>
                                        <td><input type="text" name="NAME" id="NAME" value="${pd.NAME}" maxlength="255"
                                                   placeholder="这里输入姓名" title="姓名" style="width:98%;"/></td>
                                    </tr>
                                    <tr>
                                        <td style="width:75px;text-align: right;padding-top: 13px;">性别:</td>
                                        <td><input type="text" name="GENDER" id="GENDER" value="${pd.GENDER}"
                                                   maxlength="255" placeholder="这里输入性别" title="性别" style="width:98%;"/>
                                        </td>
                                    </tr>
                                </table>
                                <input id="btnAdd" type="button" value="Submit"/>
                            </div>
                        </form>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.page-content -->
        </div>
    </div>
    <!-- /.main-content -->
</div>
<!-- /.main-container -->
</body>


</html>