package app.moneylover.controllers

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import java.net.URL
import java.util.*

//import app.moneylover.repositories.AccountRepository as Accounts
import app.moneylover.repositories.UserRepository as Users;
import app.moneylover.models.Account;

class HomeController() : BaseController(), Initializable
{
    @FXML private lateinit var fullNameLabel: Label;

    override fun initialize(url: URL?, resource: ResourceBundle?)
    {
        this.fullNameLabel.text = Users.getUser(Account.currentAccountId)?.fullName;
    }
}