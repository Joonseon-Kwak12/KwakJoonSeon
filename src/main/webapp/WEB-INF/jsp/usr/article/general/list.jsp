<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../common/head.jspf"%>
<%@ include file="../../common/nav.jspf"%>
	


	<section class="mt-8">
		<div class="container mx-auto px-3">
			<div class="w-10/12 mx-auto">
				
				<ul class="divide-y divide-amber-200">
					<c:forEach var="article" items="${articles }">
						<li>
							<div class="flex gap-x-11 my-2 justify-around text-base">
								<div>${article.id}</div>
								<div>${article.memberId}</div>
								<div>${article.regDate.substring(0,16)}</div>
							</div>
							<div class="font-semibold my-2">
								<a class="hover:underline" href="/article/general/${article.id }">${article.title}</a>
							</div>
						</li>
					</c:forEach>
				</ul>
				<div class="h-px bg-amber-200"><!-- 목록 하단 구분선 --></div>
				<div class="flex justify-end">
					<div class="mr-2"><a class="hover:underline" href="/article/general/write">글쓰기</a></div>
				</div>
			</div>
		</div>
	</section>
	
<%@ include file="../../common/footer.jspf"%>