import java.util.Scanner;

public class PIDController {

	private static double Kp = 0, Ki = 0, Kd = 4, error = 0, deltaError = 0, prevError = 0, setPoint = 0,
			pointValue = 0, derivative = 0, curValue = 0;
	private static double p = 0;
	private static double i = 0;
	private static double d = 0;
	static double t = 0;
	public static double sum = 0;
	private static double deltaTime = 0;;
	private static long prevTime = 0;;

	public PIDController(double kp, double ki, double kd) {
		Kp = kp;
		Ki = ki;
		Kd = kd;
	}

	public void setSp(double sp) {
		setPoint = sp;
	}

	public double calculatePID(double pointValue) {
		deltaError = error - prevError;
//		System.out.println("delta error: " + deltaError);
		deltaTime = (double)(System.currentTimeMillis() - prevTime)/1000.0;
//		System.out.println("delta time: " + deltaTime);
		error = setPoint - pointValue;
//		System.out.println("error: " + error);
		p = Kp * error;
//		System.out.println("p: " + p);
		i += (Ki * error * deltaTime);
		derivative = deltaError / deltaTime;
		d = Kd * derivative;
		prevError = error;
		prevTime = System.currentTimeMillis();
		return p + i + d;

	}
}
