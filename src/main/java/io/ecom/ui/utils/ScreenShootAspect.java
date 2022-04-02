package io.ecom.ui.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ScreenShootAspect {

    @After(("@annotation(io.qameta.allure.Step) && execution(* *(..))"))
    public void takeScreenshotAfterStep(final JoinPoint joinPoint) {
        AllureAttachmentUtils.screenshotForAllure();
    }

}
