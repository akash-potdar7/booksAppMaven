package com.akash.booksApp.app;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

public class CustomContainer implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		System.out.println("CustomContainer.customize(): OFF");
		//container.setPort(9999);
	}
}
