<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Tables</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    BoardList Page
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="panel-body">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>#번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일</th>
                                <th>수정일</th>
                            </tr>
                            </thead>
                                <%-- 왜 c:forEach 안먹지... 코드상으로는 전혀 이상할 거 없는데?--%>
<%--                            <c:forEach items="${list}" var="board">--%>
<%--                                <tr>--%>
<%--                                    <td><c:out value="${board.bno}"/></td>--%>
<%--                                    <td><c:out value="${board.title}"/></td>--%>
<%--                                    <td><c:out value="${board.writer}"/></td>--%>
<%--                                    <td><fmt:formatDate pattern="yyyy-MM-dd"--%>
<%--                                                        value="${board.regdate}"/></td>--%>
<%--                                    <td><fmt:formatDate pattern="yyyy-MM-dd"--%>
<%--                                                        value="${board.modDate}"/></td>--%>
<%--                                </tr>--%>
<%--                            </c:forEach>--%>
                        </table>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <%--  /.page-wrapper  --%>
    <%@ include file="../includes/footer.jsp" %>
