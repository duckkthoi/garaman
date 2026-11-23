<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, garaman.config.DBConnection" %>
<%
    try (Connection c = DBConnection.getDataSource().getConnection();
         Statement st = c.createStatement();
         ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM tblItem")) {
        rs.next();
        out.println("Số item trong DB: " + rs.getInt(1));
    }
%>