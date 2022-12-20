package consoCarbone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlimentationTest {
	private static ConsoCarbone tested1;
	private static ConsoCarbone tested2;

	@Test
	void comparer_twoAlimentation_compareTheImpacts() {
		tested1 = new Alimentation(0.3,0.7);
		tested2 = new Alimentation(0.4,0.6);
		
		int result = tested1.compare(tested1, tested2);
		
		assertEquals(2 /*resultat attendu*/, result);
	}

}
