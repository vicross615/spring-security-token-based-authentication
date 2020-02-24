package admin.portal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.logging.Logger;

@SpringBootApplication
public class AdminApplication {
	private final static Logger LOGGER = Logger.getLogger(AdminApplication.class.getName());


	@Value("${server.port}")
	private int port;

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onAppStarted() throws IOException {

	}

}

