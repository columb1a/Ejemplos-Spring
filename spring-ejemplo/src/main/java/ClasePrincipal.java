import juggler.Juggler;
import interfaces.Performer;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import auditorium.Auditorium;

public class ClasePrincipal {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		// cambiar segun se necesite llamar a un bean
		// Performer performer = (Performer) ctx.getBean("poeticDuke");
		// performer.perform();

		/*
		 * Se llama al bean "auditorium". Esto gatilla que justo después de su
		 * creación se utilice el método "turnOnLights" enganchado al
		 * init-method
		 */
		Auditorium auditorium = (Auditorium) ctx.getBean("auditorium");

		/*
		 * Se llama al bean "kenny_playing_instruments" al cual se le inyectaron
		 * dependecias a traves de setters y getters
		 */
		Performer performer = (Performer) ctx
				.getBean("kenny_playing_instruments");
		performer.perform();

		/*
		 * Se destruye el bean auditorium. Esto gatilla que justo antes de su
		 * destrucción se utilice el método "turnOffLights" enganchado al
		 * destroy-method
		 */
		BeanDefinitionRegistry factory = (BeanDefinitionRegistry) ctx
				.getAutowireCapableBeanFactory();
		factory.removeBeanDefinition("auditorium");

	}
}
