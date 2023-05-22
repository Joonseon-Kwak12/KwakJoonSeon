<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../common/head.jspf"%>
<%@ include file="../../common/nav.jspf"%>



	<section class="mt-8 text-l">
		<div class="container mx-auto px-3">
		
			<!-- write 구현 후 양식 맞춰서 구현 -->
			<%-- placeholder="${articleData.title }
			
			<div class="w-10/12 mx-auto">
				<form action="/article/write" method="post">
				
					<input type="hidden" />
					<div>제목</div>
					<input name="body" class="w-full border" type="text"/>
					<div class="mt-4">내용</div>
					<input name="body" class="w-full border min-h-[300px]" type="text"/>

					<div class="mt-4 h-px bg-amber-200"></div>

					<div class="flex justify-end gap-x-5">
						<div>
							<a href="/article/write">작성 완료</a>
						</div>
					</div>
				</form>
			</div> --%>
			
		</div>

		<div class="h-40">
			<!-- 스크롤 아래로 내리기 위한 빈 공간 -->
		</div>
	</section>



<%@ include file="../../common/footer.jspf"%>