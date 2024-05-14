package com.ai.example;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/AIserver")
public class AIcontroller {

	private OllamaChatClient client;
     private static final String Prompt="who is manideep mukhi";
	public AIcontroller(OllamaChatClient client) {
		this.client = client;
	}
@GetMapping("/prompt")
public Flux<String> promptResponse(@RequestParam("prompt") String prompt )
{
	Flux<String> res=client.stream(prompt);
	return res;
}
}

