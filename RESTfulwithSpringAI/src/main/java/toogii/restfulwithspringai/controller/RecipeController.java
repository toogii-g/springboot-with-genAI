package toogii.restfulwithspringai.controller;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
public class RecipeController {

    private final OllamaChatModel chatModel;

    @Autowired
    public RecipeController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ai/generate/recipe")
    public Map generateRecipe(@RequestParam(value = "message", defaultValue = "Give me a dinner recipe") String message) {
        return Map.of("generation", chatModel.call(message));
    }
}
