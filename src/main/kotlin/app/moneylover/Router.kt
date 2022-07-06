package app.moneylover

import javafx.event.ActionEvent
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Scene
import javafx.stage.Stage

object Router
{
    @JvmStatic val routes: Array<String> = arrayOf(
        "login",
        "home",
        "my-wallets",
        "transactions"
    );

    @JvmStatic fun switchScene(event: ActionEvent, pageIndex: Int, passedData: Any? = null)
    {
        val fxmlLocation = Router::class.java.getResource("${routes[pageIndex]}.fxml");
        val fxmlLoader = FXMLLoader(fxmlLocation);

        val stage: Stage = (event.source as Node).scene.window as Stage;
        val scene = Scene(fxmlLoader.load());

        stage.scene = scene;
        stage.show();
    }
}