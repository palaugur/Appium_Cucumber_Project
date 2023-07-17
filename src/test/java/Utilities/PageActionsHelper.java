package Utilities;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class PageActionsHelper extends GWD{

public void performScroll(String direction){

    if (direction.equalsIgnoreCase("down")){
        Dimension size = getAndroidDriver().manage().window().getSize();
        //System.out.println(size);
        int startX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.8);
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.1);
        swipeWithCoordinates(startX,startY,endX,endY);
    } else if (direction.equalsIgnoreCase("right")) {
        Dimension size = getAndroidDriver().manage().window().getSize();
        //System.out.println(size);
        int startX = (int) (size.getWidth() * 0.9);
        int startY = (int) (size.getHeight() * 0.8);
        int endX = (int) (size.getWidth() * 0.1);
        int endY = startY;
        swipeWithCoordinates(startX,startY,endX,endY);

    }else {
        System.out.println("Invalid direction!");
    }
}
    public void swipeWithCoordinates(int startX, int startY, int endX, int endY){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofSeconds(1)))
                .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getAndroidDriver().perform(Collections.singletonList(sequence));
    }
    public void dragAndDrop(){
        String leftCenterRight = "lcr";

        for (int i = 1; i <=3 ; i++) {
            for (int j = 0; j < leftCenterRight.length(); j++) {

                char ch = leftCenterRight.charAt(j);

                WebElement source = getAndroidDriver().findElement(AppiumBy.accessibilityId("drag-"+ch+i));
                WebElement target = getAndroidDriver().findElement(AppiumBy.accessibilityId("drop-"+ch+i));

                Point sourceElementCenter = new Point(source.getLocation().getX() + source.getSize().getWidth() / 2 , source.getLocation().getY() + source.getSize().getHeight() / 2);
                Point targetElementCenter = new Point(target.getLocation().getX() + target.getSize().getWidth() / 2 , target.getLocation().getY() + target.getSize().getHeight() / 2);

                PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
                Sequence sequence = new Sequence(finger1, 1)
                        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
                        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(new Pause(finger1, Duration.ofMillis(100)))
                        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), targetElementCenter))
                        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                getAndroidDriver().perform(Collections.singletonList(sequence));
            }
        }

    }
}
