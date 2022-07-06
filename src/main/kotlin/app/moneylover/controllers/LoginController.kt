package app.moneylover.controllers

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.event.ActionEvent;

import app.moneylover.repositories.AccountRepository;
import app.moneylover.Router;

class LoginController
{
    @FXML private lateinit var loginBtn: Button;

    @FXML private lateinit var userNameField: TextField;
    @FXML private lateinit var passwordField: TextField;

    @FXML fun login(event: ActionEvent): Boolean
    {
        val userName: String = this.userNameField.text;
        val password: String = this.passwordField.text;

        val userId: Int = AccountRepository.getAccount(userName, password)?.id?.toInt() ?: -1;

        if (userId == -1)
        {
            print("wrong bitches");
            return false;
        }

        Router.switchScene(event, 1);
        return true;
    }
}