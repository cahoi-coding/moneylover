package app.moneylover.controllers

import app.moneylover.Router
import javafx.event.ActionEvent
import javafx.fxml.FXML;

open class BaseController
{
//    constructor(){}
    @FXML fun switchToSceneLogin(event: ActionEvent)
    { Router.switchScene(event, 0); }

    @FXML fun switchToSceneHome(event: ActionEvent)
    { Router.switchScene(event, 1); }

    @FXML fun switchToSceneMyWallets(event: ActionEvent)
    { Router.switchScene(event, 2); }

    @FXML fun switchToSceneTransactions(event: ActionEvent)
    { Router.switchScene(event, 3); }

    @FXML fun switchToSceneStatistical(event: ActionEvent)
    { Router.switchScene(event, 4); }
}