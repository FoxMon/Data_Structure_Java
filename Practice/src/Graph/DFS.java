package Graph;

import java.util.List;

public class DFS {
	private int N; // 그래프의 정점의 수
	private List<Edge>[] graph;
	private boolean[] visited; // DFS 수행 중 방문한 정점을 true로 만듬
	
	public DFS(List<Edge>[] adjList) { // 생성자
		N = adjList.length;
		graph = adjList;
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) { // 초기 배열 false로 모두 초기화
			visited[i] = false;
		}
		
		for(int i = 0; i < N; i++) { // 인접한 정점을 방문
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	private void dfs(int i) { // 전위순회와 비슷한 개념
		visited[i] = true; // 자기꺼 방문했으면 true
		
		System.out.print(i + " ");
		
		for(Edge e : graph[i]) { // i 번째의 인접 리스트를 계속 호출
			if(!visited[e.adjvertex]) { // 만약 방문이 안됐다면
				dfs(e.adjvertex); // 재귀호출
			}
		}
	}
}
