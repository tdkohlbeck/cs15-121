class TrafficLight {
	enum Light { RED, YELLOW, GREEN }
	Light light;
}

public class TrafficLightTest {
	public static void main(String args[]) {
		TrafficLight one = new TrafficLight();
		one.light = TrafficLight.Light.RED;
		System.out.println("Currently: " + one.light);
	}
}
