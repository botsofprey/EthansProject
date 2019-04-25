
public class PIDTester {

	public static void main(String[] args) {
		double kp = 0.2;
		double ki = 0;
		double kd = 0;
		PIDController controller = new PIDController(kp, ki, kd);
		controller.setSp(10);
		for(double q = -50; q < 50; q++) {
			System.out.println(controller.calculatePID(q));
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
