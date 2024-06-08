package myFoodora.Test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import myFoodora.model.LecteurScenario;

public class LecteurScenarioTest {

	@Test
	public void testRunFileScénario() throws IOException {
		LecteurScenario.runFileScénario("Scénarios/scénario1.txt");
	}

}
