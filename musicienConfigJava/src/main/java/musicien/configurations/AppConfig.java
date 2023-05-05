package musicien.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import musicien.beans.Instrument;
import musicien.beans.Musicien;
import musicien.beans.Saxophone;
import musicien.beans.Saxophoniste;

@Configuration
@ComponentScan({ "musicien.beans", "musicien.aspects" })
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean("saxophone")
	public Instrument saxophone() {
		return new Saxophone();
	}

	@Bean
	public Musicien saxophoniste(@Qualifier("saxophone") Instrument instrument) {
		Saxophoniste saxophoniste = new Saxophoniste();
		saxophoniste.setInstrument((Saxophone) instrument);
		return saxophoniste;
	}
}
