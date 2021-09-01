package testUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.services.TvShowService;

class Test1 {

	@Autowired
	TvShowService tvShowService;
	
	
	@Test
	public void test() throws NetflixException{
		
	long id = 1;	
	String aux= "Juego de tronos";


	String nametv = tvShowService.getTvShowById(id).getName();

		assertEquals("Juego de tronos",aux);
		
	}

}
