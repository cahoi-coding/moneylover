@file:Suppress("NAME_SHADOWING")

package app.moneylover.repositories

import app.moneylover.models.Account
import java.sql.SQLException;
import java.sql.Statement;

import app.moneylover.services.DatabaseConnection as Database;

object AccountRepository
{
    @JvmStatic val statement: Statement = Database.connection.createStatement();

    @JvmStatic fun getAccount(userName: String, password: String): Account?
    {
        val accountId: UInt;

        return try {
            val query: String =
                "SELECT * FROM moneylover_db.accounts as acc " +
                        "WHERE acc.user_name = '$userName' AND acc.password = '$password' ";

            val accountResultSet = statement.executeQuery(query);
            accountResultSet.next();

            val accountId: UInt = accountResultSet.getInt("id").toUInt();
            val userName: String = accountResultSet.getString("user_name").toString();
            val password: String = accountResultSet.getString("password").toString();

            Account(accountId, userName, password);

        } catch (ex: SQLException) { null }
    }
}