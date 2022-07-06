package app.moneylover

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

import app.moneylover.services.DatabaseConnection as Database;

class Index : Application()
{
    override fun start(stage: Stage) 
    {
        val fxmlLoader = FXMLLoader(Index::class.java.getResource("login.fxml"))
        val scene = Scene(fxmlLoader.load())

        stage.scene = scene

        stage.show()
    }
}

fun main() 
{
    Application.launch(Index::class.java);
}