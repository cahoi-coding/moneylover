package app.moneylover.repositories

import app.moneylover.models.User
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import app.moneylover.services.DatabaseConnection as Database;

object UserRepository
{
    @JvmStatic val statement: Statement = Database.connection.createStatement();

    @JvmStatic fun getUser(id: Int): User?
    {
        if (id == -1)
        {
            return null;
        }
        try
        {
            val query: String =
                "SELECT * FROM moneylover_db.users AS u " +
                "WHERE u.user_id = $id";

            print(query);

            val userResultSet = statement.executeQuery(query);
            userResultSet.next();

            val userId: UInt = userResultSet.getInt("user_id").toUInt();
            val userFullName: String = userResultSet.getString("full_name");
            val userAvatar: String = userResultSet.getString("avatar");

            return User(userId, userFullName, userAvatar);
        }
        catch (ex: SQLException) { return null; }
    }
}