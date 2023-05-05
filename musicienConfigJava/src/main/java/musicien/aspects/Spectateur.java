package musicien.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import musicien.beans.Musicien;
import musicien.beans.Saxophoniste;

@Component
@Aspect
public class Spectateur {

	@Autowired
	@Qualifier("saxophoniste")
	private Musicien saxophoniste;

	@Pointcut("execution(public void musicien.beans.Musicien.performer())")
	public void performerMusicien() {

	}

	@Pointcut("execution(public void musicien.beans.Guitariste.performer())")
	public void performerGuitariste() {

	}

	@Pointcut("execution(public void musicien.beans.Saxophoniste.performer())")
	public void performerSaxophoniste() {

	}

	@Before("performerGuitariste()")
	public void before() {
		installation();
		couperTelephone();
	}

	private void couperTelephone() {
		System.out.println("les spectateurs coupent leur telephone");
	}

	private void installation() {
		System.out.println("les spectateurs s'installent");
	}

	@AfterReturning(pointcut = "performerMusicien()")
	public void bravo() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "performerMusicien()", throwing = "musicien.exceptions.FausseNoteException")
	public void huer() {
		System.out.println("pas content");
	}

	@After("performerGuitariste()")
	public void suivant() {
		System.out.println("suivant");
		saxophoniste.performer();
	}

	@After("performerSaxophoniste()")
	public void partir() {
		System.out.println("les spectateurs partent");
	}
}
