package org.alf.study.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.alf.study.model.Greeting;
import org.alf.study.model.impl.JsonGreeting;
import org.alf.study.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * RestController combines @Controller and @ResponseBody
 */
@RestController
@RequestMapping("/hello")
public class SpringHelloService implements HelloService {

	private static final Logger logger = LoggerFactory.getLogger(SpringHelloService.class);

	/*
	 * The @ResponseBody annotation tells Spring MVC not to render a model into a
	 * view, but rather to write the returned object into the response body.
	 */
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public Greeting index(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String param) {
		return new JsonGreeting(System.currentTimeMillis(), "index:" + param);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{name}")
	public Greeting path(@PathVariable("name") String name) {
		return new JsonGreeting(System.currentTimeMillis(), "path:" + name);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/ret/{name}")
	public String returning(@PathVariable("name") String name) {
		return "returning :" + name;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/redirect/{name}")
	public void redirect(HttpServletResponse response, @PathVariable("name") String name) throws IOException {
		response.sendRedirect("../" + name + "_redirected");
	}

	@Override
	public void init() {
		logger.info("{} initialized", getClass().getName());
	}

	@Override
	public void start() {
		logger.info("{} started", getClass().getName());
	}

	@Override
	public void stop() {
		logger.info("{} stopped", getClass().getName());
	}

	@Override
	public void dispose() {
		logger.info("{} disposed", getClass().getName());
	}
}
