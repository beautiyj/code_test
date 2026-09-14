package com.example.demo.internetsearch;

import java.time.LocalDateTime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InternetSearchTools {

	private String searchEndpoint; // SerpApi 엔드포인트

	private String apiKey; // SerpApi API 키

	private WebClient webClient; // WebClient 인스턴스

	private ObjectMapper objectMapper = new ObjectMapper(); // JSON 파싱을 위한 ObjectMapper

	// 생성자

	public InternetSearchTools(

			@Value("${serpapi.endpoint}") String searchEndpoint,

			@Value("${serpapi.apiKey}") String apiKey,

			WebClient.Builder webClientBuilder) {

		this.searchEndpoint = searchEndpoint;

		this.apiKey = apiKey; // SerpApi API 키 설정

		this.webClient = webClientBuilder

				.baseUrl(searchEndpoint) // SerpApi 엔드포인트 설정

				.defaultHeader("Accept", "application/json") // 기본 헤더 설정

				.build(); // WebClient 인스턴스 생성

	}

	// 1. 인터넷 검색을 수행하는 도구(tool)
	// 검색 결과를 제목, 링크, 요약으로 문자열로 반환
	@Tool(description = "인터넷 검색을 합니다. 제목, 링크, 요약을 문자열로 반환합니다.")

	public String search(String query) {
		try {
			String responseBody = webClient.get() // GET 요청
					.uri(uriBuilder -> uriBuilder// URI 빌더 사용
							.queryParam("engine", "google") // 검색 엔진 지정
							.queryParam("q", query) // 검색어 지정
							.queryParam("api_key", apiKey) // API 키 지정
							.build()) // URI 생성
					.retrieve() // 응답 수신
					.bodyToMono(String.class) // 응답 본문을 문자열로변환
					.block(); // 동기적으로 결과를 기다림
			System.out.println("응답본문: " + responseBody);

			// JSON 파싱
			JsonNode root = objectMapper.readTree(responseBody);
			JsonNode organicResults = root.path("organic_results"); // "organic_results" 배열 추출
			if (!organicResults.isArray() || organicResults.isEmpty()) {
				return "검색 결과가 없습니다.";
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < Math.min(3, organicResults.size()); i++) { // 최대 3개의 검색 결과만 처리
				JsonNode result = organicResults.get(i);
				String title = result.path("title").asText(); // 제목 추출
				String link = result.path("link").asText(); // 링크 추출
				String snippet = result.path("snippet").asText(); // 요약 추출
				sb.append(String.format("%d. %s\n%s\n%s\n\n", i + 1, title, link, snippet));
			}
			System.out.println(sb.toString().trim());
			return sb.toString().trim();
		} catch (Exception e) {
			return "인터넷 검색 중 오류 발생: " + e.getMessage();
		}
	}
	// search() end

	// 2. 웹 페이지의 본문 텍스트를 반환하는 도구(tool)
	@Tool(description = "웹 페이지의 본문 텍스트를 반환합니다.")
	public String fetch(String url) {

		return "";
	}

	// 3. 현재 날짜와 시간 정보를 반환하는 도구(tool)
	@Tool(description = "현재 날짜와 시간 정보를 제공합니다.")
	public String getCurrentDateTime() {

		return "";
	}

}
