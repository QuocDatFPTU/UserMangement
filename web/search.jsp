<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Bootstrap Simple Data Table</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <!-- Font Awesome -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <!-- MDB -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.css"
            rel="stylesheet"
            />
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Roboto', sans-serif;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                min-width: 1200px;
                background: #fff;
                padding: 20px;

            }
            .table-title {
                padding-bottom: 10px;
                margin: 0 0 10px;
                min-width: 100%;
            }
            .table-title h2 {
                margin: 8px 0 0;
                font-size: 22px;
            }

            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td:last-child {
                width: 120px;
            }
            table.table td a {
                color: #a0a5b1;
                display: inline-block;
                margin: 0 5px;
            }
            table.table td a.view {
                color: #03A9F4;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #E34724;
            }
            table.table td i {
                font-size: 19px;
            }    




        </style>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <c:if test="${sessionScope.LOGIN_USER.roleID == 1}">
        <body>
            <div class="container-xl">
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-8"><h2>User <b>Details</b></h2></div>
                                <div class="col-sm-8">
                                    <h2>Hello ${sessionScope.LOGIN_USER.getName()}</h2>
                                </div>
                                <div class="col-sm-8 mb-4">
                                    <c:url var="logoutLink" value="MainController">
                                        <c:param name="action" value="Logout"></c:param>
                                    </c:url>
                                    <a href="${logoutLink}" class="btn btn-primary btn-sm mt-3">Logout</a>
                                </div>
                                <div class="col-sm-4">
                                    <!---Search box --->
                                    <form action="MainController">
                                        <div class="input-group">
                                            <input type="text" class="form-control rounded" placeholder="Search" aria-label="Search"
                                                   aria-describedby="search-addon" name="search" value="${param.search}"/>
                                            <button type="submit" class="btn btn-outline-primary" name="action" value="Search">search</button>
                                        </div>
                                    </form>
                                    <!---End of Search box --->
                                </div>
                            </div>
                        </div>

                        <c:if test="${requestScope.LIST_USER != null}">
                            <c:if test="${not empty requestScope.LIST_USER }">
                                <table class="table table-striped table-hover table-bordered">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>User ID </th>
                                            <th>Name</th>
                                            <th>Password </th>
                                            <th>Phone </th>
                                            <th>Address</th>
                                            <th>Create Date</th>
                                            <th>Role</th>
                                            <th>Status</th>
                                            <th>Update</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="user" items="${requestScope.LIST_USER}" varStatus="counter">
                                        <form action="MainController">
                                            <tr>
                                                <td>${counter.count}</td>
                                                <td>${user.userID}</td>
                                                <td>
                                                    <input type="text" name="name" value="${user.name}"/>
                                                </td>
                                                <td>${user.password}</td>
                                                <td>
                                                    <input type="text" name="phone" value="${user.phone}"/>
                                                </td>
                                                <td>
                                                    <input type="text" name="address" value="${user.address}"/>
                                                </td>
                                                <td>${user.createDate}</td>
                                                <td>
                                                    <c:if test="${user.roleID == 1}">
                                                        AD
                                                    </c:if>
                                                    <c:if test="${user.roleID == 2}">
                                                        US
                                                    </c:if>     
                                                </td>
                                                <td> 
                                                    <c:if test="${user.statusID == 1}">
                                                        Active
                                                    </c:if>
                                                    <c:if test="${user.statusID == 0}">
                                                        Disable
                                                    </c:if>                                 
                                                </td>                                       
                                                <td>
                                                    <input type="hidden" name="userID" value="${user.userID}"/>
                                                    <input type="submit" class="btn btn-primary btn-sm" name="action" value="Update"/>                                      
                                                    <input type="hidden" name="search" value="${param.search}"/>  
                                                </td>
                                                <td>
                                                    <c:url var ="deleteLink" value="MainController">
                                                        <c:param name="action" value="Delete"/>
                                                        <c:param name="userID" value="${user.userID}"/>
                                                        <c:param name="search" value="${param.search}"/>
                                                    </c:url> 
                                                    <a href="${deleteLink}" class="btn btn-primary btn-sm" >Delete</a>  
                                                </td>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>    
                        </c:if>

                    </div>
                </div>  
            </div>   
        </body>
    </c:if>
    <c:if test="${sessionScope.LOGIN_USER.roleID != 1}">
        <c:redirect url="user.jsp"/>
    </c:if>
</html>