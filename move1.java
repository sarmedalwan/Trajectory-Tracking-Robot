import lejos.nxt.*;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import lejos.robotics.localization.OdometryPoseProvider ;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.objectdetection.RangeFeatureDetector;

import java.io.*;

/**
 * Created by sa16566 on 26/01/2018.
 */
public class move1 {
    public static void main(String[] args) {
        DifferentialPilot pilot = new DifferentialPilot(3.25, 20, Motor.A, Motor.C, false);  // parameters in inches
        OdometryPoseProvider opp = new OdometryPoseProvider (pilot) ;
        FileOutputStream out = null; // declare outside the try block
        File data = new File("coordinates.dat");

        try {
            out = new FileOutputStream(data);
        } catch(IOException e) {
            System.err.println("Failed to create output stream");
        }

        DataOutputStream dataOut = new DataOutputStream(out);
        pilot.setTravelSpeed(5);

        try {
            pilot.travel(100, true);         // cm
            while (pilot.isMoving()) {
                dataOut.writeChars(String.valueOf(opp.getPose()));
                System.out.println("pose = " + opp.getPose());
                System.out.println("Tacho Count:" + Motor.A.getTachoCount());
                Delay.msDelay(1000);
            }
            //try { Thread.sleep(2000); }
            //catch ( InterruptedException e ) {}
            pilot.rotate(-90);        // degrees clockwise
            pilot.travel(100, true);         // cm
            while (pilot.isMoving()) {
                dataOut.writeChars(String.valueOf(opp.getPose()));
                System.out.println("Pose: " + opp.getPose());
                System.out.println("Tacho Count:" + Motor.A.getTachoCount());
                Delay.msDelay(1000);
            }
            //try { Thread.sleep(2000); }
            //catch ( InterruptedException e ) {}
            pilot.rotate(-90);
            pilot.travel(100, true);         // cm
            while (pilot.isMoving()) {
                dataOut.writeChars(String.valueOf(opp.getPose()));
                System.out.println("pose = " + opp.getPose());
                System.out.println("Tacho Count:" + Motor.A.getTachoCount());
                Delay.msDelay(1000);
            }
            //try { Thread.sleep(2000); }
            //catch ( InterruptedException e ) {}
            pilot.rotate(-90);        // degrees clockwise
            pilot.travel(100, true);         // cm
            while (pilot.isMoving()) {
                dataOut.writeChars(String.valueOf(opp.getPose()));
                System.out.println("pose = " + opp.getPose());
                System.out.println("Tacho Count:" + Motor.A.getTachoCount());
                Delay.msDelay(1000);
            }
            //try { Thread.sleep(2000); }
            //catch ( InterruptedException e ) {}
            Delay.msDelay(20000);
            //try { Thread.sleep(20000); }
            //catch ( InterruptedException e ) {}
            pilot.stop();
            out.close();
        } catch (IOException e){
            System.out.println("IO Exception");
        }
    }
}

//public static class LCDDraw implements Runnable{
  //  @Override
    //public void run(){
      //  LCD.drawChar(".", -1*Math.round(x/10)*Math.round(y/12));
   // }
//}

//pilot.steer(-50, 180, true); // turn 180 degrees to the right
//pilot.steer(100);          // turns with left wheel stationary
//while (pilot.isMoving()) Thread.yield();