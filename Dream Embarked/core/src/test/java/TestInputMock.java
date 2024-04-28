package test.java;

import com.badlogic.gdx.Input;
import dreams.embarked.InputMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInputMock {
    @Test
    public void testSetKeyPressed() {
        InputMock inputMock = new InputMock();

        inputMock.setKeyPressed(Input.Keys.LEFT);

        assertTrue(inputMock.isKeyPressed(Input.Keys.LEFT));
    }
    @Test
    public void testSetKeyReleased() {
        InputMock inputMock = new InputMock();

        inputMock.setKeyReleased(Input.Keys.LEFT);

        assertFalse(inputMock.isKeyPressed(Input.Keys.LEFT));
    }
    @Test
    public void testEverythingElse() {
        // We don't use any of the other methods, but
        // we get a compiler error if we don't have them,
        // so this is for coverage.

        InputMock inputMock = new InputMock();

        inputMock.getAccelerometerX();
        inputMock.getAccelerometerY();
        inputMock.getAccelerometerZ();
        inputMock.setCursorPosition(0, 0);
        inputMock.isCursorCatched();
        inputMock.setCursorCatched(false);
        inputMock.getNativeOrientation();
        inputMock.getRotation();
        inputMock.isPeripheralAvailable(null);
        inputMock.getInputProcessor();
        inputMock.setInputProcessor(null);
        inputMock.isCatchKey(0);
        inputMock.setCatchKey(0, false);
        inputMock.isCatchMenuKey();
        inputMock.setCatchMenuKey(false);
        inputMock.isCatchBackKey();
        inputMock.setCatchBackKey(false);
        inputMock.getCurrentEventTime();
        inputMock.getRotationMatrix(null);
        inputMock.getRoll();
        inputMock.getPitch();
        inputMock.getAzimuth();
        inputMock.vibrate(0);
        inputMock.vibrate(null);
        inputMock.vibrate(0, false);
        inputMock.vibrate(0, 0, false);
        inputMock.setOnscreenKeyboardVisible(false);
        inputMock.setOnscreenKeyboardVisible(false, null);
        inputMock.getTextInput(null, null, null, null);
        inputMock.getTextInput(null, null, null, null, null);
        inputMock.isKeyJustPressed(0);
        inputMock.isButtonJustPressed(0);
        inputMock.isButtonPressed(0);
        inputMock.getPressure();
        inputMock.getPressure(0);
        inputMock.isTouched();
        inputMock.isTouched(0);
        inputMock.justTouched();
        inputMock.getX();
        inputMock.getX(0);
        inputMock.getDeltaX();
        inputMock.getDeltaX(0);
        inputMock.getY();
        inputMock.getY(0);
        inputMock.getDeltaY();
        inputMock.getDeltaY(0);
        inputMock.getMaxPointers();
        inputMock.getGyroscopeX();
        inputMock.getGyroscopeY();
        inputMock.getGyroscopeZ();
    }
}
