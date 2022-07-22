<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Read</h1>
    </div>
</div>
<%--/.row--%>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">

            <div class="panel-heading">Board Read Page</div>
            <div class="panel-body">

                <div class="form-group">
                    <label>Bno</label>
                    <input class="form-control" name="bno"
                           value="<c:out value="${board.bno}"/>" readonly="readonly">
                </div>

                <div class="form-group">
                    <label>Title</label>
                    <input class="form-control" name="title"
                           value="<c:out value="${board.title}" />" readonly="readonly">
                </div>

                <div class="form-group">
                    <label>Text Area</label>
                    <input class="form-control" name="content"
                           value="<c:out value="${board.content}" />" readonly="readonly">
                </div>

                <div class="form-group">
                    <label>Writer</label>
                    <input class="form-control" name="writer"
                           value="<c:out value="${board.writer}" />" readonly="readonly">
                </div>

                <button data-oper="modify" class="btn btn-default"
                onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">MODIFY</button>
                <button data-oper="list" class="btn btn-info"
                onclick="location.href='/board/list'">LIST</button>

            </div>
            <%-- panel-body --%>
        </div>
        <%-- panel-body --%>
    </div>
    <%-- panel --%>
</div>
<%-- /.row --%>
<%@ include file="../includes/footer.jsp" %>