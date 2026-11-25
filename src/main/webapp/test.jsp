<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, garaman.config.DBConnection" %>
<%@ page import="garaman.dao.*, garaman.config.DBConnection" %>
<%= new ItemDAO(DBConnection.getDataSource()).search("dau").size() %>
<%= new MemberDAO(DBConnection.getDataSource()).checkCustomerLogin("0901234567", "123456") %>