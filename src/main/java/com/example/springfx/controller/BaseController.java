package com.example.springfx.controller;

import com.example.springfx.navigator.Navigator;
import com.example.springfx.stagestore.StageStore;
import javafx.application.Platform;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseController {
    private final Navigator navigator;
    private final StageStore stageStore;

    public BaseController(Navigator navigator, StageStore stageStore) {
        this.navigator = navigator;
        this.stageStore = stageStore;
    }

    protected <CONTROLLER extends BaseController> void navigate(Class<CONTROLLER> controllerClass) {
        Platform.runLater(() -> navigator.navigate(controllerClass, stageStore.getCurrentStage()));
    }


}
