package garaman.dao;

import garaman.model.Customer;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Optional;

public class MemberDAO extends DAO {

    private static final String SQL_LOGIN =
            "SELECT m.id, m.full_name, m.username, m.password, m.phone, m.email, c.address "
                    + "FROM tblMember m JOIN tblCustomer c ON c.member_id = m.id "
                    + "WHERE m.username = ?";

    public MemberDAO(DataSource dataSource){
        super(dataSource);
    }

    public Optional<Customer> checkCustomerLogin(String username, String password) throws SQLException{

        return null;
    }
}
