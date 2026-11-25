package garaman.view;

import garaman.model.Customer;
import garaman.model.Item;
import garaman.model.Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class ViewHelper {
    public static final String LOGGED_IN_CUSTOMER = "loggedInCustomer";
    private static final String LOGIN_PAGE = "/view/member/login.jsp";

    private ViewHelper(){

    }

    public static Customer loggedInCustomer(HttpSession session){
        Object customer = session == null ? null : session.getAttribute(LOGGED_IN_CUSTOMER);
        return customer instanceof Customer c ? c : null;
    }

    public static boolean requireCustomer(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        if(loggedInCustomer(request.getSession(false)) != null){
            return true;
        }
        redirectToLogin(request, response);
        return false;
    }

    public static void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
    }

    public static String esc(Object value){
        if(value == null){
            return "";
        }
        String s = value.toString();
        StringBuilder sb = new StringBuilder(s.length());
        for(char c : s.toCharArray()){
            switch (c){
                case '<' -> sb.append("&lt;");
                case '>' -> sb.append("&gt;");
                case '&' -> sb.append("&amp;");
                case '"' -> sb.append("&quot;");
                case '\'' -> sb.append("&#39;");
                default -> sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String encode(String value){
        return URLEncoder.encode(value == null ? "" : value, StandardCharsets.UTF_8);
    }

    public static String itemCode(Item item){
        return (item instanceof Service ? "DV" : "PT") + String.format("%02d", item.getId());
    }

    public static String itemType(Item item) {
        return item instanceof Service ? "Dịch vụ" : "Phụ tùng";
    }

    public static String formatPrice(BigDecimal price) {
        if (price == null) {
            return "";
        }
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        return new DecimalFormat("#,##0", symbols).format(price) + " đ";
    }
}
