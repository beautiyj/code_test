package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.Embedding;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.embedding.EmbeddingResponseMetadata;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.filter.FilterExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AiService {
//
//  @Autowired
//  @Qualifier("googleGenAiEmbeddingModel")
//  private EmbeddingModel embeddingModel;

	// @Qualifier 제거 (스프링 AI가 자동 생성한 EmbeddingModel을 주입받음)
	@Autowired
	private EmbeddingModel embeddingModel;

	@Autowired
	private VectorStore vectorStore;

	// 1. 임베딩 모델을 이용하여 텍스트를 벡터로 변환
	public void textEmbedding(String question) {
		EmbeddingResponse response = embeddingModel.embedForResponse(List.of(question));
		System.out.println("임베딩:" + Arrays.toString(response.getResults().get(0).getOutput()));

		EmbeddingResponseMetadata metadata = response.getMetadata();
		System.out.println("모델 이름: " + metadata.getModel());
		System.out.println("모델의 임베딩 차원:" + embeddingModel.dimensions());

		Embedding embedding = response.getResults().get(0);
		System.out.println("벡터 차원:" + embedding.getOutput().length);
		System.out.println("벡터:" + embedding.getOutput());

		vectorStore.add(List.of(new Document(question, Map.of("source", "user-question", "year", 2026))));
	}

	// 2. Document를 벡터 저장소에 추가
	public void addDocument() {
		List<Document> documents = List.of(new Document("대통령 선거는 5년마다 있습니다.", Map.of("source", "헌법", "year", 1987)),
				new Document("대통령 임기는 4년입니다.", Map.of("source", "헌법", "year", 1980)),
				new Document("국회의원은 법률안을 심의·의결합니다.", Map.of("source", "헌법", "year", 1987)),
				new Document("자동차를 사용하려면 등록을 해야합니다.", Map.of("source", "자동차관리법")),
				new Document("대통령은 행정부의 수반입니다.", Map.of("source", "헌법", "year", 1987)),
				new Document("국회의원은 4년마다 투표로 뽑습니다.", Map.of("source", "헌법", "year", 1987)),
				new Document("승용차는 정규적인 점검이 필요합니다.", Map.of("source", "자동차관리법")));
		vectorStore.add(documents);
	}

	// 3. Document를 벡터 저장소에서 기본 유사도 검색
	public List<Document> searchDocument1(String question) {
		List<Document> documents = vectorStore
				.similaritySearch(SearchRequest.builder().query(question).topK(3).similarityThreshold(0.3).build());
		return documents;
	}

	// 4. Document를 벡터 저장소에서 필터링 적용 검색 (헌법 & 1987년 이상)
	public List<Document> searchDocument2(String question) {
		FilterExpressionBuilder feb = new FilterExpressionBuilder();

		List<Document> documents = vectorStore
				.similaritySearch(SearchRequest.builder().query(question).topK(3).similarityThreshold(0.3)
						.filterExpression(feb.and(feb.eq("source", "헌법"), feb.gte("year", 1987)).build()).build());
		return documents;
	}

	// 5. Document 전체 또는 특정 조건 삭제
	public void deleteDocument() {
		// 저장소의 모든 Document 삭제 예시 (단순 검색 후 ID 추출하여 삭제)
		List<Document> documents = vectorStore.similaritySearch(SearchRequest.builder().query("").topK(100).build());
		if (documents != null && !documents.isEmpty()) {
			List<String> ids = documents.stream().map(Document::getId).toList();
			vectorStore.delete(ids);
		}
	}
}