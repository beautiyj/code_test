package com.example.demo.config;

import java.util.List;
import java.util.Map;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.Embedding;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Value("${spring.ai.google.genai.api-key}")
    private String apiKey;

    @Bean
    @Primary
    public EmbeddingModel googleGenAiEmbeddingModel() {
        return new GeminiRestEmbeddingModel(apiKey);
    }

    private static class GeminiRestEmbeddingModel implements EmbeddingModel {

        private final String apiKey;
        private final RestClient restClient;

        public GeminiRestEmbeddingModel(String apiKey) {
            this.apiKey = apiKey;
            this.restClient = RestClient.create();
        }

        @Override
        public EmbeddingResponse call(EmbeddingRequest request) {
            String text = request.getInstructions().get(0);
            String url = "https://generativelanguage.googleapis.com/v1beta/models/text-embedding-004:embedContent?key=" + apiKey;

            Map<String, Object> body = Map.of(
                "model", "models/text-embedding-004",
                "content", Map.of("parts", List.of(Map.of("text", text)))
            );

            Map response = restClient.post()
                    .uri(url)
                    .body(body)
                    .retrieve()
                    .body(Map.class);

            Map embeddingData = (Map) response.get("embedding");
            List<Double> values = (List<Double>) embeddingData.get("values");

            float[] floatArray = new float[values.size()];
            for (int i = 0; i < values.size(); i++) {
                floatArray[i] = values.get(i).floatValue();
            }

            Embedding embedding = new Embedding(floatArray, 0);
            return new EmbeddingResponse(List.of(embedding));
        }

        @Override
        public float[] embed(Document document) {
            EmbeddingResponse response = call(new EmbeddingRequest(List.of(document.getText()), null));
            return response.getResults().get(0).getOutput();
        }

        @Override
        public float[] embed(String text) {
            EmbeddingResponse response = call(new EmbeddingRequest(List.of(text), null));
            return response.getResults().get(0).getOutput();
        }

        @Override
        public List<float[]> embed(List<String> texts) {
            EmbeddingResponse response = call(new EmbeddingRequest(texts, null));
            return response.getResults().stream().map(Embedding::getOutput).toList();
        }

        @Override
        public int dimensions() {
            return 768; // text-embedding-004 규격 차원수
        }
    }
}