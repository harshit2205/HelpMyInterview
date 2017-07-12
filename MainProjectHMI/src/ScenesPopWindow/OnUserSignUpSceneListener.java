package ScenesPopWindow;

import Dao.UserDAO;
import Models.User;
import Models.UserLab;
import Stages.PopUpStage;
import javafx.scene.control.*;

/**
 * Created by staLker on 07-07-2017.
 */
public class OnUserSignUpSceneListener {
    public static void listen(TextField firstNameTextField, TextField lastNameTextField, TextField eMailTextField, TextField contactTextField, ToggleGroup genderToggleGroup, TextField usernameTextField, PasswordField passwordTextField, PasswordField repeatPasswordTextField, ComboBox<String> statesComboBox, ComboBox<String> cityComboBox, Button registerButton) {

        registerButton.setOnAction(e -> {
            User user = new User();
            user.setUserDetails(
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    eMailTextField.getText(),
                    Long.parseLong(contactTextField.getText()),
                    genderToggleGroup.getSelectedToggle().getUserData().toString(),
                    usernameTextField.getText(),
                    passwordTextField.getText(),
                    statesComboBox.getValue(),
                    cityComboBox.getValue()
                    );


            UserDAO.getUserDAOInstance().insertUser(user);

            UserLab.get().getUserList().add(user);
            PopUpStage.getWindow().close();
        });
    }
}
